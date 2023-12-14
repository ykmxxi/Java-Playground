package chap6;

import chap6.a.AccessData;

public class AccessOuter {

    public static void main(String[] args) {
        AccessData data = new AccessData();

        // public 접근 가능
        data.publicField = 10;
        data.publicMethod();

        // 다른 패키지라 default 불가능
        // data.defaultField = 20;
        // data.defaultMethod();

        // private 호출 불가
        // accessData.privateField = 30;
        // accessData.privateMethod();

        data.innerAccess();
    }

}
