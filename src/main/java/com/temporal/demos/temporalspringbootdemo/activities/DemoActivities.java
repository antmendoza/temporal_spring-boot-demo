package com.temporal.demos.temporalspringbootdemo.activities;

import io.temporal.activity.ActivityInterface;

@ActivityInterface
public interface DemoActivities {
    void before(String cloudEvent);
    void after(String cloudEvent);
}
