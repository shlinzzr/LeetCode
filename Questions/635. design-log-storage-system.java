// https://leetcode.com/problems/design-log-storage-system

class LogSystem {
    Map<String, Integer> log;
    List<String> list;
    int[] poses;
     
    public LogSystem() {
        log = new TreeMap<>(); 
        list = Arrays.asList(new String[]{"Year", "Month", "Day", "Hour", "Minute", "Second"});
        poses = new int[]{4, 7, 10, 13, 16, 19};  //"2017 :01 :01 :23 :59 :59"
    }
    
    public void put(int id, String timestamp) {
        log.put(timestamp, id);
    }
    
    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> res = new LinkedList<>();
        int pos = poses[list.indexOf(gra)];
        
        for (String str : log.keySet()) {
            
            if (str.substring(0, pos).compareTo(s.substring(0, pos)) < 0) continue; 
            if (str.substring(0, pos).compareTo(e.substring(0, pos)) > 0) break;
            res.add(log.get(str));
        }
        return res; 
    }
}