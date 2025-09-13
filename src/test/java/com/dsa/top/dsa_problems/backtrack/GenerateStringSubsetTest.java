package com.dsa.top.dsa_problems.backtrack;


import com.dsa.top.dsa_problems.backtracing.GenerateStringSubset;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenerateStringSubsetTest {

    @Test
    void testEmptyString() {
        List<String> subsets = GenerateStringSubset.generateSubsets("");
        assertEquals(1, subsets.size(), "Empty string should have only one subset: \"\"");
        assertTrue(subsets.contains(""), "Subset should contain the empty string");
    }

    @Test
    void testSingleCharacter() {
        List<String> subsets = GenerateStringSubset.generateSubsets("a");
        assertEquals(2, subsets.size(), "Single character string should have 2 subsets");
        assertTrue(subsets.contains(""), "Should contain empty subset");
        assertTrue(subsets.contains("a"), "Should contain 'a'");
    }

    @Test
    void testTwoCharacters() {
        List<String> subsets = GenerateStringSubset.generateSubsets("ab");
        assertEquals(4, subsets.size(), "String 'ab' should have 4 subsets");
        assertTrue(subsets.contains(""), "Should contain empty subset");
        assertTrue(subsets.contains("a"), "Should contain 'a'");
        assertTrue(subsets.contains("b"), "Should contain 'b'");
        assertTrue(subsets.contains("ab"), "Should contain 'ab'");
    }

    @Test
    void testThreeCharacters() {
        List<String> subsets = GenerateStringSubset.generateSubsets("abc");
        assertEquals(8, subsets.size(), "String 'abc' should have 8 subsets");
        assertTrue(subsets.contains(""), "Should contain empty subset");
        assertTrue(subsets.contains("a"), "Should contain 'a'");
        assertTrue(subsets.contains("b"), "Should contain 'b'");
        assertTrue(subsets.contains("c"), "Should contain 'c'");
        assertTrue(subsets.contains("ab"), "Should contain 'ab'");
        assertTrue(subsets.contains("ac"), "Should contain 'ac'");
        assertTrue(subsets.contains("bc"), "Should contain 'bc'");
        assertTrue(subsets.contains("abc"), "Should contain 'abc'");
    }

    @Test
    void testDuplicatesInString() {
        List<String> subsets = GenerateStringSubset.generateSubsets("aa");
        // Should still generate 4 subsets because method does not eliminate duplicates
        assertEquals(4, subsets.size());
        assertTrue(subsets.contains(""), "Should contain empty subset");
        assertTrue(subsets.contains("a"), "Should contain 'a' at least once");
        assertTrue(subsets.contains("aa"), "Should contain 'aa'");
    }
}

