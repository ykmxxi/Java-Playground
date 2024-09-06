package chap02.item03;

// 대부분 상황에서는 원소가 하나뿐인 열거 타입(enum)이 싱글톤을 만드는 가장 좋은 방법이다
public enum Elvis {

    INSTANCE;

    public void leaveTheBuilding() {
        System.out.println("Elvis.leaveTheBuilding");
    }

    public static void main(String[] args) {
        Elvis instance = Elvis.INSTANCE;
        instance.leaveTheBuilding();
    }

}
