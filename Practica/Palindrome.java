class Palindrome {
    public static int absoluteLog(int n){
        //Function that produces the log10 of the absolute value of the input
        //If the input is 0, the function returns -1
        int logResult=-1;
        while(n!=0){
            n=n/10;
            logResult++;
        }
        return logResult;
    }

    public static boolean isPalindrome(int x) {
        //We discard any negative numbers from the beggining
        if(x<0){
            return false;
        }
        //If the number only has 1 digit, it is a palindrome
        if(absoluteLog(x)<=0){
            return true;
        }
        //We generate an array of ints that contain the digits of the input
        int sizeArray=absoluteLog(x)+1;
        int[] digitArray=new int[sizeArray];
        for(int i=0; i<sizeArray;i++){
            digitArray[i]=x%10;
            x/=10;
        }
       //We compare the first and last digit, then the second and last second, and so on
       //Notice that for numbers with an odd amount of digits, we do not need to check the digit on the middle
        boolean result=true;
        for(int i=0;i<sizeArray/2;i++){
            if(digitArray[i]!=digitArray[sizeArray-i-1]){
                result=false;
            }
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(-121));
    }
}