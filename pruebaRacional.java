public class racional{
    public static void main(String[]arg){
        racional medio=new racional(1,2);
        racional tresCuartos=new racional(3,4);
        System.out.print(medio.suma(tresCuartos));
    }
}
int num;
int den;
public racional(){
    this.num=1;
    this.den=1;
}
public racional(int num,int den){
    this.num=num;
    this.den=den;
}
public racional suma(racional a){
    racional result=new racional();
    result.num=num*a.den+den*a.num;
    result.den=den*a.den;
    return result; 
}