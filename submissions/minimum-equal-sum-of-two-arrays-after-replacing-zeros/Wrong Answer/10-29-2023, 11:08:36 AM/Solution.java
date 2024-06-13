// https://leetcode.com/problems/minimum-equal-sum-of-two-arrays-after-replacing-zeros

class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        
//         Arrays.sort(nums1);
//           Arrays.sort(nums2);
        
//         for(int n : nums1){
//             System.out.print(n+",");
//         }
//         System.out.println();
        
//               for(int n : nums2){
//             System.out.print(n+",");
//         }
//         System.out.println();
        
        long z1=0, z2=0;
        long sum1=0, sum2=0;
        for(int i=0; i<len1; i++){
            sum1 += nums1[i];
            if(nums1[i]==0)
                z1++;
        }
        
        for(int i=0; i<len2; i++){
            sum2 += nums2[i];
              if(nums2[i]==0)
                z2++;
        }
        
        
         //    System.out.println(sum1 + " z1=" + z1);
         // System.out.println(sum2 + " z2=" + z2);
        
        if(sum1==sum2 && z1==0 && z2==0)
            return 0;
        
        if(sum1!=sum2 && z1==0 && z2==0)
            return -1;
        
        if(sum1>sum2 && z2==0)
            return -1;
        
        if(sum2>sum1 && z1==0)
            return -1;
        
    
        
        long min1 = sum1 + z1;
        long min2 = sum2 + z2;
        
        
        long diff = Math.abs(sum1-sum2);
        if(sum1>sum2){
            if(diff < z2)
                return -1;
        }else if(sum2>sum1){
            if(diff<z1)
                return -1;
        }
        
        
        
        return Math.max(min1, min2);
//         if(min1 == min2)
//             return z1+z2;
        
//         long res= 0;
//         if(min1>min2){
//             res = min1-min2+z1 + z2;
//         }else{
//             res = min2-min1 + z1 +z2;
//         }
        
//         return res;
        
        
        
    }
}