package BookExample;

public class Time {
	private int hour;          //ȡֵΪ0~23Сʱ 
	private int minute;        //ȡֵΪ0~59��
	private int second;        //ȡֵΪ0~59��
	public Time(int h,int m,int s){     //���췽�����ù��췽����3������
		setHour(h);     //���÷���
		setMinute(m);
		setSecond(s);
	}
	public Time(Time time){     //���ع��췽���������Ƕ���
		this(time.getHour(),time.getMinute(),time.getSecond());
	}
	public void setHour(int h){
		hour=((h>=0&&h<24)?h:0);     //СʱӦ���ڴ��ڵ���
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
	public String toUniversalString(){   //ͨ��ʱ���ʽ��ʾ��HH��MM��SS��
		return String.format("%02d:%02d:%02d",getHour(),getMinute(),getSecond());
	}
	public String toString(){   //��׼��ʽ��ʾ��H:MM:SS AM or PM��
		return String.format("%d:%02d:%02d %s",((getHour()==0||getHour()==12)?12:getHour()%12),getMinute(),getSecond(),(getHour()<12?"AM":"PM"));
	}

}
