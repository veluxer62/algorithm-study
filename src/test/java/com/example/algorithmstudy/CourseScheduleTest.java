package com.example.algorithmstudy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourseScheduleTest {
    private final Solution sut = new Solution();

    /*
     * 0을 완료하기 위해서는 1을 끝내야 한다는 것을 [0,1] 쌍으로 표현하는 n개의 코스가 있다.
     * 코스 개수 n과 이 쌍들을 입력으로 받았을 때 모든 코스가 완료 가능한지 판별하라.
     */

    @Test
    public void test_canFinish() {
        var numCourses = 3;
        var prerequisites = new int[][] {{1,0}, {2,1}};
        var actual = sut.canFinish(numCourses, prerequisites);
        assertTrue(actual);

        numCourses = 2;
        prerequisites = new int[][] {{2,1}, {1,2}};
        actual = sut.canFinish(numCourses, prerequisites);
        assertFalse(actual);
    }

    @Test
    public void test_canFinish2() {
        var numCourses = 3;
        var prerequisites = new int[][] {{1,0}, {2,1}};
        var actual = sut.canFinish2(numCourses, prerequisites);
        assertTrue(actual);

        numCourses = 2;
        prerequisites = new int[][] {{2,1}, {1,2}};
        actual = sut.canFinish2(numCourses, prerequisites);
        assertFalse(actual);
    }

    private static class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            var finishToTakeMap = new HashMap<Integer, List<Integer>>();
            for (var prerequisite : prerequisites) {
                finishToTakeMap.putIfAbsent(prerequisite[0], new ArrayList<>());
                finishToTakeMap.get(prerequisite[0]).add(prerequisite[1]);
            }

            var takes = new ArrayList<Integer>();
            for (var finish : finishToTakeMap.keySet()) {
                if (!dfs(finishToTakeMap, finish, takes)) return false;
            }

            return true;
        }

        private boolean dfs(Map<Integer, List<Integer>> finishToTakeMap, Integer finish, List<Integer> takes) {
            if (takes.contains(finish)) return false;

            if (finishToTakeMap.containsKey(finish)) {
                takes.add(finish);
                for (var take : finishToTakeMap.get(finish)) {
                    if (!dfs(finishToTakeMap, take, takes)) return false;
                }
                takes.remove(finish);
            }

            return true;
        }

        /*
         * m={[1=0], [2=1]}
         * takes=[]
         *
         * t=1
         * takes=[1]
         *      t=0
         * takes=[]
         *
         * t=2
         * takes=[2]
         *      t=1
         *      takes=[2,1]
         *          t=0
         *      takes=[2]
         * takes=[]
         */

        public boolean canFinish2(int numCourses, int[][] prerequisites) {
            var finishToTakeMap = new HashMap<Integer, List<Integer>>();
            for (var prerequisite : prerequisites) {
                finishToTakeMap.putIfAbsent(prerequisite[0], new ArrayList<>());
                finishToTakeMap.get(prerequisite[0]).add(prerequisite[1]);
            }

            var takes = new ArrayList<Integer>();
            var taken = new ArrayList<Integer>();

            for (var finish : finishToTakeMap.keySet()) {
                if (!dfs(finishToTakeMap, finish, takes, taken)) return false;
            }

            return true;
        }

        private boolean dfs(Map<Integer, List<Integer>> finishToTakeMap, Integer finish, List<Integer> takes, List<Integer> taken) {
            if (takes.contains(finish)) return false;
            if (taken.contains(finish)) return true;

            if (finishToTakeMap.containsKey(finish)) {
                takes.add(finish);
                for (var take : finishToTakeMap.get(finish)) {
                    if (!dfs(finishToTakeMap, take, taken, taken)) return false;
                }
                taken.remove(finish);
                takes.add(finish);
            }

            return true;
        }
    }
}
