package PackageDemo;

public class Project1 {
	 static int i =90;
	public static void main(String[] args) {
		
		int add = addition();
		System.out.println(add);
		int sub = substraction();
		System.out.println(sub);
	}

	public static int addition()
	{
		i = i+25;
		return i;
	}
	public static int substraction()
	{
		i = i-5;
		return i;
	}

}
