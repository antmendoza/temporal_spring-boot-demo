package com.temporal.demos.temporalspringbootdemo;


import com.temporal.demos.temporalspringbootdemo.workflows.DemoWorkflow;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class Starter {

    final WorkflowClient client;


    public Starter(WorkflowClient client) {
        this.client = client;
        DemoWorkflow workflow = client.newWorkflowStub(DemoWorkflow.class, WorkflowOptions.newBuilder()
                .setTaskQueue("DemoTaskQueue").setWorkflowId("test").build());

        WorkflowClient.start(workflow::exec, "my-event");
        workflow.addEvent("second event");


        CompletableFuture.runAsync(() -> {
            String result = client.newUntypedWorkflowStub("test").getResult(String.class);
            System.out.println("Result : " + result);

        });


    }


}
