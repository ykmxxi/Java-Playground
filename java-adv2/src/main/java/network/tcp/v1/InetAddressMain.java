package network.tcp.v1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressMain {

    public static void main(String[] args) throws UnknownHostException {
        // DNS 탐색
        InetAddress localhost = InetAddress.getByName("localhost"); // 호스트 파일에서 조회
        System.out.println("localhost = " + localhost);

        InetAddress google = InetAddress.getByName("google.com"); // 호스트 파일에 존재하지 않아 DNS 서버에서 조회
        System.out.println("google = " + google);
    }

}
