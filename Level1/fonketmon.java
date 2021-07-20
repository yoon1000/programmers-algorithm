import java.util.HashMap;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int num : nums){
            hashMap.put(num, hashMap.getOrDefault(num, 0)+1);
        }
        if(hashMap.size()>nums.length/2)
            answer = nums.length/2;
        else if(hashMap.size()<=nums.length/2)
            answer = hashMap.size();
        return answer;
    }
}
