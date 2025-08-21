package com.dsa.top.dsa_problems.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class LongestPalindromicSubstringTest {

    @Test
    void testEmptyString() {
        assertEquals("", LongestPalindromicSubstring.longestPalindrome(""), "Empty string should return empty palindrome");
    }

    @Test
    void testSingleCharacter() {
        assertEquals("a", LongestPalindromicSubstring.longestPalindrome("a"), "Single char should return itself");
    }

    @Test
    void testTwoCharactersPalindrome() {
        assertEquals("aa", LongestPalindromicSubstring.longestPalindrome("aa"), "Two same chars should return both");
    }

    @Test
    void testTwoCharactersNonPalindrome() {
        String result = LongestPalindromicSubstring.longestPalindrome("ab");
        // Either "a" or "b" is valid
        boolean valid = result.equals("a") || result.equals("b");
        assertTrue(valid, "Should return either 'a' or 'b'");
    }

    @Test
    void testOddLengthPalindrome() {
        assertEquals("bab", LongestPalindromicSubstring.longestPalindrome("babad"), "Longest palindrome is 'bab' or 'aba'");
    }

    @Test
    void testEvenLengthPalindrome() {
        assertEquals("bb", LongestPalindromicSubstring.longestPalindrome("cbbd"), "Longest palindrome is 'bb'");
    }

    @Test
    void testWholeStringIsPalindrome() {
        assertEquals("racecar", LongestPalindromicSubstring.longestPalindrome("racecar"), "Whole string is palindrome");
    }

    @Test
    void testPalindromeInMiddle() {
        assertEquals("aba", LongestPalindromicSubstring.longestPalindrome("xxabayy"), "Longest palindrome is 'aba'");
    }

    @Test
    void testLongStringWithMultiplePalindromes() {
        String result = LongestPalindromicSubstring.longestPalindrome("forgeeksskeegfor");
        assertEquals("geeksskeeg", result, "Longest palindrome is 'geeksskeeg'");
    }

    @Test
    void testUnicodePalindrome() {
        assertEquals("éé", LongestPalindromicSubstring.longestPalindrome("abcdééf"), "Palindrome with unicode 'éé'");
    }
}

