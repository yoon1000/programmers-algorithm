// level 1 - 약수의 개수와 덧셈

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
      
        //left와 right의 사이 갯수만큼 배열을 만들어 준다.
        int number[] = new int[right-left+1];
        int count = 0;
      
        //각 수의 약수 개수를 구한 후 배열에 넣어준다.
        //배열의 index는 (숫자 -left)
        for(int i = left; i <= right; i++){
            for(int j = 1; j<=i; j++){
                if(i % j ==0){
                    count++;
                }
            }
            number[i-left] = count;
            count = 0;
        }
      
        //약수의 갯수가 짝수이면 더해주고 홀수이면 빼준다.
        for(int i = 0; i<right-left+1; i++){
            if(number[i]%2==0)
                answer += (i+left);
            else
                answer -= (i+left);
        }

        return answer;
    }
}
