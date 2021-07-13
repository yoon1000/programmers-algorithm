class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        int temp = 0;
        for(int i = 0;i<a.length;i++){
            temp = a[i]*b[i];
            answer = answer + temp;
        }
        return answer;
    }
}
