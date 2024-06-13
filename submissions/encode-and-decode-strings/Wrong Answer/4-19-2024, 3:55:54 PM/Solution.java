// https://leetcode.com/problems/encode-and-decode-strings

public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb  = new StringBuilder();

        for(String s: strs){

            if(!sb.isEmpty()) sb.append("##,##");
            sb.append(s);
        }

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {

        return Arrays.asList(s.split("##,##"));
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));