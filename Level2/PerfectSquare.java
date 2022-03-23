class Solution {
    public static long solution(int w, int h) {
        // w와 h는 1억 이하의 자연수이기 때문에 long형을 사용해야 한다.
        long answer = (long)w * (long)h;
        long W = (long)w;
        long H = (long)h;
        long gcd = GCD(W, H);
        long minW = W/gcd;
        long minH = H/gcd;
        long uncomplete = (minW + minH - 1) * gcd;
        answer -= uncomplete;

        return answer;
    }
    static long GCD(long a, long b){ // 최대공약수
        while(b!=0){
            long r = a%b;
            a= b;
            b= r;
        }
        return a;
    }
}
