// https://leetcode.com/problems/boats-to-save-people

class Solution {
    public int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);
        int len = people.length;

        int st = 0, ed=len-1;
        int cnt = 0;
        while(st<=ed){
            if(people[ed]+people[st]<=limit){
                
                st++;
                ed--;
            }else {
                ed--;
            }
            cnt++;
        }

        return cnt;

        
    }
}