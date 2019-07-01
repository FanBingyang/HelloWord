package ShiYan_1;

public class JvXing {
	private double chang;
	private double wide;
	public void setChang(double chang){
		this.chang=chang;
	}
	public double getChang(){
		return chang;
	}
	public void setWide(double wide){
		this.wide=wide;
	}
	public double getWide(){
		return wide;
	}
	public double zhouchang(){
		return 2*(chang+wide);
	}
	public double mianji(double chang,double wide){
		return chang*wide;
	}
}
