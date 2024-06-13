// https://leetcode.com/problems/product-of-two-run-length-encoded-arrays

class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<Integer> list1 = new ArrayList<>();
        for(int[] en : encoded1){
            for(int i=0; i<en[1]; i++){
                list1.add(en[0]);
            }
        }
        
        List<Integer> list2 = new ArrayList<>();
        for(int[] en : encoded2){
            for(int i=0; i<en[1]; i++){
                list2.add(en[0]);
            }
        }
        
        
        List<Integer> list3 = new ArrayList<>();
        for(int i=0; i<list1.size(); i++){
            list3.add(list1.get(i) * list2.get(i));
        }
        
        
        List<List<Integer>> res = new ArrayList<>();
        int i=0;
        while(i<list3.size()){
            
            int n = list3.get(i);
            int cnt = 1;
            while(i+1<list3.size() && list3.get(i+1)==n){
                cnt++;
                i++;
            }
            
            List<Integer> list = new ArrayList<>();
            list.add(n);
            list.add(cnt);
            res.add(list);
            i++;
        }
        
        return res;
        
    }
}