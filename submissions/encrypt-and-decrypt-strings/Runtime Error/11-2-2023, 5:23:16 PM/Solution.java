// https://leetcode.com/problems/encrypt-and-decrypt-strings

class Encrypter {
    HashMap<Character, String> map ;
    String[] dictionary;

    HashMap<String, Integer> enc;

    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        map = new HashMap<>();
        for(int i=0; i<keys.length; i++){
            map.put(keys[i], values[i]);
        }

        enc = new HashMap<>();
        for(String d : dictionary){
            String s =  encrypt(d);
            enc.put(s, enc.getOrDefault(s, 0)+1);
        }

        this.dictionary = dictionary;
    }
    
    public String encrypt(String word1) {

        StringBuilder sb = new StringBuilder();
        for(char ch : word1.toCharArray()){
            if(map.containsKey(ch)){
                sb.append(map.get(ch));
            }else
                sb.append(ch);
        }
        return sb.toString();
        
    }
    
    public int decrypt(String word2) {
        return enc.get(word2);
    }
}

/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */