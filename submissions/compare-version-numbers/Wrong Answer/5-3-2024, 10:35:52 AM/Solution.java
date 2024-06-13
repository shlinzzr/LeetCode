// https://leetcode.com/problems/compare-version-numbers

class Solution {
    public int compareVersion(String version1, String version2) {

        String[] arr1 = version1.split(".");
        String[] arr2 = version2.split(".");

        for(int i=0; i<Math.min(arr1.length, arr2.length); i++){

            String a = arr1[i];
            String b = arr2[i];

            int v1 = Integer.parseInt(a);
            int v2 = Integer.parseInt(b);
            if(v1==v2) continue;
            else if(v1<v2) return -1;
            else return 1;

        }

        return 0;
        
    }
}