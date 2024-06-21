package org.example.chap5_collection_list;

public class BatchProcessor {

    private final MyList<Integer> list;


    public BatchProcessor(final MyList<Integer> list) {
        this.list = list;
    }

    public long logic(final int size) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            list.add(0, i);
        }

        long end = System.currentTimeMillis();
        long result = end - start;
        System.out.println(list.getClass().getSimpleName() + ", " + size + "개 추가 걸린 시간: " + result + "ms");
        return result;
    }

}
