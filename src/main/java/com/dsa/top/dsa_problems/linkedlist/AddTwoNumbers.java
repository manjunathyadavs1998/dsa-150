package com.dsa.top.dsa_problems.linkedlist;

import java.util.List;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;

        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        ListNode temp1 = l1, temp2 = l2;

        while (temp1 != null || temp2 != null) {
            int x = (temp1 != null) ? temp1.val : 0;
            int y = (temp2 != null) ? temp2.val : 0;

            int sum = x + y + carry;
            carry = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;

            if (temp1 != null) temp1 = temp1.next;
            if (temp2 != null) temp2 = temp2.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummy.next;  // head of result
    }

}
