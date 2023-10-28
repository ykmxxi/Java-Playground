package jdk17;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StringTest {

    @Test
    void textBlockTest() {
        String name1 = "pobi";
        int count1 = 3;
        String name2 = "woni";
        int count2 = 4;

        String result1 = getJoin(name1, count1);
        String result2 = getJoin(name2, count2);

        String result = result1 + "\n" + result2;
        String textBlock = """
                pobi : ---
                woni : ----""";

        System.out.println(result);
        System.out.println(textBlock);
        assertThat(result).isEqualTo(textBlock);
    }

    private String getJoin(final String name, final int count) {
        return String.join(" : ", name, "-".repeat(count));
    }

}
