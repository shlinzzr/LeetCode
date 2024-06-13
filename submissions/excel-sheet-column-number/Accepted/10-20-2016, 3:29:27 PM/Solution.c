// https://leetcode.com/problems/excel-sheet-column-number

/*
int titleToNumber(char* s) {
    char *ptr = 'A' - '1';
    int n = strlen(s);
    char *arr = malloc(n *sizeof(char));
    
    //s = s-ptr;
    
    for(int i=0; i<n; i++)
    {
        arr[i]= s[i] - ptr[i];
    }
    
    return arr;
}

*/

//關鍵在於  result * 26 + *s++ - 'A' + 1   
//Q1.為什麼字元可在int中被相減 
//Q2.為何要*26 
//Q3.為何+1

//  註:
//  result*26=0, s=25863776, *s=65  result=1
//  result*26=0, s=25863808, *s=66  result=2
//  result*26=0, s=25863776, *s=67  result=3
int titleToNumber(char* s) {
    
    int result = 0;
	while (*s){
	    printf("  result*26=%d, s=%d, *s=%d",result, s, *s);
		result = result * 26 + *s++ - 'A' + 1;
		printf("  result=%d\n",result);
	}
	return result;
}