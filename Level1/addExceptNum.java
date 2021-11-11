// level 1 - 없는 숫자 더하기

import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        for(int A: numbers){
          hashSet.add(A);
        }
        for(int i = 0; i < 10; i++){
           if(!hashSet.contains(i))
           answer += i;
        }
      return answer;
    }
}
