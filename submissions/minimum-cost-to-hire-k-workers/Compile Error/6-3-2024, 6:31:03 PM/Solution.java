// https://leetcode.com/problems/minimum-cost-to-hire-k-workers

class Solution {

    class Worker{
        int q;
        int w;
        double ratio;
        public Worker(int q, int w){
            this.q = q;
            this.w = w;

            this.ratio = 1.0*w/q;
        }
    }
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {

        // wage : 期望拿到的薪水
        // quality :工作產出
        // 條件是必須要符合 所有k個worker中 最小的單位期望薪資(ratio)
        // 對於每個員工 單位期望薪資(ratio)就是 w/q
        // 限制是 薪資可以多給 但是不能少給
        // 我們只想要最便宜的方式去hire. k workers, => 薪資越低越好, 產出越大越好
        // 因此我們 sort workers by ratio asc => 當下ratio一定都比之前workers大
        // 我們把員工放進pq內。 把產量太高的員工踢掉 => 產量太高表示薪資太貴
        // sum up 產能 去乘以ratio就是總支付薪資         

        int n = quality.length;

        List<Worker> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            Worker worker = new Worker(quality[i], wage[i]);
            list.add(worker);
        }
        // cp直 : q/w
        Collections.sort(list, (a,b)-> a.cp-b.cp);
        

        
        
    }
}