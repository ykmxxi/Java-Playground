package chap4;

import java.util.ArrayList;
import java.util.List;

public class ConstructMain {

    public static void main(String[] args) {
        MemberConstruct member1 = new MemberConstruct("user1", 16, 90);
        MemberConstruct member2 = new MemberConstruct("user2", 15);

        List<MemberConstruct> members = new ArrayList<>();
        members.add(member1);
        members.add(member2);

        members.stream()
                .map(member -> "이름: " + member.name + " 나이: " + member.age + " 성적: " + member.grade)
                .forEach(System.out::println);
    }

}
