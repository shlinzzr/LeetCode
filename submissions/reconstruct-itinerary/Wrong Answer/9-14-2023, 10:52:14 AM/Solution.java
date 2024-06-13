// https://leetcode.com/problems/reconstruct-itinerary

class Solution {


    int ticketsCnt=0;
    List<String> res = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {

        ticketsCnt = tickets.size();
       

        HashMap<String, List<String>> map = new HashMap<>();
        HashMap<String, Integer> deg = new HashMap<>();

        List<String> maxList = new ArrayList<>();
        int maxDeg = 0;

        

        for(List<String> list : tickets){

            String a = list.get(0);
            String b = list.get(1);
            map.putIfAbsent(a, new ArrayList<>());
            map.get(a).add(b);

            deg.put(a, deg.getOrDefault(a,0)+1);

            if(deg.get(a)>=maxDeg){
                if(deg.get(a)>maxDeg){
                    maxDeg = deg.get(a);
                    maxList = new ArrayList<>();
                }
                maxList.add(a);
            }

            deg.put(b, deg.getOrDefault(b,0)-1);
        } 

        for(String key : map.keySet()){
            Collections.sort(map.get(key));
        }

        for(String st : maxList){
            List<String> curr =new ArrayList<>();
            curr.add(st);
            dfs(map, st, new HashSet<>(), curr);
            if(!res.isEmpty())
                return res;
        }

        return res;

    }

    private void dfs(HashMap<String, List<String>> map, String st, HashSet<String> seen, List<String> curr ){



        if(curr.size()==ticketsCnt+1){
            res = new ArrayList<>(curr);
            return;
        }


       
        for(String next : map.getOrDefault(st, new ArrayList<>())){

            if(!seen.contains(st+"_"+next)){
                seen.add(st+"_"+next);
                curr.add(next);
                dfs(map, next, seen, curr);
                if(!res.isEmpty())
                    return;

                curr.remove(curr.size()-1);
                seen.remove(st+"_"+next);
            }
        }
    }
}