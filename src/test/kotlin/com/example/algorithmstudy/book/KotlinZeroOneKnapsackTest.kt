package com.example.algorithmstudy.book

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KotlinZeroOneKnapsackTest {
    @Test
    fun test_zeroOneKnapsack() {
        val cargos =
            listOf(
                Cargo(4, 12),
                Cargo(2, 1),
                Cargo(10, 4),
                Cargo(1, 1),
                Cargo(2, 2),
            )
        val capacity = 15

        val actual: Int = zeroOneKnapsack(cargos, capacity)

        assertEquals(15, actual)
    }

    private fun zeroOneKnapsack(
        cargos: List<Cargo>,
        capacity: Int,
    ): Int {
        val pack = Array(cargos.size + 1) { IntArray(capacity + 1) }

        for (i in 0..cargos.size) {
            for (c in 0..capacity) {
                pack[i][c] =
                    when {
                        i == 0 || c == 0 -> 0
                        cargos[i - 1].weight <= c ->
                            maxOf(
                                cargos[i - 1].price + pack[i - 1][c - cargos[i - 1].weight],
                                pack[i - 1][c],
                            )

                        else -> pack[i - 1][c]
                    }
            }
        }

        return pack[cargos.size][capacity]
    }

    private data class Cargo(
        val price: Int,
        val weight: Int,
    )
}
