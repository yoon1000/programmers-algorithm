//level 1 - 모의고사

import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int a[] = {1,2,3,4,5};          //5개
        int b[] = {2,1,2,3,2,4,2,5};    //8개
        int c[] = {3,3,1,1,2,2,4,4,5,5};//10개
        
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1,0);
        hashMap.put(2,0);
        hashMap.put(3,0);
        
        //정답이 맞을 때 마다 key가 각각 1,2,3인 곳의 value를 하나씩 더해준다
        int length = answers.length;
        for(int i = 0; i<length;i++){
            if(answers[i] == a[i%5])
                hashMap.put(1, hashMap.getOrDefault(1, 0)+1);
            if(answers[i] == b[i%8])
                hashMap.put(2, hashMap.getOrDefault(2, 0)+1);
            if(answers[i] == c[i%10])
                hashMap.put(3, hashMap.getOrDefault(3, 0)+1);
        }

        //세 명 중에서 가장 많이 맞춘 사람의 갯수(max)를 구한다.
        int max = hashMap.get(1).intValue();
        for(int i = 2;i<=3;i++){
            if(hashMap.get(i).intValue()>max)
                max = hashMap.get(i).intValue();
        }

        //max와 같은 갯수를 가진 키 값을 리스트에 추가해준다.
        List<Integer> list = new ArrayList<>();
        for(int i = 1;i<=3;i++){
            if(hashMap.get(i) == max)
                list.add(i);
        }

        //list에 추가된 키 값들을 배열로 바꿔준다.
        int[] answer = new int[list.size()];
        for(int i = 0; i <list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
