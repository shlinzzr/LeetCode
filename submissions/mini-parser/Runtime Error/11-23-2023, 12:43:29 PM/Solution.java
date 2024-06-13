// https://leetcode.com/problems/mini-parser

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        int len = s.length();

        int lv1=0, op1=1;
        // int lv2=1, op2=1;
        
        NestedInteger tmp = new NestedInteger();
        
        Integer val = null;


        for(int i=0; i<len; i++){
            char ch = s.charAt(i);

            if(ch=='-'){
                op1=-1;

            }else if(ch==','){
                op1 = s.charAt(i+1)=='-'? -1 : 1;
                
            }
                
            else if(Character.isDigit(ch)){
                int num = ch-'0';
                while(i+1<len && Character.isDigit(s.charAt(i+1))){
                    num = num*10 + (s.charAt(++i)-'0');
                }
                if(val==null) val=0;
                val += num*op1;
                // res.setInteger(val);
                // lv2 = op2==1?lv2*num : lv2/num;
            }else if(ch=='['){
                int j = i+1;
                for(int cnt=0; i<len; i++){
                    if(s.charAt(i)=='[') cnt++;
                    if(s.charAt(i)==']') cnt--;
                    if(cnt==0) break;
                }
                NestedInteger ni = deserialize(s.substring(j, i));
                if(ni.isInteger()){
                    NestedInteger nn = new NestedInteger();
                    nn.add(new NestedInteger(ni.getInteger()));
                    tmp.add(nn);
                }
               

                    
                else 
                    tmp.add(ni);
            }
        }

        NestedInteger res = new NestedInteger();
        if(tmp.getList().size()==0 && val!=null){
            res.setInteger(val);
        }else if(val==null && tmp.getList().size()>0){
            return tmp.getList().get(0);
        }else {
            res.add(new NestedInteger(val));
            for(NestedInteger ni : tmp.getList()){
                res.add(ni);
            }
        }

        return res;

        
    }
}