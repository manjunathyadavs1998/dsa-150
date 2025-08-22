package com.dsa.top.dsa_problems.generic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.dsa.top.dsa_problems.generics.ReverseInteger;
import org.junit.jupiter.api.Test;

public class ReverseIntegerTest {

    @Test
    void testPositiveNumber() {
        assertEquals(321, ReverseInteger.reverse(123), "123 reversed is 321");
    }

    @Test
    void testNegativeNumber() {
        assertEquals(-321, ReverseInteger.reverse(-123), "-123 reversed is -321");
    }

    @Test
    void testNumberEndingWithZero() {
        assertEquals(21, ReverseInteger.reverse(120), "120 reversed is 21");
        assertEquals(-21, ReverseInteger.reverse(-120), "-120 reversed is -21");
    }

    @Test
    void testSingleDigit() {
        assertEquals(5, ReverseInteger.reverse(5), "Single digit remains the same");
        assertEquals(-7, ReverseInteger.reverse(-7), "Single negative digit remains the same");
    }

    @Test
    void testZero() {
        assertEquals(0, ReverseInteger.reverse(0), "0 reversed is 0");
    }

    @Test
    void testMaxInteger() {
        // 2147483647 reversed overflows → return 0
        assertEquals(0, ReverseInteger.reverse(2147483647), "Overflow returns 0");
    }

    @Test
    void testMinInteger() {
        // -2147483648 reversed overflows → return 0
        assertEquals(0, ReverseInteger.reverse(-2147483648), "Overflow returns 0");
    }

    @Test
    void testPalindromeNumber() {
        assertEquals(1221, ReverseInteger.reverse(1221), "Palindrome number remains same after reverse");
        assertEquals(-1221, ReverseInteger.reverse(-1221), "Negative palindrome");
    }

    @Test
    void testLargeNumberWithinRange() {
        assertEquals(463847412, ReverseInteger.reverse(2147483647 / 10), "Edge large number");
    }
}
