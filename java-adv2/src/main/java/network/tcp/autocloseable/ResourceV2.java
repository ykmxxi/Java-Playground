package network.tcp.autocloseable;

public class ResourceV2 implements AutoCloseable {

    private final String name;

    public ResourceV2(final String name) {
        this.name = name;
    }

    public void call() {
        // 정상 로직 호출
        System.out.println(name + " call");
    }

    public void callEx() throws CallException {
        // 비정상 로직 호출
        System.out.println(name + " callEx");
        throw new CallException(name + " ex");
    }

    @Override
    public void close() throws CloseException {
        // 정상 종료
        System.out.println(name + " close");
        throw new CloseException(name + "ex");
    }

}
