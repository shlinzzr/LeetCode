// https://leetcode.com/problems/find-beautiful-indices-in-the-given-array-ii

class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        
        TreeSet<Integer> seta = KMP(s, a);
        TreeSet<Integer> setb = KMP(s, b);
        
        System.out.println(seta);
        System.out.println(setb);
        
        
        List<Integer> res = new ArrayList<>();
        for(int i : seta){
            if(setb.ceiling(i-k)!=null && setb.ceiling(i-k)<=i+k){
                res.add(i);
            }
        }
        
        return res;
        
    }
    
    public TreeSet<Integer> KMP(String haystack, String needle) {
        TreeSet<Integer> list = new TreeSet<>();
       
        int m = haystack.length();
        int n = needle.length();
        if (n == 0) return list;

        int[] next = getNext(needle);

        for (int j=0, i=0; i < m; i++){
            while (j > 0 && j<n && haystack.charAt(i) != needle.charAt(j)){
                j = next[j-1]; // fallback
            }
            if (haystack.charAt(i) == needle.charAt(j)){
                j++;
            }
            if ( j==n ){
                list.add(i-n+1);
                j=next[j-1];
            }
        }
       
        return list;
    }


    private int[] getNext(String needle){
        int n = needle.length();
        int[] next = new int[n];
        for(int j=0, i=1; i<n; i++){

            while(j>0 && needle.charAt(j)!=needle.charAt(i)){
                j = next[j-1];
            }

            if(needle.charAt(i)==needle.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
    /*
    "lrtsi"
"lrts"
"i"
3*/
    
}