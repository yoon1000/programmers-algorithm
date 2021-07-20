import java.util.HashMap;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(String person : participant){
            hashMap.put(person, hashMap.getOrDefault(person, 0)+1);
        }
        for(String person : completion){
            hashMap.put(person, hashMap.getOrDefault(person, 0)-1);
        }
        for(String key : participant){
            if(hashMap.get(key) !=0)
                answer = key;
        }
        return answer;
    }
}
