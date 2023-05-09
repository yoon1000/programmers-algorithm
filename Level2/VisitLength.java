// 2023.05.08
// Level 2- 방문 길이

import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
      
        // 입력으로 들어온 String을 character 배열로 바꿔준다.
        char[] chars = dirs.toCharArray();
      
        // 좌표평면을 11 * 11 * 4 배열로 표현한다. (4는 각 방향 U,D,R,L)
        boolean[][][] Bools = new boolean[11][11][4];
      
        // 처음 시작 위치 i = 5, j = 5
        int i = 5; int j = 5;
      
        for(char A : chars){
            
            switch (A){
                // 각 명령어가 들어오면 조건에 맞게 Bools 좌표평면을 지나갔다고 표시해준다.
                // 이동한 길에 대한 반대 쪽 길도 표시해준다.(방향성 상관 없이 같은 길)
                case 'U':
                    if(!Bools[i][j][0] && i > 0){
                        answer++;Bools[i][j][0] = true;
                    }
                    
                    if(i >= 1){
                        Bools[i-1][j][1] = true;
                        i = i-1;
                    }
                    break;
                case 'D':
                    if(!Bools[i][j][1] && i < 10){
                        answer++;Bools[i][j][1] = true;
                    }
                    
                    if(i <= 9){
                        Bools[i+1][j][0] = true;
                        i = i + 1;
                    }
                    
                    break;
                case 'R':
                    if(!Bools[i][j][2] && j < 10){
                        answer++;Bools[i][j][2] = true;
                    }
                    
                    if(j <= 9){
                        Bools[i][j+1][3] = true;
                        j = j + 1;
                    }
                
                    break;
                case 'L':
                    if(!Bools[i][j][3] && j > 0){
                        answer++;Bools[i][j][3] = true;
                    }
                    
                    if(j >= 1){
                        Bools[i][j-1][2] = true;
                        j = j - 1;
                    }
                    break;
            }
            //System.out.println(answer + " i:" +i+" j:"+j);

        }
        return answer;
    }
    
}
