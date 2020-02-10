package com.example.sessions.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.events.SessionCreatedEvent;
import org.springframework.session.events.SessionDeletedEvent;
import org.springframework.session.events.SessionExpiredEvent;

/**
 * @ClassName: SpringSessionConfiguration
 * @Author: zhaojh0912
 * @Dae: 2020-02-09
 * @Vsersion: 1.0.0
 * @Description: TOO
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 120)
@Slf4j
public class SpringSessionConfiguration {
    /**
     * Redis内session过期事件监听
     * @param expiredEvent
     */
    @EventListener
    public void onSessionExpired(SessionExpiredEvent expiredEvent) {
        String sessionId = expiredEvent.getSessionId();
        log.info("Session失效事件:"+sessionId);

    }

    /**
     * Redis内session创建事件监听
     * @param createdEvent
     */
    @EventListener
    public void onSessionCreated(SessionCreatedEvent createdEvent) {
        String sessionId = createdEvent.getSessionId();
        log.info("创建Session事件:"+sessionId);
    }

    /**
     * Redis内session删除事件监听
     * @param deletedEvent
     */
    @EventListener
    public void onSessionDeleted(SessionDeletedEvent deletedEvent) {
        String sessionId = deletedEvent.getSessionId();
        log.info("删除Session事件:"+sessionId);
    }
}
