// 2023.05.08
// Level 2 - 영어 끝말잇기

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        // 영어 단어를 중복 없이 담을 HashSet과 각 사람이 말한 단어를 담을 HashMap을 생성한다.
        HashSet<String> wordSet = new HashSet<>();
        HashMap<Integer, List<String>> wordMap = new HashMap<>();
        for(int i = 1; i <= n; i++){
            wordMap.put(i , new ArrayList<String>());
        }
        
        for(int j = 0; j < words.length; j++){
            int order = j % n + 1;
            
            // 첫 번째 사람이 말한 단어를 넣고 시작한다.
            if(j == 0){
                wordSet.add(words[j]);
                wordMap.get(order).add(words[j]);
            }       
            
            else{
                // 다음 사람이 말한 단어의 첫 글자가 이전 사람이 말한 단어의 첫 글자와 같은 지 확인한다.
                String former = words[j-1].substring(words[j-1].length()-1);
                String latter = words[j].substring(0,1);
                
                wordSet.add(words[j]);
                wordMap.get(order).add(words[j]);
                
                // 만약의 두 글자가 같지 않다면 틀린 사람은 현재 말한 사람
                if(!former.equals(latter)){
                    answer[0] = order;
                    answer[1] = wordMap.get(order).size();
                    break;
                }
                // 글자는 맞게 말하였지만 이전에 나왔던 단어라면 틀린 사람의 현재 말한 사람
                else{
                    if(wordSet.size() != j+1){
                        answer[0] = order;
                        answer[1] = wordMap.get(order).size();
                        break;
                    }
                    
                }
                
            }
            
        }
        
        
        return answer;
    }
}
