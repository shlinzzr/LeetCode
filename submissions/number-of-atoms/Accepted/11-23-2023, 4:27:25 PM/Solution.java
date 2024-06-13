// https://leetcode.com/problems/number-of-atoms

class Solution {
    public String countOfAtoms(String f) {
        Stack<Map<String,Integer>> st= new Stack<>();
        Map<String, Integer> map= new HashMap<>();
        int len = f.length();
        int n = len;
        for(int i=0; i<len; i++){
            char ch = f.charAt(i);

            if(ch=='('){
                st.push(map);
                map=new HashMap<>();

            }else if(ch==')'){
                int num=0;
                if(i+1<len && Character.isDigit(f.charAt(i+1))){
                    num = (f.charAt(++i)-'0');
                    while(i+1<len && Character.isDigit(f.charAt(i+1))){
                        num = num*10+ (f.charAt(++i)-'0');
                    }
                }

                if(num==0) num=1;

                if(!st.isEmpty()){
                    Map<String,Integer> temp = map;
                    map=st.pop();
                    for(String key: temp.keySet())
                        map.put(key, map.getOrDefault(key,0)+temp.get(key)*num);
                }

            }else{ // parsing atom
                int start=i;
                i++;
                while(i<len && Character.isLowerCase(f.charAt(i))){
                    i++;
                }
                String atom = f.substring(start, i);


                int num=0;
                while(i<len && Character.isDigit(f.charAt(i))){
                    num = num*10+ (f.charAt(i)-'0');
                    i++;
                }
                if(num==0) num=1;
               
                map.put(atom, map.getOrDefault(atom ,0)+num);
                i--;
              
            }
        }
        StringBuilder sb= new StringBuilder();
        List<String> list= new ArrayList<>(map.keySet());
        Collections.sort(list);
        for(String key: list){ 
            sb.append(key);
            if(map.get(key)>1) 
                sb.append(map.get(key));
        }
        return sb.toString();
        //  StringBuilder sb= new StringBuilder();
        // List<String> list= new ArrayList<>(map.keySet());
        // Collections.sort(list);
        // for(String key: list){ 
        //     sb.append(key);
        //   if(map.get(key)>1) sb.append(map.get(key));
        //                             }
        // return sb.toString();
    }
}