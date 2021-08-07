//level1 - 체육복
import java.util.ArrayList;
import java.util.HashMap;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int count = n - lost.length;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : lost){
            list.add(i);
        }

        HashMap<Integer, Integer> Reserve = new HashMap<>();
        for(int i : reserve){
            Reserve.put(i, 1);
        }
        for(int i : lost) {
            if (Reserve.containsKey(i)){
                Reserve.remove(i);
                list.remove(list.indexOf(i));
                count++;
            }
        }

        for(int i : list){
            if(Reserve.containsKey(i+1)){
                Reserve.remove(i+1);
                count++;
            }
            else if(Reserve.containsKey(i-1)){
                Reserve.remove(i-1);
                count++;
            }
        }


        answer = count;
        return answer;
    }
}
