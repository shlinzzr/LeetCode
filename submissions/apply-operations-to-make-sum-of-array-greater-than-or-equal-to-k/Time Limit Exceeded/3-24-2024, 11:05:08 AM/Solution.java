// https://leetcode.com/problems/apply-operations-to-make-sum-of-array-greater-than-or-equal-to-k

class Solution {
    public int minOperations(int k) {
        
//         1 : 2/2 
//         2 : 3 , 4
//         3 : 4 : u8
//         4 : 5 16
            
//             1 + a *b>=k
//             // a*b > k
        
//         if(k==1) return 0; 
            
//         int a = (int) Math.sqrt(k) ;
//         a++;
        
//         if(a>=k) return a-1;
//         int b = k%a==0 ? k/a-1 : k/a;
        
//         return a+b;
            
        List<Integer> list = new ArrayList<>();
        list.add(1);
        
        Set<List<Integer>> seen = new HashSet<>();
        
        Queue<List<Integer>> q = new LinkedList<>();
        int step = 0;
        q.offer(list);
        while(!q.isEmpty()){
            
            int siz = q.size();
            while(siz-->0){
                
                List<Integer> p = q.poll();
                // System.out.println(step + " " + p);
                
                
                int sum = 0;
                for(int a : p){
                    sum+=a;
                }
                
                if(sum>=k) return step;
                
                
                for(int i=0; i<p.size(); i++){
                    int a = p.get(i);
                    
                    
                  List<Integer> next1 = new ArrayList<>(p);
                  next1.set(i , a+1);
                    
                  if(seen.add(next1)){
                      q.offer(next1);
                  }
                    
                    
                    List<Integer> next2 = new ArrayList<>(p);
                    next2.add(a);
                    
                    if(seen.add(next2)){
                        q.offer(next2);
                    }
                }
                    
                
                
            }
            
            
            step++;
        }
        
        return -1;
        
         
//         1 
            
//         a : +1
//         b : +n
            
//         => k
            
            
//         k/2
            
//         ex : 11
//         target 6:
        
    }
}