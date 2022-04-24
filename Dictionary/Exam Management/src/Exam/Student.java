package Exam;

class Student 
{
	private Long enrollno,seatno;
	private String name,course;
	
	public Student(String name,Long enrollno,Long seatno,String course)
	{
		this.name=name;
		this.enrollno=enrollno;
		this.seatno=seatno;
		this.course=course;
	}
	
	public String getname()
	{return name;}
	public Long getenrollno()
	{return enrollno;}
	public Long getseatno()
	{return seatno;}
	public String getcourse()
	{return course;}
}
