public class GoodSubSets2 {
    //You are given a positive integer 0-indexed array nums.
    //A subset of the array nums is square-free if the product of its elements is a square-free integer.
    //A square-free integer is an integer that is divisible by no square number other than 1.
    //Return the number of square-free non-empty subsets of the array nums. Since the answer may be too large, return it modulo 109 + 7.
    //A non-empty subset of nums is an array that can be obtained by deleting some (possibly none but not all) elements from nums. Two subsets are different if and only if the chosen indices to delete are different.
    
    //This list is used to speed up the process of checking if a number is prime. Depending on the range of problems, this can be extended or another algorithm can be used.
    public static int[] primeList={ 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };
    public static int[] squaredPrimeList={4,9,25};
    //Array full of zeroes generator
    public static int[] zeroesArrayGen(int n){
        int[] newArray=new int[n];
        for(int i=0;i<n;i++){    
            newArray[i]=0;
        }
        return newArray;
    }
    //Binary increment
    public static void binaryIncrement(int[] binNum,int incrementIndex){
        binNum[incrementIndex]++;
        if(binNum[incrementIndex]>1){
            binNum[incrementIndex]=0;
            if(incrementIndex<binNum.length-1){
                binaryIncrement(binNum, incrementIndex+1);
            }
        }
    }
    
    //toString method for arrays
    public static String toString(int[] myArray) {
        String result = new String("{" + myArray[0]);
        for (int i = 1; i < myArray.length; i++) {
            result = result.concat("," + myArray[i]);
        }
        result = result.concat("}");
        return result;
    }
    //set generator that only contains coprime numbers
    public static int[] coprimeSet(int c,int max){
        return new int[1];
    }
    //Function to generate the prime factorization of a number less (or equal) to 30
    public static int[] primeFacArrayGen(int n){
        int[] factorizationArray=zeroesArrayGen(3);
        int arrayIndex=0;
        for(int i=0;i<primeList.length;i++){
            if(n>=primeList[i]){
                if(n%primeList[i]==0){
                    factorizationArray[arrayIndex]=primeList[i];
                    arrayIndex++;
                }
            }
        }
        return factorizationArray;
    }
    public static int squareFreeSubsets(int[] nums) {
        //Generate an array full of zeroes
        int[] numberCounter=zeroesArrayGen(31);
        //count how many times each number appears on the set
        for(int i=0;i<nums.length;i++){
            numberCounter[nums[i]]++;
        }
        //Eliminate all numbers divisible by a square
        for(int i=0; i<numberCounter.length; i++){
            for(int j=0;j<squaredPrimeList.length;j++){
                if(i%squaredPrimeList[j]==0) numberCounter[i]=0;
                    
            }
        }
        
        //Array that contains which compound are found in nums and counter of all different compounds
        int[] compoundNums=zeroesArrayGen(numberCounter.length);
        int compoundCount=0;
        boolean primecheck;
        for(int i=1; i<numberCounter.length; i++){
            primecheck=true;
            for(int j=0;j<primeList.length;j++){
                primecheck=primecheck&&(i!=primeList[j])&&(numberCounter[i]!=0);
            }
            if(primecheck){
                compoundNums[i]=1;
                compoundCount++;
            } 
        }

        //first recount of possibilities (all subsets that only contain primes)
        int subsetCount=0;
        int prev=0;
        int act=0;
        for(int i=0;i<primeList.length-1;i++){
            if(i==0){
                prev=numberCounter[primeList[i]];
                act=numberCounter[primeList[i+1]];
                subsetCount=subsetCount+prev+act+(act*prev);
            }else{
                prev=subsetCount;
                act=numberCounter[primeList[i+1]];
                subsetCount=subsetCount+prev+act+(act*prev);
            }
        }

        //Generation of all subsets that contain a specific compound
        int[][] combinations=new int[compoundCount][];
        int combinationsIndex=0;
        //First cycle goes through all compound numbers
        for(int i=0;i<compoundNums.length;i++){
            //The index i represents the compound for a given set
            if(compoundNums[i]==1){
                int[] primeFactorization=primeFacArrayGen(i);
                int[] combArrays=zeroesArrayGen(numberCounter.length);
                combArrays[0]=i;
                int combArraysIndex=1;
                //For a given compound, we check to see which numbers are coprime to it
                    for(int j=0;j<numberCounter.length;j++){
                        //The j index represents each number checked
                        if(numberCounter[j]!=0){
                            boolean combAdded=true;
                            for(int k=0;k<primeFactorization.length;k++){
                                if(primeFactorization[k]!=0){
                                    combAdded=combAdded&&(j%primeFactorization[k]!=0);
                                }
                            }
                            if(combAdded){
                                    combArrays[combArraysIndex]=j;
                                    combArraysIndex++;
                                }
                        }
                    }
                combinations[combinationsIndex]=combArrays;
                combinationsIndex++;
            } 
        }
        for(int i=0;i<compoundCount;i++){
            System.out.println(toString(combinations[i]));
        }
        

        System.out.println(toString(numberCounter));
        System.out.println(toString(compoundNums)+" "+compoundCount);
        return 0;
    }
    
    public static void main(String[] args){
        //int[] a={3,4,4,4,4,4,5,7,6,9,10,11,13,13,17,21};
        //squareFreeSubsets(a);
        int[] b=zeroesArrayGen(4);
        for(int i=0;i<16;i++){
            binaryIncrement(b, 0);
            System.out.println(toString(b));
        }
        
        System.out.println(toString(primeFacArrayGen(21)));
    }
}
