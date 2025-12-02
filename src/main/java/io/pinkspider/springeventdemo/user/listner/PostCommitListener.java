package io.pinkspider.springeventdemo.user.listner;

import io.pinkspider.springeventdemo.user.event.UserSignedUpEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

// 트랜잭션 커밋 이후만 실행
@Component
public class PostCommitListener {

    private static final Logger log = LoggerFactory.getLogger(PostCommitListener.class);

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void afterCommit(UserSignedUpEvent event) {
        log.info("AFTER_COMMIT: create coupon for userId={}", event.userId());
        // 쿠폰 발급/외부 호출 등 커밋 보장 필요한 작업
    }
}

