package com.example.algorithmstudy;

import com.example.algorithmstudy.utils.ListNode;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;
import java.util.Stack;

import static com.example.algorithmstudy.FunctionsKt.generateList;
import static com.example.algorithmstudy.FunctionsKt.record;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddTowNumbersTest {
    private final Solution sut = new Solution();

    /*
     * 역순으로 저장된 연결 리스트의 숫자를 더하라
     */

    @Test
    public void test_add() {
        var a = new ListNode(List.of(2, 4, 3));
        var b = new ListNode(List.of(5, 6, 2));
        var actual = record(() -> sut.add(a, b));
        assertEquals(
                new ListNode(List.of(7, 0, 6)),
                actual
        );
    }

    @Test
    public void test_add2() {
        var a = new ListNode(List.of(2, 4, 3));
        var b = new ListNode(List.of(5, 6, 2));
        var actual = record(() -> sut.add2(a, b));
        assertEquals(
                new ListNode(List.of(7, 0, 6)),
                actual
        );
    }

    @Test
    public void test_add3() {
        var a = new ListNode(List.of(2, 4, 3));
        var b = new ListNode(List.of(5, 6, 2));
        var actual = record(() -> sut.add3(a, b));
        assertEquals(
                new ListNode(List.of(7, 0, 6)),
                actual
        );

        var aa = new ListNode(generateList(100000));
        var bb = new ListNode(generateList(100000));
        record(() -> sut.add3(aa, bb));
    }

    private static class Solution {
        public ListNode add(ListNode a, ListNode b) {
            var numA = toNum(a);
            var numB = toNum(b);

            var total = numA + numB;

            return toList(total);
        }

        private int toNum(ListNode head) {
            var stack = new Stack<String>();
            var tmp = head;
            while (tmp != null) {
                stack.add(String.valueOf(tmp.val));
                tmp = tmp.next;
            }

            var result = new StringBuilder();
            while (!stack.isEmpty()) {
                result.append(stack.pop());
            }

            return Integer.parseInt(result.toString());
        }

        private ListNode toList(int num) {
            var arr = String.valueOf(num).toCharArray();
            var head = new ListNode(Integer.parseInt(String.valueOf(arr[arr.length - 1])));
            var tmp = head;
            for (var i = arr.length - 2; i >= 0; i--) {
                tmp.next = new ListNode(Integer.parseInt(String.valueOf(arr[i])));
                tmp = tmp.next;
            }

            return head;
        }

        public ListNode add2(ListNode a, ListNode b) {
            var ra = reverseList(a);
            var rb = reverseList(b);
            var n = toBigInteger(ra).add(toBigInteger(rb));
            return toReversedLinkedList(n);
        }

        private ListNode reverseList(ListNode head) {
            ListNode prev = null, node = head;

            while (node != null) {
                var next = node.next;
                node.next = prev;
                prev = node;
                node = next;
            }

            return prev;
        }

        private BigInteger toBigInteger(ListNode head) {
            StringBuilder val = new StringBuilder();
            while (head != null) {
                val.append(head.val);
                head = head.next;
            }

            return new BigInteger(val.toString());
        }

        private ListNode toReversedLinkedList(BigInteger val) {
            ListNode prev = null, node = null;
            for (char c : val.toString().toCharArray()) {
                node = new ListNode(Character.getNumericValue(c));
                node.next = prev;
                prev = node;
            }

            return node;
        }

        /*
         * n = 6-null
         * p = 6-null
         *
         * n = 0-6-null
         * p = 0-6-null
         *
         * n = 7-0-6-null
         * p = 7-0-6-null
         */

        public ListNode add3(ListNode a, ListNode b) {
            var node = new ListNode(0);
            var root = node;

            int sum, carry = 0, remainder;

            while(a != null || b != null || carry != 0) {
                sum = 0;
                if (a != null) {
                    sum += a.val;
                    a = a.next;
                }

                if (b != null) {
                    sum += b.val;
                    b = b.next;
                }

                remainder = (sum + carry) % 10;
                carry = (sum + carry) / 10;

                node.next = new ListNode(remainder);
                node = node.next;
            }

            return root.next;
        }

        /*
         * r=0
         * n=0
         * s=0
         * c=0
         * r=0
         *
         * s=7
         * r=(7+0) % 10 = 7
         * c=(7+0) / 10 = 0
         * n=0-7
         * n=7
         * r=0-7
         *
         * s=10
         * r=(10+0) % 10 = 0
         * c=(10+0) / 10 = 1
         * n=7-0
         * n=0
         * r=0-7-0
         *
         * s=5
         * r=(5+1) % 10 = 6
         * c=(5+1) / 10 = 0
         * n=0-6
         * n=6
         * r=0-7-0-6
         */
    }
}
