//weekly challenge 1주차 - 부족한 금액 계산하기

class Solution {
    public String solution(int[][] scores) {
       String answer = "";
        int size = scores.length;
        int max = 0;
        int min = 100;
        float average[] = new float[size];
        int myscore[] = new int[size];
        boolean flag = false;
        
        for(int i = 0; i < size; i++){
            myscore[i] = scores[i][i];
            for(int j = 0; j < size; j++){
                average[i] += scores[j][i];
                if (max < scores[j][i])
                    max = scores[j][i];
                if (min > scores[j][i])
                    min = scores[j][i];
                if(i != j && myscore[i] == scores[j][i])
                    flag = true;
            }

            if(flag && (max == myscore[i] || min == myscore[i])){
                average[i] = average[i]/size;
            }
            else if(max == myscore[i] || min == myscore[i]){

                average[i] = (average[i] - myscore[i])/(size - 1);

            }
            else{
                average[i] = average[i]/size;
            }
            max = 0;
            min = 100;
            flag = false;
        }

        for(float i: average){
            if(90 <= i)
                answer += "A";
            else if(80 <= i && i < 90)
                answer += "B";
            else if(70 <= i && i < 80)
                answer += "C";
            else if(50 <= i && i < 70)
                answer += "D";
            else if(i < 50)
                answer += "F";
        }
        return answer;
    }
}




