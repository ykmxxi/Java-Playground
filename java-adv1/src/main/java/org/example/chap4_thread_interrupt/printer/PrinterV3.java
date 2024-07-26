package org.example.chap4_thread_interrupt.printer;

import static org.example.util.MyLogger.log;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * V3: interrupt() 사용 & Thread.interrupted()로 인터럽트 상태 직접 확인
 */
public class PrinterV3 {

    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread printerThread = new Thread(printer, "printer");
        printerThread.start();

        Scanner sc = new Scanner(System.in);
        while (true) {
            log("프린터할 문서를 입력. 종료(q): ");
            String input = sc.nextLine();
            if ("q".equals(input)) {
                printerThread.interrupt();
                break;
            }
            printer.addJob(input);
        }
    }

    static class Printer implements Runnable {

        Queue<String> jobQueue = new ConcurrentLinkedQueue<>();

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                if (jobQueue.isEmpty()) {
                    continue;
                }
                try {
                    String job = jobQueue.poll();
                    log("출력 시작: " + job + ", 대기 문서: " + jobQueue);
                    Thread.sleep(3_000L);
                    log("출력 완료");
                } catch (InterruptedException e) {
                    log("interrupt!!");
                    break;
                }
            }
            log("프린터 종료");
        }

        public void addJob(final String input) {
            jobQueue.offer(input);
        }

    }

}
