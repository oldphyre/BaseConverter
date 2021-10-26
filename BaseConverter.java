import java.io.*;
import java.math.BigDecimal;
import java.util.Scanner;

public class BaseConverter 
{

	public static void Base10toBase2(int value)
	{
		int numb = value;
		int counter = 0;
		int binaryVal[] = new int[64];

		while(numb > 0)
		{
			binaryVal[counter++] = numb % 2;
			numb = numb / 2;
			
			System.out.println(numb*2+binaryVal[counter-1] + " / 2 = " + numb + " R" + binaryVal[counter-1] );
		}

		for(int i = counter-1; i >=0; i--)
		{
			System.out.print(binaryVal[i]);
		}

	}
	
	public static void Base10toBase16(int value)
	{
//		BigDecimal bd = new BigDecimal(value);
//		BigDecimal bdDevisor = new BigDecimal(16);
//		
//		BigDecimal bdRemainder = bd.remainder(bdDevisor); 
		
		int numb = value;
		int counter = 0;
		int hexVal[] = new int [64];
		
		while(numb > 0)
		{
			int nRemainder = numb % 16;	
			hexVal[counter++] = nRemainder;
			numb = numb / 16;
			
			System.out.println(numb*16+nRemainder + " / 16 = " + numb + " R" + nRemainder);
		}
		
		for(int i = counter-1; i >=0; i--)
		{
			System.out.printf("%x", hexVal[i]);
		}
		
	}
	
	
	public static void Base2toBase10(String value)
	{
		int sum = 0;
		
		for(int i=0; i < value.length(); i++)
		{
			int bit = 0;
			
			if(value.charAt(i) == '1')
				bit = 1;
			else if(value.charAt(i) == '0')
				;
			else
				return;
			
			int nAdd = bit * (int)Math.pow(2, value.length()-i-1);
			sum += nAdd;
			
			System.out.format("%d | (%d * 2^%d) = %d\n", 
					bit,
					bit,
					value.length()-i-1,
					nAdd);
			
			//System.out.println("bit[" + i + "] = " + bit + " | 2^" + i + " = " + nAdd);
		}
		
		System.out.println("Answer is: " + sum);
	}
	
	public static void Base2toBase16(String value)
	{
		int nHowMany0stoadd = value.length() % 4;
		StringBuilder sb = new StringBuilder(value);
		
		for(int i=0; i<nHowMany0stoadd; i++)
			sb.insert(0, "0");
		
		String s = sb.toString();
		
		
		for(int i=0; i<s.length(); i+=4)
		{
			int sum = 0;
			
			String ss = s.substring(i, i+4);
			System.out.println(ss + " -> ");
			
			int multiply[] = new int[4];
			
			
			int k = 3;
			for(int j=0; j<4; j++)
			{
				int bit = 0;
				
				
				if(ss.charAt(j) == '1')
					bit = 1;
				else if(ss.charAt(j) == '0')
					;
				else
					return;
				
				multiply[j] = bit * (int)Math.pow(2, k);
				
				sum += multiply[j];
				
				System.out.format("(%d * 2^%d) = %x\n", bit, k, multiply[j]);
				k--;
			}
			
			System.out.format("sum = %x\n", sum);
		}
	}
	
	public static void Base16toBase10(String value)
	{
		int[] temp = new int[value.length()];
		int[] temp2 = new int[value.length()];
		
		
		for(int i=0; i<value.length();i++)
		{
			temp[i] = Character.getNumericValue(value.charAt(i));
			temp2[i] = temp[i] * (int)Math.pow(16, value.length()-i-1);
			System.out.format("%d * 16^%d = %d\n", temp[i], value.length()-i-1, temp2[i]);
			
			
			//System.out.println(temp[i]);
			
		}
		
		int sum =0;
		for(int i=0; i<temp2.length; i++)
			sum += temp2[i];
		System.out.println("= " + sum);
	}
	
	

	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);

		//
		//Base2toBase16(s.nextLine());
		//Base2toBase10(s.nextLine());
		Base10toBase2(s.nextInt());
		//Base10toBase16(s.nextInt());
		//Base16toBase10(s.nextLine());
		
		s.close();
	}

}
