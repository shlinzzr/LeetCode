// https://leetcode.com/problems/minimum-number-of-people-to-teach

class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        // n languages(1-idx), m users(1-idx)

        int m = languages.length;
        //先把那些user 會哪些語言build 出來
        Map<Integer, Set<Integer>> userMap = new HashMap<>(); // userId, Set<lanIdx>
        for(int i = 0; i < m; i++) {
            userMap.put(i+1, new HashSet<>());
            for(int l : languages[i]) {
                userMap.get(i + 1).add(l);
            }
        }

        int fLen = friendships.length;

        boolean[] alreadyCan = new boolean[fLen];
        // 確認哪些需要skip
        for(int j = 1; j <= n; j++) { // loop 1 to n languages, check all languages
            for(int i = 0; i < fLen; i++) {
                int u = friendships[i][0];
                int v = friendships[i][1];

                if(userMap.get(u).contains(j) && userMap.get(v).contains(j)) {
                    alreadyCan[i] = true;
                }
            }            
        }
        // 關鍵沒看到 ： You can choose "one" language and teach it, ... find min
        // loop all languages, 確認每個 languages 教學後 friendship 的 teachSet 為最小
        int minTeach = Integer.MAX_VALUE;
        for(int j = 1; j <= n; j++) {
            Set<Integer> teachSet = new HashSet<>();
            for(int i = 0; i < fLen; i++) {
                if(alreadyCan[i]) continue;

                int u = friendships[i][0];
                int v = friendships[i][1];
                if(!userMap.get(u).contains(j)) teachSet.add(u);
                if(!userMap.get(v).contains(j)) teachSet.add(v);
            }
            minTeach = Math.min(teachSet.size(), minTeach);
        }
        return minTeach;


        



    }
}