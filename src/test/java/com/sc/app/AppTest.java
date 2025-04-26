package com.sc.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AppTest {
    @Test
    void TestMrRobottoManMoves() {
        final String layout = """
        5 5
        1 2 N
        RFRFFRFRF
        """;

        String report = World
            .fromString(layout)
            .run()
            .getReport();
        assertEquals("Report: (1.0, 1.0) N", report);
    }

    @Test
    void TestMrRobottoManOutOfBounds() {
        final String layout = """
        5 5
        0 0 E
        RFLFFLRF
        """;

        World w = World.fromString(layout);
        assertThrows(PositionOutOfBoundsException.class, w::run);
    }
}
