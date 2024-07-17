package com.sitinuraisha.longrunningAPI.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sitinuraisha.longrunningAPI.Services.SlowProcessService;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api")
public class ProcessController {

    private final SlowProcessService slowProcessService;

    @Autowired
    public ProcessController(SlowProcessService slowProcessService) {
        this.slowProcessService = slowProcessService;
    }

    @GetMapping("/start-slow-process")
    public String startSlowProcess() {
        CompletableFuture<String> future = slowProcessService.runSlowProcess();
        return "Proses dimulai. Silahkan lanjutkan kerjaan lainnya selama proses ini berlangsung!";
    }

    @GetMapping("/get-process-result")
    public CompletableFuture<String> getProcessResult() {
        return slowProcessService.getProcessResult();
    }
}
