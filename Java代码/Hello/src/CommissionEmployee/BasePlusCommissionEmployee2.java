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
//		return basesSalary+(CommissionRate*grossSales);   //˽�б������ܱ�����
//	}
//	public String toString(){
		   //һ����ͼ���ø����˽�б����������쳣
//		return String.format("%s:%s\n%s:%s\n%s:%.2f\n%s:%.2f\n%s:%.2f","Ա������",name,"Ա������",ID,"���۶�",grossSales,"�����",commissionRate,"������н",basesSalary);
//	}

}
