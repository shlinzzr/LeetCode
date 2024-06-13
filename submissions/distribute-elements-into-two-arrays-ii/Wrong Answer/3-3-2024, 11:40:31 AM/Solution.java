// https://leetcode.com/problems/distribute-elements-into-two-arrays-ii

class Solution {
    public int[] resultArray(int[] nums) {
        
         int len = nums.length;
        
        
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Set<Integer> set1= new TreeSet<>();
        Set<Integer> set2= new TreeSet<>();
        
        set1.add(nums[0]);
        set2.add(nums[1]);
        list1.add(nums[0]);
        list2.add(nums[1]);
        
        for(int i=2; i<len; i++){
            
            if(greaterCount(new ArrayList<>(set1), nums[i]) ==  greaterCount(new ArrayList<>(set2), nums[i]) ){
                
                if(set1.size()<=set2.size()){
                    set1.add(nums[i]);
                    list1.add(nums[i]);
                }else{
                    set2.add(nums[i]);
                    list2.add(nums[i]);
                }
                
            
            }else if(greaterCount(new ArrayList<>(set1), nums[i]) >  greaterCount(new ArrayList<>(set2), nums[i]) ){
                set1.add(nums[i]);
                list1.add(nums[i]);
            } else{
                set2.add(nums[i]);
                list2.add(nums[i]);
            }
        }
        
        int idx=0, i1=0, i2=0;
        
        
        // System.out.println(list1);
        //   System.out.println(list2);
        
        while(i1<list1.size()){
            nums[idx++] = list1.get(i1++);
        }
        
        while(i2<list2.size()){
            nums[idx++] = list2.get(i2++);
        }
        
        
        return nums;
    }
    
    // [1, 3] , 3
    private int greaterCount(List<Integer> list, int val){
        
        int st=0, ed= list.size()-1;
        
        while(st<ed){
            
            int mid = st+(ed-st)/2;
            
            if(list.get(mid)<=val){
                st = mid+1;
            }else{
                ed = mid;
            }
            
        }
        
        // System.out.println("greaterCount(" + val + "):"+st);
        
        
        if(list.get(st)>val) return list.size()-st;
            
            
        return 0;
        
        
        
    }
    
}