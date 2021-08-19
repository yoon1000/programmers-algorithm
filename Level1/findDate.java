// level 1 - 2016년

class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int month[] = {0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335};
        int date = month[a - 1] + b;
        date = date % 7;
        switch (date){
            case 1: answer = "FRI";
            break;
            case 2: answer = "SAT";
                break;
            case 3: answer = "SUN";
                break;
            case 4: answer = "MON";
                break;
            case 5: answer = "TUE";
                break;
            case 6: answer = "WED";
                break;
            case 0: answer = "THU";
                break;
        }
        return answer;
    }
}
