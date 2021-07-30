// level 1 - 키패드 누르기
import java.util.ArrayList;

class Solution {
    public String solution(int[] numbers, String hand) {
       ArrayList<Integer> left = new ArrayList<>();
        left.add(1);left.add(4);left.add(7);

        ArrayList<Integer> right = new ArrayList<>();
        right.add(3);right.add(6);right.add(9);

        int lastHand[] = new int[2];//0은 왼손, 1은 오른손
        lastHand[0] = 10;
        lastHand[1] = 12;

        ArrayList<String> result = new ArrayList<>();
        
        for(int i :numbers){
            if(left.contains(i)){
                lefthand(i, result, lastHand);
            }
            else if(right.contains(i)){
                righthand(i, result, lastHand);
            }
            else{
                if( calculate(lastHand[0], i) < calculate(lastHand[1], i) ){
                    lefthand(i, result, lastHand);
                }
                else if( calculate(lastHand[0], i) > calculate(lastHand[1], i) ){
                    righthand(i, result, lastHand);
                }
                else{
                    if(hand.equals("left"))
                        lefthand(i, result, lastHand);
                    else
                        righthand(i, result, lastHand);
                }
            }

        }
        String answer = "";
        
        answer = String.join("", result);
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
    public static void lefthand(int number, ArrayList<String> result, int lastHand[]){
        result.add("L");
        lastHand[0] = number;
    }
    public static void righthand(int number, ArrayList<String> result, int lastHand[]){
        result.add("R");
        lastHand[1] = number;
    }
}
