package chap6.a;

import chap6.Speaker;

public class ExtendsMain extends Speaker {

    public ExtendsMain(final int volume) {
        super(volume);
    }

    public void protectedVolumeUp() {
        // this.defaultVolume += 10; // default는 다른 패키지라 접근 불가
        this.protectedVolume += 10; // 상속 관계라 접근 가능
    }

}
