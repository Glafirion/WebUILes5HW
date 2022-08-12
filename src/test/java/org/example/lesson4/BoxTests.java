package org.example.lesson4;

import lesson4.Box;
import lesson4.BoxIsEmptyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class BoxTests {
    Box box;

    @Nested
    class WhenEmptyBox{
        @BeforeEach
        void createEmptyBox() {
            box = new Box();
        }

        @Test
        void whereDeleteBallThrowException(){
            Assertions.assertThrows(BoxIsEmptyException.class,() -> box.deleteBall());
        }

        @Nested
        class WhenOneBall {
            @BeforeEach
            void addBall(){
                box.addBall();
            }

            @Test
            void deleteBall() throws BoxIsEmptyException {
                box.deleteBall();
                Assertions.assertEquals(0, box.getBallsCount());
            }
        }
    }
}
