package ShiYan_1;

public class Billiards extends Ball{
	private String color;
	public Billiards(String color,double r){
		super(r);
		this.color=color;
	}
	public void setColor(String color){
		this.color=color;
	}
	public void show(){
		System.out.println("̨����ɫ��"+color+",\t̨��뾶��"+getR());
	}

}
