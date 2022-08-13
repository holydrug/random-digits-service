package com.popov.random.digits.service.controllers;

import com.popov.random.digits.service.components.SessionState;
import com.popov.random.digits.service.entity.Message;
import com.popov.random.digits.service.entity.OutputMessage;
import com.popov.random.digits.service.services.DigitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Controller
@Slf4j
@RequiredArgsConstructor
public class DigitController {
    private final SimpMessagingTemplate simpMessagingTemplate;
    private final DigitService digitService;
    private final SessionState sessionState;

    @MessageMapping("/chat")
    public void chat(final Message message) {
        sessionState.getStatusMap().computeIfAbsent(message.getFrom(), (key) -> once(message));
    }

    @MessageMapping("/chatAuto")
    public void chatAuto(final Message message) {
        sessionState.getStatusMap().computeIfAbsent(message.getFrom(), (key) -> auto(message));
    }

    private ScheduledExecutorService once(final Message message) {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        Runnable task = () -> task(message);
        ses.schedule(task, 0,  TimeUnit.SECONDS);
        return ses;
    }

    private ScheduledExecutorService auto(final Message message) {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        Runnable task = () -> task(message);
        ses.scheduleAtFixedRate(task, 0, 5, TimeUnit.SECONDS);
        return ses;
    }

    private void task(final Message message) {
        final String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
        simpMessagingTemplate.convertAndSend("/topic/messages/" + message.getFrom(),
                new OutputMessage(message.getFrom(), digitService.output(Integer.parseInt(message.getText())), time));
    }
}
