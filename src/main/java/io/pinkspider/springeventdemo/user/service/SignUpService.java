package io.pinkspider.springeventdemo.user.service;

import io.pinkspider.springeventdemo.user.event.UserSignedUpEvent;
import io.pinkspider.springeventdemo.user.model.User;
import io.pinkspider.springeventdemo.user.repo.UserRepository;
import java.time.Instant;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SignUpService {

    private final UserRepository userRepository;
    private final ApplicationEventPublisher publisher;

    public SignUpService(UserRepository userRepository, ApplicationEventPublisher publisher) {
        this.userRepository = userRepository;
        this.publisher = publisher;
    }

    @Transactional
    public Long signUp(String email, String name) {
        User user = userRepository.save(new User(email, name));
        publisher.publishEvent(new UserSignedUpEvent(user.getId(), user.getEmail(), Instant.now()));
        return user.getId();
    }
}
