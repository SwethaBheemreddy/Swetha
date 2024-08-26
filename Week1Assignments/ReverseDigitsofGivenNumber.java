package Week1Assignments;
class ReverseDigitsofGivenNumber {
public static void main(String args[])
{
	int num=6814;
	int rev_num=0;
	while(num!=0)
	{
		rev_num=(rev_num*10)+(num%10);
		num=num/10;
	}
	System.out.println(rev_num);
	}
}

