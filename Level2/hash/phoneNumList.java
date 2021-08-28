// level 2 - 코딩테스트 고득점 Kit - Hash - 전화번호 목록

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        // 각 전화번호와 길이를 hashmap에 저장한다.
        HashMap<String, Integer> length = new HashMap<>();
        for(int i = 0; i < phone_book.length; i++){
            length.put(phone_book[i], phone_book[i].length());
        }

        // 전화번호의 substring한 것이(접두사로) hashmap에 포함되어 있는지 판단한다.
        for(int i = 0; i < phone_book.length; i++){
            for(int j = 1; j < phone_book[i].length(); j++){
                if(length.containsKey(phone_book[i].substring(0,j))){
                    answer = false;
                }
            }
        }

        return answer;
    }
}
