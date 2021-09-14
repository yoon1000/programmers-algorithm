import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int index = location;
        boolean flag = true;
        
        // hashset을 이용해 중요도의 종류를 구분한다.(중복된 것은 사라짐)
        // list를 이용해 queue를 구현한다. 
        HashSet<Integer> hashSet = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int a : priorities){
            hashSet.add(a);
            list.add(a);
        }

        // 중요도가 높은 순으로 정렬한다.
        List<Integer> sortlist = new ArrayList<>(hashSet);
        Collections.sort(sortlist, Collections.reverseOrder());
      
        // list로 printer의 규칙을 구현한다.
        for(int A : sortlist){
            while(flag){
                // 가장 앞의 문서보다 중요도가 높은 문서가 존재하면 가장 뒤로 보내준다.
                if(list.contains(A) && list.get(0) != A){
                    list.add(list.get(0));
                    list.remove(0);
                    if(index==0)
                        index+=list.size()-1;
                    else
                        index--;

                }
                // 가장 앞의 문서가 가장 높은 중요도와 같다면 list에서 제거해준다.
                else if(list.contains(A) && list.get(0) == A){
                    list.remove(0);
                    // 찾고자 하는 문서가 프린트 되지 않았다면 다시 앞의 과정을 반복해준다.
                    if(index != 0) {
                        index--;
                        answer++;
                    }
                    // 이 때 프린트한 문서가 알고자 하는 문서라면 현재의 순서를 반환한다.
                    else{
                        answer++;
                        flag = false;
                    }
                }
                // 해당 중요도를 갖고 있지 않다면 다음 중요도로 넘어간다.
                else if(!list.contains(A)){
                    break;
                }
            }
        }
        return answer;
    }
}
