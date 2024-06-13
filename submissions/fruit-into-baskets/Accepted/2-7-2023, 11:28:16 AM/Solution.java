// https://leetcode.com/problems/fruit-into-baskets

class Solution {
    public int totalFruit(int[] tree) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        int res = 0, st = 0;
        for (int ed = 0; ed < tree.length; ed++) {
            count.put(tree[ed], count.getOrDefault(tree[ed], 0) + 1);
            while (count.size() > 2) {
                count.put(tree[st], count.get(tree[st]) - 1);
                if (count.get(tree[st]) == 0) count.remove(tree[st]);
                st++;
            }
            res = Math.max(res, ed - st + 1);
        }
        return res;
    }
}