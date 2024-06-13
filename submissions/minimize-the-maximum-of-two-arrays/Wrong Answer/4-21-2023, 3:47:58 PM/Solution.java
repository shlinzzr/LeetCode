// https://leetcode.com/problems/minimize-the-maximum-of-two-arrays

class Solution {
    public int minimizeSet(int d1, int d2, int u1, int u2) {
        int st=1, ed=Integer.MAX_VALUE;
        
        int ans = -1;
        
        while(st<ed){
            int mid = st+(ed-st)/2;
            System.out.println(mid + " " + ok(d1,d2,u1,u2, mid));
            if(ok(d1,d2,u1,u2, mid)==false){
                ed=mid;
                
            }else{
                ans = mid;
                st = mid+1;
                
            }
        }
        
        return ans;
        
    }
    
    
    private boolean ok (int d1, int d2, int u1, int u2, int mid){
        
        if(mid%d1==0 && mid%d2==0)
            return false;
        
        int cnt1=0, cnt2=0, cnt3=0;
    
        for(int i= 1; i<mid; i++){
            if(i%d1!=0 && i%d2!=0)
                cnt3++;

            else if(mid%d1==0)
                cnt2++;
            else 
                cnt1++;
            
            if((cnt1>=u1 && cnt2>=u2)|| (cnt1+cnt2+cnt3>=u1+u2))
                return false;
            
        }
        
        
        return true;
        
//         // if(cnt1+cnt3<u1 || cnt2+cnt3<u2 || (cnt1+cnt2+cnt3<u1+u2))
//         //     return false;
        
        
//         System.out.println(cnt1 + " " + cnt2 + " "+ cnt3 + " " + mid);
        
//         if(cnt1<u1){
//             cnt3-=u1-cnt1;
//         }
        
//         if(cnt2<u2){
//             cnt3-=u2-cnt2;
//         }
        
//         return cnt3>0;
        
        
        
        
        
    }
}