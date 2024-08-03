package org.example.bounded;

/**
 * 버퍼 역할을 하는 큐
 * <p>
 * put(String data): 버퍼에 데이터 저장, 생산자 스레드가 호출하고 데이터 생산
 * <p>
 * take(): 버퍼에 보관된 값을 가져옴, 소비자 스레드가 호출하고 데이터 소비
 */
public interface BoundedQueue {

    void put(String data);

    String take();

}
