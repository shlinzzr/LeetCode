// https://leetcode.com/problems/maximum-number-of-ones

class Solution {
    public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
      
        
        int[][] count = new int[sideLength][sideLength];
        
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                count[i%sideLength][j%sideLength]++;
            }
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b)->(b-a)
        );
        
        for(int i=0; i<sideLength; i++){
            for(int j=0;j<sideLength;j++){
                pq.offer(count[i][j]);
            }
        }
        
        int res = 0;
        while(maxOnes-->0){
            res += pq.poll();
        }            
        
        return res;
        
        /*
        List<Integer> count = new ArrayList<>();
        
        for (int r = 0; r < sideLength; ++r) {
            for (int c = 0; c < sideLength; ++c) {
                count.add((1 + (width - 1 - c) / sideLength) * (1 + (height - 1 - r) / sideLength));   
            }
        }
        
        count.sort(Comparator.reverseOrder());
        int answer = 0;
        for (int i = 0; i < maxOnes; ++i) {
            answer += count.get(i);
        }
        
        return answer;*/
    }
}