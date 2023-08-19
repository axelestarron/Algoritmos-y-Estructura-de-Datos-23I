class GoodSubSets {
    //Method for obtaining the factorial of a number
    public static int factorial(int n){
        int fact=1;
        if(n<=1) return fact;
        for(int i=1;i<=n;i++){
            fact=fact*i;
        }
        return fact;
    }
    //Method for obtaining x^p
    public static int power(int x, int p) {
        int power = 1;
        for (int i = 0; i < p; i++) {
            power = power * x;
        }
        return power;
    }
    //Method for obtaining the combinations from pool choose size (e.g. 5 choose 3)
    public static int combinationNumber(int pool, int size){
        if(pool>=size){
            return factorial(pool)/(factorial(size)*factorial(pool-size));
        }else{
            System.out.println("Choose appropiate values for pool and size");
            return 0;
        }
    }
    //Method for determining which combination comes next
    public static void rightmostReplaceble(int arraySize, int[] flagArray){
        int diff=0;
        for(int i=0;i<flagArray.length;i++){
            if(i==0) System.out.println(toString(flagArray));
            if(flagArray[flagArray.length-1]!=arraySize-1 && i==0){
                flagArray[flagArray.length-1]++;
            }else if(flagArray[1]==arraySize-flagArray.length+1){
                flagArray[0]++;
                for(int j=1;j<flagArray.length;j++){
                    flagArray[j]=flagArray[0]+j;
                }
            }else{
                if(i<flagArray.length-2){
                    diff=flagArray[flagArray.length-1-i]-flagArray[flagArray.length-2-i];
                    if(diff!=1) flagArray[flagArray.length-2-i]++;
                }
            }
        }
    }
    public static String toString(int[] myArray) {
        String result = new String("{" + myArray[0]);
        for (int i = 1; i < myArray.length; i++) {
            result = result.concat("," + myArray[i]);
        }
        result = result.concat("}");
        return result;
    }

    //Method for obtaining the combinations of size r from a list of numbers
    public static Object[] combinations(int[] pool,int r){
        int size=combinationNumber(pool.length,r);
        Object[] combinationArray=new Object[size];
        int[] combPos=new int[r];
        for(int i=0;i<r;i++){
            combPos[i]=i;
        }
        int[] temp=new int[r];
        for(int i=0;i<size;i++){
            for(int k=0;k<r;k++){

            }
            for(int j=0;j<r;j++){
                temp[j]=pool[combPos[j]];
            }
            combinationArray[i]=temp;
        }
        return combinationArray;
    }
    

    public static int squareFreeSubsets(int[] nums) {
        // We generate arrays that list which numbers are divisible by different factors
        int[] primelist = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };
        int[] mult2 = new int[nums.length];
        int[] mult3 = new int[nums.length];
        int[] mult5 = new int[nums.length];
        int[] mult7 = new int[nums.length];
        int[] mult11 = new int[nums.length];
        int[] mult13 = new int[nums.length];
        int[] mult17 = new int[nums.length];
        int[] mult19 = new int[nums.length];
        int[] mult23 = new int[nums.length];
        int[] mult29 = new int[nums.length];
        // We fill the arrays previously mentioned
        int zeroes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 4 == 0 || nums[i] % 9 == 0||nums[i]%25==0) {
                nums[i] = 0;
                zeroes++;
            }
            if (nums[i] % primelist[0] == 0)
                mult2[i] = 1;
            if (nums[i] % primelist[1] == 0)
                mult3[i] = 1;
            if (nums[i] % primelist[2] == 0)
                mult5[i] = 1;
            if (nums[i] % primelist[3] == 0)
                mult7[i] = 1;
            if (nums[i] % primelist[4] == 0)
                mult11[i] = 1;
            if (nums[i] % primelist[5] == 0)
                mult13[i] = 1;
            if (nums[i] % primelist[6] == 0)
                mult17[i] = 1;
            if (nums[i] % primelist[7] == 0)
                mult19[i] = 1;
            if (nums[i] % primelist[8] == 0)
                mult23[i] = 1;
            if (nums[i] % primelist[9] == 0)
                mult29[i] = 1;
        }
        // We determine how many sets we can make while keeping a given number
        int counter = 0;
        int notValid = 0;
        int temp = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                zeroes--;
            } else {
                temp = 0;
                notValid = 0;
                for (int i = j + 1; i < nums.length; i++) {
                    if(nums[i]!=0){
                        if ((mult2[i] * mult2[j] == 1) || (mult3[i] * mult3[j] == 1) || (mult5[i] * mult5[j] == 1)
                            || (mult7[i] * mult7[j] == 1) || (mult11[i] * mult11[j] == 1)
                            || (mult13[i] * mult13[j] == 1) || (mult17[i] * mult17[j] == 1)
                            || (mult19[i] * mult19[j] == 1) || (mult23[i] * mult23[j] == 1)
                            || (mult29[i] * mult29[j] == 1)) {
                            notValid++;
                            System.out.println(notValid);
                        }
                    }
                    
                }
                System.out.println("--");
                temp = nums.length - zeroes - j - 1 - notValid;
                System.out.println(temp);
                counter = counter + power(2, temp);
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        //int[] a = {8, 11, 17, 2, 25, 29, 21, 20, 4, 22};
        //11,17,2,29,21,22
        //System.out.println("The answer is: "+squareFreeSubsets(a));
        //System.out.println(factorial(5));
        //System.out.println(combinationNumber(5, 1));
        int[] a={0,1,2};
        for(int i=0;i<11;i++){
            rightmostReplaceble(5, a);
        }

    }
}
