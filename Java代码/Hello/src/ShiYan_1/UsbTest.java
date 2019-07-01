package ShiYan_1;

public class UsbTest {

	public static void main(String[] args) {
		UsbDiskWriter diskWriter=new UsbDiskWriter();
		UsbCamera camera=new UsbCamera();
		UsbMobile mobile=new UsbMobile();
		diskWriter.start();
		diskWriter.stop();
		camera.start();
		camera.stop();
		mobile.start();
		mobile.stop();
	}

}
