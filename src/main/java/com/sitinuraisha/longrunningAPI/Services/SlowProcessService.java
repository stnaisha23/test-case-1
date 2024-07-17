package com.sitinuraisha.longrunningAPI.Services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class SlowProcessService {

    @Async
    public CompletableFuture<String> runSlowProcess() {
        try {
            Thread.sleep(10000); // 10 detik
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return CompletableFuture.completedFuture("Selamat, proses telah berhasil dan selesai!");
    }

    public CompletableFuture<String> getProcessResult() {
        return runSlowProcess();
    }
}


