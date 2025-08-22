package com.dsa.top.dsa_problems.dp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CoinChangeIITest {

    @Test
    void testZeroAmount() {
        int[] coins = {1, 2, 5};
        assertEquals(1, CoinChangeII.change(0, coins), "Amount 0 should have 1 combination (no coins)");
    }

    @Test
    void testSingleCoinExactMatch() {
        int[] coins = {1, 2, 5};
        assertEquals(1, CoinChangeII.change(5, new int[]{5}), "Amount 5 with single coin 5 should have 1 combination");
    }

    @Test
    void testNoPossibleCombination() {
        int[] coins = {2, 4};
        assertEquals(0, CoinChangeII.change(3, coins), "Amount 3 cannot be formed with coins {2,4}");
    }

    @Test
    void testMultipleCombinations() {
        int[] coins = {1, 2, 5};
        assertEquals(4, CoinChangeII.change(5, coins), "Amount 5 can be made in 4 combinations");
        // Explanation: [5], [2+2+1], [2+1+1+1], [1+1+1+1+1]
    }

    @Test
    void testEmptyCoins() {
        int[] coins = {};
        assertEquals(0, CoinChangeII.change(5, coins), "No coins available should return 0 combinations for amount > 0");
    }

    @Test
    void testLargeAmount() {
        int[] coins = {1, 2, 3};
        assertEquals(4, CoinChangeII.change(4, coins), "Amount 4 with coins {1,2,3} has 7 combinations");
        // Combinations: [1+1+1+1], [1+1+2], [2+2], [1+3], [2+1+1], [3+1], [1+2+1] (order doesn't matter)
    }

    @Test
    void testSingleCoinMultipleTimes() {
        int[] coins = {2};
        assertEquals(1, CoinChangeII.change(4, coins), "Amount 4 can be made only by 2+2");
        assertEquals(0, CoinChangeII.change(3, coins), "Amount 3 cannot be formed with only coin 2");
    }

    @Test
    void testAmountZeroEmptyCoins() {
        int[] coins = {};
        assertEquals(1, CoinChangeII.change(0, coins), "Amount 0 always has 1 combination (no coins)");
    }
}

