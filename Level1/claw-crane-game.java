// level 1 - 크레인 인형 뽑기 게임

import java.util.ArrayList;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        int current = 0;
        int index = 1;
        int count = 0;
        while(current<moves.length){
            for(int i = 0; i <board.length;i++){
                if(board[i][moves[current]-1]!=0) {
                    list.add(board[i][moves[current] - 1]);
                    board[i][moves[current] - 1] = 0;
                    if(list.size()>1 && list.get(list.size()-2)==list.get(list.size()-1)){
                        list.remove(list.size()-1);
                        list.remove(list.size()-1);
                        count++;
                    }
                    break;
                }
            }
            current++;
        }


        answer = count*2;
        return answer;
    }
}
