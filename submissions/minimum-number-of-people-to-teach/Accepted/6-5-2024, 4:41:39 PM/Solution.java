// https://leetcode.com/problems/minimum-number-of-people-to-teach

class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        // n languages(1-idx), m users(1-idx)

        int m = languages.length;
        //先把那些user 會哪些語言build 出來
        Map<Integer, Set<Integer>> userMap = new HashMap<>(); // userId, Set<lanIdx>
        for(int i = 1; i <= m; i++) {
            userMap.put(i, new HashSet<>());
            for(int l : languages[i-1]) {
                userMap.get(i).add(l);
            }
        }

        int fLen = friendships.length;

        boolean[] canTalk = new boolean[fLen];
        // 確認哪些需要skip
        for(int lan = 1; lan <= n; lan++) { // loop 1 to n languages, check all languages
            for(int i = 0; i < fLen; i++) {
                int u = friendships[i][0];
                int v = friendships[i][1];

                if(userMap.get(u).contains(lan) && userMap.get(v).contains(lan)) {
                    canTalk[i] = true;
                }
            }            
        }
        // 關鍵沒看到 ： You can choose "one" language and teach it, ... find min
        // loop all languages, 確認每個 languages 教學後 friendship 的 teachSet 為最小
        int minTeach = Integer.MAX_VALUE;
        for(int lan = 1; lan <= n; lan++) {  // loop all language
            Set<Integer> teachSet = new HashSet<>();
            for(int i = 0; i < fLen; i++) {
                if(canTalk[i]) continue;

                int u = friendships[i][0];
                int v = friendships[i][1];
                if(!userMap.get(u).contains(lan)) teachSet.add(u);
                if(!userMap.get(v).contains(lan)) teachSet.add(v);
            }
            minTeach = Math.min(teachSet.size(), minTeach);
        }
        return minTeach;

    }
}