// https://leetcode.com/problems/replace-non-coprime-numbers-in-array

class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
       List<Integer > list = new ArrayList<>();
        for(int n : nums){

            //跟list最後一個一直check co-prime : 如果gcd>1表示沒有互質, 用lcm替代
            while(!list.isEmpty() && gcd(list.get(list.size()-1), n)>1){
                
                int last = list.get(list.size()-1);
                n = (int)lcm((long)last, (long)n);
                list.remove(list.size()-1);
               
            }

            list.add(n);

        }

        return list;
    }



//y : 45 *2  = 90
// 灣鬼 12 *14 = 168
// S, M 12 * 6 = 72
// L 15 *3 = 45
//  bridge 25*6 150
// 90 + 240 + 150 + 45
//slope 100


    // // gcd(8,4) => gcd(4%8=4, 4) => gcd(4%4=0, 4) => 4
    // private long gcd(long a, long b){
    //     if(a==0) return b;
    //     return gcd(b%a, b);
    // }
 private int gcd(int a, int b){
        if(b==0)  return a;
        return gcd(b, a%b);
    } 

    public long gcd(long a,long b)
	{
		if (b == 0)   
			return a;  

		return gcd(b, a % b);  
	}


    private long lcm(long a, long b){

        long rt = gcd(a,b);
        // System.out.println("gcd("+a+","+b+")="+rt);

        return a*b/gcd(a,b);
    }
}