// level 2 - [1차] 다트 게임
import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int score = 0;
        int index = 0;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
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
            }
            else if(strarr[i].equals("*")||strarr[i].equals("#")){
                option(strarr[i], list);
            }
            else{
                list.add(Integer.parseInt(strarr[i]));
            }
        }
        for(int a : list){
            answer += a;
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
    public static void option(String C, ArrayList<Integer> list){
        double score = 0;
        if(C.equals("#")){
            score = list.get(list.size()-1) * (-1);
            list.remove(list.size()-1);
            list.add((int)score);
        }
        else if(C.equals("*")){
            score = (list.get(list.size()-1) + list.get(list.size()-2)) * 2;
            list.remove(list.size()-1);
            list.remove(list.size()-1);
            list.add((int)score);
        }

        return;
    }
}
