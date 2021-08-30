// level 2 - 2018 KAKAO BLIND RECRUITMENT - [1차] 프렌즈4블록

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        int index = m-1;
        for(String a : board){
            System.out.println(index + ": " +a);
            index--;
        }

        List<ArrayList<String>> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(new ArrayList<String>());
        }

        for(int j = 0; j < m; j++){
            char[] chars = board[board.length - 1 - j].toCharArray();
            for(int i = 0; i < n; i++){
                list.get(i).add(Character.toString(chars[i]));
            }
        }

        Map<Integer, List<Integer>> maps = new HashMap<>();
        for(int j = 0; j < m - 1; j++){
            for(int i = 0; i < n - 1 ;i++){
                if(isSame(list.get(j).get(i), list.get(j+1).get(i), list.get(j).get(i+1),list.get(j+1).get(i+1))) {
                    System.out.println("j: " + j + " i: " + i);
                }
            }
        }

        return answer;
    }
  
  public static boolean isSame(String A, String B, String C, String D){
        boolean issame = false;
        if(A.equals(B) && B.equals(C) && C.equals(D) && D.equals(A))
            issame = true;
        return issame;
    }
}
