package BookExample;
/*
     功能简介：if语句嵌套使用，用于判断考试等级，分数是100分制，判断等级标准为优秀（大于等于90分）、良好（大于等于80，
     小于90）、中等（大于等于70分，小于80分）、及格（大于等于60分，小于70分）和不及格（小于60分）。本程序可以实现对任
     意输入的一个float类型的100以内的非负数惊醒成绩等级判断。
 */
import java.util.Scanner;

public class StatementNestedScore {
	public static void main(String args[]){
		float score;
		Scanner input=new Scanner(System.in);
		System.out.println("请输入成绩：");
		score=input.nextFloat();
		if(score<90)
			if(score<80)
				if(score<70)
					if(score<60)
						System.out.println("你的成绩等级为：不及格！");
					else
						System.out.println("你的成绩等级为：及格！");
				else
					System.out.println("你的成绩等级为：中等！");
			else
				System.out.println("你的成绩等级为：良好！");
		else
			System.out.println("你的成绩等级为：优秀！");
	}

}
