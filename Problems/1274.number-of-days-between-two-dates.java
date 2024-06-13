// https://leetcode.com/problems/number-of-days-between-two-dates

class Solution {
    public int daysBetweenDates(String date1, String date2) {
        
        
       
        
        
        return Math.abs(daySince1970(date1)-daySince1970(date2));
        
        
    }
    
    
    private int daySince1970(String date1){
        
        
        int[] arr = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        
         String[] d1 = date1.split("-");
        int year = Integer.parseInt(d1[0]);
        int month = Integer.parseInt(d1[1]);
        int days = Integer.parseInt(d1[2]);
        
        int cnt=0;
        
        for(int i=1971; i<year; i++){
            cnt += isLeapYear(i) ? 366 : 365;
        }
        
        
        for(int i=1; i<month; i++){
             
            if(isLeapYear(year) && i==2)
                cnt += 1;
            
            
            cnt+=arr[i];
        }
        
        
        cnt += days;
       
        
        return cnt;
        
        
        
        
        
        
    }
    
    
    
    
    
    
    
    public boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
}