package ClientDemo;

import javax.swing.*;

public class CutPanle {

    public CutPanle(){}

    /**
     * 打开系统再带的截图功能，对外提供截图方法
     */
    public static void Cut(){
        final Runtime runtime = Runtime.getRuntime();
        Process process = null;
        try {
            final String command = "SnippingTool";// 打开windows自带的截图软件
            process = runtime.exec(command);
        } catch (final Exception ee) {
            JOptionPane.showMessageDialog(null,"该操作系统不支持截图");
            System.out.println("Error win exec!");
        }
    }

}
