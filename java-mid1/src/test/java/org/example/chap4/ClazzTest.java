package org.example.chap4;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class ClazzTest {

    private static final Logger log = LoggerFactory.getLogger(ClazzTest.class);

    @Test
    void Class_클래스_기능() throws Exception {
        //Class 조회, clazz 라는 이름을 관행으로 사용
        Class<String> clazz = String.class; // 1.클래스에서 조회
        // Class<String> clazz = new String().getClass(); // 2.인스턴스에서 조회
        // Class<String> clazz = Class.forName("java.lang.String"); // 3.문자열로 조회

        // 모든 필드
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            log.info("Field: {} {}", declaredField.getType(), declaredField.getName());
        }

        // 모든 메서드
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            log.info("Method: {}", declaredMethod);
        }

        // 상위 클래스 정보
        log.info("SuperClass: {}", clazz.getSuperclass().getName());

        // 인터페이스 정보
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class<?> inter : interfaces) {
            log.info("Interface: " + inter.getName());
        }
    }

    @Test
    void 사용자_정의_클래스() throws Exception {
        Class<?> helloClazz = Class.forName("org.example.chap4.Hello");

        Hello hello1 = (Hello) helloClazz.getDeclaredConstructor().newInstance(); // 기본 생성자
        Hello hello2 = (Hello) helloClazz.getDeclaredConstructor(String.class).newInstance("java");

        log.info("hello1 Method Call: {}", hello1.hello());
        log.info("hello2 Method Call: {}", hello2.hello());
    }

}
