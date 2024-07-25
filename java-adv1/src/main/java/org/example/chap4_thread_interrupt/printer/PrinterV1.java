package org.example.chap4_thread_interrupt.printer;

import static org.example.util.MyLogger.log;
import static org.example.util.ThreadUtils.sleep;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * V1: 변수를 사용해 printer 스레드의 작업 중단
 * 현재 문제점: 종료 입력 시 반응성이 느림, 최악의 경우 종료 지시 후 3초 뒤 종료
 */
public class PrinterV1 {

    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread printerThread = new Thread(printer, "printer");
        printerThread.start();

        Scanner sc = new Scanner(System.in);
        while (true) {
            log("프린터할 문서를 입력. 종료(q): ");
            String input = sc.nextLine();
            if ("q".equals(input)) {
                printer.work = false;
                break;
            }
            printer.addJob(input);
        }
    }

    static class Printer implements Runnable {

        volatile boolean work = true;
        Queue<String> jobQueue = new ConcurrentLinkedQueue<>();

        @Override
        public void run() {
            while (work) {
                if (jobQueue.isEmpty()) {
                    continue;
                }
                String job = jobQueue.poll();
                log("출력 시작: " + job + ", 대기 문서: " + jobQueue);
                sleep(3_000L);
                log("출력 완료");
            }
            log("프린터 종료");
        }

        public void addJob(final String input) {
            jobQueue.offer(input);
        }

    }

}
