// level 2 - 위장

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        int length = clothes.length;
        // 옷의 종류별로 몇 벌인지 hashmap으로 구분한다.
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < length; i++){
            hashMap.put(clothes[i][1], hashMap.getOrDefault(clothes[i][1], 0)+1);
        }
        // 옷 종류당 안 입는 경우를 포함하여 모든 경우의 수를 곱해준다.
        for(int val: hashMap.values()){
            answer = answer * (val + 1);
        }
        // 모두 안 입는 경우를 빼준다.
        answer = answer -1;

        return answer;
    }
}
