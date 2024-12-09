package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssignCookiesTest {
    private final Solution sut = new Solution();

    /*
     * 아이들에게 1개씩 쿠키를 나눠줘야 한다. 각 아이(i)마다 그리드 펙터 g를 갖고 있으며, 이는 아이가 만족하는 최소 쿠키의 크기를 말한다.
     * 똫나 각 쿠키(j)의 크기는 s이며, s >= g 여야 아이가 만족하며 쿠키를 받는다. 최대 몇 명의 아이들에게 쿠키를 나눠줄 수 있는지 출력하라.
     */

    @Test
    public void test_findContentChildren() {
        var g = new int[]{1, 2, 3, 4};
        var s = new int[]{1, 1};

        var actual = sut.findContentChildren(g, s);

        assertEquals(1, actual);
    }

    private static class Solution {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);

            var i = 0;
            var j = 0;

            while (i < g.length && j < s.length) {
                if (s[j] >= g[i]) {
                    i++;
                }

                j++;
            }

            return i;
        }
    }
}
