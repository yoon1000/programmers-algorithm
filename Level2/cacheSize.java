// level 2 - 2018 KAKAO BLIND RECRUITMENT - [1차] 캐시

import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
       int answer = 0;
        int hit = 0; int miss = 0;
        
        //도시 이름은 대소문자를 구분하지 않는다.(소문자로 통일)
        String[] lowCities = new String[cities.length];
        for(int i = 0; i < cities.length; i++){
            lowCities[i] = cities[i].toLowerCase();
        }
        
        // ArrayList를 이용해 캐시 구현
        // 가장 오래된 내용은 index = 0에 있다.
        ArrayList<String> list = new ArrayList<>();
        // 캐시 크기가 0일 때 무조건 miss만 해당한다
        if(cacheSize == 0){
            answer = cities.length * 5;
        }
        // 캐시 크기가 0이 아닐 경우
        if(cacheSize > 0){
           for(String A : lowCities){
               // 캐시 안에 아직 꽉 차지 않았을 경우
               if(list.size() < cacheSize && !list.contains(A)){
                   list.add(A);
                   miss++;
               }
               else if(list.size() < cacheSize && list.contains(A)){
                   list.remove(A);
                   list.add(A);
                   hit++;
               }
               // 캐시가 꽉 찼을 때
               else if(list.size()==cacheSize){
                   if(list.contains(A)){
                       list.remove(A);
                       list.add(A);
                       hit++;
                   }
                   else{
                       list.remove(0);
                       list.add(A);
                       miss++;
                   }
               }
           }
            // hit와 miss 기반으로 실행시간을 계산해준다.
            answer = (hit * 1) + (miss * 5);
        }
        return answer;
    }
}
