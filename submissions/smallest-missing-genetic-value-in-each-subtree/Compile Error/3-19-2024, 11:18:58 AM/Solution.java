// https://leetcode.com/problems/smallest-missing-genetic-value-in-each-subtree

class Solution {
    List<Set<Integer>> setList = new ArrayList<>();
    int[] setIdx = new int[100005];
    int[] rets;
    List<Integer>[] children = new ArrayList[100005];

    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {

        int len = parents.length;
        rets = new int[len];
        // buildgraph

        for (int i=1; i<len; i++)   {
            if(children[parents[i]]==null)
                children[parents[i]] = new ArrayList<>();

            children[parents[i]].add(i);
        }     

        dfs(0, nums);
        return rets;
    }

    private void dfs(int node, int[] nums){
        if (children[node]==null || children[node].isEmpty())
        {
            setIdx[node] = setList.size();
            setList.add( new HashSet<>(Arrays.asList(nums[node])));
            rets[node] = nums[node]==1?2:1;     
            // cout<<node<<":"<<setIdx[node]<<" "<<setList[setIdx[node]].size()<<endl;       
        }
        else
        {   
            for (int child: children[node])
                dfs(child, nums);

            int maxSetSize = 0;
            int maxSetIdx;
            for (int child: children[node])
            {
                if (setList.get(setIdx[child]).size() > maxSetSize)
                {
                    maxSetSize = setList.get(setIdx[child]).size();
                    maxSetIdx = setIdx[child];
                }
            }

            for (int child: children[node])
            {
                if (setIdx[child] == maxSetIdx) continue;
                for (int x: setList.get(setIdx[child]))
                    setList.get(maxSetIdx).add(x);
            }
            setList.get(maxSetIdx).add(nums[node]);
            setIdx[node] = maxSetIdx;

            int maxMissing = 0;            
            for (int child: children[node])            
                maxMissing = Math.max(maxMissing, rets[child]);
            int x = maxMissing;
            while (setList.get(maxSetIdx).contains(x))
                x++;
            rets[node] = x;
        }

    }
}