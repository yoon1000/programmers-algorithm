// level 2 - 스택/큐 - 주식가격

import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < prices.length; i++){
            for(int j = i+1; j < prices.length; j++){
                // i시점의 가격보다 높거나 같다면 주식 가격이 유지되기 때문에 stack에 추가해준다.
                if(prices[i] <= prices[j]) {
                    stack.add(0);
                }
                // i시점의 가격보다 작아지면 주식 가격이 그 직전까지는 유지되었기 때문에 stack에 추가 후 시간을 구한다.
                else if(prices[i] >= prices[j]){
                    stack.add(0);
                    break;
                }
                else
                    break;
            }
            answer[i] = stack.size();
            stack.clear();
        }
        return answer;
    }
}
