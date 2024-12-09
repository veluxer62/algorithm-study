package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZeroOneKnapsackTest {
    private final Solution sut = new Solution();

    @Test
    public void test_zeroOneKnapsack() {
        var cargos = List.of(
                new Solution.Cargo(4, 12),
                new Solution.Cargo(2, 1),
                new Solution.Cargo(10, 4),
                new Solution.Cargo(1, 1),
                new Solution.Cargo(2, 2)
        );
        var capacity = 15;

        var actual = sut.zeroOneKnapsack(cargos, capacity);

        assertEquals(15, actual);
    }


    private static class Solution {
        private static class Cargo {
            int price;
            int weight;

            public Cargo(int price, int weight) {
                this.price = price;
                this.weight = weight;
            }
        }

        public int zeroOneKnapsack(List<Cargo> cargos, int capacity) {
            var pack = new int[cargos.size() + 1][capacity + 1];

            for (var i = 0; i <= cargos.size(); i++) {
                for (var c = 0; c <= capacity; c++) {
                    if (i == 0 || c == 0) {
                        pack[i][c] = 0;
                    } else if (cargos.get(i - 1).weight <= c) {
                        pack[i][c] = Math.max(cargos.get(i - 1).price + pack[i - 1][c - cargos.get(i - 1).weight], pack[i - 1][c]);
                    } else {
                        pack[i][c] = pack[i - 1][c];
                    }
                }
            }

            return pack[cargos.size()][capacity];
        }
    }
}
