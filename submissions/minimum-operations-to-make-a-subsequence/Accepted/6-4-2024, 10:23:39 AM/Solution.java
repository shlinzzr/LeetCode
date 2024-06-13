// https://leetcode.com/problems/minimum-operations-to-make-a-subsequence

class Solution {
    public int minOperations(int[] target, int[] arr) {
        // 9,4,2,3,4 
        //[x,x,x,2,x ]


        // 5 1 3
        // 0 1 2
        int val = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<target.length; i++){
            int t = target[i];
            if(!map.containsKey(t)){
                map.put(t, val++);
            }
            target[i] = map.get(t);
        }

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            int a = arr[i];
            if(map.containsKey(a)){
                a = map.get(a);
                if(list.isEmpty() || a>list.get(list.size()-1)){
                    list.add(a);
                }else{
                    int idx = ceiling(list, a);
                    list.set(idx, a);
                }
            }
        }

        return target.length-list.size();
       


    }

     private int ceiling(List<Integer> list, int n){
        int st= 0, ed=list.size()-1;

        while(st<ed){
            int mid = st+(ed-st)/2;
            if(list.get(mid)>=n){
                ed = mid;
            }else{
                st = mid+1;
            }
        }

        return st;
    }
}