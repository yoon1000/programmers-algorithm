// level 1 - 소수 만들기
// 2021.11.10

import java.util.*;

public class makePrimeNum {
  public static int solution(int[] nums) {
    int answer = 0;
    boolean[] visited = new boolean[nums.length];
    ArrayList<Integer> combList  = new ArrayList<>();
    combination(nums, visited, 0, nums.length, 3, combList);
    for(int A : combList){
      if(isPrime(A))
        answer++;
    }

    return answer;
  }
  
  // 사용 예시 : combination(arr, visited, 0, n, r)
  public static void combination(int[] arr, boolean[] visited, int start, int n, int r, ArrayList<Integer> combList) {
    if (r == 0) {
      print(arr, visited, n, combList);
      return;
    }

    for (int i = start; i < n; i++) {
      visited[i] = true;
      combination(arr, visited, i + 1, n, r - 1, combList);
      visited[i] = false;
    }
  }

  // 배열 출력
  public static void print(int[] arr, boolean[] visited, int n, ArrayList<Integer> combList) {
    int sum = 0;
    for (int i = 0; i < n; i++) {
      if (visited[i]) {
        sum += arr[i];
      }
    }
    combList.add(sum);
  }

  // 해당 숫자의 루트까지 나눠보아 소수인지 판단한다.
  public static boolean isPrime(int num){
    for(int i=2; i*i<=num; i++){
      if(num % i == 0) return false;
    }
    if(num == 1 || num == 0) return false;
    return true;
  }
}
