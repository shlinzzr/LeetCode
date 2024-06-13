// https://leetcode.com/problems/distribute-elements-into-two-arrays-ii


class Solution {
    public int[] resultArray(int[] nums) {
        int n=nums.length;
        
        // two normal lists
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        
        // two sorted lists
        List<Integer> sortedList1=new ArrayList<>();
        List<Integer> sortedList2=new ArrayList<>();
        
        
        //insert in two normal lists
        list1.add(nums[0]);
        list2.add(nums[1]);
        
        // insert in two sorted lists
        sortedList1.add(nums[0]);
        sortedList2.add(nums[1]);
        
        for(int i=2;i<n;i++){
            int greaterCount1=greaterCount(sortedList1,nums[i]);
            int greaterCount2=greaterCount(sortedList2,nums[i]);
            
            // conditions given in problem
            if(greaterCount1 > greaterCount2)
                insert(sortedList1,nums[i],list1);
            else if(greaterCount1 < greaterCount2)
                insert(sortedList2,nums[i],list2);
            else if(list1.size() < list2.size())
                insert(sortedList1,nums[i],list1);
            else if(list2.size() < list1.size())
                insert(sortedList2,nums[i],list2);
            else
                insert(sortedList1,nums[i],list1);
            
        }
        
        // concatenate lists to list1
        list1.addAll(list2);
        
        //convert list to array
        int[] ans=new int[n];
        for(int i=0;i<n;i++) ans[i]=list1.get(i);
        return ans;
    }
    
    
    public void insert(List<Integer> sortedList, int element, List<Integer> list) {
        // insert at last index of a normal list
        list.add(element);
        
        // insert element in a sorted list    
        int index = Collections.binarySearch(sortedList, element);
        if (index < 0) {
            index = -index - 1;
        }
        sortedList.add(index, element);
    }
    
    
    // function to find count of greater elements than val
    public int greaterCount(List<Integer> list,int val){
        int n=list.size();
        int l = 0;
        int r = n - 1;
        int leftGreater = n;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (list.get(m) > val) {
                leftGreater = m;
                r = m - 1;
            }
            else l = m + 1;
        }
        return n - leftGreater;
    }
    
}