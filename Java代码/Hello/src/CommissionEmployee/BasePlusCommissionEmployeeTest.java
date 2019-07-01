package CommissionEmployee;

public class BasePlusCommissionEmployeeTest {

	public static void main(String[] args) {
		    BasePlusCommissionEmployee employee=new BasePlusCommissionEmployee("张志峰","000001",1000000,0.06,3600);
			System.out.println("员工基本情况如下：\n");
			System.out.printf("%s %s\n","员工姓名",employee.getName());
			System.out.printf("%s %s\n","员工工号",employee.getID());
			System.out.printf("%s %.2f\n","销售额",employee.gteGrossSales());
			System.out.printf("%s %.2f\n","提成率",employee.getCommissionRate());
			System.out.printf("%s %.2f\n","底薪",employee.getBaseSalary());
			System.out.printf("%s %.2f\n","员工工资",employee.earnings());
			employee.setGrossSales(2000000);
			System.out.printf("\n%s:\n\n%s\n","更新以后员工信息",employee.toString());
			System.out.printf("%s %.2f\n","员工工资",employee.earnings());
	}

}
