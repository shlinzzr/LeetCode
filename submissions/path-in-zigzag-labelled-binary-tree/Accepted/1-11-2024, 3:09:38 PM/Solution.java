// https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree

class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new ArrayList<>();

        List<List<Integer>> list = new ArrayList<>();
        int rowLen=1;
        
       
        for(int i=1; i<=label; i++){
            list.add(new ArrayList<>());
            for(int j=0; j<rowLen; j++){
                list.get(list.size()-1).add(i++);
            }
            i--;
            rowLen*=2;
        }        

        
        for(int h =0; h<list.size(); h++){
            if(h%2==1){
                Collections.reverse(list.get(h));
            }
        }

        int idx = -1;
        List<Integer> od = new ArrayList<>();
        for(int i=0; i<list.size(); i++){
            for(int j=0; j<list.get(i).size(); j++){
                if(list.get(i).get(j)==label) idx = od.size();
                od.add(list.get(i).get(j));
            }
        }

        // System.out.println(od + " " + idx);

        while(idx>=0){
         
            res.add(0, od.get(idx));
            if(idx==0) break;
            idx = (idx-1)/2;
            
        }
        

        return res;
    }
}