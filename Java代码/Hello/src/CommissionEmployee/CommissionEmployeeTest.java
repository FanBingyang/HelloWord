package CommissionEmployee;

public class CommissionEmployeeTest {
	public static void main(String args[]){
		CommissionEmployee employee=new CommissionEmployee("��־��","000001",1000000,.06);
		System.out.println("Ա������������£�\n");
		System.out.printf("%s %s\n","Ա������",employee.getName());
		System.out.printf("%s %s\n","Ա������",employee.getID());
		System.out.printf("%s %.2f\n","���۶�",employee.getGrossSales());
		System.out.printf("%s %.2f\n","�����",employee.getCommissionRate());
		System.out.printf("%s %.2f\n","Ա������",employee.earnings());
		employee.setGrossSales(500000);
		employee.setCommissionRate(.1);
		System.out.printf("\n%s:\n\n%s\n","�����Ժ�Ա����Ϣ",employee);
		System.out.printf("%s %.2f\n","Ա������",employee.earnings());
	}

}
