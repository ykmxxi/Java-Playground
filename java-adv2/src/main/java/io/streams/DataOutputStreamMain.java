package io.streams;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamMain {

    public static void main(String[] args) throws IOException {
        try (
                FileOutputStream fos = new FileOutputStream("temp/data.dat");
                DataOutputStream dos = new DataOutputStream(fos)
        ) {
            dos.writeUTF("회원A");
            dos.writeInt(20);
            dos.writeDouble(10.5);
            dos.writeBoolean(true);
        }

        try (
                FileInputStream fis = new FileInputStream("temp/data.dat");
                DataInputStream dis = new DataInputStream(fis)
        ) {
            // 꼭! 저장한 순서대로 읽어와야 한다
            System.out.println(dis.readUTF());
            System.out.println(dis.readInt());
            System.out.println(dis.readDouble());
            System.out.println(dis.readBoolean());
        }
    }

}
