// https://leetcode.com/problems/compare-version-numbers

class Solution {
    public int compareVersion(String version1, String version2) {

        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int i=0;
        for(; i<Math.min(arr1.length, arr2.length); i++){

            String a = arr1[i];
            String b = arr2[i];
            // System.out.println(a +" " + b);

            int v1 = Integer.parseInt(a);
            int v2 = Integer.parseInt(b);
            if(v1==v2) continue;
            else if(v1<v2) return -1;
            else return 1;

        }

        while(i<arr1.length){
            String a = arr1[i++];
            int v1 = Integer.parseInt(a);
            if(v1>0) return 1; 
        }

        while(i<arr2.length){
            String b = arr2[i++];
            int v2 = Integer.parseInt(b);
            if(v2>0) return -1; 
        }

        return 0;
        
    }
}