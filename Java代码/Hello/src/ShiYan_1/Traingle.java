package ShiYan_1;

public class Traingle {
    private double size1;
    private double size2;
    private double size3;
    private boolean isTriangle;
    public Traingle(double size1,double size2,double size3){
    	this.size1=size1;
    	this.size2=size2;
    	this.size3=size3;
    	isTriangle=triangle();
    }
    
    private boolean triangle() {
    	if((size1+size2>size3)&&(size1+size3>size2)&&(size2+size3>size1)&&(size1-size2<size3)&&(size1-size3<size2)&&(size2-size3<size1))
    		return true;
		return false;
	}
    public void setSize1(double size1){
    	this.size1=size1;
    }
    public double getSize1(){
    	return size1;
    }
    
    public void setSize2(double size2){
    	this.size2=size2;
    }
    public double getSize2(){
    	return size2;
    }    

    public void setSize3(double size3){
    	this.size3=size3;
    }
    public double getSize3(){
    	return size3;
    }

    public boolean IsTriangle(){
    	return isTriangle;
    }
    public void setTriangle(boolean isTriangle){
    	this.isTriangle=isTriangle;
    }
    
    public double getMianJi(){
    	if(isTriangle){
    		double c=getZhouChang()/2;
    		return Math.sqrt(c*(c-size1)*(c-size2)*(c-size3));
    	}
    	throw new IllegalArgumentException("三边不能构成三角形！");
    }
    
    public double getZhouChang(){
    	if(isTriangle)
    		return size1+size2+size3;
    	throw new IllegalArgumentException("三边不能构成三角形！");
    }

	public static void main(String[] args) {
		Traingle traingle=new Traingle(3, 4, 5);
		System.out.println("三边为： "+traingle.getSize1()+" "+traingle.getSize2()+" "+traingle.getSize3());
		System.out.println("周长："+traingle.getZhouChang());
		System.out.println("面积："+traingle.getMianJi());
		traingle.setSize1(6);
		traingle.setSize2(8);
		traingle.setSize3(10);
		System.out.println("改变三边为： "+traingle.getSize1()+" "+traingle.getSize2()+" "+traingle.getSize3());
		System.out.println("周长："+traingle.getZhouChang());
		System.out.println("面积："+traingle.getMianJi());
	}

}
