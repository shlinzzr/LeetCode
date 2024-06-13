// https://leetcode.com/problems/sequence-reconstruction

class Solution {
    Map<Integer, Set<Integer>> map;
    Map<Integer, Integer> indegree;
    
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        map = new HashMap<>();
        indegree = new HashMap<>();
        
        for(List<Integer> seq: sequences) {
            if(seq.size() == 1) {
                addNode(seq.get(0));
            } else {
                for(int i = 0; i < seq.size() - 1; i++) {
                    addNode(seq.get(i));
                    addNode(seq.get(i + 1));

                    // 加入子节点, 子节点增加一个入度
                    // [1,2] => 1 -> 2
                    // 1: [2]
                    int curr = seq.get(i);
                    int next = seq.get(i + 1);
                    if(map.get(curr).add(next)) {
                        indegree.put(next, indegree.get(next) + 1);
                    }
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int key : indegree.keySet()) {
            if(indegree.get(key) == 0){
                queue.offer(key);
            }
        }

        int index = 0;
        while(!queue.isEmpty()) {            
            // 如果只有唯一解, 那么queue的大小永远都是1
            if(queue.size() != 1) return false;
            
            int curr = queue.poll();
            if(curr != nums[index++]) return false;
            
            for(int next: map.get(curr)) {
                indegree.put(next, indegree.get(next) - 1);
                if(indegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }
        
        return index == nums.length;
    }
    
    private void addNode(int node) {
        if(!map.containsKey(node)) {
            map.put(node, new HashSet<>());
            indegree.put(node, 0);
        }
    }
}