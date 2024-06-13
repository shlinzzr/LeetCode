// https://leetcode.com/problems/snapshot-array

class SnapshotArray {

    int idx = 0;
    List<Integer> list;
    HashMap<Integer, List<Integer>> map;
    public SnapshotArray(int length) {
        list = new ArrayList<>();
        while(list.size()<length){
            list.add(0);
        }
        map = new HashMap<>();
    }
    
    public void set(int index, int val) {
        list.set(index, val);
    }
    
    public int snap() {
        map.put(idx++, new ArrayList<>(list));
        return idx-1;
    }
    
    public int get(int index, int snap_id) {
        return map.get(snap_id).get(index);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */