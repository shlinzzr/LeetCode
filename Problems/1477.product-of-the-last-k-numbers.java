// https://leetcode.com/problems/product-of-the-last-k-numbers

class ProductOfNumbers {

    List<Integer> list;
    public ProductOfNumbers() {
        list = new ArrayList<>();
        list.add(1);
    }
    
    public void add(int a) {
        if (a > 0)
            list.add(list.get(list.size() - 1) * a);
        else {   // 有0的話 整個prod list清掉 長度重新開始
            list = new ArrayList();
            list.add(1);
        }
    }

    public int getProduct(int k) {
        int n = list.size();
        return k >= n ? 0 : list.get(n - 1) / list.get(n - k - 1) ;
        // 如果k>n 表示 req k 的prod中有包含0 因此直接回傳0
    }
    
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */