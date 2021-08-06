// level 1 - 실패율

import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        float people = stages.length;//사람 수
        
        HashMap<Integer, Integer> hashMap = new HashMap<>();//스테이지 별 사람 수
        HashMap<Integer, Float> Result = new HashMap<>();//실패율 계산한 결과값
        //각 스테이지 별 몇 명이 있는지 세어준다.
        for(int i : stages){
            hashMap.put(i, hashMap.getOrDefault(i, 0)+1);
        }
        //사용자 수를 기반으로 실패율을 계산한다.
        for(int i = 1; i <= N; i++){
            if(hashMap.get(i)!= null){
                Result.put(i, hashMap.get(i)/people);
                people = people - hashMap.get(i);
            }
            else{
                Result.put(i, 0/people);
                //System.out.println(Result.get(i));
            }
        }
        //리스트를 활용해 value값을 내림차순으로 정렬해준다.
        List<Integer> keySetList = new ArrayList<>(Result.keySet());
        Collections.sort(keySetList, (o1, o2) -> Result.get(o2).compareTo(Result.get(o1)));
        for(int i = 0; i < N; i++) {
            answer[i] = keySetList.get(i);
        }
        return answer;
    }
}
