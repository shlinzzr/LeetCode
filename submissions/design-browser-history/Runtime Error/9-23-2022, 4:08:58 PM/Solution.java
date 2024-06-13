// https://leetcode.com/problems/design-browser-history

class BrowserHistory {

    String homepage = "";
    int curr = 0;
    List<String> list;
        
    
    public BrowserHistory(String homepage) {
        this.homepage = homepage;    
        list = new ArrayList<>();
        list.add(homepage);
    }
    
    public void visit(String url) {
        curr++;
        while(list.size()>curr){
            list.remove(list.size()-1);
        }
        list.add(url);
    }
    
    public String back(int steps) {
        
        if(curr-steps<0){
            curr=0;
        }else{
            curr = curr - steps;
        }
        return list.get(curr);
    }
    
    public String forward(int steps) {
        
        if(curr+steps > list.size()){
            curr = list.size()-1;
            
        }else{
            curr = curr+steps;
        }
        
        return list.get(curr);
                    
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */