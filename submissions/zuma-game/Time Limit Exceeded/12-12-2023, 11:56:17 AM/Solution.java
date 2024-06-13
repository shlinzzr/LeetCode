// https://leetcode.com/problems/zuma-game

	class Solution {
		int MAX = 6;
		int[] color = new int[]{'R' - 'A', 'Y' - 'A', 'B' - 'A', 'G' - 'A', 'W' - 'A'};
		public int findMinStep(String board, String hand) {
			int[] h = new int[26];
			for(char i: hand.toCharArray())
				h[i - 'A']++;
			int ans = dfs(board + "#", h, new HashMap<String, Integer>());
			return ans == MAX ? -1 : ans;
		}

		public int dfs(String b, int[] h, Map<String, Integer> map) {
			b = remove(b);
			//System.out.println(b);
			if(b.equals("#")) return 0;
			if(map.containsKey(b))
				return map.get(b);
			int ans = MAX;
			for(int j = 0; j < b.length(); j++) {
				for(int k: color) {
					if(h[k] > 0) {
						h[k]--;
						ans = Math.min(ans, 1 + dfs(new StringBuffer(b.substring(0, j))
													.append((char)(k + 'A'))
													.append(b.substring(j)).toString(), h, map));
						h[k]++;
					}
				}
			}
			map.put(b, ans);
			return ans;
		}

		public String remove(String b) {
			for(int i = 0, j = 0; j <= b.length(); j++) {
				if(j < b.length() && b.charAt(i) == b.charAt(j)) continue;
				if(j - i >= 3) 
					return remove(b.substring(0, i) + b.substring(j));
				i = j;
			}
			return b;
		}
	}