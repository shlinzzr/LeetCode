// https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital

class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> rmNode = new HashSet<>();
        for(int[] r : roads){
            List<Integer> list = map.getOrDefault(r[0], new ArrayList<>());
            list.add(r[1]);
            map.put(r[0], list);
            
            list = map.getOrDefault(r[1], new ArrayList<>());
            list.add(r[0]);
            map.put(r[1], list);
        }
        
        boolean[] visited = new boolean[roads.length+1];
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0]= true;
        
        int res=0, step=0, s=seats;
        
        boolean multiCar =false;
        while(!queue.isEmpty()){
            
            int siz= queue.size();
            
            for(int i=0; i<siz; i++){
                int node = queue.poll();
                
                List<Integer> nebor = map.getOrDefault(node, new ArrayList<>());
                for(int neb : nebor){
                    if(visited[neb]==false){
                        visited[neb]=true;
                        queue.offer(neb);    
                        res++;
                    }
                }
            }
            
            if(step%seats==0){
                res+=queue.size()*step;
                if(queue.size()>0 && step!=0) multiCar=true;
                // System.out.println("siz= "+queue.size() + " step="+step + " res=" + res);
            }
            
            if(queue.size()==0 && step%seats!=0 && multiCar){
                res-=(seats-step%seats);
            }
            
            
            
            // System.out.println(res);
            
            
            
            step++;
            // res+=step;
        }
        
        return res;
        
    }
}