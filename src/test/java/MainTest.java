import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Nested
    @DisplayName("Tests for extractNumbersFromString method")
    class extractNumbersFromStringTests {
        @Test
        void extractNumbersFromCharArrayContainingDigit() {
            String line = "abc2cdb";
            Integer[] expectedArray = {2};
            ArrayList<Integer> numbers = Main.extractNumbersFromString(line);
            assertArrayEquals(numbers.toArray(), expectedArray);
        }

        @Test
        void extractNumbersFromCharArrayContainingNumberWithMultipleDigits() {
            String line = "abc129cdb";
            Integer[] expectedArray = {129};
            ArrayList<Integer> numbers = Main.extractNumbersFromString(line);
            assertArrayEquals(numbers.toArray(), expectedArray);
        }

        @Test
        void extractNumbersFromCharArrayContainingNumberAtTheStart() {
            String line = "129abccdb";
            Integer[] expectedArray = {129};
            ArrayList<Integer> numbers = Main.extractNumbersFromString(line);
            assertArrayEquals(numbers.toArray(), expectedArray);
        }
        @Test
        void extractNumbersFromCharArrayContainingNumberAtTheEnd() {
            String line = "abccdb129";
            Integer[] expectedArray = {129};
            ArrayList<Integer> numbers = Main.extractNumbersFromString(line);
            assertArrayEquals(numbers.toArray(), expectedArray);
        }
        @Test
        void extractNumbersFromCharArrayContainingMultipleNumbers() {
            String line = "0ab78cc1db129";
            Integer[] expectedArray = {0, 78, 1, 129};
            ArrayList<Integer> numbers = Main.extractNumbersFromString(line);
            assertArrayEquals(numbers.toArray(), expectedArray);
        }
        @Test
        void extractNumbersFromCharArrayContainingOnlyDigits() {
            String line = "58422044";
            Integer[] expectedArray = {58422044};
            ArrayList<Integer> numbers = Main.extractNumbersFromString(line);
            assertArrayEquals(numbers.toArray(), expectedArray);
        }
        @Test
        void extractNumbersFromCharArrayContainingOnlyLetters() {
            String line = "abhaskhdkqw";
            Integer[] expectedArray = {};
            ArrayList<Integer> numbers = Main.extractNumbersFromString(line);
            assertArrayEquals(numbers.toArray(), expectedArray);
        }
    }

    @Nested
    @DisplayName("Tests for printLineWhenContainsLargerNumber method")
    class printLineWhenContainsLargerNumberTests {
        private final ByteArrayOutputStream out = new ByteArrayOutputStream();
        private final PrintStream originalOut = System.out;
        @BeforeEach
        public void setStreams() {
            System.setOut(new PrintStream(out));
        }

        @AfterEach
        public void restoreInitialStreams() {
            System.setOut(originalOut);
        }
        @Test
        void printsOutWithLargerNumber() {
            String line = "abccdb11";
            ArrayList<Integer> numbers = new ArrayList<>(List.of(11));
            Main.printLineWhenContainsLargerNumber(line, numbers, 10);
            assertEquals(line+"\n", out.toString());
        }
        @Test
        void printsOutWithEqualNumber() {
            String line = "ab10ccdb";
            ArrayList<Integer> numbers = new ArrayList<>(List.of(10));
            Main.printLineWhenContainsLargerNumber(line, numbers, 10);
            assertEquals(line+"\n", out.toString());
        }
        @Test
        void doesNotPrintOutWithSmallerNumber() {
            String line = "abccdb9";
            ArrayList<Integer> numbers = new ArrayList<>(List.of(9));
            Main.printLineWhenContainsLargerNumber(line, numbers, 10);
            assertEquals("", out.toString());
        }
    }

}