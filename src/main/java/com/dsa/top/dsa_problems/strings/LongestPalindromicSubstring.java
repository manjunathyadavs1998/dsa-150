package com.dsa.top.dsa_problems.strings;

public class LongestPalindromicSubstring {


    /*
    🔎 Dry Run Example ("babad")

        i=0 → check "b", expand → "bab" → length 3

        i=1 → check "a", expand → "aba" → length 3

        i=2 → check "b", expand → "bab" again

        Result = "bab" or "aba" ✅


     */

    private static String expandAroundCenter(String s, int left, int right) {
        int n = s.length();
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";

        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            // Odd length palindrome
            String odd = expandAroundCenter(s, i, i);

            // Even length palindrome
            String even = expandAroundCenter(s, i, i + 1);

            // Pick the longer one
            if (odd.length() > ans.length()) ans = odd;
            if (even.length() > ans.length()) ans = even;
        }
        return ans;
    }

}
