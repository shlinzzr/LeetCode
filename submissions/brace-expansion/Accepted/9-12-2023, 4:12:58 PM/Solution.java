// https://leetcode.com/problems/brace-expansion

class Solution {
    public String[] expand(String s) {
                
        int st=0, ed=0;

        List<List<String>> f = new ArrayList<>();

        while(st<s.length()){
            List<String> list = new ArrayList<>();
            char ch = s.charAt(st);
            if(ch=='{'){
                ed = s.indexOf('}', st);
                String sub = s.substring(st+1, ed);

                // System.out.println("sub="+sub);
                
                list = Arrays.asList(sub.split(",", -1));
                f.add(list);
                st = ed+1;
            }else{

                ed = s.indexOf('{', st);
                if(ed==-1) 
                    ed = s.length();

                String sub = s.substring(st, ed);
                //   System.out.println("sub2="+sub);
                list.add(sub);
                st = ed;
                f.add(list);
            }

          
        }

        // System.out.println(f);

        List<String> res = new ArrayList<>();
        res.add("");
        int siz = f.size();
        for(int i=0; i<siz; i++){
            List<String> curr = f.get(i);
            Collections.sort(curr);
            List<String> tmp = new ArrayList<>();

            for(String r : res){
                for(String c : curr){
                    tmp.add(r+c);
                }
            }

            res = new ArrayList<>(tmp);

            //  System.out.println("res="+res);

        }

        String[] arr = new String[res.size()];

        for(int i=0; i<res.size(); i++){
            arr[i] = res.get(i);
        }

        return arr;

    }


}



// let x v
// add 2 3

