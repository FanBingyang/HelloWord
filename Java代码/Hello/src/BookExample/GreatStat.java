package BookExample;

public class GreatStat {
	private String courseName;
	private int grades[];
	public GreatStat(String name,int gradesArray[]){
		courseName=name;
		grades=gradesArray;
	}
	public void setCourseName(String name){
		courseName=name;
	}
	public String getCourseName(){
		return courseName;
	}
	public void displayMessage(){
		System.out.printf("欢迎查看以下成绩：\n%s!\n\n",getCourseName());
	}
	public void ProcessGrades(){
		outputGrades();
		System.out.printf("\n平均分是：%.2f\n",getAverage());
		System.out.printf("最低分是： %d\n最高分是： %d\n\n",getMinimum(),getMaximum());
		outputBarChart();
	}
	public int getMinimum(){
		int lowGrade=grades[0];
		for(int grade:grades)
		{
			if(grade<lowGrade)
				lowGrade=grade;
		}
		return lowGrade;
	}
	
	public int getMaximum(){
		int highGrade=grades[0];
		for(int grade:grades){
			if(grade>highGrade)
				highGrade=grade;
		}
		return highGrade;
	}
	public double getAverage(){
		int total=0;
		for(int grade:grades)
			total+=grade;
		return (double)total/grades.length;
	}
	public void outputBarChart(){
		System.out.println("成绩分布率：");
		int frequency[]=new int[11];
		for(int grade:grades)
		++frequency[grade/10];
		for(int count=0;count<frequency.length;count++)
		{
			if(count==10)
				System.out.printf("%5d:",100);
			else
				System.out.printf("%02d-%02d:",count*10,count*10+9);
			for(int stars=0;stars<frequency[count];stars++)
				System.out.print("*");
			System.out.println();
		}
		
	}
	public void outputGrades(){
		System.out.println("成绩如下：\n");
		for(int student=0;student<grades.length;student++)
			System.out.printf("Student %2d:%3d\n",student+1,grades[student]);
	}
	public static void main(String args[]){
		int gradesArray[]={90,89,36,89,87,76,89,92,12,90};
		GreatStat myGrade=new GreatStat("Java程序设计成绩", gradesArray);
		myGrade.displayMessage();
		myGrade.ProcessGrades();
	}
}
