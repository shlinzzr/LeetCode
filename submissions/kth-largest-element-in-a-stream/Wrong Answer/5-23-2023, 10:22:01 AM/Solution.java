// https://leetcode.com/problems/kth-largest-element-in-a-stream

class KthLargest {

    int idx = 0;

    ArrayList<Integer> list;
    
    public KthLargest(int k, int[] nums) {
        
        this.idx = k;
        list = new ArrayList<>();
        
        for(int n: nums){
            list.add(n);
        }
        
        Collections.sort(list, Collections.reverseOrder());
        
    }
    
    public int add(int val) {
        
        int st=0;
        int ed=list.size()-1;
        
        while(st<ed){
            
            int mid = st+(ed-st)/2;
            
            if(list.get(mid)==val){
                st=mid;
                break;
            
            }else if(list.get(mid)<val){
                ed = mid;
            }else 
                st = mid+1;
        }
        
        // for(int n : list){
        //     System.out.print(n + ",");
        // }
        // System.out.println();
        
        
        list.add(st, val);
            
        return list.get(idx-1);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */