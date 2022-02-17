// level 2 깊이/너비 우선 탐색(DFS/BFS) - 타겟 넘버 - 22/2/17

import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        // 이진트리를 생성할 list와 타켓 넘버를 달성하는 경우를 세주는 size를 생성한다.
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> size = new ArrayList<>();
        
        // 재귀함수를 이용해 dfs방식으로 푼다.
        DFS(1, numbers.length, list, size, numbers, target);
        answer = size.size();
        return answer;
    }
    
    static void DFS(int x,int limit, ArrayList<Integer> list, ArrayList<Integer> size, int[] numbers, int target){
        list.add(x);
        
        // 이진트리의 최하단으로 갔을 때 +인지 -인지 판단해주어 합을 구해본다.
        if(x>=Math.pow(2, limit)) {
            int isTarget = 0;
            for(int i = 1; i < list.size(); i++){
                // 이진트리의 index가 짝수일 때는 +, 홀수일 때는 -
                isTarget += numbers[i-1] * isEven(list.get(i));
            }
            // 만약 target과 같다면 size에 크기를 하나 더한다.
            if(isTarget == target){
                size.add(0);
            }
            list.remove(list.size()-1);
        }
      
        else{
            DFS(x*2, limit, list, size, numbers, target);
            DFS(x*2+1, limit, list, size, numbers, target);
            list.remove(list.size()-1);
        }

    }
    // 이진트리의 index가 짝수일 때는 +, 홀수일 때는 -
    static int isEven(int y){
        int answer = 0;
        if(y % 2 == 0 )
            answer = 1;
        else
            answer = -1;
        return answer;
    }
}
