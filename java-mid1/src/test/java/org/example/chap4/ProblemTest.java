package org.example.chap4;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.Test;

class ProblemTest {

    @Test
    void problem1() {
        // 문자로 입력된 str1, str2 두 수의 합을 구하기
        String str1 = "10";
        String str2 = "20";

        int res1 = Integer.parseInt(str1) + Integer.parseInt(str2);
        assertThat(res1).isEqualTo(30);

        // 배열에 입력된 모든 숫자의 합 구하기, 숫자는 double 형이 입력될 수 있다
        String[] array = {"1.5", "2.5", "3.0"};
        double res2 = 0.0d;
        for (String s : array) {
            res2 += Double.parseDouble(s);
        }
        assertThat(res2).isEqualTo(7.0d);
    }

    @Test
    void problem2() {
        // 로또 번호 자동 생성, 1 ~ 45 사이의 숫자를 6개 생성, 중복 X, 실행할 때 마다 결과가 달라야 한다
        final Random random = new Random();
        final int[] lottoNumbers = new int[6];

        int count = 0;
        while (count < 6) {
            int number = random.nextInt(45) + 1;
            if (isUnique(number, lottoNumbers)) {
                lottoNumbers[count] = number;
                count++;
            }
        }

        Arrays.sort(lottoNumbers);
        System.out.println("lottoNumber = " + Arrays.toString(lottoNumbers));

    }

    private boolean isUnique(final int number, final int[] lottoNumbers) {
        for (int lottoNumber : lottoNumbers) {
            if (lottoNumber == number) {
                return false;
            }
        }
        return true;
    }

}
