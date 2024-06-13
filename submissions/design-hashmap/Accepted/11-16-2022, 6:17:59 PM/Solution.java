// https://leetcode.com/problems/design-hashmap

class MyHashMap
{
	ListNode[] nodes = new ListNode[10000];
    // create 10000 buckets, and the first listNode in bucket is null;

    private static class ListNode  //listNode int bucket =>  has key, value and "next"
	{
		int key, val;
		ListNode next;

		ListNode(int key, int val)
		{
			this.key = key;
			this.val = val;
		}
	}
    
    
	public int get(int key)
	{
		int index = getIndex(key);  // use hash
		ListNode prev = findElement(index, key); // the tricky part is to find the "prev" node
		return prev.next == null ? -1 : prev.next.val;
	}
	
    private int getIndex(int key)
	{	
		return Integer.hashCode(key) % nodes.length;
	}
    
    
	public void put(int key, int value)
	{
		int index = getIndex(key);
		ListNode prev = findElement(index, key);
		
		if (prev.next == null)
			prev.next = new ListNode(key, value);
		else 
			prev.next.val = value;
	}

	
	

	private ListNode findElement(int index, int key)
	{
		if(nodes[index] == null)
			return nodes[index] = new ListNode(-1, -1); // initialize the first null ListNode when findElement checking idx;
        
        ListNode prev = nodes[index];
		
		while(prev.next != null && prev.next.key != key)
		{
			prev = prev.next;
		}
		return prev;
	}
    
    public void remove(int key)
	{
		int index = getIndex(key);
        ListNode prev = findElement(index, key);
			
        if(prev.next != null)
		    prev.next = prev.next.next;
	}

	
}