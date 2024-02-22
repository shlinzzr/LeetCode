// https://leetcode.com/problems/count-complete-substrings


public class Solution {

    ///https://leetcode.com/problems/count-complete-substrings/solutions/4355938/c-java-python-javascript-maps-explained/
    public int countCompleteSubstrings(String word, int k) {
        int count = 0;
        int uniqueChars = new HashSet<>(Arrays.asList(word.split(""))).size();

        // System.out.println(Arrays.asList("word".split("")));
        // System.out.println(Arrays.asList("word".toCharArray()));
        for (int subLen = 1; subLen <= uniqueChars; ++subLen) {
            int windowSize = subLen * k;

            Map<Character, Integer> charFreq = new HashMap<>();
            int start = 0;
            int end = start + windowSize - 1;
            // [start, end]
            for (int i = start; i <= Math.min(end, word.length() - 1); ++i) {
                charFreq.put(word.charAt(i), charFreq.getOrDefault(word.charAt(i), 0) + 1);
            }

            while (end < word.length()) {
                if (hasEqualFrequency(charFreq, k) && hasAdjacentDifferenceAtMostTwo(word, start, end)) {
                    count++;
                }

                charFreq.put(word.charAt(start), charFreq.get(word.charAt(start)) - 1);
                start++;
                end++;

                if (end < word.length()) {
                    charFreq.put(word.charAt(end), charFreq.getOrDefault(word.charAt(end), 0) + 1);
                }
            }
        }

        return count;
    }

    private boolean hasEqualFrequency(Map<Character, Integer> charFreq, int k) {
        for (int value : charFreq.values()) {
            if (value != k && value != 0) {
                return false;
            }
        }
        return true;
    }

    private boolean hasAdjacentDifferenceAtMostTwo(String word, int start, int end) {
        for (int i = start + 1; i <= end; ++i) {
            if (Math.abs(word.charAt(i) - word.charAt(i - 1)) > 2) {
                return false;
            }
        }
        return true;
    }
}

