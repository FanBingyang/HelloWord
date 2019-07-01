package ShiYan_2;

import java.io.RandomAccessFile;

public class FeiBoNaQi {
	private int n = 10;
	public FeiBoNaQi() {
		try {
			RandomAccessFile file = new RandomAccessFile("fei.dat", "rw");
			
			file.write(("斐波那契数列前十项："+"\r\n").getBytes());
			for (int i = 1; i <=n ; i++) {
				int temp = fb(i);
				file.write((temp + "\r\n").getBytes()); 
			}
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int fb(int n) {
		return n < 2 ? n:fb(n-1)+fb(n-2);
	}
	
	public static void main(String[] args) {
		new FeiBoNaQi();
	}
	
	
}
