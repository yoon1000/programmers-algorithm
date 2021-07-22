import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int a[] = {1,2,3,4,5};          //5개
        int b[] = {2,1,2,3,2,4,2,5};    //8개
        int c[] = {3,3,1,1,2,2,4,4,5,5};//10개
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int length = answers.length;
        for(int i = 0; i<length;i++){
            if(answers[i] == a[i%5])
                hashMap.put(1, hashMap.getOrDefault(1, 0)+1);
            if(answers[i] == b[i%8])
                hashMap.put(2, hashMap.getOrDefault(2, 0)+1);
            if(answers[i] == c[i%10])
                hashMap.put(3, hashMap.getOrDefault(3, 0)+1);
        }

        List<Integer> keySetList = new ArrayList<>(hashMap.keySet());
        Collections.sort(keySetList, (o1, o2) -> (hashMap.get(o2).compareTo(hashMap.get(o1))));

        int[] answer = new int[keySetList.size()];
        for(int i = 0; i<keySetList.size(); i++) {
            answer[i] = keySetList.get(i);
        }


        return answer;
    }
}
