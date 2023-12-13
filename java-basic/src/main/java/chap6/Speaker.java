package chap6;

public class Speaker { // 클래스 레벨 접근 제어자

    private int volume; // 필드
    int defaultVolume;
    protected int protectedVolume;
    public int publicVolume;

    public Speaker(final int volume) { // 생성자
        this.volume = volume;
    }

    public void volumeUp() { // 메서드
        System.out.println("Volume up");
        increaseVolume();
    }

    private void increaseVolume() { // 메서드
        volume += 10;
    }

}
