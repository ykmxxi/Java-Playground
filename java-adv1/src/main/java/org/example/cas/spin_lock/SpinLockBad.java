package org.example.cas.spin_lock;

import static org.example.util.MyLogger.log;
import static org.example.util.ThreadUtils.sleep;

public class SpinLockBad {

    private volatile boolean lock = false;

    public void lock() {
        log("락 획득 시도");
        while (true) {
            // 1, 2 과정이 나뉘어 원자적이지 않은 연산
            if (!lock) { // 1. 락 사용 여부 확인
                sleep(100L); // 문제 상황 확인을 위한 스레드 대기
                lock = true; // 2. 락의 값 변경
                break;
            } else {
                // 락을 획득할 때 까지 스핀 대기(바쁜 대기)
                log("락 획득 실패 - 스핀 대기");
            }
        }
        log("락 획득 완료");
    }

    public void unlock() {
        lock = false; // 원자적 연산
        log("락 반납 완료");
    }

}
