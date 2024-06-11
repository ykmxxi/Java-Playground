package org.example.chap2_generic_advanced.problem;

import org.example.chap2_generic_advanced.problem.unit.Marine;
import org.example.chap2_generic_advanced.problem.unit.Zealot;
import org.example.chap2_generic_advanced.problem.unit.Zergling;
import org.junit.jupiter.api.Test;

class ShuttleTest {

    @Test
    void problem1() {
        Shuttle<Marine> shuttle1 = new Shuttle<>();
        shuttle1.in(new Marine("마린", 40));
        shuttle1.showInfo();

        Shuttle<Zealot> shuttle2 = new Shuttle<>();
        shuttle2.in(new Zealot("질럿", 140));
        shuttle2.showInfo();

        Shuttle<Zergling> shuttle3 = new Shuttle<>();
        shuttle3.in(new Zergling("저글링", 30));
        shuttle3.showInfo();
    }

    @Test
    void problem2() {
        Shuttle<Marine> shuttle1 = new Shuttle<>();
        shuttle1.in(new Marine("마린", 40));

        Shuttle<Zealot> shuttle2 = new Shuttle<>();
        shuttle2.in(new Zealot("질럿", 140));

        UnitPrinter.printV1(shuttle1);
        UnitPrinter.printV2(shuttle1);

        UnitPrinter.printV1(shuttle2);
        UnitPrinter.printV2(shuttle2);
    }

}
