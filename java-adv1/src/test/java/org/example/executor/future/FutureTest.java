package org.example.executor.future;

import static java.util.concurrent.Future.State.CANCELLED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.example.util.ThreadUtils.sleep;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.jupiter.api.Test;

class FutureTest {

    @Test
    void futureCancel() {
        ExecutorService es = Executors.newFixedThreadPool(1);
        Future<Integer> future = es.submit(new Task());
        sleep(3000L);
        boolean cancel = future.cancel(false);

        assertThatThrownBy(future::get).isInstanceOf(CancellationException.class);
        assertThat(future.state()).isEqualTo(CANCELLED);
        assertThat(cancel).isTrue();
        assertThat(future.isCancelled()).isTrue();
    }

    static class Task implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            for (int i = 0; i < 5; i++) {
                System.out.println(i + "번째 작업중");
                sleep(1000L);
            }
            return 1;
        }

    }

}
