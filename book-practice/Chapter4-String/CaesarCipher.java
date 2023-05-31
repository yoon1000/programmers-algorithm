// 2023.05.31
// Level 1 - 시저 암호

class Solution {
    public String solution(String s, int n) {
        char[] chars = s.toCharArray();
        char[] answerChars = new char[chars.length];
        for(int i = 0; i < chars.length; i++){
            char result = ' ';
            // 공백
            if(chars[i]==32);
            else if(65 <= chars[i] && chars[i] <= 90){

                if(chars[i] + n > 90)
                    result = (char) (chars[i] + n - 26);
                else
                    result = (char) (chars[i] + n);
            }
            else if(97 <= chars[i] && chars[i] <= 122){
                if(chars[i] + n > 122)
                    result = (char) (chars[i] + n - 26);
                else
                    result = (char) (chars[i] + n);
            }
            answerChars[i] = result;
        }
        String answer = new String(answerChars);
        return answer;
    }
}
