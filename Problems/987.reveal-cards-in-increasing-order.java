// https://leetcode.com/problems/reveal-cards-in-increasing-order

class Solution {

    class Tuple{
        int val;
        int idx;
        public Tuple(int idx, int val){
            this.val=val;
            this.idx=idx;
        }
    }
    public int[] deckRevealedIncreasing(int[] deck) {
        int len = deck.length;

        Tuple[] arr = new Tuple[len];
        for(int i=0; i<len; i++){
            arr[i] = new Tuple(i, deck[i]);
        }   
        proc(arr);

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<len;i++){
            map.put(i, arr[i].idx);
        }

        Arrays.sort(deck);

        int[] res = new int[len];


        for(int i=0; i<len; i++){
            res[map.get(i)] = deck[i];
        }

        return res;

        


    }


    private void proc(Tuple[] arr){

        Queue<Tuple> q = new LinkedList<>();
        for(Tuple t : arr){
            q.offer(t);
        }
        int idx = 0 ;
        while(!q.isEmpty()){
            arr[idx++] = q.poll();

            if(!q.isEmpty())
                q.offer(q.poll());
        }
    }
}