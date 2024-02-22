// https://leetcode.com/problems/24-game

class Solution {
    //https://leetcode.com/problems/24-game/discuss/113972/Very-Easy-JAVA-DFS
    
    
    public boolean judgePoint24(int[] nums) {
        
        //convert to double list
        List<Double> list = new ArrayList<>();
        for (int i : nums) {
            list.add((double) i);
        }
        return dfs(list);
    }

    private boolean dfs(List<Double> list) {
        if (list.size() == 1) {
            if (Math.abs(list.get(0)- 24.0) < 0.001) {
                return true;
            }
            return false;
        }

        for(int i = 0; i < list.size(); i++) {
            for(int j = i + 1; j < list.size(); j++) {
                // loop 所有可能
                for (double d : generatePossibleResults(list.get(i), list.get(j))) {
                    List<Double> nextRound = new ArrayList<>();
                    
                    nextRound.add(d); 
                    for(int k = 0; k < list.size(); k++) {
                        if(k == j || k == i) continue; //j 跟 i 用過了: continue;
                        nextRound.add(list.get(k));
                    }
                    
                    if( dfs(nextRound) ) 
                        return true;
                }
            }
        }
        return false;

    }

    private List<Double> generatePossibleResults(double a, double b) {
        List<Double> res = new ArrayList<>();
        res.add(a + b);
        
        res.add(a - b);
        res.add(b - a);
        
        res.add(a * b);
        
        res.add(a / b);
        res.add(b / a);
        return res;
    }
}