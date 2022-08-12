package org.example.lesson4.HomeWork4;

import org.example.HomeWork4.TriangleArea;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest {

    @Test
    void triangleTest() throws Exception {
        Assertions.assertEquals(TriangleArea.calculatedAreaT(2,3,4),2.904, 0.001);

    }

    @Test
    void triangleNegativeTest() throws Exception {
        assertThrows(Exception.class,() ->TriangleArea.calculatedAreaT(2,3,-4));

    }
}
