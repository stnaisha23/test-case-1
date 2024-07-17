package com.sitinuraisha.longrunningAPI.Services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class SlowProcessService {

    @Async
    public void startSlowProcess() {
        runSlowProcess();
    }

    public String runSlowProcess() {
        try {
            Thread.sleep(10000); // 10 detik
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return "Selamat, proses telah berhasil dan selesai!";
    }
}
