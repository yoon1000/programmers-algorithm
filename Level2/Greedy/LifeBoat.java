// level 2 탐욕법 - 구명보트 - 22/2/14

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        // 사람들의 몸무게를 오름차순으로 정렬해준다.
        Arrays.sort(people);
      
        // ArrayList를 이용하여 Stack과 같은 자료구조를 사용한다.
        ArrayList<Integer> stack = new ArrayList<>();
        for(int i = people.length-1; i>=0; i--){
            // 몸무게가 무거운 사람부터 stack에 추가한다.
            stack.add(people[i]);
            if(stack.size()>=2){
                // 현재 스택의 가장 가벼운 사람 둘을 더했을 때 limit보다 작으면 한 개의 보트로 갈 수 있다.
                int peek = stack.get(stack.size()-1);
                int peek2 =stack.get(stack.size()-2);
                if(peek + peek2 <=limit){
                    answer++;
                    stack.remove(stack.size()-1);
                    stack.remove(stack.size()-1);
                }
            }
        }
      
        // 나머지 사람들은 각자 한 개의 보트로 타야하므로 남은 사람의 수를 더해준다.
        answer = answer + stack.size();
        return answer;
    }
}
