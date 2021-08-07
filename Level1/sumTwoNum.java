// level 1 - 두 개 뽑아서 더하기

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;


class Solution {
    public int[] solution(int[] numbers) {
        int length = numbers.length;
        HashSet<Integer> set = new HashSet<>();
        //두 개의 숫자 조합을 set객체에 넣어준다.(중복 값은 알아서 사라짐)
        for(int i = 0; i < length - 1; i++){
            for(int j = i + 1; j < length; j++){
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        //list와 sort를 통해 배열에 넣어준다.
        ArrayList<Integer> list = new ArrayList<>(set);
        int[] answer = new int[list.size()];
        Collections.sort(list);

        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
