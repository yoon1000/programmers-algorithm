import java.util.Arrays;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);

        Arrays.sort(completion);

        for(int i = 0;i<completion.length;i++){
            if(participant[i]!=completion[i]){
                if(participant[i+1]==completion[i]){
                    answer = participant[i];
                }
            }
            else if(i == completion.length-1 && answer == "")
                answer = participant[participant.length-1];

        }
        return answer;
    }
}
