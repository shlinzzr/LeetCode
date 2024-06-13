// https://leetcode.com/problems/3sum-with-multiplicity

class Solution {
    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        
        int len =arr.length;
        int M = (int) 1e9+7;
        
        long  res = 0L;
        
        Map<Integer, Integer> map = new TreeMap<>();
        for(int a: arr){
            map.put(a, map.getOrDefault(a, 0)+1);
        }
        
        
        List<Integer> list = new ArrayList<>(map.keySet());
//         for(int l : list){
//             System.out.print(l + ",");
//         }
        
//         System.out.println();
//         System.out.println();
        
        
        
        
        
        for(int i=0; i<list.size()-2; i++){
            
            int j=(map.get(list.get(i))==1?i+1 : i), k=list.size()-1;
            
            while(j<=k){
                int x = list.get(i);
                int y = list.get(j);
                int z = list.get(k);


                if(x+y+z==target){
                    res = (res + map.get(x)*map.get(y)%M * map.get(z) %M )%M;
                    
                    if(x==y) res/=map.get(x);
                    if(x==z) res/=map.get(x);
                    
                    j++;
                    k--;
                }else if(x+y+z<target){
                    j++;
                }else
                    k--;

                // System.out.println("x="+x + " map.get(x)=" + map.get(x) 
                //                    + " y="+y + " map.get(y)=" + map.get(y) 
                //                    + " z="+z + " map.get(z)=" + map.get(z) 
                //                    + " sum="+(x+y+z) + " res="+res); 
            }
        }
        
        return (int)res;
        
        
        
        
        
        
    }
}