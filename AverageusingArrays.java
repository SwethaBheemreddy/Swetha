package Week1Assignments;

class AverageusingArrays {
public static void main(String args[])
{
	double value[]= {96.5,75.4,92.3,80.2,78.3};
	double sum=0.0;
	for(double num:value)
	{
		sum+=num;
	}
	System.out.println(sum);
	double avg=sum/value.length;
	System.out.println("Avg:"+avg);
}
}
