// level 1 - 나머지가 1이 되는 수 찾기
// 2021.11.10

public class restOne {
  public static int solution(int n) {
    int answer = 1;
    int rest = n-1;
    boolean flag = true;
    while(flag){
      answer++;
      if(rest%answer==0)
        flag=false;
    }
    return answer;
  }
}
