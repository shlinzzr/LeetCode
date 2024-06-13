// https://leetcode.com/problems/sentence-similarity-ii

class Solution {
    Map<String, String> map;
    public boolean areSentencesSimilarTwo(String[] sen1, String[] sen2, List<List<String>> sim) {
        
        if(sen1.length!=sen2.length) return false;


        map = new HashMap<>();
        for(String w: sen1){
            map.put(w, w);
        }
        for(String w: sen2){
            map.put(w, w);
        }
        for(List<String> list : sim){
            String a = list.get(0);
            String b = list.get(1);
            map.put(a,a);
            map.put(b,b);
        }



        for(List<String> list : sim){
            String a = find(list.get(0));
            String b = find(list.get(1));

            if(a.equals(b)) continue;

            if(a.compareTo(b)>0){
                map.put(a, b);
            }else{
                map.put(b, a);
            }
        }
        // System.out.println( find("good"));
        // System.out.println( find("fine"));
        // System.out.println( find("great"));
        
        for(int i=0; i<sen1.length; i++){
            System.out.println(find(sen1[i]) + " " + find(sen2[i]));
            if(!find(sen1[i]).equals(find(sen2[i]))) return false;
        }


        return true;



        
    }

    private String find(String x){
        if(!x.equals(map.get(x))) map.put(x, find(map.get(x)));
        return map.get(x);
    }
}