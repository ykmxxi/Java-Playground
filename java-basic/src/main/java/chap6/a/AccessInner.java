package chap6.a;

public class AccessInner {

    public static void main(String[] args) {
        AccessData accessData = new AccessData();

        // public 호출 가능
        accessData.publicField = 10;
        accessData.publicMethod();

        // 같은 패키지 default 호출 가능
        accessData.defaultField = 20;
        accessData.defaultMethod();

        // private 호출 불가
        // accessData.privateField = 30;
        // accessData.privateMethod();

        accessData.innerAccess();
    }

}
