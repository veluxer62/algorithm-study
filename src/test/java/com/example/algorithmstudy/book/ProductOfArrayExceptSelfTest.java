package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import static com.example.algorithmstudy.FunctionsKt.generateIntArray;
import static com.example.algorithmstudy.FunctionsKt.record;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductOfArrayExceptSelfTest {
    private final Solution sut = new Solution();

    /*
     * 배열을 입력받아 output[i]가 자신을 제외한 나머지 모든 엘리먼트의 곱셈 결과가 되도록 출력하다.
     */

    @Test
    public void test_productExceptSelf() {
        var arr = new int[]{1, 3, 5, 7};
        var actual = record(() -> sut.productExceptSelf(arr));
        assertArrayEquals(new int[]{105, 35, 21, 15}, actual);

        var arr2 = generateIntArray(50000);
        record(() -> sut.productExceptSelf(arr2));
    }

    @Test
    public void test_productExceptSelf2() {
        var arr = new int[]{1, 3, 5, 7};
        var actual = record(() -> sut.productExceptSelf2(arr));
        assertArrayEquals(new int[]{105, 35, 21, 15}, actual);

        var arr2 = generateIntArray(50000);
        record(() -> sut.productExceptSelf2(arr2));
    }

    @Test
    public void test_productExceptSelf3() {
        var arr = new int[]{1, 3, 5, 7};
        var actual = record(() -> sut.productExceptSelf3(arr));
        assertArrayEquals(new int[]{105, 35, 21, 15}, actual);

        var arr2 = generateIntArray(50000);
        record(() -> sut.productExceptSelf3(arr2));
    }

    private static class Solution {
        public int[] productExceptSelf(int[] nums) {
            var result = new int[nums.length];

            for (int i = 0; i < nums.length; i++) {
                var sum = 1;

                for (int j = 0; j < nums.length; j++) {
                    if (i != j) {
                        sum = sum * nums[j];
                    }
                }

                result[i] = sum;
            }

            return result;
        }

        public int[] productExceptSelf2(int[] nums) {
            var result = new int[nums.length];

            for (int i = 0; i < nums.length; i++) {
                var sum = 1;
                for (int num : nums) {
                    sum *= num;
                }

                result[i] = sum / nums[i];
            }

            return result;
        }

        public int[] productExceptSelf3(int[] nums) {
            var result = new int[nums.length];
            var p = 1;
            for (int i = 0; i < nums.length; i++) {
                result[i] = p;
                p *= nums[i];
            }

            p = 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                result[i] *= p;
                p *= nums[i];
            }

            return result;
        }
    }
}
