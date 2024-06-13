// https://leetcode.com/problems/exam-room

class ExamRoom {
    
    int len;
    ArrayList<Integer> list = new ArrayList<>();
    public ExamRoom(int n) {
        len = n;
    }

    public int seat() {
        if (list.size() == 0) {
            list.add(0);
            return 0;
        }
        
        // max-min
        int d = Math.max(list.get(0), len-1-list.get(list.size() - 1));
        
        // 找最大間隔： 與每個間隔的一半做比較
        for (int i = 0; i < list.size()-1; ++i) 
            d = Math.max(d, (list.get(i+1) - list.get(i)) / 2);
        
        // 跟頭做比較        
        if (list.get(0) == d) {
            list.add(0, 0);
            return 0;
        }
        for (int i = 0; i < list.size()-1; ++i){
            if ((list.get(i+1) - list.get(i)) / 2 == d) {
                list.add(i+1, (list.get(i+1) + list.get(i)) / 2);
                return list.get(i+1);
            }
        }
            
        //都沒找到 放在最後
        list.add(len - 1);
        return len - 1;
    }

    public void leave(int p) {
        for (int i = 0; i < list.size(); ++i) if (list.get(i) == p) list.remove(i);
    }
}