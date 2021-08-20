// 코딩테스트 고득점 Kit - Hash - 전화번호 목록

import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        String substring = "";
        HashMap<String, Integer> length = new HashMap<>();
        for(int i = 0; i < phone_book.length; i++){
            length.put(phone_book[i], phone_book[i].length());
        }
        List<Map.Entry<String, Integer>> lengthList = new LinkedList<>(length.entrySet());
        lengthList.sort(Map.Entry.comparingByValue());

        for(int i = 0; i < phone_book.length-1; i++){
            for(int j = i+1; j < phone_book.length; j++){
                substring = lengthList.get(j).getKey()
                        .substring(0, lengthList.get(i).getValue());
                boolean prefix = substring.equals(lengthList.get(i).getKey());
                if(prefix){
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }
}
