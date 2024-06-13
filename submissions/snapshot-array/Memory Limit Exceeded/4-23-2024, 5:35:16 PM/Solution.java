// https://leetcode.com/problems/snapshot-array

class SnapshotArray {

    int[] arr ;
    List<int[]> list;
    public SnapshotArray(int length) {
        arr = new int[length];
        list = new ArrayList<>();
    }
    
    public void set(int index, int val) {
        arr[index] = val;
    }
    
    public int snap() {
        
        list.add(Arrays.copyOf(arr, arr.length));
        return list.size()-1;
        
    }
    
    public int get(int index, int snap_id) {
        return list.get(snap_id)[index];
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */