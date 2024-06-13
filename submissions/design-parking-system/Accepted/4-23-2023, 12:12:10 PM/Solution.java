// https://leetcode.com/problems/design-parking-system

class ParkingSystem {

    
    int b=0, m=0, s=0;
    
    int[] arr = new int[4];
    
    public ParkingSystem(int big, int medium, int small) {
        this.arr[1] =big;
        this.arr[2] =medium;
        this.arr[3] =small;
    }
    
    public boolean addCar(int carType) {
        return (arr[carType]--)>0;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */