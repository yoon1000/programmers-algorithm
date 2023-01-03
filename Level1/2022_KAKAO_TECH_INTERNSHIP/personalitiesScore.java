// Level 1 - 성격 유형 검사하기
// 2023.01.03

import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        // 성격 유형 별로 점수를 저장하기 위해 hashmap 사용
        HashMap<String, Integer> personalityScore = new HashMap<>();
      
        // 모든 성격 유형에 대해 0점으로 초기화
        String[] personalities = {"R", "T", "C", "F", "J", "M", "A", "N"};
        for(String P : personalities){
            personalityScore.put(P, 0);
        }
      
        // 배열을 돌면서 각각 점수를 계산한다
        for(int i = 0; i < survey.length; i++){
            // 앞의 문항은 A, 뒤의 문항은 B
            String A = survey[i].substring(0, 1);
            String B = survey[i].substring(1);
            
            // 점수는 4점을 중간 점으로 하기 때문에 4를 뺀 점수로 계산한다.
            int score = choices[i] - 4;
            if(score < 0){
                personalityScore.put(A, personalityScore.getOrDefault(A, 0) + Math.abs(score));
                personalityScore.put(B, personalityScore.getOrDefault(B, 0));
            }
            else if(score > 0){
                personalityScore.put(B, personalityScore.getOrDefault(B, 0) + Math.abs(score));
                personalityScore.put(A, personalityScore.getOrDefault(A, 0));
            }
        }
        // 점수가 같은 경우 알파벳 순이 높은 앞의 문항이 최종 성격 유형이 된다
        String first = (personalityScore.get("R") >= personalityScore.get("T")) ? "R" : "T";
        String second = (personalityScore.get("C") >= personalityScore.get("F")) ? "C" : "F";
        String third = (personalityScore.get("J") >= personalityScore.get("M")) ? "J" : "M";
        String forth = (personalityScore.get("A") >= personalityScore.get("N")) ? "A" : "N";
        answer = first + second + third + forth;
        return answer;
    }
}
