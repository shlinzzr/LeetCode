// https://leetcode.com/problems/encode-and-decode-strings

public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s);
            sb.append("_");
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int idx =0;
        List<String> res = new ArrayList<>();
        while(idx<s.length() || idx==-1){
            res.add(s.substring(idx, s.indexOf("_")));
            s = s.substring(s.indexOf("_")+1, s.length());
        }
        
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));