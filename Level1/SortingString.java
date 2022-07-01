import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        
        // key값이 알파벳, value값이 List인 HashMap을 만들어준다.
        HashMap<Character, List<String>> SortingList = new HashMap<>();
        for(char i = 97; i <= 122; i++){
            SortingList.put(i, new ArrayList<>());
        }
      
        // 인덱스 n에 해당하는 알파벳에 맞게 HashMap에 추가해준다.
        for(String A : strings){
            char stringChar = A.charAt(n);
            SortingList.get(stringChar).add(A);
        }
      
        List<String> Answer = new ArrayList<>();
      
        // 해당 알파벳 안에서 사전 순으로 정렬해준다.
        for(char i = 97; i <= 122; i++){
            if(!SortingList.get(i).isEmpty()){
                Collections.sort(SortingList.get(i));
                Answer.addAll(SortingList.get(i));
            }
        }
      
        // 리스트로 정렬해놨던 것을 배열로 바꿔준다.
        for(int i = 0; i < strings.length; i++){
            answer[i]= Answer.get(i);
        }
        return answer;
    }
}
