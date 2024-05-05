import java.util.*;
import java.math.*;
public class rsa
{

public static int e=0,n=0,d=0,t=0,phi=0;

int gcd(int a,int b,int t1,int t2){
if(a%b==0){
if(t2<0)
t=phi+t2;
else
t=t2;
return b;
}
return gcd(b,a%b,t2,t1-(a/b)*t2);
}

void keygen(int p,int q){
n=p*q;
phi=(p-1)*(q-1);
System.out.println("phi="+phi);
for(int i=2;i<phi;i++){
if(gcd(phi,i,0,1)==1){
e=i;
break;
}
}
System.out.println("e="+e);
System.out.println("t="+t);
d = t % phi;
System.out.println("d="+d);
}

int encrypt(int p){
double c=Math.pow(p,e)%n;
int c1=(int)c;
return c1;
}

public static BigInteger decrypt(int c) {
  return BigInteger.valueOf(c).modPow(BigInteger.valueOf(d), BigInteger.valueOf(n));
}

public static void main(String [] args){
Scanner sc=new Scanner (System.in);
rsa ob=new rsa();
System.out.println("Enter two large prime numbers");
int p=sc.nextInt();
int q=sc.nextInt();
System.out.println("Enter the number to be encrypted: ");
int inp=sc.nextInt();
ob.keygen(p,q);
int C=ob.encrypt(inp);
System.out.println("Encryption: "+C);
System.out.println("Decryption: "+ob.decrypt(C));
}
}

