// https://leetcode.com/problems/fraction-to-recurring-decimal

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        
        if (numerator == 0) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        
        // "+" or "-"
        sb.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        
        // integral part
        sb.append(num / den); // 4/333==0
        num %= den; // num=4
        if (num == 0) {
            return sb.toString();
        }
        
        // fractional part
        sb.append("."); // sb= "0."
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, sb.length()); // 存餘數, (4, 2)
        
        while (num != 0) {
            // System.out.println(num + " " + den + " " +  sb.length() );
            // System.out.println(map.keySet());
            num *= 10; // 4*10==40 ...  40*10==400 ... 67*10==670
            sb.append(num / den); // [40/333==0, sb="0.0"] [400/333==1, sb="0.01"], [670/333==2, sb="0.012"]
            num %= den; // [40%333==40], [400%333==67], [670%333==4]
            if (map.containsKey(num)) {  // map.containsKey(4)==true
                int index = map.get(num); // idx==2
                sb.insert(index, "("); // sb.insert(2, '(') ... 
                sb.append(")");   //  ==>  0.012 => 0.(012)
                break;
            }
            else {
                map.put(num, sb.length()); // (40, 3), (67, 4)
            }
        }
        return sb.toString();
    }
}