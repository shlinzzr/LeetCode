// https://leetcode.com/problems/take-k-of-each-character-from-left-and-right

class Solution {
    public int takeCharacters(String s, int k) {
        
        int len = s.length();
        
        if(len<3*k)
            return -1;
        System.out.println(len);
        
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<len; i++){
            if(s.charAt(i)=='a'){
                System.out.println(i);
                list.add(i);
            }
                
            
        }
        
        int min = len;
        min = Math.min(min , list.get(k-1)+1);
        min = Math.min(min , len - list.get(list.size()-k));
        // System.out.println("ff="+(list.get(k-1)+1));
        // System.out.println("bb="+ (len - list.get(list.size()-k)));
        
        
        for(int i=0; i<k; i++){
            
            int fidx = list.get(i)+1;
            int bidx = len - list.get(list.size()-(k-(i+1)));
            // System.out.println(fidx + " " + bidx);
            int total = fidx + bidx;
                                                   
            min = Math.min(min, total);
            
            return min;
            // System.out.println(total);
            
            
        }
        
        return -1;
        
        
        
        
        
        
    }
    
    private boolean ok(int[] arr, int k){
        
        for(int a: arr){
            if(a<k)
                return false;
        }
        return true;
        
    }
}