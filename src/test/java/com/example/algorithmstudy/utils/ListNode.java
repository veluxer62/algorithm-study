package com.example.algorithmstudy.utils;

import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    public ListNode(List<Integer> list) {
        this.val = list.get(0);
        var temp = this;
        for (int i = 1; i < list.size(); i++) {
            temp.next = new ListNode(list.get(i));
            temp = temp.next;
        }
    }
}
