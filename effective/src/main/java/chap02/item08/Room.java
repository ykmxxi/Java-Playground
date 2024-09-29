package chap02.item08;

import java.lang.ref.Cleaner;

public class Room implements AutoCloseable {

    private static final Cleaner cleaner = Cleaner.create();

    // 청소가 필요한 자원. 절대 Room을 참조해서는 안 된다
    private static class State implements Runnable {
        int numJunkPiles; // 방(Room) 안의 쓰레기 수

        State(final int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
        }

        // close 메서드나 cleaner가 호출한다
        @Override
        public void run() {
            System.out.println("방 청소");
            numJunkPiles = 0;
        }

    }

    private final State state; // 방의 상태, cleanable과 공유
    private final Cleaner.Cleanable cleanable; // cleanable 객체, 수거 대상이 되면 방을 청소

    public Room(final int numJunkPiles) {
        state = new State(numJunkPiles);
        cleanable = cleaner.register(this, state);
    }

    public boolean isCleaned() {
        return state.numJunkPiles == 0;
    }

    @Override
    public void close() {
        cleanable.clean();
    }

}
