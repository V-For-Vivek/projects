package Exam;

class TimeT 
{
	private int subcode,date;
	private String time,subject,scheme;
	
	public TimeT(String time,int subcode,String subject,String scheme,int date)
	{
		this.time=time;
		this.subcode=subcode;
		this.subject=subject;
		this.scheme=scheme;
		this.date=date;
	}
	
	public String getTime()
	{
		return time ;
	}
	public int getsubcode()
	{
		return subcode;
	}
	public String getsub()
	{
		return subject;
	}
	public String getscheme()
	{
		return scheme;
	}
	public int getdate()
	{
		return date;	
	}
}

