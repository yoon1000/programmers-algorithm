// level 2 - 2018 KAKAO BLIND RECRUITMENT - [1차] 캐시

import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
       int answer = 0;
        int hit = 0; int miss = 0;
        String[] lowCities = new String[cities.length];
        for(int i = 0; i < cities.length; i++){
            lowCities[i] = cities[i].toLowerCase();
        }
        ArrayList<String> list = new ArrayList<>();
        if(cacheSize == 0){
            answer = cities.length * 5;
        }
        if(cacheSize > 0){
           for(String A : lowCities){
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
           System.out.println(hit + " " + miss);

            answer = (hit * 1) + (miss * 5);
        }
        return answer;
    }
}
