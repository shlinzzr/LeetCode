// https://leetcode.com/problems/number-of-people-that-can-be-seen-in-a-grid

class Solution {
    public int[][] seePeople(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;


        Stack<Integer> st = new Stack<>();
        int[][] prevGreater_ver = new int[m][n];
        for(int[] p : prevGreater_ver){
            Arrays.fill(p, -1);
        }
        for(int j=0; j<n; j++){
            for(int i=m-1; i>=0; i--){
                while(!st.isEmpty() && heights[i][j]>=heights[st.peek()][j]){
                    prevGreater_ver[st.pop()][j] = i;
                }
                st.push(i);
            }
             st.clear();
        }

        st.clear();
        int[][] prevGreater_hor = new int[m][n];
        for(int[] p : prevGreater_hor){
            Arrays.fill(p, -1);
        }
        for(int i=0; i<m; i++){
            for(int j=n-1; j>=0; j--){
                while(!st.isEmpty() && heights[i][j]>=heights[i][st.peek()]){
                    prevGreater_hor[i][st.pop()] = j;
                }
                st.push(j);
            }
            st.clear();
        }

        
        int[][] nextGreater_ver = new int[m][n];
        for(int[] p : nextGreater_ver){
            Arrays.fill(p, m);
        }
        for(int j=0; j<n; j++){
            for(int i=0; i<m; i++){
                while(!st.isEmpty() && heights[st.peek()][j]<heights[i][j]){
                    nextGreater_ver[st.pop()][j] = i;
                }
                st.push(i);
            }
             st.clear();
        }

        st.clear();
        int[][] nextGreater_hor = new int[m][n];
        for(int[] p : nextGreater_hor){
            Arrays.fill(p, n);
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                while(!st.isEmpty() && heights[i][st.peek()]<heights[i][j]){
                    nextGreater_hor[i][st.pop()] = j;
                }
                st.push(j);
            }
             st.clear();
        }


        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.print(prevGreater_ver[i][j]+ " " );
            }
            System.out.println();
        }
//  System.out.println();
  System.out.println();


        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.print(prevGreater_hor[i][j]+ " " );
            }
            System.out.println();
        }

  System.out.println();

         for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.print(nextGreater_hor[i][j]+ " " );
            }
            System.out.println();
        }




        int[][] res = new int[m][n];
        for(int j=0; j<n; j++){
            for(int i=0; i<m; i++){

                if(prevGreater_ver[i][j]!=-1){
                    res[ prevGreater_ver[i][j] ][j] ++;
                }

                if(prevGreater_hor[i][j]!=-1){
                    res[i][ prevGreater_hor[i][j] ]++;
                }

                if(nextGreater_ver[i][j]!=m){
                    res[i][j]++;
                }

                if(nextGreater_hor[i][j]!=n){
                    res[i][j]++;
                }
            }
        }

        return res;








    }


    
}