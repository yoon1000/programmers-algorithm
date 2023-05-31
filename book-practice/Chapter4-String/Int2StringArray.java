// 2023.05.31
// Level 1 - 자연수 뒤집어 배열로 만들기

class Solution {
    public int[] solution(long n) {
        String string = Long.toString(n);
        int[] answer = new int[string.length()];
    
        for(int i = 0; i < string.length(); i++){
            answer[i] = string.charAt(string.length()-i-1) - '0';
        }
        return answer;
    }
}
