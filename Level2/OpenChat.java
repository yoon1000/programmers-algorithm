import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        // Id 와 닉네임을 연결할 hashmap
        HashMap<String, String> IdName = new HashMap<>();
      
        // 결과로 나올 문장을 StringBuilder를 이용해 우선 하나의 문장으로 만들어준다. "+"를 기점으로 끊어준다.
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < record.length; i++){
            String[] process = record[i].split(" ");
            // 각 명령에 따른 경우를 Enter/Leave/Change로 나누어준다.
            switch (process[0]){
                case "Enter":
                    sb.append(process[1]).append("님이 들어왔습니다.+");
                    IdName.put(process[1], process[2]);
                    break;
                case "Leave":
                    sb.append(process[1]).append("님이 나갔습니다.+");
                    break;
                case "Change":
                    IdName.put(process[1], process[2]);
                    break;
            }
        }
      
        // 한 문장으로 만들어진 결과를 "+"로 끊어 읽어준다.
        String str = sb.toString();
        String[] result = str.split("\\+");
      
        // id로 저장되어 있는 부분을 최종적으로 바뀐 닉네임으로 변경해준다.
        for(int i = 0; i < result.length; i++){
            String key = result[i].substring(0, result[i].indexOf("님"));
            result[i] = result[i].replace(key, IdName.get(key));
        }
        return result;
    }
}
