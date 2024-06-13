// https://leetcode.com/problems/naming-a-company

class Solution {
    public long distinctNames(String[] ideas) {
        HashSet<String> set = new HashSet<>();
        
        int len = ideas.length;
        
        for(int i=0; i<len; i++){
            set.add(ideas[i]);
        }
        
        
        for(int i=0; i<len-1; i++){
            for(int j=i+1; j<len; j++){
                set.add(ideas[i]+" " + ideas[j]);
                set.add(ideas[j]+" " + ideas[i]);
            }
        }
        
        int cnt=0;
        for(int i=0; i<len-1; i++){
            for(int j=i+1; j<len; j++){
                
                if(ideas[i].substring(1, ideas[i].length()).equals(ideas[j].substring(1, ideas[j].length()))
                || ideas[i].substring(0, 1).equals(ideas[j].substring(0, 1))){
                    continue;
                }
                
                char[] arr1 = ideas[i].toCharArray();
                char[] arr2 = ideas[j].toCharArray();
                
                char tmp = arr1[0];
                arr1[0]=arr2[0];
                arr2[0]=tmp;
                
                if(set.contains(String.valueOf(arr1)) ||set.contains(String.valueOf(arr2)) )
                    continue;
                
                
                String normal  = String.valueOf(arr1)+" " + String.valueOf(arr2);
                String reverse = String.valueOf(arr2)+" " + String.valueOf(arr1);
                
                // System.out.println(normal +" " + reverse);
                
                
                if(!set.contains(normal)){
                    cnt++;
                    set.add(normal);
                }
                if(!set.contains(reverse)){
                    cnt++;
                    set.add(reverse);
                }
                
            }
        }
        
        return cnt;
        
    }
}