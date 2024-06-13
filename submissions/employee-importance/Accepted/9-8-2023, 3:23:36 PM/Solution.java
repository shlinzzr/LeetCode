// https://leetcode.com/problems/employee-importance

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

// class Solution {
    
//     public int getImportance(List<Employee> employees, int id) {
        
//         HashMap<Integer, Employee> map = new HashMap<>();
//         for(Employee e : employees){
//             map.put(e.id, e);
//         }
        
//         return helper(id, map);
        
//     }
    
//     private int helper(int id, HashMap<Integer, Employee> map){
        
//         int res = 0;
        
//         Employee e = map.get(id);
//         res += e.importance;
//         List<Integer> sub = e.subordinates;
//         if(sub!=null && !sub.isEmpty){
//             for(int s: sub){
//                 res += helper(s, map);
//             }
//         }
        
//         return res;
//     }
    
// }


class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return getImportanceHelper(map, id);
    }
    
    private int getImportanceHelper(Map<Integer, Employee> map, int rootId) {
        Employee root = map.get(rootId);
        int total = root.importance;
        for (int subordinate : root.subordinates) {
            total += getImportanceHelper(map, subordinate);
        }
        return total;
    }
}