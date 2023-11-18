import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

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

    public static List<Integer> subsetA(List<Integer> arr) {
        // Write your code here
            Collections.sort(arr);
            int subSize=1; int accumA; int accumB;
            boolean correctSize=false; boolean AbiggerB;
            while(!correctSize){
                accumA=0;
                for(int i=0; i<subSize; i++){
                    accumA+=arr.get(arr.size()-1-i);
                    System.out.println(accumA);
                }
                AbiggerB=true;
                accumB=0; int Bindex=arr.size()-subSize-1;
                while((AbiggerB)&&(Bindex>-1)){
                    accumB+=arr.get(Bindex);
                    System.out.println(accumB+" hola");
                    Bindex--;
                    AbiggerB=(accumA>accumB);
                }
                correctSize=(Bindex==-1);
                subSize++;
            }
            List<Integer> result=new ArrayList<Integer>();
            for(int i=0;i<subSize; i++){
                result.add(arr.get(arr.size()-1-i));
            }
            return result;
        }
    
    public static void main(String[] args){
        //IBM.dec2bin(10);
        //IBM.fibonacciTri(7);
        int[] myArray={6,5,4,2,3,2,1};
        List<Integer> myList=new ArrayList<Integer>();
        for(int i=0;i<myArray.length;i++){
            myList.add(myArray[i]);
        }
        Collections.sort(myList);
        for(int i=0;i<myList.size();i++){
            System.out.println(myList.get(myList.size()-1-i));
        }
        System.out.println("");
        for(int i=0;i<myList.size();i++){
            System.out.println(myList.get(i));
        }

    }
}