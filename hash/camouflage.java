// level 2 - 위장

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        int length = clothes.length;
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < length; i++){
            hashMap.put(clothes[i][1], hashMap.getOrDefault(clothes[i][1], 0)+1);
        }
        for(int val: hashMap.values()){
            answer = answer * (val + 1);
        }
        answer = answer -1;

        return answer;
    }
}
