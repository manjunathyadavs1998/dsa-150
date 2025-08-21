package com.dsa.top.dsa_problems.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LongestSubstringTest {

    @Test
    void testEmptyString() {
        assertEquals(0, LongestSubstring.lengthOfLongestSubstring(""), "Empty string should return 0");
    }

    @Test
    void testSingleCharacter() {
        assertEquals(1, LongestSubstring.lengthOfLongestSubstring("a"), "Single char should return 1");
    }

    @Test
    void testNoRepeatingCharacters() {
        assertEquals(3, LongestSubstring.lengthOfLongestSubstring("abc"), "All unique should return length of string");
    }

    @Test
    void testRepeatingCharacters() {
        assertEquals(3, LongestSubstring.lengthOfLongestSubstring("abcabcbb"), "Longest substring is 'abc' with length 3");
    }

    @Test
    void testAllSameCharacters() {
        assertEquals(1, LongestSubstring.lengthOfLongestSubstring("bbbbbb"), "All same chars should return 1");
    }

    @Test
    void testMixedCharacters() {
        assertEquals(3, LongestSubstring.lengthOfLongestSubstring("pwwkew"), "Longest substring is 'wke' with length 3");
    }

    @Test
    void testSubstringAtEnd() {
        assertEquals(2, LongestSubstring.lengthOfLongestSubstring("abba"), "Longest substring without repeat is 'ab' or 'ba'");
    }

    @Test
    void testUnicodeCharacters() {
        assertEquals(5, LongestSubstring.lengthOfLongestSubstring("abcdé"), "Unicode should also work (abcdé → 5 unique)");
    }

    @Test
    void testLongString() {
        assertEquals(10, LongestSubstring.lengthOfLongestSubstring("abcdefghijabcdefghij"), "First 10 unique characters → 10");
    }
}
