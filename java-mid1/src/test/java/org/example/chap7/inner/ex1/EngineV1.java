package org.example.chap7.inner.ex1;

public class EngineV1 {

    private final CarV1 car;

    public EngineV1(final CarV1 car) {
        this.car = car;
    }

    public void start() {
        System.out.println("충전 레벨 확인: " + car.getChargeLevel());
        System.out.println(car.getModel() + "의 엔진을 구동합니다");
    }

}
