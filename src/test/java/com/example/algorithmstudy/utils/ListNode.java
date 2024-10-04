package com.example.algorithmstudy.utils;

import java.util.LinkedList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        var me = toLinkedList(this);
        var other = toLinkedList((ListNode)o);
        return me.equals(other);
    }

    private LinkedList<Integer> toLinkedList(ListNode node) {
        var result = new LinkedList<Integer>();
        var temp = node;

        while (temp != null) {
            result.add(temp.val);
            temp = temp.next;
        }

        return result;
    }

    @Override
    public int hashCode() {
        return toLinkedList(this).hashCode();
    }

    @Override
    public String toString() {
        return toLinkedList(this).toString();
    }
}
