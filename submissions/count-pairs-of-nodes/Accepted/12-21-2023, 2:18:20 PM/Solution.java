// https://leetcode.com/problems/count-pairs-of-nodes

class Solution {
	public int[] countPairs(int n, int[][] edges, int[] queries) {
		int[] indeg = new int[n+1];		

        //calculating the indegree for each node
		for(int i = 0 ; i < edges.length ; i++) {
			indeg[edges[i][0]]++;
			indeg[edges[i][1]]++;			
		}
		
		int[] duplicate = indeg.clone();
		
		Arrays.sort(duplicate);
		

        //Putting all the edges with its frequency in a hashmap
		HashMap<String,Integer> map = new HashMap<>(); // a#b, cnt
		for(int i = 0 ; i < edges.length ; i++) {
			int a = edges[i][0];
			int b = edges[i][1];
			if(a>b) {
				int temp = a;
				a=b;
				b=temp;
			}

            String key = a+"#"+b;
            map.put(key, map.getOrDefault(key, 0)+1);
		}

		int[] ans = new int[queries.length];
		for(int i=0; i<queries.length; i++) {
            int query = queries[i];
            
			int total = twosum(duplicate, query);  // sum of the incident pair > query
			Set<String> keys = map.keySet(); // a#b
			for(String edge : keys) {
				String[] vtxs = edge.split("#");
				int a = Integer.parseInt(vtxs[0]);//1st vertex of the edge 
				int b = Integer.parseInt(vtxs[1]);//2nd vertex of the edge
				
				if(indeg[a]+indeg[b]>query && indeg[a]+indeg[b]-map.get(edge)<=query)//if the pair qualified earlier and doesn't qualify when each edge is considered once
				{
					total--;	
				}
			}
			ans[i]=total;
		}
		
		return ans;
    }

     public int twosum(int[] arr,int query) {
		int left = 1;//beginning point
		int right = arr.length-1;//ending point
		int total = 0;
		while(left<right)
		{
			if(arr[left]+arr[right]>query)
			{
				total+=(right-left);
				right--;
			}
			else
			{
				left++;
			}			
		}
		return total; //pairs with sum of indegrees>query
	}
}