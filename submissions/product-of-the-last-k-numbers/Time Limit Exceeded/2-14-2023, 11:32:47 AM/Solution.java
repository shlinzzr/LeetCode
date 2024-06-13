// https://leetcode.com/problems/product-of-the-last-k-numbers

class ProductOfNumbers {

    List<Integer> list;
    
    public ProductOfNumbers() {
        list = new ArrayList<>();
    }
    
    public void add(int num) {
        list.add(0, num);
    }
    
    public int getProduct(int k) {
        
        int res = 1;
        
        for(int i=0; i<k; i++){
            res *= list.get(i);
        }
        
        return res;
    }
    
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */