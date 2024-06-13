// https://leetcode.com/problems/reconstruct-original-digits-from-english

class Solution {
    public String originalDigits(String s) {
        // "zeroonetwo"
        //  ^^^^^^^^^^
        // "owoztneoer"
        
        // zero
        // one
        // two
        // three
        // four
        // five
        // six
        // seven
        // eight
        // nine
        
        int[] arr = new int[10];
        
        for(char ch : s.toCharArray()){
            
            
            // v : 5 7 x
            // z : 0 
            // w : 2
            // u : 4
            // x : 6
            // g : 8
            // f : 4 5
            // s : 6 7
            // h : 3 8
            
            
            // t : 2, 3, 8
            // o : 0 1, 2
            // e : 0, 1, 3 5 7 8 9
            // r : 0 3 4
            // i : 5 6 8 9
            // n : 1 7 9
            
            if(ch=='z') arr[0]++; 
            if(ch=='w') arr[2]++;
            if(ch=='u') arr[4]++; 
            if(ch=='x') arr[6]++;
            if(ch=='g') arr[8]++;
            
            if(ch=='f') arr[5]++; //5-4
            if(ch=='h') arr[3]++; //3-8
            if(ch=='s') arr[7]++; // 7-6
            if(ch=='o') arr[1]++;
            if(ch=='n') arr[9]++;
          
            
        }
        
         arr[3] -= arr[8];
         arr[5] -= arr[4];
         arr[7] -= arr[6];
         arr[1] = arr[1] - arr[2] - arr[0] - arr[4];
         arr[9] = (arr[9] - arr[1] - arr[7])/2;
        
        
         String res = "";
            for(int i=0; i<10; i++){
                
                while(arr[i]>0){
                    arr[i]--;
                    res += String.valueOf(i);
                }
                
            }   
            
            return res;
        
        
        
    }
}