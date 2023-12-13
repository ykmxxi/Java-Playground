package chap6.a;

import chap6.Speaker;

public class OtherPackageMain {

    public static void main(String[] args) {
        Speaker speaker = new Speaker(10);
        // private, default는 당연히 접근 불가
        // speaker.protectedVolume = 10; // 다른 패키지이고 상속 관계가 아니라 protected도 접근 불가
        speaker.publicVolume = 10;
    }

}
