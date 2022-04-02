package kr.guncabinet.guncabinet.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CurrentUser extends User {

    private final kr.guncabinet.guncabinet.entity.User user;

    public CurrentUser(String username, String password,
                       Collection<? extends GrantedAuthority> authorities,
                       kr.guncabinet.guncabinet.entity.User user) {
        super(username, password, authorities);
        this.user = user;
    }

    public kr.guncabinet.guncabinet.entity.User getUser() {return user;}
}
