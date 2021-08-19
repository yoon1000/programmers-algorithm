// level 1 - [1차] 비밀지도


class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        // temp에 arr1과 arr2의 OR연산한 결과 값을 넣는다.
        int temp[] = new int[n];
        for(int i = 0; i < n; i++){
            temp[i] = arr1[i] | arr2[i];
        }

        //calculate함수를 이용해 answer을 #과 공백으로 바꿔준다.
        for(int i = 0; i < n; i++){
            answer[i] = calculate(n, temp[i]);
        }


        return answer;
    }
    
    public  String calculate(int n, int num){
        String Answer = "";
      
        //만약 숫자가 2^n보다 크다면 #으로 채워준다.
        if(num >= Math.pow(2, n)){
            for(int i = 0; i < n; i++){
                Answer = Answer + "#";
            }
            return Answer;
        }
      
      
        //이진수 계산을 하여 #과 공백을 넣어준다.
        else{
            while(Answer.length() != n){
                if(num %  2 == 1)
                    Answer = "#" + Answer;
                else
                    Answer = " " + Answer;
                num = num/2;
            }
            return Answer;
        }
    }
}
