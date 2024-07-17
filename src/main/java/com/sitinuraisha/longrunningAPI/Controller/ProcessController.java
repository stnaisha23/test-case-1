package com.sitinuraisha.longrunningAPI.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sitinuraisha.longrunningAPI.Services.SlowProcessService;

@RestController
@RequestMapping("/api")
public class ProcessController {

    private final SlowProcessService slowProcessService;
    private boolean processStarted = false;

    @Autowired
    public ProcessController(SlowProcessService slowProcessService) {
        this.slowProcessService = slowProcessService;
    }

    @GetMapping("/start-process")
    public String startSlowProcess() {
        slowProcessService.startSlowProcess();
        processStarted = true;
        return "Proses dimulai. Silahkan anda bisa melakukan kerjaan lainnya tanpa menunggu di sini!";
    }

    @GetMapping("/get-process-result")
    public String getProcessResult() {
        if (!processStarted) {
            return "Proses belum dimulai. Silakan mulai proses dulu!";
        }
        return slowProcessService.runSlowProcess();
    }
}
