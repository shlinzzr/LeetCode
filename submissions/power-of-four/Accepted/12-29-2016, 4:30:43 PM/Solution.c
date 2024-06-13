// https://leetcode.com/problems/power-of-four

bool isPowerOfFour(int num) {
    if ((num&1==1 && 1!=num) || num<0)   // 這裡當input==1時    1!=num條件應該可以省略 (1&1==1)會是true,並return false 
                                         // 但是條件拿掉後會出錯 不知到為啥
        return false;
    if (
       num==1
    || num == 4
    || num == 4<<2
    || num == 4<<4
    || num == 4<<6
    || num == 4<<8
    || num == 4<<10
    || num == 4<<12
    || num == 4<<14
    || num == 4<<16
    || num == 4<<18
    || num == 4<<20
    || num == 4<<22
    || num == 4<<24
    || num == 4<<26
    || num == 4<<28
    )
        return true;
    else
        return false;
}