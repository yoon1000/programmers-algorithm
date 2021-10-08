// level 2 - 정렬 - H_index

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0; int h = -1;
        // 정렬을 위해 Integer 배열을 이용한다.
        Integer[] sortedList = new Integer[citations.length];
        for(int i = 0; i < citations.length; i++){
            sortedList[i] = citations[i];
        }
        Arrays.sort(sortedList);
      
        // (논문의 총 갯수) 번 보다 작게 반복을 해준다.
        while(h < citations.length){
            h++;
            int num = 0;
            // 해당 논문들중 h번 이상 인용된 논문의 갯수를 구한다.
            for(int i = 0; i <citations.length; i++){
                if(h <= sortedList[i])
                    num++;
            }
            // 해당 논문의 h가 갯수보다 커져버리면 그 보다 하나 작은 h-1이 정답이 된다.
            if(num < h) {
                answer = h-1;
                break;
            }
            
            if(h == num) {
                answer = h;
                break;
            }

        }
        return answer;
    }
}
