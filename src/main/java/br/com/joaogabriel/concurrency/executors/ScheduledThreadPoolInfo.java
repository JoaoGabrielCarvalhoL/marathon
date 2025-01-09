package br.com.joaogabriel.concurrency.executors;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolInfo {
    private static final ScheduledExecutorService SCHEDULED_EXECUTOR_SERVICE = Executors.newScheduledThreadPool(1);

    private static void beeper() {
        Runnable runnable = () -> System.out.println(LocalTime.now(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("HH:mm:ss", Locale.of("pt", "BR"))) + ": beep");
        ScheduledThreadPoolInfo.SCHEDULED_EXECUTOR_SERVICE.schedule(runnable, 1, TimeUnit.SECONDS);
        ScheduledThreadPoolInfo.SCHEDULED_EXECUTOR_SERVICE.shutdown();
    }

    private static void beeperWithFixedDelay() {
        Runnable runnable = () -> System.out.println(LocalTime.now(ZoneId.systemDefault())
                .format(DateTimeFormatter.ofPattern("HH:mm:ss", Locale.of("pt", "BR"))) + ": beep");
        ScheduledFuture<?> scheduledFutureFixedDelay = ScheduledThreadPoolInfo.SCHEDULED_EXECUTOR_SERVICE
                .scheduleWithFixedDelay(runnable, 1, 2, TimeUnit.SECONDS);
        ScheduledThreadPoolInfo.SCHEDULED_EXECUTOR_SERVICE.schedule(() -> {
            System.out.println("Canceling the scheduleWithFixedDelay...");
           scheduledFutureFixedDelay.cancel(false);
            ScheduledThreadPoolInfo.SCHEDULED_EXECUTOR_SERVICE.shutdown();
        }, 10, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {

        beeperWithFixedDelay();
    }
}
