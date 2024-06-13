// https://leetcode.com/problems/minimum-sum-of-values-by-dividing-array

class Solution {
    
    int[] parent;
    int[] weight;
    
    public int minimumValueSum(int[] nums, int[] andValues) {
        int len = nums.length;
        
        weight = new int[len];
        parent = new int[len];
        for(int i=0; i<len; i++){
            parent[i] = i;
            weight[i] = nums[i];
        }
        
        
        int res= 0 ;
        int m = andValues.length;
        int k=0;
        for(int i=0; i<len; i++){
            
            int j=i;
            
            while(k<m && j+1<len && weight[i]!=andValues[k]){
                union(i, j+1);
                j++;
            }
            
            if(k==m-1 && weight[i]!=andValues[k]) return -1;
            
            res+= nums[j];
            k++;
             System.out.println(i+ " "+ j + " " + res + " " + k);
            i=j;
           
            
        }
        
        if(k<m) return -1;
        return res;
    }
    
    
    private int find(int x){
        if(parent[x]!=x) parent[x] = find(parent[x]);
        return parent[x];
    }
    
    private void union(int a, int b){
        a = find(a);
        b = find(b);
        
        if(a==b) return;
        
        if(a<b){
            parent[b]=a;
            weight[a] = weight[a] & weight[b];
        }else{
            parent[a] = b;
            weight[b] = weight[a] & weight[b];
        }
    }
}