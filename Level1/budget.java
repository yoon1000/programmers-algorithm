// level 1 - 예산

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int count = 0;

        //Arraylist에 부서가 신청한 금액을 넣어준다.
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : d){
            list.add(i);
        }   
        //작은 금액부터 정렬해준다.
        Collections.sort(list);
        
        //예산에서 작은 금액부터 빼가면서 예산을 넘지 않을때 까지의 부서 갯수를 세준다.
        for(int i : list){
            budget -= i;
            if(budget < 0)
                break;
            count++;
        }
        answer = count;
        return answer;
    }
}
