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
	
	public Active getsingletoninstance()
	{
		if(this.obj==null)
		{
			this.obj=new Active();
			return this.obj;
		}
		else
			return this.obj;
	}
}
