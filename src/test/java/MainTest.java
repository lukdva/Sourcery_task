import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

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