class GoodSubSets {
    public static int power(int x, int p) {
        int power = 1;
        for (int i = 0; i < p; i++) {
            power = power * x;
        }
        return power;
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
        int[] a = {8, 11, 17, 2, 25, 29, 21, 20, 4, 22};
        //11,17,2,29,21,22
        System.out.println("The answer is: "+squareFreeSubsets(a));
    }
}
