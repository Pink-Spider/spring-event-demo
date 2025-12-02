package io.pinkspider.springeventdemo.user.api;

import io.pinkspider.springeventdemo.user.service.SignUpService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class SignUpController {

    private final SignUpService signUpService;

    public SignUpController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    @PostMapping("/signup")
    public Long signUp(@RequestParam String email, @RequestParam String name) {
        return signUpService.signUp(email, name);
    }
}
