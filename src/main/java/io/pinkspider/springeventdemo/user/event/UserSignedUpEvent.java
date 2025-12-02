package io.pinkspider.springeventdemo.user.event;

import java.time.Instant;

public record UserSignedUpEvent(Long userId, String email, Instant occurredAt) {

}
