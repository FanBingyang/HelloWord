package BookExample;

public class Time {
	private int hour;          //取值为0~23小时 
	private int minute;        //取值为0~59分
	private int second;        //取值为0~59秒
	public Time(int h,int m,int s){     //构造方法，该构造方法有3个参数
		setHour(h);     //调用方法
		setMinute(m);
		setSecond(s);
	}
	public Time(Time time){     //重载构造方法，参数是对象
		this(time.getHour(),time.getMinute(),time.getSecond());
	}
	public void setHour(int h){
		hour=((h>=0&&h<24)?h:0);     //小时应该在大于等于
	}
	public int getHour(){
		return hour;
	}
	public void setMinute(int m){
		minute=((m>=0&&m<60)?m:0);
	}
	public int getMinute(){
		return minute;
	}
	public void setSecond(int s){
		second=((s>=0&&s<60)?s:0);
	}
	public int getSecond(){
		return second;
	}
	public String toUniversalString(){   //通用时间格式显示（HH：MM：SS）
		return String.format("%02d:%02d:%02d",getHour(),getMinute(),getSecond());
	}
	public String toString(){   //标准格式显示（H:MM:SS AM or PM）
		return String.format("%d:%02d:%02d %s",((getHour()==0||getHour()==12)?12:getHour()%12),getMinute(),getSecond(),(getHour()<12?"AM":"PM"));
	}

}
