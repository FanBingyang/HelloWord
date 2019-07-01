package BookExample;

public class ShowTime {
	public static void main(String args[]){
	long totalMilliseconds = System.currentTimeMillis();
	long totalSeconds=totalMilliseconds/1000;
	long currentSecond=totalSeconds%60;
	long toatlMinutes=totalSeconds/60;
	long currentMinute=toatlMinutes%60;
	long totalHours=toatlMinutes/60;
	long currentHours=totalHours%24;
	System.out.println("Current time is "+currentHours+":"+currentMinute+":"+currentSecond+" GMT");
	}
}
