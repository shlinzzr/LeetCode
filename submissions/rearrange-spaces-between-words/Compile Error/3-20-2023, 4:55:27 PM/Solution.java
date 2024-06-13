// https://leetcode.com/problems/rearrange-spaces-between-words

class Solution {
    public String reorderSpaces(String text) {
        // get total spaces     --- n
        int n = 0;
        for (char c : text.toCharArray()) {
            if (c == ' ') n++;
        }    
        
        // split text, get total words --- m
        String[] words = text.trim().split("\\s+");
        int m = words.length;
            
        // n/(m - 1) spaces per interval  n%(m-1) spaces in end(could be 0)
        int midSpaces = 0, endSpaces = 0;
        if (m == 1) {
            endSpaces = n;
        } else {
            midSpaces = n / (m - 1);
            endSpaces = n % (m - 1);
        }
        
		StringBuilder sb = new StringBuilder();
		// sb append words and midSpaces.When m = 1 automatically skip this part
        for (int i = 0; i < m - 1; i++) {
            sb.append(words[i]);
            for (int j = 0; j < midSpaces; j++) 
                sb.append(" ");
        }
        
        // sb append last word and endSpaces 
        sb.append(words[m - 1]);
        for (int j = 0; j < endSpaces; j++) 
            sb.append(" ");
        
		return sb.toString();
    }
}
    }
}