// https://leetcode.com/problems/range-module

class RangeModule {

    TreeMap<Integer, Integer> map;

    public RangeModule() {
        map = new TreeMap<>();
    }
    
    public void addRange(int left, int right) {
        if (map.size() == 0) {
            map.put(left, right);
        } else {
            Map.Entry<Integer, Integer> entryLeft = map.floorEntry(left);
            Map.Entry<Integer, Integer> entryRight = map.floorEntry(right);

            if (entryLeft != null && entryLeft.getValue() >= left) {
                left = entryLeft.getKey();
            }
            if (entryRight != null && entryRight.getValue() > right) {
                right = entryRight.getValue();
            }

            map.subMap(left, right).clear();
            map.put(left, right);
        }
    }
    
    public boolean queryRange(int left, int right) {
        Map.Entry<Integer, Integer> entryLeft = map.floorEntry(left);
        if (entryLeft == null) {
            return false;
        } else {
            return entryLeft.getValue() >= right;
        }
    }
    
    public void removeRange(int left, int right) {
        Map.Entry<Integer, Integer> entryLeft = map.floorEntry(left);
        Map.Entry<Integer, Integer> entryRight = map.floorEntry(right);
        
        if (entryLeft != null && entryLeft.getValue() > left) {
            //update the key entryLeft.getKey();
            map.put(entryLeft.getKey(), left);
        }
        if (entryRight != null && entryRight.getValue() > right) {
            map.put(right, entryRight.getValue());
        }
        map.subMap(left, right).clear();
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */