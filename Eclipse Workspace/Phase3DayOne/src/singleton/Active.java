package singleton;

class Active {

	private static Active obj;
	
	private String var1;
	private String var2;
	private int var3;
	
	private Active()
	{
		var1="this is variable 1";
		var2="this is variable 2";
		var3=50;
	}
	
	public static Active getsingletoninstance()
	{
		if(obj==null)
		{
			obj=new Active();
			return obj;
		}
		else
			return obj;
	}
}
