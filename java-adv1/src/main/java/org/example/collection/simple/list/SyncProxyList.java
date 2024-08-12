package org.example.collection.simple.list;

public class SyncProxyList implements SimpleList {

    private final SimpleList target;

    public SyncProxyList(final SimpleList target) {
        this.target = target;
    }

    @Override
    public synchronized int size() {
        return target.size();
    }

    @Override
    public synchronized void add(final Object e) {
        target.add(e);
    }

    @Override
    public synchronized Object get(final int index) {
        return target.get(index);
    }

    @Override
    public synchronized String toString() {
        return target.toString() + " by " + this.getClass().getSimpleName();
    }

}
