// https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int len = A.length;
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();
        
        int[] res =  new int[len];
        
        for(int i=0; i<len; i++){
            setA.add(A[i]);
            setB.add(B[i]);
            
            Set<Integer> setC = new HashSet<Integer>(setA); // use the copy constructor
            setC.retainAll(setB);
            res[i]=setC.size();
        }
        return res;
    }
}