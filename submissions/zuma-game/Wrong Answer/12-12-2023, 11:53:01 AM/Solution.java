// https://leetcode.com/problems/zuma-game

class Solution {
    int res =6;

    public int findMinStep(String board, String hand) {
        int len = board.length();
        boolean[] seen = new boolean[len];
        int[] arr = new int[26];
        for(char ch : board.toCharArray()){
            arr[ch-'A']++;
        }

        dfs(new StringBuilder(board), arr, 0);
        return res;
    }

    private void dfs(StringBuilder sb, int[] arr, int op){
        if(op==6)
            return;

        if(sb.isEmpty()){
            res = Math.min(res, op);
            return;
        }

        for(int i=0; i<sb.length(); i++){
            for(char ch ='A'; ch<='Z'; ch++){
                if(arr[ch-'A']!=0 && ch==sb.charAt(i)){
                    StringBuilder tmp = new StringBuilder(sb);
                    tmp.insert(i, ch);
                    tmp = squeezeString(tmp.toString());

                    arr[ch-'A']--;
                    dfs(tmp, arr, op+1);
                    arr[ch-'A']++;
                }
            }
        }
    }

    private StringBuilder squeezeString(String temp){
        while(true){
            int[] nums = canEliminate(temp);
            if(nums[0]==-1 && nums[1]==-1)
                return new StringBuilder(temp);
            temp = temp.substring(0, nums[0]) + temp.substring(nums[1]+1);
        }
    }

    public int[] canEliminate(String sb){
        int left =0, right=0;
        while(right<sb.length()){
            while(right<sb.length() && sb.charAt(right)==sb.charAt(left))
                right++;
            if(right-left>=3){
                return new int[]{left, right-1};
            }

            left = right;
        }

        return new int[]{-1, -1};
    }
}