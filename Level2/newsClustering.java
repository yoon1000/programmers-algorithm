// level 2 - 2018 KAKAO BLIND RECRUITMENT - [1차] 뉴스 클러스터링

import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        // 입력은 모두 소문자로 만들어준다.
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();


        // 교집합 구하기
        ArrayList<String> str1set = makeSet(str1);
        ArrayList<String> str2set = makeSet(str2);
        ArrayList<String> intersection = new ArrayList<>();
      
        // 두 집합의 크기에 따라 교집합을 구하는 순서를 달리한다.
        if(str1set.size()>str2set.size()) {
            for (String a : str1set) {
                if (str2set.contains(a)) {
                    intersection.add(a);
                    str2set.remove(a);
                }
            }
        }
        else if(str1set.size()<=str2set.size()){
            for (String a : str2set) {
                if (str1set.contains(a)) {
                    intersection.add(a);
                    str1set.remove(a);
                }
            }
        }
        

        // 합집합 구하기
        str1set = makeSet(str1);
        str2set = makeSet(str2);
        ArrayList<String> union = new ArrayList<>();
        // 두 집합의 크기에 따라 합집합을 구하는 순서를 달리한다.
        if(str1set.size()>str2set.size()){
            for(String a : str2set){
                union.add(a);
                if(str1set.contains(a))
                    str1set.remove(a);
            }
            for(String a : str1set){
                union.add(a);
            }
        }
        else if(str1set.size()<=str2set.size()) {
            for (String a : str1set) {
                union.add(a);
                if (str2set.contains(a))
                    str2set.remove(a);
            }
            for (String a : str2set) {
                union.add(a);
            }
        }
        
        // 교집합과 합집합의 갯수를 가지고 자카드 유사도를 구한다.
        float j = (float) intersection.size()/union.size();
        double temp = Math.floor(j * 65536);
        answer = (int) temp;
      
        // 두 집합이 모두 공집합일 때는 자카드 유사도 1(answer = 65536)로 만들어준다.
        str1set = makeSet(str1);
        str2set = makeSet(str2);
        if(str1set.size() == 0 && str2set.size() == 0)
            answer = 65536;
        return answer;
    }
    
    // 입력받은 String을 이용해 규칙에 맞는 집합을 만들어준다.
    public static ArrayList<String> makeSet(String string){
        int index = 0;
        char[] tochar = string.toCharArray();
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < tochar.length - 1; i++){
            if(isEnglish(tochar[index]) && isEnglish(tochar[index + 1])){
                list.add(new String(tochar, index, 2));
            }
            index += 1;
        }
        return list;
    }
    
    // 입력받은 char이 영문자인지 판단해준다.
    public  static boolean isEnglish(char A){
        boolean isEng = false;
        if((65 <= (int)A && (int)A <= 90) || (97 <= (int)A && (int)A <= 122))
            isEng = true;
        return isEng;
    }
}
