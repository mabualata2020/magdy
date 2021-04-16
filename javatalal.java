
/*
Talal Albelwy



*/
import java.lang.*;
import java.util.*;

class Talal
{	
	String id;
	int balance;

	Talal(String i)
	{
		id = i;
		balance = 300;
	}

	void BalanceInq()
	{
		System.out.println("رقم الحساب :- " + id);
		System.out.println("الرصيد :- " + balance);
	}

	void withdraw()
	{
		int temp;
		Scanner sc = new Scanner(System.in);

		System.out.print("ادخل قيمة السجب :- ");
		temp = sc.nextInt();

		if(balance - temp < 300)
			System.out.println("اقل قيمة 300");
		else
		{
			balance = balance - temp;
			System.out.println("الرصيد الحالي  :- " + balance);
		}
	}

	void deposit()
	{
		int temp;
		Scanner sc = new Scanner(System.in);
	
		System.out.print("ادخل قيمة الايداع :- ");
		temp = sc.nextInt();

		balance = balance + temp;

		System.out.println("الرصيد الحالي :- " + balance);
	}

	void moneyTransfer(ArrayList ar)
	{
		int temp;
		String id;
		Scanner sc = new Scanner(System.in);
		Talal ac = null;

		System.out.print("ادخل رقم الحساب :- ");
		id = sc.next();

		Iterator itr = ar.iterator();
		while(itr.hasNext())
		{
			Talal a = (Talal) itr.next();

			if(id.equals(a.id))
				ac = a;
				
		}
		
		if(ac == null)
			System.out.println("الحساب غير موجود");
		else
		{ 
			System.out.print("ادخل القيمة  :- ");
			temp = sc.nextInt();

			if(temp > balance)
			System.out.println("الرصيد غير كافي ");
			else
			{
				ac.balance = ac.balance + temp;
				balance = balance - temp;
			}
		}
	}

	void Create(ArrayList arr)
	{
		String str;
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter ID :- ");
		str = sc.next();

		Talal ac = new Talal(str);
		arr.add(ac);
	}
	
	void delete(ArrayList arr)
	{
		String str;
		Scanner sc = new Scanner(System.in);
		Talal ac = null;

		System.out.print("Enter ID :- ");
		str = sc.next();

		Iterator itr = arr.iterator();
		while(itr.hasNext())
		{
			Talal a = (Talal) itr.next();
			if(str.equals(a.id))
				ac = a;			
		}
	
		if(ac == null)
			System.out.println("الحساب غير موجود");
		else
		{
			arr.remove(ac);
			System.out.println("تم الغاء الحساب بنجاح");
		}
	}
}

public class javatalal
{
	public static void main(String[] args)
	{
		ArrayList<Talal>arr = new ArrayList<Talal>();
		Scanner sc = new Scanner(System.in);
		String str;
		int op;
		Talal ac = null;
		Talal a = new Talal(null);

		arr.add(new Talal("1"));
		arr.add(new Talal("2"));
		arr.add(new Talal("3"));
		arr.add(new Talal("4"));
		arr.add(new Talal("5"));
		arr.add(new Talal("6"));
		arr.add(new Talal("7"));
		arr.add(new Talal("8"));
		arr.add(new Talal("9"));
		arr.add(new Talal("10"));

		System.out.print("ادخل رقم الحساب :- ");
		str = sc.next();

		Iterator itr = arr.iterator();
		while(itr.hasNext())
		{
			a = (Talal) itr.next();
			if(str.equals(a.id))
				ac = a;
		}

		if(ac == null)
		{
			System.out.println("حساب غير صحيح ");
			System.exit(0);
		}
		else
		{

		do
		{
			System.out.println("Press 1 -  الرصيد");
			System.out.println("Press 2 -  سحب");
			System.out.println("Press 3 -  ايداع");
			System.out.println("Press 4 - تحويل");
			System.out.println("Press 5 - انشاء حساب");
			System.out.println("Press 6 - الغاء حساب ");
			System.out.println("Press 0 - خروج من النظام");
		
			System.out.print("اختر احد الخيارات  => ");
			op = sc.nextInt();
		
				switch(op)
				{
					case 1:
						ac.BalanceInq();
						break;
					case 2:
						ac.withdraw();
						break;
					case 3:
						ac.deposit();
						break;
					case 4:
						ac.moneyTransfer(arr);
						break;
					case 5:
						ac.Create(arr);
						break;
					case 6:
						ac.delete(arr);
						break;
					case 0:
					System.out.println("شكرا ");
						break;
					default:
					System.out.println("ادخال خاطىء ");
				}
			}while(op != 0);
		}
}	
}