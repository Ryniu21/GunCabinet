package kr.guncabinet.guncabinet.controller;

import kr.guncabinet.guncabinet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class UserFormController {
    private final UserService userService;


}
