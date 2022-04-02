package kr.guncabinet.guncabinet.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 60)
    @Pattern(regexp = "^\\S*$", message = "{username.space}")
    @Size(min=4)
    private String username;

    @Column(length = 50)
    @NotBlank
    @Email
    private String mail;

    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$", message = "{password.notValid}")
    private String password;

    @ManyToOne
    private Role role;

    @Column(name = "verification_code", length = 64)
    private String verificationCode;
    private boolean enabled;
}
