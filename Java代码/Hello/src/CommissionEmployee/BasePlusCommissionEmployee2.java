package CommissionEmployee;

public class BasePlusCommissionEmployee2  extends CommissionEmployee{
	private double basesSalary;
	public BasePlusCommissionEmployee2(String name,String ID,double sales,double rate,double salary){
		super(name,ID,sales,rate);
		setBaseSalary(salary);
	}
	public void setBaseSalary(double salary){
		basesSalary=(salary<0.0)?0.0:salary;
}
	public double getBaseSalary(){
		return basesSalary;
	}
//	public double earnings(){
//		return basesSalary+(CommissionRate*grossSales);   //私有变量不能被访问
//	}
//	public String toString(){
		   //一下试图引用父类的私有变量，将报异常
//		return String.format("%s:%s\n%s:%s\n%s:%.2f\n%s:%.2f\n%s:%.2f","员工姓名",name,"员工工号",ID,"销售额",grossSales,"提成率",commissionRate,"基本底薪",basesSalary);
//	}

}
