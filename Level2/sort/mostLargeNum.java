// level 2 - 정렬 - 가장 큰 수

import java.util.*;

class Solution {
    public static StringBuilder solution(int[] numbers) {
        // String에 계속해서 더해주는 것을 방지하기 위해 StringBuilder 사용
        // 0만 나오는 경우를 판단하기 위해 HashSet 사용
        StringBuilder answer = new StringBuilder();
        HashSet<Integer> hashSet = new HashSet<>();

        Integer[] list  = new Integer[numbers.length];
        for (int i=0; i<numbers.length; i++) {
            list[i] = numbers[i];
            hashSet.add(numbers[i]);
        }
        
        // Comparator의 compare함수를 이용하여 더 큰 수가 나오도록 정렬한다 
        Arrays.sort(list, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                String tmp1 = o1.toString();
                String tmp2 = o2.toString();
                return ((tmp2+tmp1)).compareTo(tmp1+tmp2);
            }
        });

        // 정렬한 순서대로 정답을 합쳐준다
        for(int A : list){
            answer.append(A);
        }
        // 만약 모든 수가 0이라면 답을 0으로 변경해준다
        if(hashSet.size() == 1 && hashSet.contains(0)) {
            answer.delete(0, answer.length());
            answer.append(0);
        }

        return answer;
    }
}
