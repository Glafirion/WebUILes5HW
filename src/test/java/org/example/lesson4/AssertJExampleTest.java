package org.example.lesson4;

import lesson4.Functions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJExampleTest {
    @Test
    void assertJExample() {
        assertThat(Functions.isPalindrome("1235412")).isFalse();
        assertThat(6).isLessThan(10).isGreaterThan(0);

    }
}
