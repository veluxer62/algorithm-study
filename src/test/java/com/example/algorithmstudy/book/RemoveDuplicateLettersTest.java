package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveDuplicateLettersTest {
    private final Solution sut = new Solution();

    /*
     * 중복된 문자를 제외하고 사전식 순서로 나열하라.
     */

    @Test
    public void test_removeDuplicateLetters() {
        var s = "dbacdcdb";
        var actual = sut.removeDuplicateLetters(s);
        assertEquals("acdb", actual);
    }

    @Test
    public void test_removeDuplicateLetters2() {
        var s = "dbacdcdb";
        var actual = sut.removeDuplicateLetters2(s);
        assertEquals("acdb", actual);
    }

    private static class Solution {
        public String removeDuplicateLetters(String s) {
            for (char c : toSortedSet(s)) {
                var suffix = s.substring(s.indexOf(c));
                if (toSortedSet(s).equals(toSortedSet(suffix))) {
                    var replace = suffix.replace(String.valueOf(c), "");
                    return c + removeDuplicateLetters(replace);
                }
            }

            return "";
        }

        /*
         * s=dbacdcbc
         * set=[a,b,c,d]
         * c=a
         * su=acdcdb
         * [a,b,c,d]=[a,b,c,d]
         * r=cdcdb
         * a +
         *      s=cdcdb
         *      set=[b,c,d]
         *      c=b
         *      su=b
         *      [b,c,d]=[b]
         *
         *      c=c
         *      su=cdcdb
         *      [b,c,d]=[b,c,d]
         *      r=ddb
         *      c +
         *          s=ddb
         *          set=[b,d]
         *          c=b
         *          su=b
         *          [b,d]=[b]
         *
         *          c=d
         *          su=ddb
         *          [b,d]=[b,d]
         *          r=b
         *          d +
         *              s=b
         *              set=[b]
         *              c=b
         *              su=b
         *              r=
         *              b
         * acdb
         */

        private Set<Character> toSortedSet(String s) {
            Set<Character> set = new TreeSet<>(Comparator.naturalOrder());

            for (char c : s.toCharArray()) {
                set.add(c);
            }

            return set;
        }

        public String removeDuplicateLetters2(String s) {
            var counter = new HashMap<Character, Integer>();
            var seen = new HashMap<Character, Boolean>();
            var stack = new ArrayDeque<Character>();

            for (char c : s.toCharArray()) {
                counter.put(c, counter.getOrDefault(c, 0) + 1);
            }

            for (char c : s.toCharArray()) {
                counter.put(c, counter.getOrDefault(c, 0) - 1);

                if (seen.containsKey(c) && seen.get(c)) {
                    continue;
                }

                while(!stack.isEmpty() && stack.peek() > c && counter.get(stack.peek()) > 0) {
                    seen.put(stack.pop(), false);
                }

                stack.push(c);
                seen.put(c, true);
            }

            var sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pollLast());
            }

            return sb.toString();
        }

        /*
         * s=dbacdcdb
         * co={d=3, b=2, a=1, c=2}
         * se={}
         * st=[]
         *
         * c=d
         * co={d=2, b=2, a=1, c=2}
         * null != null
         * false
         * st=[d]
         * se={d=true}
         *
         * c=b
         * co={d=2, b=1, a=1, c=2}
         * null != null
         * true && d > b && 1 > 0
         * se={d=false}
         * st=[]
         * false
         * st=[b]
         * se={d=false, b=true}
         *
         * c=a
         * co={d=2, b=1, a=0, c=2}
         * null != null
         * true && b > a && 1 > 0
         * se={d=false, b=false}
         * st=[]
         * false
         * st=[a]
         * se={d=false, b=false, a=true}
         *
         * c=c
         * co={d=2, b=1, a=0, c=1}
         * null != null
         * true && a > c
         * st=[a, c]
         * se={d=false, b=false, a=true, c=true}
         *
         * c=d
         * co={d=1, b=1, a=0, c=1}
         * null != null
         * true && a > d
         * true && c > d
         * st=[a,c,d]
         * se={d=true, b=false, a=true, c=true}
         *
         * c=c
         * co={d=1, b=1, a=0, c=0}
         * true != null && true
         *
         * c=d
         * co={d=0, b=1, a=0, c=0}
         * true != null && true
         *
         * c=b
         * co={d=0, b=0, a=0, c=0}
         * false != null && false
         * true && a > b
         * true && c > b && 0 > 0
         * true && d > b && 0 > 0
         * st=[a,c,d,b]
         * se={d=true, b=true, a=true, c=true}
         */
    }
}
