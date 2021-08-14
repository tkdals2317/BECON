package com.ssafy.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class LmsScheduler {
	@Autowired
	LmsService lmsService;

	@Scheduled(cron = "0 */1 * * * *")
    public void LMS() { 
		lmsService.findConcerts();
    }
}
