package com.dsa.top.dsa_problems.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AddTwoNumbersTest {

    private ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int num : arr) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Helper to convert linked list to string for easy comparison
    private String listToString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) sb.append("->");
            head = head.next;
        }
        return sb.toString();
    }

    @Test
    void testSimpleCase() {
        ListNode l1 = createList(new int[]{2, 4, 3}); // 342
        ListNode l2 = createList(new int[]{5, 6, 4}); // 465
        ListNode result = AddTwoNumbers.addTwoNumbers(l1, l2);  // 807 -> [7,0,8]

        assertEquals("7->0->8", listToString(result));
    }

    @Test
    void testDifferentLength() {
        ListNode l1 = createList(new int[]{9, 9});   // 99
        ListNode l2 = createList(new int[]{1});      // 1
        ListNode result = AddTwoNumbers.addTwoNumbers(l1, l2); // 100 -> [0,0,1]

        assertEquals("0->0->1", listToString(result));
    }

    @Test
    void testWithCarryOver() {
        ListNode l1 = createList(new int[]{5});   // 5
        ListNode l2 = createList(new int[]{5});   // 5
        ListNode result = AddTwoNumbers.addTwoNumbers(l1, l2); // 10 -> [0,1]

        assertEquals("0->1", listToString(result));
    }

    @Test
    void testEmptyList() {
        ListNode l1 = null; // 0
        ListNode l2 = createList(new int[]{1, 2, 3}); // 321
        ListNode result = AddTwoNumbers.addTwoNumbers(l1, l2);

        assertEquals("1->2->3", listToString(result));
    }

    @Test
    void testBothNull() {
        ListNode result = AddTwoNumbers.addTwoNumbers(null, null);
        assertEquals("", listToString(result));
    }
}

