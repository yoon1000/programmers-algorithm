class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int Pnum = 0;
        int Ynum = 0;
        // 대소문자 상관 없으므로 소문자로 변경해줌
        s = s.toLowerCase();
        for(int i = 0; i < s.length();i++){
            char[] chars = s.toCharArray();
            if(chars[i]==112)
                Pnum++;
            else if(chars[i]==121)
                Ynum++;
        }
        //갯수가 다르면 false
        if(Pnum!=Ynum)
            answer=false;
        return answer;
    }
}
