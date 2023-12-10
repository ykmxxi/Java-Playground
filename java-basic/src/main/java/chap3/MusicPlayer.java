package chap3;

public class MusicPlayer {

    int volume = 0;
    boolean isOn = false;

    public void on() {
        isOn = true;
        System.out.println("음악 플레이어를 시작");
    }

    public void off() {
        isOn = false;
        System.out.println("음악 플레이어를 종료합니다.");
    }

    public void increaseVolume() {
        this.volume++;
        System.out.println("음악 플레이어 볼륨: " + this.volume);
    }

    public void decreaseVolume() {
        this.volume--;
        System.out.println("음악 플레이어 볼륨: " + this.volume);
    }

    public void showStatus() {
        System.out.println("음악 플레이어 상태 확인");
        if (this.isOn) {
            System.out.println("음악 플레이어 ON, 음악 플레이어 볼륨: " + this.volume);
        } else {
            System.out.println("음악 플레이어 OFF");
        }
    }

}
