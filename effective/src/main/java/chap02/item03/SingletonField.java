package chap02.item03;

public class SingletonField {

    static class Elvis {

        public static final Elvis INSTANCE = new Elvis();

        private Elvis() {}

        public void leaveTheBuilding() {
            System.out.println("Elvis.leaveTheBuilding");
        }

    }

    public static void main(String[] args) {
        Elvis instance = Elvis.INSTANCE;
        instance.leaveTheBuilding();
    }

}
