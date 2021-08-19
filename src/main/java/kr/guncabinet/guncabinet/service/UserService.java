package kr.guncabinet.guncabinet.service;

import kr.guncabinet.guncabinet.entity.Role;
import kr.guncabinet.guncabinet.entity.User;
import kr.guncabinet.guncabinet.repository.RoleRepository;
import kr.guncabinet.guncabinet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.utility.RandomString;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JavaMailSender mailSender;

    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    public User findUserByMailIgnoreCase(String mail) {
        return userRepository.findUserByMailIgnoreCase(mail);
    }

    public List<User> finaAllUser() {
        return userRepository.findAllUser();
    }

    public List<User> findAllByRoleId(int id) {
        return userRepository.findAllByRoleId(id);
    }

    public void saveUser(User user, String siteURL) throws UnsupportedEncodingException, MessagingException {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(false);
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRole(userRole);
        user.setVerificationCode(RandomString.make(64));
        userRepository.save(user);
        sendVerificationEmail(user, siteURL);
    }

    private void sendVerificationEmail(User user, String siteURL)
            throws MessagingException, UnsupportedEncodingException {
        String toAddress = user.getMail();
        String fromAddress = "guncabinetservice@gmail.com";
        String senderName = "MyGunCabinetApp";
        String subject = "Proszę potwierdzić rejestrację";
        String content = "Hej [[name]],<br>"
                + "Proszę kliknij w poniższy link aby potwierdzić rejestrację:<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">WERYFIKUJ</a></h3>"
                + "Pozdrawiam,<br>"
                + "MyGunCabinetApp Crew.";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);

        content = content.replace("[[name]]", user.getUsername());
        String verifyURL = siteURL + "/verify/" + user.getVerificationCode();

        content = content.replace("[[URL]]", verifyURL);

        helper.setText(content, true);

        mailSender.send(message);
    }

    public boolean verify(String verificationCode) {
        User user = userRepository.findByVerificationCode(verificationCode);

        if (user == null || user.isEnabled()) {
            return false;
        } else {
            user.setVerificationCode(null);
            user.setEnabled(true);
            userRepository.save(user);

            return true;
        }

    }

}
