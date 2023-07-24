package com.temporal.demos.temporalspringbootdemo.workflows;

import com.temporal.demos.temporalspringbootdemo.activities.DemoActivities;
import io.temporal.activity.ActivityOptions;
import io.temporal.spring.boot.WorkflowImpl;
import io.temporal.workflow.Workflow;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@WorkflowImpl(taskQueues = "DemoTaskQueue")
public class DemoWorkflowImpl implements DemoWorkflow {

    private final List<String> eventList = new ArrayList<>();

    private final DemoActivities demoActivities =
            Workflow.newActivityStub(DemoActivities.class,
                    ActivityOptions.newBuilder()
                            .setStartToCloseTimeout(Duration.ofSeconds(2))
                            .build());

    @Override // WorkflowMethod
    public String exec(String cloudEvent) {
        eventList.add(cloudEvent);

        demoActivities.before(cloudEvent);

        Workflow.await(() -> eventList.size() == 2);

        demoActivities.after(cloudEvent);

        return "done";
    }

    @Override // SignalMethod
    public void addEvent(String cloudEvent) {
        eventList.add(cloudEvent);
    }

    @Override // QueryMethod
    public String getLastEvent() {
        return eventList.get(eventList.size() - 1);
    }
}
