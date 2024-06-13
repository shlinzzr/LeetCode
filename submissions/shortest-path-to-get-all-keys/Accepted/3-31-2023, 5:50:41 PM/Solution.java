// https://leetcode.com/problems/shortest-path-to-get-all-keys

class Solution {
    public int shortestPathAllKeys(String[] grid) {

        int n = grid.length, m = grid[0].length(), start[] = new int[3], KEYS = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') { start[1] = i; start[2] = j; }
                else if ('a' <= c && c <= 'f') KEYS |= (1 << (c-'a'));                                    
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);

        Set<String> visited = new HashSet<>();
        visited.add(start[0] + " " + start[1] + " " + start[2]);

        int moves = 0, Ds[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] A = queue.poll();
                for (int[] D : Ds) {
                    int i = A[1] + D[0], j = A[2] + D[1], keys = A[0];
                    if (i < 0 || i >= n || j < 0 || j >= m) continue;                   // out of grid
                    char c = grid[i].charAt(j);

                    if (c == '#') continue;                                             // wall
                    if ('A' <= c && c <= 'F' && ((A[0] >> (c-'A')) & 1) == 0) continue; // no key
                    if ('a' <= c && c <= 'f') keys = A[0] | (1 << (c-'a'));             // update key
                    if (visited.contains(keys + " " + i + " " + j)) continue;           // visited
                    if (keys == KEYS) return moves+1;                                   // found !!!
                    visited.add(keys + " " + i + " " + j);
                    queue.offer(new int[] {keys, i, j});
                }
            }
            moves++;
        }

        return -1; // not found
    }
}