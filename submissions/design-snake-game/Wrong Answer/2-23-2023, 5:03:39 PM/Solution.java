// https://leetcode.com/problems/design-snake-game

class SnakeGame {
    
    int width;
    int height;
    int[][] food;

    int k=0;
    Point cur;
    LinkedList<Point> shake;
    
    public SnakeGame(int width, int height, int[][] food) {
        this.width=width;
        this.height=height;
        this.food=food;
        
        this.k=0;
        this.shake=new LinkedList<>();
        shake.addFirst(new Point(0,0));
    }
    
    public int move(String direction) {
        
        // the new head is based on the current head
        // the tail is removed, but can be returned back if food is found
        Point head = shake.getFirst();
        Point newHead = new Point(head.i, head.j);        
        Point tail = shake.removeLast(); 
        
        if(direction.equals("U")){
            newHead.i--;
        }else if(direction.equals("D")){
            newHead.i++;
        }else if(direction.equals("L")){
            newHead.j--;
        }else{
            newHead.j++;
        }
        
        if(newHead.i<0 || newHead.i==height || newHead.j<0 || newHead.j==width || shake.contains(newHead)) return -1;
        
        shake.addFirst(newHead);
        
        if(k<food.length && food[k][0]==newHead.i && food[k][1]==newHead.j){            
            shake.addLast(tail); // return tail back
            k++;
        }
        
        return k;
    }
    
    class Point{
        int i;
        int j;
        Point(int i, int j){
            this.i=i;
            this.j=j;
        }
        
        // public boolean equals(Object o) {} // todo: implement
        // public int hashCode() {} // todo: implement
    }
    
}