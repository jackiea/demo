package com.youkol.demo.k8sprobe.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.availability.ApplicationAvailability;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.LivenessState;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/probe")
public class StateController {

    @Autowired
    ApplicationAvailability applicationAvailability;

    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    /// =========== Get state method ===============

    /**
     * 查询状态
     * 
     * @return
     */
    @GetMapping(value = "/state")
    public String getState() {
        String format = "liveness state: %s <br />" 
                      + "readiness state: %s <br />" 
                      + "time: %s";
        return String.format(format, applicationAvailability.getLivenessState(),
                applicationAvailability.getReadinessState(), LocalDateTime.now());
    }

    /// =========== Change state method ============

    /**
     * 将存活状态修改为BROKEN (kubernetes杀死/重启pod)
     * 
     * @return
     * @see LivenessState#BROKEN
     */
    @PostMapping(value = "/liveness/broken")
    public String livenessBroken() {
        AvailabilityChangeEvent.publish(applicationEventPublisher, this, LivenessState.BROKEN);
        
        return "Change liveness state to broken success, " + LocalDateTime.now();
    }
    
    /**
     * 将存活状态修改为CORRECT
     * 
     * @return
     * @see LivenessState#CORRECT
     */
    @PostMapping(value = "/liveness/correct")
    public String livenessCorrect() {
        AvailabilityChangeEvent.publish(applicationEventPublisher, this, LivenessState.CORRECT);
        
        return "Change liveness state to correct success, " + LocalDateTime.now();
    }

    /**
     * 将就绪状态修改为REFUSING_TRAFFIC,
     * kubernetes不再把外部请求转发到此pod
     * 
     * @return
     * @see ReadinessState#REFUSING_TRAFFIC
     */
    @PostMapping(value = "/readiness/refusing")
    public String readinessRefusing() {
        AvailabilityChangeEvent.publish(applicationEventPublisher, this, ReadinessState.REFUSING_TRAFFIC);
        
        return "Change readiness state to refusing success, " + LocalDateTime.now();
    }

    /**
     * 将就绪状态修改为ACCEPTING_TRAFFIC,
     * kubernetes会把外部请求转发到此pod
     * 
     * @return
     * @see {@link ReadinessState#ACCEPTING_TRAFFIC ACCEPTING_TRAFFIC}
     */
    @PostMapping(value = "/readiness/accepting")
    public String readinessAccepting() {
        AvailabilityChangeEvent.publish(applicationEventPublisher, this, ReadinessState.ACCEPTING_TRAFFIC);
        
        return "Change readiness state to accepting success, " + LocalDateTime.now();
    }
}
