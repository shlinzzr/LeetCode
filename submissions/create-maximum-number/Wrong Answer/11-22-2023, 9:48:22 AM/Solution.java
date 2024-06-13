// https://leetcode.com/problems/create-maximum-number

class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {





        int m = nums1.length;
        int n = nums2.length;
        Stack<Integer> st = new Stack<>();
        
        int del = m+n-k;


        int[] tmp1 = new int[m+n];
        System.arraycopy(nums1, 0, tmp1, 0, m);
        System.arraycopy(nums2, 0, tmp1, m, n);
        int d= 0;

        for(int i=0; i<m+n; i++){
            while(!st.isEmpty() && st.peek()<tmp1[i] && d>del){
                d++;
                st.pop();
            }
            st.push(tmp1[i]);
        }
        while(d<del){
            st.pop();
            d++;
        }
        int[] res1= new int[st.size()];
        int idx= 0;
        for(int v: st){
            System.out.print(v + ", ");
            res1[idx++] = v;
        }
    
        


        /*
            sec part
        */
        st.clear();

 System.out.println();
 System.out.println();
 System.out.println();
 System.out.println();
        int[] tmp2 = new int[m+n];
        System.arraycopy(nums2, 0, tmp2, 0, n);
        System.arraycopy(nums1, 0, tmp2, n, m);
        d= 0;

        for(int i=0; i<m+n; i++){
            while(!st.isEmpty() && st.peek()<tmp2[i] && d>del){
                d++;
                st.pop();
            }
            st.push(tmp2[i]);
        }
        while(d<del){
            st.pop();
            d++;
        }
        int[] res2= new int[st.size()];
        idx= 0;
        for(int v: st){
            System.out.print(v + ", ");
            res2[idx++] = v;
        }

        for(int i=0; i<res1.length; i++){
            if(res1[i]>res2[i])
                return res1;
            
        }

        return res2;
            

        


/*

9 3 4 6
9 6 5 2 5
9 6 5 5

*/

        // int i=0,j=0,d=0;
        // while(i<m && j<n){

        //     int num= nums1[i]>nums2[j] ? nums1[i++] : nums2[j++];

        //     while(!st.isEmpty() && st.peek()<num && d<del){
        //         st.pop();
        //         d++;
        //     }
        //     st.push(num);
        // }

        // while(i<m){
        //     while(!st.isEmpty() && st.peek()<nums1[i] && d<del){
        //         st.pop();
        //         d++;
        //     }
        //     st.push(nums1[i]);
        //     i++;
        // }


        // while(j<n){
        //     while(!st.isEmpty() && st.peek()<nums2[j] && d<del){
        //         st.pop();
        //         d++;
        //     }
        //     st.push(nums2[j]);
        //     j++;
        // }



        // while(d<del){
        //     st.pop();
        //     d++;
        // }

        // int[] res = new int[st.size()];
        // int idx= 0;
        // for(int v : st){
        //     res[idx++]=v;
        // }

        // return res;

    }
}