import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        // 신고한 사람 - 신고 목록
        HashMap<String, ArrayList<String>> doReport = new HashMap<>();
        for(int i = 0; i < report.length; i++){
            String[] AnB = report[i].split(" ");
            if(!doReport.containsKey(AnB[0])){
                doReport.put(AnB[0], new ArrayList<>());
                doReport.get(AnB[0]).add(AnB[1]);
            }
            else{
                if(doReport.get(AnB[0]).contains(AnB[1]));
                else
                    doReport.get(AnB[0]).add(AnB[1]);
            }
        }
        // 신고받은 횟수
        HashMap<String, Integer> ReportedNum = new HashMap<>();
        for(String DoReport: id_list){
            for(String Reportedperson: id_list){
                if(doReport.containsKey(DoReport) && doReport.get(DoReport).contains(Reportedperson))
                    ReportedNum.put(Reportedperson, ReportedNum.getOrDefault(Reportedperson, 0)+1);
            }
        }
        // 실제 신고 처리된 사람들
        ArrayList<String> handled = new ArrayList<>();
        for(String A: id_list){
            if(!ReportedNum.containsKey(A));
            else if(ReportedNum.get(A) >= k){
                handled.add(A);
            }
        }
        for(int i = 0; i < id_list.length; i++){
            int result = 0;
            for(String Handled: handled ){
                if (!doReport.containsKey(id_list[i]));
                else if(doReport.get(id_list[i]).contains(Handled))
                    result++;
            }
            answer[i] = result;
        }
        return answer;
    }
}
