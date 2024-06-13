// https://leetcode.com/problems/robot-collisions

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        
        
        List<Robot> list = new ArrayList<>();

        int len = positions.length;
        for(int i=0; i<len; i++){
            Robot robot = new Robot(i, positions[i], healths[i], directions.charAt(i));
            list.add(robot);
        }

        Collections.sort(list, (a,b)-> a.pos-b.pos);

        Stack<Robot> st = new Stack<>();

        for(int i=0; i<list.size(); i++){

            Robot cur = list.get(i);

            if(cur.isRight){
                st.push(cur);

            }else{
                if(st.isEmpty()|| !st.peek().isRight){
                    st.push(cur);
                    continue;
                }else{

                    while(!st.isEmpty() && st.peek().isRight && st.peek().heal<cur.heal){
                        cur.heal--;
                        st.pop();
                    }

                    if(!st.isEmpty() && st.peek().isRight && st.peek().heal==cur.heal){
                        st.pop();
                        continue;
                    }

                    if(!st.isEmpty() && st.peek().isRight && cur.heal<st.peek().heal){
                        st.peek().heal--;
                        continue;
                    }

                    if(st.isEmpty()){
                        st.push(cur);
                    }

                }
            }

            System.out.println(st);
        }

        Robot[] arr = new Robot[len];

        for(Robot r : st){
            arr[r.idx] = r;
        }

        List<Integer> res = new ArrayList<>();
        
        for(Robot r : arr){
            if(r==null)
                continue;
            else
                res.add(r.heal);
        }

        return res;





    }

    class Robot {
        int idx;
        int pos;
        int heal;
        char dir;
        boolean isRight;
        public Robot(int idx, int pos, int heal, char dir){
            this.idx=idx;
            this.pos=pos;
            this.heal=heal;


            this.dir=dir;
            this.isRight = dir=='R';
        }
    }
}