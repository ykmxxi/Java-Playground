package chap6;

public class SamePackageMain {

    public static void main(String[] args) {
        Speaker speaker = new Speaker(10);

        // 같은 패키지이기 때문에 default, protected, public 모두 접근 가능
        speaker.defaultVolume = 10;
        speaker.protectedVolume = 10;
        speaker.publicVolume = 10;
    }

}
