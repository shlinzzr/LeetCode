// https://leetcode.com/problems/strobogrammatic-number-ii

class Solution {
    List<String> result;

    public List<String> findStrobogrammatic(int n) {
        result = new ArrayList<String>();
        char[] arr = new char[n];
        find(arr, 0 , n-1);
        return result;
         
    }

    void find(char[] arr, int l, int r) {
        if(l > r){
            result.add(new String(arr));
            return;
        }

        if(l == r){
            arr[l] = '0';
            result.add(new String(arr));
            arr[l] = '1';
            result.add(new String(arr));
            arr[l] = '8';
            result.add(new String(arr));
            return;
        }

        if (l != 0) {
            arr[l] = '0';
            arr[r] = '0';
            find(arr, l + 1, r - 1);
        }
        arr[l] = '1';
        arr[r] = '1';
        find(arr, l + 1, r - 1);

        arr[l] = '8';
        arr[r] = '8';
        find(arr, l + 1, r - 1);

        arr[l] = '6';
        arr[r] = '9';
        find(arr, l + 1, r - 1);

        arr[l] = '9';
        arr[r] = '6';
        find(arr, l + 1, r - 1);
         
    }

}