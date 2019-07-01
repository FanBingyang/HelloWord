package CommissionEmployee;
/*���ܼ�飺��װ�����۶���ɼӵ�н��Ա���Ļ�����Ϣ*/
public class BasePlusCommissionEmployee {
	private String name;               //Ա������
	private String ID;                 //Ա������
	private double grossSales;         //���۶�
	private double commissionRate;     //����� 
	private double baseSalary;         //��н
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
		return String.format("%s:%s\n%s:%s\n%s:%.2f\n%s:%.2f\n%s:%.2f","Ա������",name,"����",ID,"���۶�",grossSales,"�����",commissionRate,"������н",baseSalary);
	}

}
