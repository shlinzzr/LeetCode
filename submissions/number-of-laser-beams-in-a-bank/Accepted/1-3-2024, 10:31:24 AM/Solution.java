// https://leetcode.com/problems/number-of-laser-beams-in-a-bank

class Solution {
    public int numberOfBeams(String[] bank) {
        int len = bank.length;

        int sum = 0;
        int cnta = 0;
        int ia=0;
        while(ia<len){

           
            while(ia<len && cnta==0){
                String a = bank[ia];
                for(char ch : a.toCharArray()){
                    cnta += ch-'0';
                }
                ia++;
            }

            int ib = ia;
            int cntb = 0 ;
            while(ib<len && cntb==0){
                String b = bank[ib];
                for(char ch : b.toCharArray()){
                    cntb += ch-'0';
                }
                ib++;
            }

            if(cnta>0 && cntb>0){
                sum += cnta*cntb;
                cnta = cntb;
                ia = ib;
            }

            if(ib>=len)
                break;
        }
        


        return sum;

    }
}