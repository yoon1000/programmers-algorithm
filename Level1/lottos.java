//level 1 - 로또의 최고 순위와 최저 순위

import java.util.ArrayList;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
       int[] answer = new int[2];
        int zero = 0; int match = 0;

        //zero = 0의 갯수
        for(int i : lottos){
            if(i == 0){
                zero++;
            }
        }
        //list에 당첨 번호를 넣어줌
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : win_nums){
            list.add(i);
        }
        //lottos에 있는 번호와 list에 있는 번호를 비교해 일치하는 갯수를 구함
        for(int i : lottos){
            if(list.contains(i)){
                match++;
            }
        }
        // 최고 순위 = match + zero의 순위, 최저 순위 = match
        answer[0] = 7 - (match + zero);
        answer[1] = 7 - match;
        
        //순위 중 1개 이하로 일치할 경우 순위를 6위로 바꾸어준다
        if(match + zero<=1)
            answer[0] = 6;
        if(match<=1)
            answer[1] = 6;


        return answer;
    }
}
