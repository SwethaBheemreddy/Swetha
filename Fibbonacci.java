package Week1Assignments;

class Fibbonacci {
public static void main(String args[]) {
	int n=1000,f0=0,f1=1,f2;
	System.out.println("Fibonacci series upto" + n +":");
	while(f0<=n)
	{
		System.out.println(f0+" ");
		f2=f0+f1;
		f0=f1;
		f1=f2;
	}
		
}
}
