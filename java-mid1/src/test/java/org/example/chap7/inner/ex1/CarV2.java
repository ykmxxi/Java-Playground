package org.example.chap7.inner.ex1;

public class CarV2 {

    private final String model;
    private final int chargeLevel;
    private final Engine engine;

    public CarV2(final String model, final int chargeLevel) {
        this.model = model;
        this.chargeLevel = chargeLevel;
        this.engine = new Engine();
    }

    public void start() {
        engine.start();
        System.out.println(model + " 시작 완료");
    }

    private class Engine {

        public void start() {
            System.out.println("충전 레벨 확인: " + chargeLevel);
            System.out.println(model + "의 엔진을 구동합니다");
        }

    }

}
