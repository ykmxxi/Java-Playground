package io.member.file;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.member.Member;
import io.member.MemberRepository;

public class FileMemberRepository implements MemberRepository {

    private static final String FILE_NAME = "temp/members-txt.dat";
    private static final String DELIMITER = ",";

    @Override
    public void add(final Member member) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, UTF_8, true))) {
            writer.write(String.join(DELIMITER, member.id(), member.name(), Integer.toString(member.age())));
            writer.newLine(); // 다음 줄로 이동
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Member> findAll() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME, UTF_8))) {
            List<Member> members = readMembers(reader);
            return members.stream()
                    .toList();
        } catch (FileNotFoundException e) { // 회원 데이터가 없다면 해당 파일 존재 X
            return List.of();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Member> readMembers(final BufferedReader reader) throws IOException {
        List<Member> members = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            List<String> memberData = Arrays.stream(line.split(DELIMITER))
                    .toList();
            members.add(new Member(memberData.get(0), memberData.get(1), Integer.valueOf(memberData.get(2))));
        }
        return members;
    }

}
