package Week1Assignments;

class Factorial {
public static void main(String args[])
{
	int num=3,i=1;
	long factorial=1;
	while(i<=num)
	{
		factorial*=i;
		i++;
	}
	System.out.printf("Factorial of %d=%d",num,factorial);
}
}
