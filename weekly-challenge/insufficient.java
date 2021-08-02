// weekly challenge 1주차 - 부족한 금액 계산하기
class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long sum = 0;
        for(int i = 1; i <= count; i++){
            sum += i;
        }
        answer = Long.valueOf(price*sum - money);
        if(answer <= 0)
            answer = 0;
        return answer;
    }
}
