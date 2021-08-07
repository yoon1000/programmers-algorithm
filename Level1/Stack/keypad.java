//level 1 - 키패드 누르기
import java.util.Stack;

class Solution {
    public String solution(int[] numbers, String hand) {
       String answer = "";
        Stack<Integer> Lstack = new Stack<>();
        Stack<Integer> Rstack = new Stack<>();
        Lstack.push(10);
        Rstack.push(12);

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer += "L";
                Lstack.pop();
                Lstack.push(numbers[i]);
            }
            else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                answer += "R";
                Rstack.pop();
                Rstack.push(numbers[i]);
            }
            else {
                if(calculate(Lstack.peek(), numbers[i]) < calculate(Rstack.peek(), numbers[i])){
                    answer += "L";
                    Lstack.pop();
                    Lstack.push(numbers[i]);
                }
                else if(calculate(Lstack.peek(), numbers[i]) > calculate(Rstack.peek(), numbers[i])){
                    answer += "R";
                    Rstack.pop();
                    Rstack.push(numbers[i]);
                }
                else{
                    if(hand.equals("left")){
                        answer += "L";
                        Lstack.pop();
                        Lstack.push(numbers[i]);
                    }
                    else{
                        answer += "R";
                        Rstack.pop();
                        Rstack.push(numbers[i]);
                    }
                }
            }
        }
        return answer;
    }

    public static int calculate(int peek, int input){
        if(input == 0 )
            input = 11;
        if(peek == 0)
            peek = 11;
        int Peek[] = {(peek-1)/3, (peek-1)%3};
        int Input[] = {(input-1)/3, (input-1)%3};
        int length = Math.abs(Input[0] - Peek[0]) + Math.abs(Input[1] - Peek[1]);
        return length;
    }
}
