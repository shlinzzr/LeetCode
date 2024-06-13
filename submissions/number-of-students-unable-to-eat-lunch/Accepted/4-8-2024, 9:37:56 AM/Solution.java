// https://leetcode.com/problems/number-of-students-unable-to-eat-lunch

class Solution {
    public int countStudents(int[] stu, int[] food) {


        int len = stu.length;

        int z=0, o=0;

        for(int i=0; i<len; i++){
            if(stu[i]==0){
                z++;
            }else{
                o++;
            }
        }

        int min = Math.min(z, o);

        for(int i=0; i<len; i++){
            if(food[i]==1){
                o--;
            }else{
                z--;
            }

            if(o<0 || z<0){
                return len-i;
            }
        }

        return 0;




        // Queue<Integer> q = new LinkedList<>();
        // for(int s: stu){
        //     q.offer(s);
        // }

        // for(int i=0; i<len;i++){
        //     int s = q.pop();
        //     if(s==food[i]){
        //         continue;
        //     }else{
        //         q.offer(s);
        //         i--;
        //     }
        // }


        // boolean[] taken = new boolean[len];
        // boolean[] taken = new boolean[len];
        // int si=0, fi=0;

        // int cnt= 0 ;
        // while(cnt<len){

        //     if(stu[si]==food[fi]){
                

        //         taken[fi]=true;
        //         cnt++;
        //         if(cnt==len)
        //             break;
        //         while(taken[fi]){
        //             fi++;
        //         }

        //         while()

        //         si%=len;


        //     }
        // }
        
    }
}