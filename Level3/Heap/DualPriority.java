import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        ArrayList<Integer> priorityQueue = new ArrayList<>();
        
        // String으로 들어온 명령을 각 operation에 따라 실행해준다.
        for(int i = 0; i < operations.length; i++){
            String[] split = operations[i].split(" ");

            if(split[0].compareTo("I")==0)
                priorityQueue.add(Integer.parseInt(split[1]));

            else if(!priorityQueue.isEmpty() && split[0].compareTo("D")==0 && split[1].compareTo("1")==0)
                priorityQueue.remove(0);

            else if(!priorityQueue.isEmpty() && split[0].compareTo("D")==0 && split[1].compareTo("-1")==0)
                priorityQueue.remove(priorityQueue.size()-1);
          
            // ArrayList에 다 넣은 후에는 내림차순으로 정렬해준다.
            Collections.sort(priorityQueue, Collections.reverseOrder());
        }
         
        // 우선순위큐가 비어있다면 [0, 0]을 반환해준다.
        if(priorityQueue.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;
        }
        // 우선순위큐가 비어있지 않다면 [최댓값, 최솟값]을 반환해준다.
        else{
            answer[0] = priorityQueue.get(0);
            answer[1] = priorityQueue.get(priorityQueue.size()-1);
        }
        return answer;
    }
}
