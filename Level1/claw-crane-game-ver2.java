import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
       int answer = 0;
        int length = board.length;

        Stack<Integer> stack = new Stack<>();

        // board의 갯수 만큼 stack을 가진 리스트를 생성해줌.
        List<Stack<Integer>> list = new ArrayList<>();
        for(int i = 0; i < length;i++) {
            list.add(new Stack<Integer>());
        }

        //각 stack에는 0을 제외한 인형의 값들만 들어가있음.
        for(int i = 0; i < length;i++){
            for(int j = length-1;j >= 0; j--){
                if(board[j][i] != 0){
                    list.get(i).push(board[j][i]);
                }
            }
        }

        //stack이 비어있지 않고 stack의 peek와 list의 peek가 같다면 인형은 사라진다.
        for(int i : moves){
            if(stack.empty()==false &&list.get(i-1).empty()==false && stack.peek()==list.get(i-1).peek()) {
                stack.pop();
                answer++;
                list.get(i-1).pop();
            }
            else if(list.get(i-1).empty()==false){
                stack.push(list.get(i-1).peek());
                list.get(i-1).pop();
            }
        }

        answer = answer * 2;
        return answer;
    }
}
