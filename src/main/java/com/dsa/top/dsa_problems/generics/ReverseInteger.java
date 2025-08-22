package com.dsa.top.dsa_problems.generics;

public class ReverseInteger {

        public static int reverse(int n) {
            long num = n;          // cast to long to prevent overflow
            boolean negative = num < 0;
            if (negative) num = -num;

            long reverse = 0;
            while (num > 0) {
                reverse = reverse * 10 + (num % 10);
                num /= 10;
            }

            if (negative) reverse = -reverse;

            // check boundaries
            if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) return 0;

            return (int) reverse;
        }
    }



