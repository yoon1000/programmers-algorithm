import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
      
        // 장르별로 모든 곡의 재생 횟수를 구한다.
        HashMap<String, Integer> bestGenre = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
            bestGenre.put(genres[i], bestGenre.getOrDefault(genres[i], 0)+plays[i]);
        }
      
        // 재생 횟수가 가장 많은 장르로 정렬한다. (<String, Integer>일 때의 value값 정렬)
        List<Map.Entry<String, Integer>> list_entries = new ArrayList<Map.Entry<String, Integer>>(bestGenre.entrySet());
        Collections.sort(list_entries, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });

        // 각 장르에 대해 나눈 후 곡의 공유번호와 재생 횟수를 value값으로 설정한다. 
        // hashmap의 value값이 hashmap
        HashMap<String, HashMap<Integer, Integer>> music = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
            if(!music.containsKey(genres[i])){
                music.put(genres[i], new HashMap<>());
            }
            music.get(genres[i]).put(i, plays[i]);
        }
      
        // 가장 많이 재생된 장르부터 많게는 두 곡씩 앨범에 추가해준다.
        ArrayList<Integer> AnswerList = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : list_entries) {
            List<Integer> keySetList = new ArrayList<>(music.get(entry.getKey()).keySet());
            Collections.sort(keySetList, (o1, o2) -> (music.get(entry.getKey()).get(o2).compareTo(music.get(entry.getKey()).get(o1))));
          
            for(int i = 0; i < music.get(entry.getKey()).size(); i++){
                AnswerList.add(keySetList.get(i));
                if(i == 1)
                    break;
            }
        }

        // 정리된 arraylist를 정답 배열에 넣어준다. 
        int[] answer = new int[AnswerList.size()];
        for(int i = 0; i < AnswerList.size(); i++){
            answer[i] = AnswerList.get(i);
        }
        return answer;
    }
}
