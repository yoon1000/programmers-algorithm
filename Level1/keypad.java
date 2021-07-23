//level 1 - 키패드 누르기
import java.util.HashMap;
class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int L[] = {1,4,7};
        int R[] = {3,6,9};
        HashMap<Integer, String> hashMap = new HashMap<>();
        for(int i = 0;i < 10; i++){
            hashMap.put(i , "X");
        }
        hashMap.put(10,"L");
        hashMap.put(11,"R");
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i]==1 || numbers[i]==4 || numbers[i]==7){
                answer += "L";
            }
            else if(numbers[i]==3 || numbers[i]==6 || numbers[i]==9){
                answer += "R";
            }
            else if(numbers[i]==2 || numbers[i]==5 || numbers[i]==8){
                answer += "R";
            }
        }
        return answer;
    }
}
