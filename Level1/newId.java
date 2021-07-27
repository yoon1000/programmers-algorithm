//level 1 - 신규 아이디 추천

class Solution {
    public String solution(String new_id) {
       String answer = "";
        //1단계 대문자 -> 소문자
        answer = new_id.toLowerCase();

        //2단계 특수문자 - _ . 를 제외하고 제거
        answer = answer.replaceAll("[^a-z\\d\\-\\_\\.]", "");
        
        //3단계 ..을 .로 변경
        answer = answer.replaceAll("\\.{2,}", ".");
        
        //4단계 마침표가 처음이나 끝에 위치하면 제거
        if(answer.substring(0,1).equals(".")){
            answer = answer.substring(1,answer.length());
        }
        else if(answer.substring(answer.length()-1).equals(".")){
            answer = answer.substring(0,answer.length()-1);
        }
       
        //5단계 빈 문자열이라면 "a" 대입
        if(answer.equals("")){
            answer += "a";
        }
        //6단계 16자 이상이면 15자로 제거, .으로 끝나면 제거
        if(answer.length()>=16){
            answer = answer.substring(0,15);
            if(answer.substring(14).equals(".")){
                answer = answer.substring(0,14);
            }
        }
        //7단계 2자 이하이면 마지막 문자를 길이가 3이 될 때까지 반복
        if(answer.length()<=2){
            for(int i = answer.length(); i < 3;i++){
                answer = answer + answer.substring(answer.length()-1);
            }
        }
        return answer;
    }
}
