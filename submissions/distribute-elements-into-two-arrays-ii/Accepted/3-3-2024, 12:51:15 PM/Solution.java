// https://leetcode.com/problems/distribute-elements-into-two-arrays-ii

class Solution {
    public int[] resultArray(int[] nums) {
        
         int len = nums.length;
        
        
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        
         List<Integer> sortedlist1 = new ArrayList<>();
        List<Integer> sortedlist2 = new ArrayList<>();
        
        sortedlist1.add(nums[0]);
        sortedlist2.add(nums[1]);
        list1.add(nums[0]);
        list2.add(nums[1]);
        
        for(int i=2; i<len; i++){
            
            int idx1 = greaterCount(sortedlist1, nums[i]);
            int idx2 = greaterCount(sortedlist2, nums[i]);
            
            int cnt1 = list1.size()-idx1;
            int cnt2 = list2.size()-idx2;
            
            if( cnt1==cnt2){
                
                if(list1.size()<=list2.size()){
                    sortedlist1.add(idx1, nums[i]);
                    list1.add(nums[i]);
                     // System.out.println("add1");
                    
                }else{
                    sortedlist2.add(idx2, nums[i]);
                    list2.add(nums[i]);
                      // System.out.println("add2");
                }
                
            
            }else if(cnt1 >  cnt2) {
                sortedlist1.add(idx1, nums[i]);
                list1.add(nums[i]);
                    // System.out.println("add11");
            } else{
                  sortedlist2.add(idx2, nums[i]);
                list2.add(nums[i]);
                    // System.out.println("add22");
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
    
    // [9, 46, 42] , 25
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
        
        
          
        int res=  st;
       
         if(list.get(st)<=val) res = list.size();
         // System.out.println("greaterCount(" + val + "):"+res);
        
        
        return res;
        
//         int res = 0 ;
      
        
        
//         if(list.get(st)>val) res = list.size()-st;
            
//            
//         return res;
        
        /*
        
        Input:
[2,47,3,3,65,7,97,4]
Output:
[2,65,7,4,
47,3,3,97]
Expected:
[2,65,7,97,4,
47,3,3]




Input:
[9,58,43,42,46,25,38,2,42,72,54,96,78,44  ,2,52,74,70,66,8]
Output:
[9,72,54,96,78,44,2,52,74,70,66,8,
58,43,42,46,25,38,2,42]

Expected:
[9,72,54,96,78,44,52,74,70,66,8,
58,43,42,46,25,38,2,42,2]

[9, 72, 54, 96, 78, 44, 52, 74, 70, 66, 8]
[58, 43, 42, 46, 25, 38, 2, 42, 2]

*/
        
    }
    
}