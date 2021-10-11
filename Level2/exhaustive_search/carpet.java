// level 2 - 완전탐색 - 카펫

import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int width = 0;
        int length = 0;
        ArrayList<Integer> divisor = new ArrayList<>();
        
        // 노란색의 약수를 구해 노란색 격자의 모양 가짓수를 구한다.
        for(int i = 1; i*i <= yellow; i++){
            if(yellow % i ==0)
                divisor.add(i);
        }
        
        // 테두리는 노란색의 가로 세로의 (+2)이므로 그 상태의 테두리를 계산했을 때 갈색 격자와 갯수가 같은 경우를 찾는다.
        for(int A:divisor){
            width = yellow/A + 2;
            length = A + 2;
            int frame = width + (length-1) + (length-1) + (width-2);
            if(frame == brown)
                break;
        }
        answer[0] = width;
        answer[1] = length;
        return answer;
    }
}
