// https://leetcode.com/problems/product-of-two-run-length-encoded-arrays

class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        LinkedList<List<Integer>> product = new LinkedList<>();

        int lengthEncoding1 = encoded1.length, lengthEncoding2 = encoded2.length;
        int indexEncoding1 = 0, indexEncoding2 = 0;

        while (indexEncoding1 < lengthEncoding1 && indexEncoding2 < lengthEncoding2) {
            int[] pair1 = encoded1[indexEncoding1];
            int[] pair2 = encoded2[indexEncoding2];

            int productVal = pair1[0] * pair2[0];
            int freq = Math.min(pair1[1], pair2[1]);

            pair1[1] -= freq;
            pair2[1] -= freq;

            if (pair1[1] == 0) indexEncoding1++;
            if (pair2[1] == 0) indexEncoding2++;

            List<Integer> lastProductEncoding;
            if (product.isEmpty() || (lastProductEncoding = product.getLast()).get(0) != productVal) {
                product.add(Arrays.asList(productVal, freq));
            } else {
                lastProductEncoding.set(1, lastProductEncoding.get(1) + freq);
            }
        }
        return product;
    }
}