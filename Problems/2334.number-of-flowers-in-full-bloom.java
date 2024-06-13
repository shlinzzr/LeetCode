// https://leetcode.com/problems/number-of-flowers-in-full-bloom

class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {

        int n = flowers.length;
        int[] start  = new int[n];
        int[] end = new int[n];
        for(int i = 0; i<n; i++){
            start[i] = flowers[i][0];
            end[i] = flowers[i][1];
        }
        // flowers = [[1,6],[3,7],[9,12],[4,13]], people = [2,3,7,11]
        // n=4
        // start : 1 3 4 9
        // end :   6 7 12 13

        //
        // i==0, p=2, start bs find bloom = 3(idx==1)
        // i==0, p=2, end bs find die = 6(idx==0)
        // res[0] = 1-0 ??



        Arrays.sort(start);
        Arrays.sort(end);

        int m = people.length;
        int[] res =new int[m];
        for(int i = 0; i<m; i++){
            int bloom = binarySearch(start, people[i]+1); // for lowerbound offset, very tricky
            int die = binarySearch(end, people[i]);
            // System.out.println(bloom + " " + die);
            res[i] = bloom - die;
        }

        return res;
    }
    //找第一個 arr[m]>= target
    private int binarySearch(int[] arr, int target){
        int res = arr.length;
        int l =0;
        int r = arr.length-1;
        while(l<=r){
            int m = (l+r)/2;
            if(arr[m]>=target){
                res = m;
                r = m -1;
            } else {
                l = m +1;
            }
        }

        return res;
    }
}


        // // flowers : N, people: M
        // // TreeMap : O(NlgN + MlgN)
        // TreeMap<Integer, Integer> cntMap = new TreeMap<>();
        // for(int[] f: flowers){
        //     cntMap.put(f[0], cntMap.getOrDefault(f[0],0)+1);
        //     cntMap.put(f[1]+1, cntMap.getOrDefault(f[1]+1,0)-1);
        // }


        // TreeMap<Integer, Integer> aggMap = new TreeMap<>();
        // int agg = 0;
        // for(int x : cntMap.keySet()){
        //     agg += cntMap.get(x);
        //     aggMap.put(x, agg);
        // }

        
        // int len = people.length;
        // int[] res = new int[len];
        // for(int i=0; i<len; i++){
        //     int t = people[i];
        //     Integer x = aggMap.floorKey(t);
        //     if(x!=null){
        //         res[i] = aggMap.get(x);
        //     }else{
        //         res[i] = 0;
        //     }
        // }

        // return res;



        