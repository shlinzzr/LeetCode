// https://leetcode.com/problems/trapping-rain-water-ii

class Solution {
    public int trapRainWater(int[][] heightMap) {
        int h = heightMap.length;
        int w = heightMap[0].length;


        int[][] mat = new int[h][w];
        for(int i=0; i<h; i++){

            // mat[i] = trap(heightMap[i]);

            // for(int j=0; j<w; j++){
            //     System.out.print(mat[i] + ",");
            // }

            int[] leftMax = new int[w];
            int[] rightMax = new int[w];

            for(int j=0; j<w; j++){
                leftMax[j] = j==0 ? heightMap[i][j] : Math.max(heightMap[i][j] , leftMax[j-1]);
            }

            for(int j=w-1; j>=0; j--){
                rightMax[j] = j==w-1 ? heightMap[i][j] : Math.max(heightMap[i][j], rightMax[j+1]);
            }

            for(int j=0; j<w; j++){
                mat[i][j] = Math.min(rightMax[j], leftMax[j]) - heightMap[i][j];
                System.out.print(mat[i][j]+ ",");
                if(mat[i][j]<0)
                    mat[i][j] = 0;
            }
              System.out.println();
        }

  System.out.println();
        int res = 0;

        int[][] tmp = new int[h][w];
        for(int j=0; j<w; j++){
            int[] topMax = new int[h];
            int[] downMax = new int[h];

            for(int i=0; i<h; i++){
                topMax[i] = i==0? heightMap[i][j] : Math.max(heightMap[i][j], topMax[i-1]);
            }

            for(int i=h-1; i>=0; i--){
                downMax[i] = i==h-1 ? heightMap[i][j] : Math.max(heightMap[i][j], downMax[i+1]);
            }

            for(int i=0; i<h; i++){
                tmp[i][j] =  Math.min(topMax[i], downMax[i]) - heightMap[i][j];
                // int tmp = Math.min(topMax[i], downMax[i]) - heightMap[i][j];
                // mat[i][j] = Math.min(mat[i][j], tmp);
                if(mat[i][j]<0)
                    mat[i][j]=0;
                else 
                    res += Math.min(mat[i][j], tmp[i][j]);
            }
        }

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                System.out.print(tmp[i][j] + " ,");
            }
            System.out.println();
        }

        return res;


    }


    /*
    [[12,13,1,12]
    ,[13,"4",13,12].  水位會流成8
    ,[13,8,10,12]
    ,[12,13,12,12]
    ,[13,13,13,13]]


    [ 0 0 0 0]
    [ 0 9 0 0]
    [ 0 5 2 0]
    [ 0 0 0 0]
    [ 0 0 0 0]

    */


//9+4+2//

     public int[] trap(int[] height) {
        int len = height.length;

        int[] res = new int[len];
        
        int[] left = new int[len];
        int[] right = new int[len];

        left[0] = height[0];
        for(int i=1; i<len; i++){
            left[i] = Math.max(left[i-1], height[i]);
        }

        right[len-1] = height[len-1];
        for(int i=len-2; i>=0; i--){
            right[i] = Math.max(right[i+1], height[i]);
        }


        // int res = 0;
        for(int i=0; i<len; i++){
            int val = Math.min(left[i], right[i])-height[i];
            // res += val;
            res[i] = val;

            System.out.print(val + ",");
        }

        return res;


    }
}