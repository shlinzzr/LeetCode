// https://leetcode.com/problems/exam-room

class ExamRoom {

    TreeSet<Integer> s = new TreeSet<>();
    int N;

    public ExamRoom(int N) {
        this.N = N;
    }

    public int seat() {
	    //When no student
        if (s.isEmpty()) {
            s.add(0);
            return 0;
        }
        
	    //When One student
        if (s.size() == 1) {
            int num = s.first();
            if (num < (N / 2)) {
                s.add(N - 1);
                return N - 1;
            } else {
                s.add(0);
                return 0;
            }
        }
        
        List<Integer> list = new ArrayList<>(s);
        
	    //When more than one student
        int dist = -1;
        int position = -1;
        int left = list.get(0);
        
	    //check the distance between 0 and first student
        if (left > 0) {
            position = 0;
            dist = left;
        }
        int right = -1;
        
	    //Check the distance between adjacent indices,(already sorted)
        for(int i=1; i<list.size(); i++){
            right = list.get(i);
            if ((right - left) / 2 > dist) {
                dist = (right - left) / 2;
                position = left + dist;
            }
            left = right;
        }
        
	    //check the distance between last student and (N - 1)
        if ((N - 1) - left > dist) {
            position = N - 1;
        }
        s.add(position);
        return position;
    }

    public void leave(int p) {
        s.remove(p);
    }
}