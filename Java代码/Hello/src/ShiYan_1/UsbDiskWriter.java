package ShiYan_1;

public class UsbDiskWriter implements Usb{
	public void start(){
		System.out.println("开始访问U盘");
	}
	public void stop(){
		System.out.println("停止访问U盘");
	}
}
