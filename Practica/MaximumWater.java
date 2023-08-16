//You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
//Find two lines that together with the x-axis form a container, such that the container contains the most water.
//Return the maximum amount of water a container can store.
//Notice that you may not slant the container.

class MaximumWater {
    //Function to calculate the minimum between 2 numbers
    public static int minNumber(int x, int y){
        if(x<y){
            return x;
        }else{
            return y;
        }
    }
    //Function to calculate the amount of water held between two barriers
    //given the height of the borders and the base of the container
    public static int areaCalculator(int a, int b, int l){
        return l*minNumber(a,b);
    }

    public int maxArea(int[] height) {
        int maxWater=0;
        int temp=0;
        //Nested loop that compares all possible areas and selects 
        //the largest
        for(int i=0;i<height.length-1;i++){
            for(int j=i+1;j<height.length;j++){
                temp=areaCalculator(height[i],height[j],j-i);
                if(maxWater<temp){
                    maxWater=temp;
                }
            }
        }
        return maxWater;
    }

    public static void main(String[] args){

    }
}