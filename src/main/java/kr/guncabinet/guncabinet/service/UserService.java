package kr.guncabinet.guncabinet.service;

import kr.guncabinet.guncabinet.entity.User;
import lombok.Data;

public interface UserService {
    User findByUserName(String name);
    void saveUser(User user);


}
