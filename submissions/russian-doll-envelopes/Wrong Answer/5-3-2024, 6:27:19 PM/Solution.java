// https://leetcode.com/problems/russian-doll-envelopes

class Solution {
    public int maxEnvelopes(int[][] env) {

        int len = env.length;

        Arrays.sort(env, (a,b)-> a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1]); 
        // which is already ensure sort asc by width
        // then we find the lis 2d to 1d from height

        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<len; i++){
            
            int cur = env[i][1];

            if( list.isEmpty() || cur > list.get(list.size()-1) ){
                list.add(cur);
            }else{ // cur is too small
                int x = binarySearch(list, cur);
                list.set(x, cur);
            }

        }

        return list.size();
        
    }
    // to find the first element of list 
    // which is the "first one who greater" than cur and replace it with smaller "cur"
    private int binarySearch(List<Integer> list, int cur){

        int st=0, ed= list.size()-1;

        while(st<ed){ // 0 1
            int m = st+(ed-st)/2; // 0

            int mid = list.get(m);

            if(mid==cur){
                return mid;
            }if(mid<cur){
                st = m+1; //1
            }else{
                ed = m; //0
            }
        }

        return st;
    }
}