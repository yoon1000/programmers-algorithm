import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int index = 0;
        // 처음의 다리 상태를 만들어 주기 위해 큐를 다리 길이만큼 0으로 채워준다
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < bridge_length; i++){
            queue.add(0);
        }
      
        // 리스트에 트럭의 무게 배열과 함께 마지막 트럭이 지나가는 것을 생각하여 다리 길이만큼 0으로 채워준다.
        ArrayList<Integer> trucklist = new ArrayList<>();
        for(int A : truck_weights){
            trucklist.add(A);
        }
        for(int i = 0; i <bridge_length; i++){
            trucklist.add(0);
        }
      
        // 모든 트럭이 지나갈 때까지 반복문을 실행해준다.
        while(index<truck_weights.length + bridge_length){
            // 매 초마다 상황을 판단한다.
            answer++;
            // 현재 다리 위 무게와 들어올 트럭의 무게가 최대하중을 넘지 않는다면 추가해준다.
            if(listSum(queue) + trucklist.get(index) <= weight){
                queue.poll();
                queue.add(trucklist.get(index));
                index++;
            }
            // 트럭이 빠져나가는 순간 새로운 트럭을 추가해준다.
            else if((listSum(queue) - queue.peek()) + trucklist.get(index) <=weight){
                queue.poll();
                queue.add(trucklist.get(index));
                index++;
            }
            // 다리 위 무게를 견디지 못한다면 현재 시간은 넘겨준다.
            else if (listSum(queue) + trucklist.get(index) > weight){
                queue.poll();
                queue.add(0);
            }
            
        }
        return answer;
    }
  
    // 해당 큐에 있는 모든 수를 더한다.(다리 위에 있는 트럭들의 무게 합을 구한다.)
    public static int listSum(Queue<Integer> queue){
        int onBridge = 0;
        for(int A : queue){
            onBridge +=A;
        }
        return onBridge;
    }
}
