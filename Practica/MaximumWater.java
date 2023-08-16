//You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
//Find two lines that together with the x-axis form a container, such that the container contains the most water.
//Return the maximum amount of water a container can store.
//Notice that you may not slant the container.

//Still need optimization
class MaximumWater {
    //Function to calculate the minimum between 2 numbers
    public static int minNumber(int x, int y){
        if(x<y){
            return x;
        }else{
            return y;
        }
    }
    //Function to find the index of the max value on an array
    public static int maxArrayIndex(int[] array){
        int maxIndex=0;
        for(int i=0;i<array.length-1;i++){
            if(array[maxIndex]<array[i+1]){
                maxIndex=i+1;
            }
        }
        return maxIndex;
    }
    //Function to calculate the amount of water held between two barriers
    //given the height of the borders and the base of the container
    public static int areaCalculator(int a, int b, int l){
        return l*minNumber(a,b);
    }


    public int maxArea(int[] height) {
        int maxValueIndex=maxArrayIndex(height);
        //int maxValue=height[maxValueIndex];
        //We make the height array into a triangle function
        //Left side slope
        int tempMax=height[0];
        if(maxValueIndex!=0){
            for(int i=1;i<=maxValueIndex;i++){
                if(height[i]>=tempMax){
                    tempMax=height[i];
                }else{
                    height[i]=0;
                }
            }
        }
        //Right side slope
        if(maxValueIndex!=height.length-1){
            tempMax=height[height.length-1];
            for(int i=height.length-1;i<maxValueIndex;i--){
                if(height[i]>=tempMax){
                    tempMax=height[i];
                }else{
                    height[i]=0;
                }
            }
        }
        //Check for optimal volume
        int maxWater=0;
        for(int i=0;i<=maxValueIndex;i++){
            for(int j=maxValueIndex;j<height.length;j++){
                if(height[i]!=0 && height[j]!=0 && maxWater<areaCalculator(height[i], height[j], j-i)){
                    maxWater=areaCalculator(height[i], height[j], j-i);
                }
            }
        }
        return maxWater;
    }
       
    public static void main(String[] args){

    }
}