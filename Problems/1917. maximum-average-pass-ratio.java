// https://leetcode.com/problems/maximum-average-pass-ratio

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int len = classes.length;

        PriorityQueue<double[]> pq = new PriorityQueue<double[]>(
            new Comparator<double[]>(){
                public int compare(double[] a, double[] b ){
                     double diffa = (a[0]+1)/(a[1]+1) - a[0]/a[1];
                     double diffb = (b[0]+1)/(b[1]+1) - b[0]/b[1];

                     if(diffa==diffb) return 0;
                     return diffa>diffb ? -1 : 1;
                }
            }
        );

        for(int i=0; i<len; i++){
            pq.offer(new double[]{Double.valueOf(classes[i][0]), Double.valueOf(classes[i][1])});
        }

        int allpass = 0;
        while(!pq.isEmpty() && extraStudents>0){

            double[] p = pq.poll();

            p[0]+=1;
            p[1]+=1;
            pq.offer(p);
            extraStudents--;
        }


        double res = 0;

        for(double[] p : pq){
            
            res+= p[0]/p[1];
        }



        return res/Double.valueOf(len);


    }
}