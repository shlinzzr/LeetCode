// https://leetcode.com/problems/minimum-cost-to-make-array-equalindromic

class Solution {
    public long minimumCost(int[] nums) {
        
        long cost = 0; // Math.abs(n-x);
        int len = nums.length;
        
        int sum = 0;
        
        for(int i=0; i<len; i++){
            sum += nums[i];
        }
        
        if(sum/len>=1 && sum/len<=9){
            
           int  mid = sum/len;
            for(int i=0; i<len ; i++){
                cost+=Math.abs(nums[i]-mid);
            }
             long cost2=0;
            int mid2 = mid+1;
            for(int i=0; i<len ; i++){
                 cost2+=Math.abs(nums[i]-mid2);
            }

            return Math.min(cost, cost2);
        }
        
        
        if(isPal(sum/len)){
            for(int i=0; i<len ; i++){
                cost+=Math.abs(nums[i]-sum/len);
            }
            return cost;
        }
        
        
        
        String[] rt = nearestPalindromic(String.valueOf(sum/len));
        
        Integer mid = Integer.valueOf(rt[0]);
   
        for(int i=0; i<len ; i++){
             cost+=Math.abs(nums[i]-mid);
        }
        
        
        
        if(rt.length>1){
            long cost2=0;
            Integer mid2 = Integer.valueOf(rt[1]);
   
            for(int i=0; i<len ; i++){
                 cost2+=Math.abs(nums[i]-mid2);
            }

            return Math.min(cost, cost2);
        }
        
        return cost;
        
        
       
        
        
        
        //chose a n
        // 1 2 2 3 => 2
        // 11 11 11 99 99 99=>  11:88 +88 + ,   55:44+44+44+ 44+44
        
        // 12 12 12 99 99 99
        
//         PriorityQueue<int[]> pq= new ArrayList<>(
//             (a,b) -> b[0]==a[0] ? b[1]-a[1] ? b[0]-a[0] 
//         );
        
//         Arrays.sort(nums);
//          HashMap<Integer, Integer> imap = new HashMap<>();
//         HashMap<Integer, Integer> map = new HashMap<>();
        
//         for(int i=0; i<len; i++){
//             map.put(nums[i], map.getOrDefault(nums[i],0)+1);
//             imap.put(nums[i], i);
//         }
        
//         for(Integer k : map.keySet()){
//             pq.offer(new int[]{map.get(k), imap.get(k), k});
//         }
        
//         while(!pq.isEmpty()){
            
            
//         }
        
//         int[] p = pq.poll();
        
//         for(int i=0; i<len; i++){
//             cost+=Math.abs(nums[i]-p[2]);
//         }
        
        
//         return cost;
        
         
        
    }
    
    
    private boolean isPal(int n){
        int tmp = n;
        int rev = 0;
        while(tmp>0){
            rev*=10;
            rev+=tmp%10;
            tmp/=10;
        }
        
        return rev==n;
    }
    
    public String[] nearestPalindromic(String n) {
        long nl = Long.parseLong(n);
        int len = n.length();
        
        // if(len==1 || isPal(Integer.valueOf(n))) return n;
         
        //
        // Corner cases
        //
        
        // <= 10 or equal to 100, 1000, 10000, ... 
        if (nl <= 10 || (nl % 10 == 0 
                         && n.charAt(0)=='1'
                         && Long.parseLong(n.substring(1)) == 0)) {
            
            return new String[]{"" + (nl - 1)};
        }
        
        // 11 or 101, 1001, 10001, 100001, ... 
        if (nl == 11 || (nl % 10 == 1 
                         && n.charAt(0) == '1' 
                         && Long.parseLong(n.substring(1, len - 1)) == 0)) {
           return new String[]{"" + (nl - 2)};
        }
        
        // 99, 999, 9999, 99999, ...  
        if (isAllDigitNine(n)) {
            return new String[]{"" + (nl +2 )};
        }
        
        //
        // Construct the closest palindrome and calculate absolute difference with n
        //
        boolean isEvenDigits = len % 2 == 0;
        
        String palindromeRootStr
            = (isEvenDigits) ? n.substring(0, len / 2) : n.substring(0, len / 2 + 1);
        
        int palindromeRoot = Integer.valueOf(palindromeRootStr); 
        long equal = toPalindromeDigits("" + palindromeRoot, isEvenDigits);
        long diffEqual = Math.abs(nl - equal);
            
        long bigger = toPalindromeDigits("" + (palindromeRoot + 1), isEvenDigits);
        long diffBigger = Math.abs(nl - bigger);
        
        long smaller = toPalindromeDigits("" + (palindromeRoot - 1), isEvenDigits);
        long diffSmaller = Math.abs(nl - smaller);
         
         
        //
        // Find the palindrome with minimum absolute differences
        // If tie, return the smaller one
        //
        long closest = (diffBigger < diffSmaller) ? bigger : smaller;
        long minDiff = Math.min(diffBigger, diffSmaller);
        
        // if (diffEqual != 0) { // n is not a palindrome, diffEqual should be considered
        //     if (diffEqual == minDiff) { // if tie
        //         closest = Math.min(equal, closest);
        //     } else if (diffEqual < minDiff){
        //         closest = equal;
        //     }
        // }
        
        return new String[]{ ""+Math.min(equal, closest), ""+equal};
    }
    
    private long toPalindromeDigits(String num, boolean isEvenDigits) {
        StringBuilder reversedNum = new StringBuilder(num).reverse();
        String palindromeDigits = isEvenDigits
            ? num + reversedNum.toString()
            : num + (reversedNum.deleteCharAt(0)).toString();
        return Long.parseLong(palindromeDigits);
    }
    
    private boolean isAllDigitNine(String n) {
        for (char ch : n.toCharArray()) {
            if (ch != '9') {
                return false;
            }
        }
        return true;
    }
    
    // 10+9+6+3+13 111-> 109
    // 8+7+4+1+15
}