package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KotlinDesignHashMapTest {
    /*
     * 다음과 같은 기능을 제공하는 해시맵을 디자인하라.
     */

    @Test
    fun test_MyHashMap() {
        val map = MyHashMap()
        map.put(1, 1)
        map.put(2, 2)
        assertEquals(1, map.get(1))
        assertEquals(-1, map.get(3))
        assertEquals(2, map.get(2))
        map.put(2, 1)
        assertEquals(1, map.get(2))
        map.remove(2)
        assertEquals(-1, map.get(2))
    }

    private class MyHashMap {
        private val nodes = arrayOfNulls<Node>(1000000)

        fun put(
            key: Int,
            value: Int,
        ) {
            val index = key % nodes.size
            var node = nodes[index]

            if (node == null) {
                nodes[index] = Node(key, value)
                return
            }

            while (true) {
                if (node?.key == key) {
                    node.value = value
                    return
                }

                if (node?.next == null) break

                node = node.next
            }

            node?.next = Node(key, value)
        }

        fun get(key: Int): Int {
            val index = key % nodes.size
            var node = nodes[index]

            if (node == null) return -1

            while (node != null) {
                if (node.key == key) {
                    return node.value
                }

                node = node.next
            }

            return -1
        }

        fun remove(key: Int) {
            val index = key % nodes.size
            var node = nodes[index]

            if (node == null) return

            if (node.key == key) {
                if (node.next == null) {
                    nodes[index] = null
                } else {
                    nodes[index] = node.next
                }
            }

            var prev = node
            while (node != null) {
                if (node.key == key) {
                    prev?.next = node.next
                    return
                }

                prev = node
                node = node.next
            }
        }

        private data class Node(val key: Int, var value: Int, var next: Node? = null)
    }
}
