package CommissionEmployee;
/*功能简介：封装按销售额提成加底薪的员工的基本信息*/
public class BasePlusCommissionEmployee {
	private String name;               //员工工号
	private String ID;                 //员工工号
	private double grossSales;         //销售额
	private double commissionRate;     //提成率 
	private double baseSalary;         //底薪
	public BasePlusCommissionEmployee(String name,String ID,double sales,double rate,double salary)
	{
		this.name=name;
		this.ID=ID;
		setGrossSales(sales);
		setCommissionRate(rate);
		setBaseSalary(salary);
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setID(String ID){
		this.ID=ID;
	}
	public String getID(){
		return ID;
	}
	public void setGrossSales(double sales){
		grossSales=(sales<0.0)?0.0:sales;
	}
	public double gteGrossSales(){
		return grossSales;
	}
	public void setCommissionRate(double rate){
		commissionRate=(rate>0.0&&rate<1.0)?rate:0.0;
	}
	public double getCommissionRate(){
		return commissionRate;
	}
	public void setBaseSalary(double salary){
		baseSalary=(salary<0.0)?0.0:salary;;
	}
	public double getBaseSalary(){
		return baseSalary;
	}
	
	public double earnings(){
		return baseSalary+(commissionRate*grossSales);
	}
	public String toString(){
		return String.format("%s:%s\n%s:%s\n%s:%.2f\n%s:%.2f\n%s:%.2f","员工姓名",name,"工号",ID,"销售额",grossSales,"提成率",commissionRate,"基本底薪",baseSalary);
	}

}
