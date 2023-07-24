package com.temporal.demos.temporalspringbootdemo.activities;

import io.temporal.spring.boot.ActivityImpl;
import org.springframework.stereotype.Component;

@Component
@ActivityImpl(taskQueues = "DemoTaskQueue")
public class DemoActivitiesImpl implements DemoActivities {
    @Override
    public void before(String cloudEvent) {
        // todo
    }

    @Override
    public void after(String cloudEvent) {
        // todo
    }
}
