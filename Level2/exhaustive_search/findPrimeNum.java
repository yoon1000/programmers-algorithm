// level 2 - 완전탐색 - 소수 찾기
import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        char[] numberList = numbers.toCharArray();
        int[] intList = new int[numbers.length()];
        int[] output = new int[numbers.length()];
        boolean[] visited = new boolean[numbers.length()];
        HashSet<Integer> permList = new HashSet<>();

        // 입력으로 들어온 String의 숫자를 각각 나누어 int배열에 넣어준다.
        for(int i = 0; i < numbers.length(); i++){
            intList[i] = numberList[i] - '0';
        }
      
        // 순열 함수를 이용하여 n개 중에 1개 ~ n개 까지의 리스트를 구한다.
        // 리스트를 구한 후 겹치는 수를 없애기 위해 HashSet을 이용한다.
        for(int i = 1; i <= numbers.length(); i++) {
            perm(intList, output, visited, 0, numbers.length(), i, permList);
        }
      
        // permList에 있는 수를 소수인지 판단하는 함수를 이용하여 소수의 갯수를 찾아준다.
        Iterator<Integer> iterator = permList.iterator();
        while(iterator.hasNext()){
            if(isPrime(iterator.next()))
                answer++;
        }

        return answer;
    }
    
    // 해당 숫자의 루트까지 나눠보아 소수인지 판단한다.
    public static boolean isPrime(int num){
        for(int i=2; i*i<=num; i++){
            if(num % i == 0) return false;
        }
        if(num == 1 || num == 0) return false;
        return true;
    }
  
    // 해당 함수를 이용하여 순열의 결과를 저장한다.
    public static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r, HashSet<Integer> permList) {
        if (depth == r) {
            print(output, r, permList);
            return;
        }

        for (int i=0; i<n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, n, r, permList);
                visited[i] = false;;
            }
        }
    }
    // 입력으로 들어온 배열을 실제 숫자로 바꿔주는 함수이다.
    public static void print(int[] arr, int r, HashSet<Integer> permList) {
        int isPrime = 0;
        for(int i = 0; i < r; i++){
            isPrime += (int)Math.pow(10, r-i-1)*arr[i];
        }
        permList.add(isPrime);
    }
}
