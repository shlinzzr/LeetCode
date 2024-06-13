// https://leetcode.com/problems/peeking-iterator

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {

	List<Integer> list ;
	int idx =0;

	public PeekingIterator(Iterator<Integer> iter) {
	    // initialize any member here.
		list = new ArrayList<>();
	    while(iter.hasNext()){
			list.add(iter.next());
		}
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(list.isEmpty() || idx>=list.size())
			return null;

		else return list.get(idx);

	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		return list.get(idx++);
	    
	}
	
	@Override
	public boolean hasNext() {
		return idx<list.size();
	}
}