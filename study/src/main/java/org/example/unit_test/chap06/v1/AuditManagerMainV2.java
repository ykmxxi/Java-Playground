package org.example.unit_test.chap06.v1;

import java.io.IOException;

import org.example.unit_test.chap06.v0.AuditManagerV1;

public class AuditManagerMainV2 {

    public static void main(String[] args) throws IOException {
        AuditManagerV1 manager = new AuditManagerV1(5, "src/main/resources/temp/");
    }

}
