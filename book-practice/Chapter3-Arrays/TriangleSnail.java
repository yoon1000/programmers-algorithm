// 2023.05.25
// Level 2 - 삼각 달팽이


class Solution {
    public int[] solution(int n) {
        int[][] array = new int[n][n];
        
        int x = 0;
        int y = 0;
        int dIndex = 0; 
        int k = 1;
        int[] dx = {1, 0, -1};
        int[] dy = {0, 1, -1};
        
        while(true){
            int index = dIndex % 3;
            
            while(true){
                
                array[x][y] = k;
                if(x + dx[index] == n ||y + dy[index] == n || array[x+dx[index]][y+dy[index]] != 0) break;
                x = x + dx[index];
                y = y + dy[index];
                k++;
            }
            dIndex++;
            index = dIndex % 3;
            if(x + dx[index] == n ||y + dy[index] == n || array[x+dx[index]][y+dy[index]] != 0) break;
            x = x + dx[index];
            y = y + dy[index];
            k++;
        }
        
        int[] answer = new int[n*(n+1)/2];
        int aIndex = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j <=i; j++){
                answer[aIndex] = array[i][j];
                aIndex++;
            }
        }
        
        
        return answer;
    }
}
