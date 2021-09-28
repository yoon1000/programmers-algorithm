// level 2 - 힙(Heap) - 더 맵게

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        // 우선순위 큐를 이용해 스코빌지수를 정리한다.
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int a : scoville){
            priorityQueue.add(a);
        }
      
        // 최대 (음식의 갯수 - 1)번까지 새로운 음식을 만들 수 있다.
        for(int i = 0; i < scoville.length-1; i++){
          
            // 가장 맵지 않은 음식이 K보다 낮다면 계속해서 새로운 음식을 만든다.
            if(priorityQueue.peek() < K) {
                int a = priorityQueue.poll();
                int b = priorityQueue.poll();
                int mix = a + (b * 2);  // 문제에서 주어진 계산식
                priorityQueue.add(mix);
                answer++;
            }
            // 가장 맵지 않은 음식이 K 이상이라면 여기서 멈춘다.
            else if(priorityQueue.peek() >= K)
                break;
        }
      
        // 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1로 return한다.
        if(priorityQueue.peek() < K)
            answer = -1;
      
        return answer;
    }
}
