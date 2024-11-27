package io.member.data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.member.Member;
import io.member.MemberRepository;

public class DataMemberRepository implements MemberRepository {

    private static final String FILE_NAME = "temp/members-data.dat";

    @Override
    public void add(final Member member) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME, true))) {
            dos.writeUTF(member.id());
            dos.writeUTF(member.name());
            dos.writeInt(member.age());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Member> findAll() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
            return readMembers(dis).stream()
                    .toList();
        } catch (FileNotFoundException e) {
            return List.of();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Member> readMembers(final DataInputStream dis) throws IOException {
        List<Member> members = new ArrayList<>();
        while (dis.available() > 0) {
            members.add(new Member(dis.readUTF(), dis.readUTF(), dis.readInt()));
        }
        return members;
    }

}
