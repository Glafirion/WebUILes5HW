package org.example.lesson4;

import lesson4.Cat;
import lesson4.Functions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

import static lesson4.Functions.isPalindrome;
import static org.assertj.core.api.Assertions.assertThat;

public class FunctionsTest {
    private static Logger logger = LoggerFactory.getLogger("FunctionsTest");

    @BeforeAll
    static void beforeAll() {

        logger.info("Method doing one time before all methods in class");
    }

    @BeforeEach
    void beforeEach() {
        logger.error("Method doing before each test of that class");
       // WebDriver driver = new ChromeDriver();
       // System.out.println("Method doing before each test of that class");
    }


    @Test
    @DisplayName("Examination method with not even number of symbols in method isPalindrome")
    void givenPalindromeWhenCallIsPalindromeMethodThenTrue() {
       // boolean result = isPalindrome("1234321");
          assertThat(isPalindrome("1234321")).isTrue();
       // Assertions.assertTrue(result);
       // Assertions.assertEquals(true, result);
    }


    @Test
    @Disabled
    @DisplayName("Examination method with even number of symbols in method isPalindrome")
    void palindromeTest() {
        boolean result = isPalindrome(String.valueOf(123321));
        Assertions.assertTrue(result);
        // Assertions.assertEquals(true, result);
    }

    @ParameterizedTest
    @Tag("smoke")
    @ValueSource(strings = {"123321", "1235321"})
    void isPalindromeTestWithDataProvider(String word) {
        boolean result = isPalindrome(word);
        Assertions.assertTrue(result);
    }

    @ParameterizedTest
    @CsvSource({"123,false", "123321,true"})
    void csvTest(String word, boolean expectedResult) {
        boolean actualResult = isPalindrome(word);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @MethodSource("catAndAgeDataProvider")
    void catEqualsAgeTest(Cat cat, Integer age) {
        Assertions.assertEquals(cat.getAge(), age);
    }

    private static Stream<Arguments> catAndAgeDataProvider() {
        return Stream.of(
                Arguments.of(new Cat("Test1",10), 10),
                Arguments.of(new Cat("Test2",12), 12),
                Arguments.of(new Cat("Test1",15), 15)
        );
    }

    @AfterEach
    void afterEach() {
        //driver.quit();
        System.out.println("Method doing after each test of that class");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Method doing one time after all methods in class");
    }
}

