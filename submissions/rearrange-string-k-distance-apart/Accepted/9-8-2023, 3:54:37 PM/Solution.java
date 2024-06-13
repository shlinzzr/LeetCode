// https://leetcode.com/problems/rearrange-string-k-distance-apart

public class Solution {
    public String rearrangeString(String str, int k) {
        
        StringBuilder rearranged = new StringBuilder();
        //count frequency of each char
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        
        // //construct a max heap using self-defined comparator, which holds all Map entries, Java is quite verbose
        // Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
        //     public int compare(Map.Entry<Character, Integer> entry1, Map.Entry<Character, Integer> entry2) {
        //         return entry2.getValue() - entry1.getValue();
        //     }
        // });

        Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
            (a,b) -> b.getValue()-a.getValue()
        ); //char由多排到少


        
        Queue<Map.Entry<Character, Integer>> waitQueue = new LinkedList<>();
        maxHeap.addAll(map.entrySet());
        
        while (!maxHeap.isEmpty()) {
            
            Map.Entry<Character, Integer> current = maxHeap.poll();
            rearranged.append(current.getKey());
            current.setValue(current.getValue() - 1);
            waitQueue.offer(current);
            
            if (waitQueue.size() < k) { // intial k-1 chars, waitQueue not full yet
                continue;
            }
            // release from waitQueue if char is already k apart
            Map.Entry<Character, Integer> next = waitQueue.poll();
            //note that char with 0 count still needs to be placed in waitQueue as a place holder
            if (next.getValue() > 0) {
                maxHeap.offer(next);
            }
        }
        
        return rearranged.length() == str.length() ? rearranged.toString() : "";
    }
    
}