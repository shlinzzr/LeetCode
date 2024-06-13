// https://leetcode.com/problems/find-the-number-of-good-pairs-ii

class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {

        //find # of good pair
        // good pair 定義是 n1 可以被n2*k 整除 =>k是假議題 直接全乘到n2上
        // ＝> n1 = x * n2 => (n1大 n2小) => 從n1的質因數找n2


        Map<Integer, Integer> map = new HashMap<>();
        for(int n2 : nums2){
            int val = n2 * k;
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        long ans=0;
        for(int n1 : nums1){
            for(int j=1; j*j<=n1; j++){ // 找因數 從1開始找到平方為止
                
                if(n1%j==0){
                    if(map.containsKey(j)){
                        ans += map.get(j);
                    }

                    int val=n1/j; // 直接再找一層, 如果相同 ex:25=5*5的不要重複算
                    if(j!=val && map.containsKey(val)){
                        ans += map.get(val);
                    }
                }
            }
        }
        return ans;
    }
}