// level 1 - 3진법 뒤집기

import java.util.ArrayList;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int div = 1;
        ArrayList<Integer> list= new ArrayList<>();
        
        //n을 나눈 몫이 0보다 클 동안 list에 n을 나눈 나머지를 계속 넣어준다.
        //나눈 순서대로 넣으면 앞뒤 반전된 순서와 같다.
        while (div != 0){
            div = n/3;
            list.add(n%3);
            n = n/3;
        }
        
        //list에 들어있는 순서대로 3진법대로 계산해준 후 answer의 값에 계속 더해준다.
        int length = list.size();
        for(int i = 0; i < length; i++){
            answer += list.get(i)*(Math.pow(3, (length-1-i)));
        }
        return answer;
    }
}
