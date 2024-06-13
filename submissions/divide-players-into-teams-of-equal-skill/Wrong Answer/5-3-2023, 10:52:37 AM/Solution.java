// https://leetcode.com/problems/divide-players-into-teams-of-equal-skill

class Solution {
    public long dividePlayers(int[] skill) {
        int len = skill.length;
        Arrays.sort(skill);
        
        int val = skill[0] + skill[len-1];
        int sum = skill[0] * skill[len-1];
        for(int i=1; i<len/2; i++){
            
            int cur = skill[i] + skill[len-1-i];
            
            if(cur!=val)
                return -1;
            
            sum += skill[i] * skill[len-1-i];
        }
        
        return sum;
        
    }
}