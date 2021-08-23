// 코딩테스트 고득점 Kit - Hash - 전화번호 목록

import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
         boolean answer = true;
        HashMap<String, Integer> length = new HashMap<>();
        for(int i = 0; i < phone_book.length; i++){
            length.put(phone_book[i], phone_book[i].length());
        }

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
