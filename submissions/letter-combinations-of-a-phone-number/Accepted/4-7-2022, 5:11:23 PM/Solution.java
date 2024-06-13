// https://leetcode.com/problems/letter-combinations-of-a-phone-number

class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<String, List<String>> map =new HashMap();
        map.put("2", Arrays.asList("a", "b", "c" ));
        map.put("3", Arrays.asList("d", "e", "f" ));
        map.put("4", Arrays.asList("g", "h", "i" ));
        map.put("5", Arrays.asList("j", "k", "l" ));
        map.put("6", Arrays.asList("m", "n", "o" ));
        map.put("7", Arrays.asList("p", "q", "r", "s" ));
        map.put("8", Arrays.asList("t", "u", "v" ));
        map.put("9", Arrays.asList("w", "x", "y", "z" ));
        map.put("0", Arrays.asList(" " ));
                                   
        char[] arr = digits.toCharArray();
                           
           
                                 System.out.println(arr);  
                                   
        List<String> res = new ArrayList<String>();
        for(char c : arr){
            String key = String.valueOf(c);
                      System.out.println(key);  
            res = combine(map.get(key), res);
        }
                                   
                     return res;              
    }
                                   
    public static List<String> combine( List<String> digit, List<String> res) {
            List<String> result = new ArrayList<String>();
            
              if(res.size()==0)
                  return digit;
        
            for (int i=0; i<digit.size(); i++) 
                for (String x : res) {
             System.out.println("x+digit.get(i)="+x+digit.get(i));  
        
                    result.add(x+digit.get(i));
                }
            return result;
        }
}