//level 1 - 체육복
import java.util.Arrays;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
      
        //학생의 번호대로 배열을 만들어 준 후 1로 채워준다.(학생은 1부터 시작하기 때문에 0은 제외)
        int students[] = new int[n+1];
        Arrays.fill(students, 1);

        //잃어버린 학생은 체육복 수를 하나 빼준다.
        for(int i : lost){
            students[i]--;
        }

        //여분의 체육복을 가진 학생은 체육복 수를 하나 더해준다.
        for(int i : reserve){
            students[i]++;
        }
      
        //체육복 수가 0인 학생의 앞,뒤 학생을 비교해 여분이 있으면 1개 씩 나눠 갖는다.
        for(int i : lost) {
            if (students[i] == 0){
                if(i < n && students[i+1] == 2){
                    students[i]++;
                    students[i+1]--;
                }
                else if(1 < i && students[i-1] == 2){
                    students[i]++;
                    students[i-1]--;
                }
            }
        }
      
        //1개 이상의 체육복을 가진 학생 수를 구한다.
        for(int i = 1; i <= n; i++){
            if(students[i]>=1)
                answer++;
        }
        return answer;
    }
}
