// https://leetcode.com/problems/brace-expansion

class Solution {
    public String[] expand(String s) {

        List<List<String>> list = new ArrayList<>();
        String curr = "";
        int len = s.length();
        for(int i=0; i<len; i++){
            char ch = s.charAt(i);

            if(ch=='{'){

                if(!curr.isEmpty()){
                    List<String> tmp = new ArrayList<>();
                    tmp.add(curr);
                    list.add(tmp);
                    curr="";
                }

                int j=i+1;
                for(int cnt=0; i<len; i++){
                    if(s.charAt(i)=='{') cnt++;
                    if(s.charAt(i)=='}') cnt--;
                    if(cnt==0) break;
                }
                String sub = s.substring(j,i);
                String[] arr = sub.split(",");
                list.add(Arrays.asList(arr));
            }else {
                curr+=ch;
            }
        }

        if(!curr.isEmpty()){
            List<String> tmp = new ArrayList<>();
            tmp.add(curr);
            list.add(tmp);
        }

        for(List<String> aa : list){
            for(String a : aa){
                System.out.print(a+",");

            }System.out.println(" " + aa.size());

        }


        List<String> res= new ArrayList<>();
        helper(res, list, 0, "");
        String[] rt = new String[res.size()];

        for(int i=0; i<rt.length; i++){
            rt[i] = res.get(i);
        }

        return rt;


    }


    private void helper(List<String> res, List<List<String>> list, int st, String curr){
        System.out.println(curr + " st=" + st  + " res=" + res);
        if(st==list.size()){
            res.add(curr);
            return;
        }

        List<String> sub = list.get(st);
        for(String s : sub){
            helper(res, list, st+1, curr+s);
        }
    }
}