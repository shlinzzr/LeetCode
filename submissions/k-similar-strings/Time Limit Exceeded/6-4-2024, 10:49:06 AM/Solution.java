// https://leetcode.com/problems/k-similar-strings

class Solution {
    public int kSimilarity(String s1, String s2) {

        int len1 = s1.length();
        char[] arr = new char[]{'a', 'b', 'c', 'd', 'e', 'f'};

        // 6 ^ 20


        Queue<String> q = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        seen.add(s1);
        q.offer(s1);
        int step = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){

                String p = q.poll();

                if(p.equals(s2)) return step;

                for(String next: getNext(p, s2)){
                    if(seen.add(next)==false) continue;
                    q.offer(next);
                }

            }

            step++;

        }
         return -1;
    }
   

    private List<String> getNext(String s1, String s2){

        int len = s1.length();
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        List<String> res = new ArrayList<>();

        for(int i=0; i<len; i++){
            if(s1.charAt(i)==s2.charAt(i)) continue;
            for(int j=i+1; j<len; j++){
                if(s1.charAt(j)!=s2.charAt(i)) continue;

                swap(arr1, i, j);
                res.add(new String(arr1));
                swap(arr1, i, j);
            }
        }
        return res;

    }

    private void swap(char[] arr, int i ,int j){
        char ch = arr[i];
        arr[i] = arr[j];
        arr[j] = ch;
    }
}