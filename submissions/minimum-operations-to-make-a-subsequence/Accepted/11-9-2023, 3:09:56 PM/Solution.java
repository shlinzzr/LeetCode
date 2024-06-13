// https://leetcode.com/problems/minimum-operations-to-make-a-subsequence

class Solution {
    public int minOperations(int[] target, int[] arr) {
        int m = target.length;
        int n = arr.length;

        //[5,1,3] -> [0,1,2]
        HashMap<Integer, Integer> map = new HashMap<>();
        int idx=0;
        for(int t : target){
            if(!map.containsKey(t)){
                map.put(t, idx);
                idx++;
            }
        }

        for(int i=0; i<n; i++){
            if(map.containsKey(arr[i])){
                arr[i] = map.get(arr[i]);
            }else{
                arr[i] = Integer.MAX_VALUE;
            }
            // System.out.print(arr[i] + ", ");
        }
        // System.out.println();
        // [9,4,2,3,4] -> [x, x, x, 2, x]


        int cnt = lis(arr);
        // System.out.println("cnt="+cnt);

    
        return m-cnt;

    }

    private int lis(int[] arr){
        int res = 0;

        List<Integer> list = new ArrayList<>();
        int len = arr.length;

        for(int i=0; i<len; i++){

            // special handle
            if(arr[i]==Integer.MAX_VALUE)
                continue;

            if(list.isEmpty() || arr[i]>list.get(list.size()-1)){
                list.add(arr[i]);
            }else{
                int idx = binarySearch(list, arr[i]);
                list.set(idx, arr[i]);

            }
        }        
        return list.size();

    }

    private int binarySearch(List<Integer> list, int target){

        int st=0, ed=list.size()-1;

        while(st<ed){
            int mid = (st+ed)/2;
            if(list.get(mid)==target){
                return mid;

            }else if(target>list.get(mid)){
                st = mid+1;

            }else{
                ed = mid;
            }
        }

        return st;

    }
}