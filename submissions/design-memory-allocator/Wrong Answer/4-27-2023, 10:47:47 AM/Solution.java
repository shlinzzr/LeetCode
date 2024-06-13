// https://leetcode.com/problems/design-memory-allocator

class Allocator {

    int capacity;
    TreeSet<Integer> slot;
    TreeSet<Integer> used;
    HashMap<Integer, List<Integer>> map; // mId, idx
    public Allocator(int n) {
        capacity=n;
        
        slot = new TreeSet<>();
        used = new TreeSet<>();
        for(int i=0; i<n; i++)
            slot.add(i);
        
        map = new HashMap<>();
    }
    
    public int allocate(int size, int mID) {
        //    System.out.println("/////////");
        //   System.out.println("size="+size);
        // System.out.println("mID="+mID);
//             for(int s: slot){
//                 System.out.print(s + ",");
//             }
//             System.out.println();
            
//             for(int u: used){
//                 System.out.print(u + ",");
//             }
//             System.out.println();
        
        Integer idx = slot.ceiling(0);
      
        if(idx==null)
            return -1;
        
        while(idx!=null && idx<capacity){
            // System.out.println("while idx="+idx);
            //   System.out.println("used.floor(idx+size-1)="+used.floor(idx+size-1));
            
            if(used.floor(idx+size-1)!=null && used.floor(idx+size-1)>=idx){
                idx = idx+size-1;
                
                    
            }else{
                
                if(idx+size-1>capacity){
                    idx+=size;
                    break;
                        
                }
                
                map.putIfAbsent(mID, new ArrayList<>());
                for(int i=idx; i<idx+size; i++){
                    slot.remove(i);
                    used.add(i);
                    map.get(mID).add(i);
                }
                break;
            }
        }
        if(idx>capacity)
            return -1;
        
        
        return idx;
    }
    
    public int free(int mID) {
        
        List<Integer> list = map.get(mID);
        if(list==null || list.size()==0)
            return 0;
        
        map.remove(mID);
        
        for(int i : list){
            slot.add(i);
            used.remove(i);
        }
        
        return list.size();
    }
}

//expect [null, 0, 1, 2, 1, 3, 1, 6, 3, -1, 0]
        //[null,0,1,2,1,3,1,6,3,9,0]

      // [null, 0, 1, 2, 1, 4, 1, 3, 3, 10, 0]
      //.
//output [null,10,-1,-1,0,-1,-1,-1,10,10,0]

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.free(mID);
 */