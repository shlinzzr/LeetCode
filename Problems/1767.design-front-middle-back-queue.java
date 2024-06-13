// https://leetcode.com/problems/design-front-middle-back-queue

class FrontMiddleBackQueue {

    ArrayList<Integer> list;
    public FrontMiddleBackQueue() {
        list = new ArrayList<>();
    }

    public void pushFront(int val) {
        if (list.isEmpty()) list.add(val);
        else list.add(0, val);
    }

    public void pushMiddle(int val) {
        if (list.isEmpty()) list.add(val);
        else list.add(list.size() / 2, val);
    }

    public void pushBack(int val) {
        list.add(val);
    }

    public int popFront() {
        return list.isEmpty() ? -1 : list.remove(0);
    }

    public int popMiddle() {
        return list.isEmpty() ? -1 : list.size() % 2 == 0 ? list.remove(list.size() / 2 - 1) : list.remove(list.size() / 2);
    }

    public int popBack() {
        return list.isEmpty() ? -1 : list.remove(list.size() - 1);
    }
}