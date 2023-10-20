public class IBM {
    public static void dec2bin(int a){
        int copyOfa=a;
        int sizeOfbin=0;
        while(copyOfa!=0){
            copyOfa/=2;
            sizeOfbin++;
        }
        System.out.print("The decimal number "+a+" in binary is: ");
        int[] binNum=new int[sizeOfbin];
        for(int i=0;i<sizeOfbin;i++){
            binNum[i]=a%2;
            a/=2;
        }
        for(int i=0;i<sizeOfbin;i++){
            System.out.print(binNum[sizeOfbin-i-1]);
        }
    }

    public static void fibonacciTri(int n){
        int[] prev={};
        int[] curr={};
        for(int i=1;i<=n;i++){
            if(i==1){
                curr=new int[i];
                curr[0]=1;
                System.out.println(curr[0]);
            }else{
                prev=curr;
                curr=new int[i];
                for(int j=0;j<i;j++){
                    if(j==0 ||j==i-1){
                        curr[j]=1;
                    }else{
                        curr[j]=prev[j-1]+prev[j];
                    }
                }
                for(int j=0;j<i;j++){
                    System.out.print(curr[j]+" ");
                }
                System.out.println("");
            }
        }
    }
    
    public static void main(String[] args){
        //IBM.dec2bin(10);
        IBM.fibonacciTri(7);
    }
}