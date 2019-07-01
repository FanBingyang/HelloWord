package BookExample;
/*
     功能简介：通过if的嵌套使用来判断某个月是属于某个季节。
 */
public class StatementNestedSeason {
	public static void main(String args[]){
		String season;
		int month=5;
		if(month==3||month==4||month==5)
			season="春季";
		else if(month==6||month==7||month==8)
			season="夏季";
		else if(month==9||month==10||month==11)
			season="秋季";
		else if(month==12||month==1||month==2)
			season="冬季";
		else
			season="对不起，你选的月份不是1月~12月，不在一年四季中";
		System.out.println(season);
	}

}
