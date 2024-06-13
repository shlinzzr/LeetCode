// https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree

class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        
        int st=1, ed=20;
        int lv =-1;
        while(st<=ed){

            int mid = ed-(ed-st)/2;

            int left = (int) Math.pow(2, mid-1);
            int right = (int) Math.pow(2, mid)-1;

            // System.out.println(mid+ " " + left + " " + right + " st="+ st + " ed="+ed);

            if(left<= label && label<=right){
                lv = mid;
                break;
            }else if(label<left){
                ed = mid-1;
            }else if(label> right){
                st = mid+1;
            }
        }

        lv=st;

        // System.out.println(lv);


        List<Integer> res = new ArrayList<>();
        while(lv>0){
            res.add(0, label);
            int min = (int) Math.pow(2, lv-1);
            int max = (int) Math.pow(2, lv)-1;

            int revLabel = min + max-label;
            label = revLabel/2;
            lv--;
        }

        return res;



    }
}