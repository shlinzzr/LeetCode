// https://leetcode.com/problems/snapshot-array

class SnapshotArray {
    int snapId = 0;
    TreeMap<Integer, Integer>[] arr; // arr[index] = <snap_id, val>
    
    public SnapshotArray(int length) {
        arr = new TreeMap[length];
        
        for (int i = 0; i < length; i++) {
            arr[i] = new TreeMap<Integer, Integer>();
            arr[i].put(0, 0);
        }
    }

    public void set(int index, int val) {
        arr[index].put(snapId, val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snapId) {
        return arr[index].floorEntry(snapId).getValue();
    }
}