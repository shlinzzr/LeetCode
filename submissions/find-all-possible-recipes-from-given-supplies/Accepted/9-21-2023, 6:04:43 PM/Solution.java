// https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashSet<String> set = new HashSet<>();
        for(String s: supplies){
            set.add(s);
        }

        Set<String> res = new HashSet<>();

        int prev=-1;


        while(prev!=res.size()){
            prev =res.size();
            for(int i=0; i<recipes.length; i++){

                List<String> need = ingredients.get(i);
                boolean flag = true;

                for(String n : need){
                    if(!set.contains(n)){
                        flag= false;
                        break;
                    }
                }

                if(flag){
                    res.add(recipes[i]);
                    set.add(recipes[i]);
                }
            }
            // System.out.println(prev + " " +res.size());
        }
      

        return new ArrayList<>(res);
     }
}