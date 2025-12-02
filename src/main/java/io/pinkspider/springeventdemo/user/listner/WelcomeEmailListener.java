package io.pinkspider.springeventdemo.user.listner;

import io.pinkspider.springeventdemo.user.event.UserSignedUpEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

//비동기 리스너(@Async)
@Component
public class WelcomeEmailListener {

    private static final Logger log = LoggerFactory.getLogger(WelcomeEmailListener.class);

    @Async
    @EventListener(condition = "#event.email.endsWith('co.kr')")
    public void sendWelcomeEmail(UserSignedUpEvent event) {
        log.info("SEND EMAIL: welcome -> {}", event.email());
        // 실제 메일 전송 로직…
    }
}
