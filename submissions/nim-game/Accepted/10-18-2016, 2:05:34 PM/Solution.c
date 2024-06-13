// https://leetcode.com/problems/nim-game

bool canWinNim(int n) {
    int sn = n % 4;
    if(sn == 0)
        return false;
    else
        return true;
}    
