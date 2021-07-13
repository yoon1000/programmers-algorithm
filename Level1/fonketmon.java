import java.util.ArrayList;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        int count = 0;
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        list.sort(null);
        for(int i=0;i<nums.length-1;i++){
            if(list.get(i)!=list.get(i+1))
                count++;
        }
        if(count<nums.length/2)
            answer = count+1;
        else
            answer = nums.length/2;
        return answer;
    }
}
