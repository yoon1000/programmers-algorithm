// level 1 - [1차] 다트 게임
import java.util.*;

class Solution {
    public static int solution(String dartResult) {
        int answer = 0;
        int score = 0;
        int index = 0;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        ArrayList<Integer> option = new ArrayList<>();
        option.add(0);
        StringTokenizer stk = new StringTokenizer(dartResult, "*#SDT", true);
        String[] strarr = new String[stk.countTokens()];

        while(stk.hasMoreTokens()){
            strarr[index] = stk.nextToken();
            index++;
        }

        for(int i = 0; i < strarr.length; i++){
            if(strarr[i].equals("S")||strarr[i].equals("D")||strarr[i].equals("T")){
                score = calculate(list.get(list.size()-1), strarr[i]);
                list.remove(list.size()-1);
                list.add(score);
                option.add(score);
            }
            else if(strarr[i].equals("*")||strarr[i].equals("#")){
                score = option(strarr[i], option);

                if(strarr[i].equals("*")){
                    list.remove(list.size()-1);
                    list.remove(list.size()-1);
                    list.add(0);
                    answer += score;
                }
                else {
                    list.remove(list.size()-1);
                    list.add(score);
                    option.remove(list.size()-1);
                    option.add(score);

                }
            }
            else{
                list.add(Integer.parseInt(strarr[i]));
            }
        }
        for(int i: list){
            answer = answer + i;
        }

        return answer;
    }
    public static int calculate(int A, String B){
        double score = 0;
        if(B.equals("S")){
            score = A;
        }
        else if(B.equals("D")){
            score = Math.pow(A, 2);
        }
        else if(B.equals("T")){
            score = Math.pow(A, 3);
        }
        return (int)score;
    }
    public static int option(String C,ArrayList<Integer> option){
        int score = 0;
        if(C.equals("#")){
            score = option.get(option.size()-1) * (-1);
        }
        else if(C.equals("*")){
            score = (option.get(option.size()-1) + option.get(option.size()-2)) * 2;
        }
        return score;
    }
}
