// https://leetcode.com/problems/encode-and-decode-strings

public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<strs.size(); i++){
            String s = strs.get(i);
            if(i!=0)
                sb.append("##_##");
            sb.append(s);
            
            
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        
        // String[] arr = s.split("##_##");   // "##_##" -> []
        String[] arr = s.split("##_##", -1);  // "##_##" -> ["", ""]
        return Arrays.asList(arr);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));