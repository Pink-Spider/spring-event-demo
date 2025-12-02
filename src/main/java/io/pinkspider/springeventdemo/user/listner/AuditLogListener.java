package io.pinkspider.springeventdemo.user.listner;

import io.pinkspider.springeventdemo.user.event.UserSignedUpEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// 동기 리스너
@Component
public class AuditLogListener {

    private static final Logger log = LoggerFactory.getLogger(AuditLogListener.class);

    @Order(0)
    @EventListener
    public void onUserSignedUp(UserSignedUpEvent event) {
        log.info("AUDIT: userId={}, email={}, at={}", event.userId(), event.email(), event.occurredAt());
    }
}
