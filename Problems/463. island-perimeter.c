// https://leetcode.com/problems/island-perimeter


//https://discuss.leetcode.com/topic/68786/clear-and-easy-java-solution
int islandPerimeter(int** grid, int gridRowSize, int gridColSize) {
    
    int neighbours=0 ,island=0;
    
    for(int i=0;i<gridRowSize;i++)
    {
     
        
        for(int j=0;j<gridColSize;j++)
        {
            if(grid[i][j] == 1){
              island++;
            if (i < gridRowSize - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
            if (j < gridColSize - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                
                
            }
            printf("%d ", grid[i][j]);
            
        }
           printf("\n");
    }
    
    return island * 4 - neighbours *2 ;
}