// https://leetcode.com/problems/design-a-text-editor

class TextEditor {
    StringBuilder sb;
    int idx=0;
    
    public TextEditor() {
        sb = new StringBuilder();
    }
    
    public void addText(String text) {
        sb.insert(idx, text);
        idx += text.length();
    }
    
    public int deleteText(int k) {
        int tmp = idx;
        idx -= k;
        if(idx<0) idx=0;
        sb.delete(idx, tmp);
        return tmp-idx;
    }
    
    public String cursorLeft(int k) {
        idx-=k;
        if(idx<0) idx = 0;
        if(idx<10) return sb.substring(0, idx);
        return sb.substring(idx-10, idx);
    }
    
    public String cursorRight(int k) {
        idx+=k;
        if(idx>sb.length()) idx = sb.length();
        if(idx<10) return sb.substring(0, idx);
        return sb.substring(idx-10, idx);
    }
}