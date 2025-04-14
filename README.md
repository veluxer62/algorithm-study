# 알고리즘

### Boyer-Moore 과반수 투표 알고리즘

Boyer-Moore 다수결 투표 알고리즘(Boyer-Moore Majority Vote Algorithm)은 배열에서 과반수(majority element, 전체 원소 수의 절반 초과로 등장하는 값)를 찾기 위한 O(n) 시간, O(1) 공간 알고리즘입니다.
과반수 원소가 존재한다면, 해당 원소는 투표를 거쳐도 결국 **"후보자(candidate)"**로 남는다는 것을 이용합니다. 최종적으로 남은 후보가 과반수인지 검증하는 과정이 필요할 수 있습니다 (문제에서 반드시 과반수가 존재한다는 조건이 없을 경우).

```java
public class BoyerMoore {
    public static Integer majorityElement(int[] nums) {
        Integer candidate = null;
        int count = 0;

        // 1차 스캔: 후보 선택
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        // 2차 스캔: 후보 검증 (필요한 경우)
        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }

        // 과반수 조건: 등장 횟수가 전체의 절반 초과인지 확인
        if (count > nums.length / 2) {
            return candidate;
        } else {
            return null; // 과반수가 없는 경우
        }
    }
}
```

#### 출처
- https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm

