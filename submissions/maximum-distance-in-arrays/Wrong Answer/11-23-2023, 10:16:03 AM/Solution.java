// https://leetcode.com/problems/maximum-distance-in-arrays

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int m = arrays.size();
        int res= 0;
       /* for(List<Integer> list : arrays){
            Collections.sort(list);
        }

        for(int i=0; i<m; i++){
            for(int j=i+1; j<m; j++){
                List<Integer> a = arrays.get(i);
                List<Integer> b = arrays.get(j);

                res = Math.max(res, Math.abs(a.get(a.size()-1)-b.get(0)));
                res = Math.max(res, Math.abs(b.get(b.size()-1)-a.get(0)));
            }
        }

        return res;*/


        TreeMap<Integer, Integer> map =new TreeMap<>();
        for(int i=0; i<m ;i++){
            List<Integer> list= arrays.get(i);
            for(int num: list){
                map.put(num, map.getOrDefault(num ,0)+1);
            }
        }

        for(int i=0; i<m; i++){
            List<Integer> list = arrays.get(i);

            if(list.size()==0)
                continue;

            Collections.sort(list);

            TreeMap<Integer, Integer> tmp = new TreeMap<>(map);
            
            while(list.size()>0 && tmp.lastKey()==list.get(list.size()-1)){
                
                int val = list.get(list.size()-1);
                tmp.put(val, tmp.getOrDefault(val ,0)-1);
                list.remove(list.size()-1);

                if(tmp.get(val)==0)
                    tmp.remove(val);
                
            }


            // for(int num: list){
            //     map.put(num, map.getOrDefault(num ,0)-1);
            //     if(map.get(num)==0)
            //         map.remove(num);
            // }

            res = Math.max(res, tmp.lastKey()-tmp.firstKey());

            // for(int num: list){
            //     map.put(num, map.getOrDefault(num ,0)-1);
            // }

        }

        return res;
    }
}

