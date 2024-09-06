package chap02.item03;

import java.io.Serializable;

public class StaticFactory {

    static class Elvis implements Serializable {

        private static final Elvis INSTANCE = new Elvis();

        private Elvis() {}

        public static Elvis getInstance() {
            return INSTANCE;
        }

        public void leaveTheBuilding() {
            System.out.println("Elvis.leaveTheBuilding");
        }

        // 싱글톤임을 보장해주는 readReSolve()
        private Object readResolve() {
            // 진짜 싱글톤 인스턴스를 반환하고, 가짜는 GC
            return INSTANCE;
        }

    }

    public static void main(String[] args) {
        Elvis instance = Elvis.getInstance();
        instance.leaveTheBuilding();
    }

}
