// level 2 - 위장

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
       int answer = 0; int length = clothes.length; int result = 0;
        ArrayList<String> list = new ArrayList<>();
        HashMap<String, String> hashMap = new HashMap<>();
        for(int i = 0; i < length; i++){
            hashMap.put(clothes[i][0], clothes[i][1]);
        }

        String arr[] = new String[clothes.length];
        for(int i =0; i< clothes.length; i++){
            arr[i] = clothes[i][0];
        }
        boolean visited[] = new boolean[clothes.length];
        combination(arr, visited, 0, 3, 2, hashMap);

        return answer;
    }
  
   static void combination(String[] arr, boolean[] visited, int start, int n, int r, HashMap<String, String> hashMap) {
        ArrayList<String> temp = new ArrayList<>();
        HashMap<String, String> listMap = new HashMap<>();
        int count = 0;
        if (r == 0) {
            temp = print(arr, visited, n);
            for(String a : temp){
                listMap.put(a, hashMap.get(a));
            }
            listMap.remove(temp.get(0));
            if(listMap.containsValue(hashMap.get(temp.get(0))))
                System.out.println("sameclothes...");
            else
                System.out.println("not same///");
            /*for(String a:temp){
                System.out.print(a +" ");
            }
            System.out.println();*/
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1, hashMap);
            visited[i] = false;
        }
    }
  
  static ArrayList<String> print(String[] arr, boolean[] visited, int n) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                list.add(arr[i]);
                //System.out.print(arr[i] + " ");
            }
        }
        //System.out.println();
        return list;
    }
}
