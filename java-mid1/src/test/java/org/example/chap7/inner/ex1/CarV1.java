package org.example.chap7.inner.ex1;

public class CarV1 {

    private final String model;
    private final int chargeLevel;
    private final EngineV1 engine;

    public CarV1(final String model, final int chargeLevel) {
        this.model = model;
        this.chargeLevel = chargeLevel;
        this.engine = new EngineV1(this);
    }

    public String getModel() {
        return model;
    }

    public int getChargeLevel() {
        return chargeLevel;
    }

    public void start() {
        engine.start();
        System.out.println(model + " 시작 완료");
    }

}
