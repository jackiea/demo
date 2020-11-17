package com.youkol.demo.k8sprobe.listener;

import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.AvailabilityState;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 监听事件类
 * 
 * @author jackiea
 * @date 2020-11-18
 */
@Component
@Slf4j
public class AvailabilityEventListener {
    
    @EventListener
    public void onStateChange(AvailabilityChangeEvent<? extends AvailabilityState> event) {
        log.info("{} : {}", event.getState().getClass().getSimpleName(), event.getState());
    }
}
