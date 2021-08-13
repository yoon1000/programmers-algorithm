//weekly challenge 1주차 - 부족한 금액 계산하기

import java.util.ArrayList;

class Solution {
    public String solution(int[][] scores) {
        String answer = "";
        int size = scores.length;
        int max = 0;
        int min = 0;
        float average[] = new float[size];

        //list 안의 list를 이용해서 각자 평가받은 점수를 넣어준다.
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        for(int i = 0; i < size; i++){
            arrayList.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                arrayList.get(i).add(scores[j][i]);
            }
            arrayList.get(i).sort(null);
        }

        //myscore[]에 자기자신이 평가한 점수를 넣어준다.
        int myscore[] = new int[size];
        for(int i = 0; i < size; i++){
            myscore[i] = scores[i][i];
        }

        //max, min을 통해 자기자신이 평가한 점수가 max 또는 min이면 빼고 평균을 구한다.
        for(int j = 0; j < size; j++) {
            max = myscore[j];
            min = myscore[j];
            for (int i = 0; i < size; i++) {
                if (max < scores[i][j])
                    max = scores[i][j];
                if (min > scores[i][j])
                    min = scores[i][j];
            }

            //max와 min이 자기자신의 점수와 같은 경우 유일한 최저점 또는 최고점 인지 판단한 후 제거한다.
            if (max == myscore[j] || min == myscore[j]){
                if(myscore[j] == arrayList.get(j).get(size-2) || myscore[j] == arrayList.get(j).get(1)){
                }
                else{

                    arrayList.get(j).remove(arrayList.get(j).indexOf(myscore[j]));
                }

            }

            for (int i : arrayList.get(j)) {
                average[j] += i;
            }
            average[j] = average[j] / arrayList.get(j).size();
        }

        //각각 점수에 대해서 학점을 매겨준다.
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





