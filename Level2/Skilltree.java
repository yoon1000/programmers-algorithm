// 2023.05.08
// Level 2 - 스킬트리

import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
      
        // 입력으로 들어온 String을 character 배열로 바꿔준다.
        char[] Skill = skill.toCharArray();     
        
        for(int i = 0; i < skill_trees.length; i++){
            
            // 유저들이 만든 스킬트리를 HashSet을 이용해 스킬 순서와 비교해준다.
            HashSet<Character> Trees = new HashSet<>();
            int index = 0;
            int sameCount = 0;
            int skillCount = 0;
            char[] trees = skill_trees[i].toCharArray();
            for(char A : trees){
                Trees.add(A);
            }
            
            // 스킬트리와 순서가 정해져 있는 스킬 순서와 비교하여 포함하고 있는 스킬의 갯수를 센다.
            for(int j=0; j < Skill.length; j++){
                if(Trees.contains(Skill[j]))
                    skillCount++;
                
            }
            // 스킬 순서에 맞게 구성되어 있는지 Skill 배열과 비교한다.
             for(char A : trees){
                if(index == Skill.length)
                    break;
                
                if(A==Skill[index]){
                    sameCount++; index++;
                }
                 
            }
            // 만약 스킬 갯수가 같다면 가능한 스킬트리의 갯수를 증가시킨다.
            if(skillCount == sameCount)
                answer++;
        }
        
        return answer;
    }
}
