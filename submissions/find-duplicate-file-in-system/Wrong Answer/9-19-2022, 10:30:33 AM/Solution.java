// https://leetcode.com/problems/find-duplicate-file-in-system

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        
        
        HashMap<String, List<String>> map = new HashMap<>();
        
        for( String path : paths){
            
            String[] fileArr = path.split(" ");
            String prefix = "";
            for(int i=0; i<fileArr.length; i++){
                if(i==0){
                    prefix = fileArr[0];
                    continue;
                }
                
                String content = fileArr[i].substring(fileArr[i].indexOf("("), fileArr[i].indexOf(")"));
                List<String> list = map.getOrDefault(content, new ArrayList<>());
                
                String filepath = prefix + "/" + fileArr[i].substring(0, fileArr[i].indexOf("("));
                list.add(filepath);
                map.put(content, list);
            }
        }
        
        
        for(Map.Entry<String, List<String>> en : map.entrySet()){
            String key = en.getKey();
            List<String> list = en.getValue();
            res.add(list);
        }
        
        return res;
        
    }
}