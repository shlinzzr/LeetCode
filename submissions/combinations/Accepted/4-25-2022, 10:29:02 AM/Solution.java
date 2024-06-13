// https://leetcode.com/problems/combinations




// class Solution {
//     public List<List<Integer>> combine(int n, int k) {
//         List<List<Integer>> res = new ArrayList<>();
        
//         List<Integer> postfix =  new ArrayList<>();
//         for(int i=1; i<=n; i++){
//             postfix.add(i);
//         }
        
//         permute(new ArrayList<Integer>(), postfix, res, n , k);
        
//         return res;
//     }
    
//     private void permute(List<Integer> prefix, List<Integer> postfix, List<List<Integer>> res, int n, int k){
        
//         System.out.println(prefix);
        
//         if(prefix.size()==k){
//             res.add(prefix);
//             return;
//         }
//          for(int p=0; p<postfix.size();  p++){
             
//              // ArrayList<Integer> newPrefix = new ArrayList<>(prefix);
//              // ArrayList<Integer> postfix = new ArrayList<>(postfix);
             
//              int max = 0;
//              for(int pre : prefix){
//                  if(pre > max)
//                      max = pre;
//              }
             
//              if(max < postfix.get(p)){
//                  prefix.add( postfix.get(p) );
//                  postfix.remove( postfix.get(p) );
//                  permute(prefix, postfix, res, n, k);
//              }
            
//          }
//     }
    
//  }   
    
//     backtracking sol
     // public class Solution {
//     public static List<List<Integer>> combine(int n, int k) {
// 		List<List<Integer>> ans = new ArrayList<List<Integer>>();
// 		combine(ans, new ArrayList<Integer>(), 1, n, k);
// 		return ans;
// 	}
// 	public static void combine(List<List<Integer>> ans, List<Integer> prefix, int start, int n, int k) {
		
//         System.out.println(prefix);
//         if(k==0) {
// 			ans.add(new ArrayList<Integer>(prefix));
// 			return;
// 		}
// 		for(int i=start;i<=n;i++) {
// 			prefix.add(i);
// 			combine(ans, prefix, i+1, n, k-1);
// 			prefix.remove(prefix.size()-1);
// 		}
// 	}
// }


// DP sol 
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k > n || k < 0) {
            return result;
        }
        if (k == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        result = combine(n - 1, k - 1);
        for (List<Integer> list : result) {
            list.add(n);
        }
        result.addAll(combine(n - 1, k));
        return result;
    }
}