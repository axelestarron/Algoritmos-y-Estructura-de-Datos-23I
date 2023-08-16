//You are given a positive integer n, you can do the following operation any number of times:
//Add or subtract a power of 2 from n.
//Return the minimum number of operations to make n equal to 0.
public class MinOperations {
    public static int power(int x, int p){
        int power=1;
        for(int i=0;i<p;i++){
            power=power*x;
        }
        return power;
    }
    public static int log2(int a){
        int temp=a;
        int counter=-1;
        while(temp!=0){
            temp=temp/2;
            counter++;
        }
        return counter;
    }

    public static int minValue(int a, int b){
        if(a<b){
            return a;
        }else{
            return b;
        }
    }

    public static int absValue(int a){
        if(a<0){
            return -a;
        }else{
            return a;
        }
    }

    public static int minOperations(int n) {
        int logNum=log2(n);
        int opCounter=0;
        int upBound=0;int lowBound=0;
        while(n!=0){
            opCounter++;
            upBound=power(2,logNum);
            lowBound=power(2,logNum+1);
            n=minValue(absValue(n-lowBound),absValue(n-upBound));
            System.out.println(n);
            logNum=log2(n);
        }  
        return opCounter; 
    }
    public static void main(String[] args){
        System.out.println(minOperations(54));
    }
} 
