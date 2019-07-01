package ShiYan_2;
	

import java.awt.*;
import java.awt.Color;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.*;
import java.io.*;
import java.nio.channels.FileLockInterruptionException;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.lang.ClassNotFoundException;

public class JiShiBen extends JFrame implements ActionListener , DocumentListener{
    JMenu mFile,mEdit,mMode,mHelp;
    JMenuItem mFile_New,mFile_Open,mFile_Save,mFile_Exit;
    JMenuItem mEdit_Undo,mEdit_Cut,mEdit_Copy,mEdit_Paste,mEdit_Del,mEdit_SelectAll;
    JCheckBoxMenuItem formatMenu_LineWrap;
    JMenu formatMenu_Color;
    JMenuItem formatMenu_Color_FgColor,formatMenu_Color_BgColor;
    JCheckBoxMenuItem viewMenu_Status;
    JMenuItem mHelp_HelpTopics,mHelp_About;
    JPopupMenu popupMenu;
    JMenuItem popupMenu_Undo,popupMenu_Cut,popupMenu_Copy,popupMenu_Paste,popupMenu_Delete,popupMenu_SelectAll;
    static JTextArea Text;
    Toolkit toolkit=Toolkit.getDefaultToolkit();
    Clipboard clipBoard=toolkit.getSystemClipboard();
    protected UndoManager undo=new UndoManager();
    protected UndoableEditListener undoHandler=new UndoHandler();
    boolean isNewFile=true;
    File currentFile;
    String oldValue;
    JButton fontOkButton;
    protected Font defaultFont=new  Font("宋体",Font.PLAIN,12);
    File saveFileName=null,fileName=null;
    public JiShiBen() {
        super("记事本");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Container container=getContentPane();
        JScrollPane scroll=new JScrollPane(Text);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        Text.setWrapStyleWord(true);
        Text.setLineWrap(true);
        Text.setFont(defaultFont);
        Text.setBackground(Color.WHITE);
        Text.setForeground(Color.black);
        oldValue=Text.getText();
        Text.getDocument().addUndoableEditListener(undoHandler);
        Text.getDocument().addDocumentListener(this);
        JMenuBar MenuBar=new JMenuBar();
        mFile=new JMenu("文件(F)",true);
        mEdit=new JMenu("编辑(E)",true);
        mMode=new JMenu("格式(O)",true);
        mHelp=new JMenu("帮助(H)",true);
        mEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkMenuItemEnabled();
            }
        });
        mFile.setMnemonic('F');
        mEdit.setMnemonic('E');
        mMode.setMnemonic('O');
        mHelp.setMnemonic('H');
        MenuBar.add(mFile);
        MenuBar.add(mEdit);
        MenuBar.add(mMode);
        MenuBar.add(mHelp);
        mFile_New=new JMenuItem("新建(N)",'N');
        mFile_Open=new JMenuItem("打开(O)",'O');
        mFile_Save=new JMenuItem("保存(S)",'S');
        mFile_Exit=new JMenuItem("退出(X)",'X');
        mFile_New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
        mFile_Open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK));
        mFile_Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
        mFile_New.addActionListener(this);
        mFile_Open.addActionListener(this);
        mFile_Save.addActionListener(this);
        mFile.add(mFile_New);
        mFile.add(mFile_Open);
        mFile.add(mFile_Save);
        mFile.addSeparator();
        mFile.add(mFile_Exit);
        mEdit_Undo=new JMenuItem("撤销(U)",'U');
        mEdit_Cut=new JMenuItem("剪切(T)",'T');
        mEdit_Copy=new JMenuItem("复制(C)",'C');
        mEdit_Paste=new JMenuItem("粘贴(P)",'P');
        mEdit_Del=new JMenuItem("删除(L)",'L');
        mEdit_SelectAll=new JMenuItem("全选(A)",'A');
        mEdit_Cut.setEnabled(false);
        mEdit_Undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,InputEvent.CTRL_MASK));
        mEdit_Cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.CTRL_MASK));
        mEdit_Copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));
        mEdit_Paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,InputEvent.CTRL_MASK));
        mEdit_Del.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,0));
        mEdit_SelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.CTRL_MASK));
        mEdit_Undo.addActionListener(this);
        mEdit_Cut.addActionListener(this);
        mEdit_Copy.addActionListener(this);
        mEdit_Paste.addActionListener(this);
        mEdit_Del.addActionListener(this);
        mEdit_SelectAll.addActionListener(this);
        mEdit.add(mEdit_Undo);
        mEdit.addSeparator();
        mEdit.add(mEdit_Cut);
        mEdit.add(mEdit_Copy);
        mEdit.add(mEdit_Paste);
        mEdit.add(mEdit_Del);
        mEdit.addSeparator();
        mEdit.add(mEdit_SelectAll);
        formatMenu_LineWrap=new JCheckBoxMenuItem("自动换行(W)");
        formatMenu_LineWrap.setMnemonic('W');
        formatMenu_LineWrap.setState(true);
        formatMenu_Color=new JMenu("颜色");
        formatMenu_Color_FgColor=new JMenuItem("字体颜色");
        formatMenu_Color_BgColor=new JMenuItem("背景颜色");
        formatMenu_LineWrap.addActionListener(this);
        formatMenu_Color_FgColor.addActionListener(this);
        formatMenu_Color_BgColor.addActionListener(this);
        mMode.add(formatMenu_LineWrap);
        mMode.addSeparator();
        mMode.add(formatMenu_Color);
        formatMenu_Color.add(formatMenu_Color_FgColor);
        formatMenu_Color.add(formatMenu_Color_BgColor);
        viewMenu_Status=new JCheckBoxMenuItem("状态栏(S)");
        viewMenu_Status.setMnemonic('S');
        viewMenu_Status.setState(true);
        viewMenu_Status.addActionListener(this);
        mHelp_HelpTopics=new JMenuItem("帮助(H)",'H');
        mHelp_About=new JMenuItem("关于(A)",'A');
        mHelp_HelpTopics.addActionListener(this);
        mHelp_About.addActionListener(this);
        mHelp.add(mHelp_HelpTopics);
        mHelp.addSeparator();
        mHelp.add(mHelp_About);
        popupMenu=new JPopupMenu();
        popupMenu_Undo=new JMenuItem("撤销(U)",'U');
        popupMenu_Cut=new JMenuItem("剪切(C)",'C');
        popupMenu_Copy=new JMenuItem("复制(C)",'C');
        popupMenu_Paste=new JMenuItem("粘贴(P)",'P');
        popupMenu_Delete=new JMenuItem("删除(D)",'D');
        popupMenu_SelectAll=new JMenuItem("全选(A)",'A');
        popupMenu_Undo.setEnabled(false);
        popupMenu.add(popupMenu_Undo);
        popupMenu.addSeparator();
        popupMenu.add(popupMenu_Cut);
        popupMenu.add(popupMenu_Copy);
        popupMenu.add(popupMenu_Paste);
        popupMenu.add(popupMenu_Delete);
        popupMenu.addSeparator();
        popupMenu.add(popupMenu_SelectAll);
        popupMenu_Undo.addActionListener(this);
        popupMenu_Cut.addActionListener(this);
        popupMenu_Copy.addActionListener(this);
        popupMenu_Paste.addActionListener(this);
        popupMenu_Delete.addActionListener(this);
        popupMenu_SelectAll.addActionListener(this);
        Text.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e){
                checkForTriggerEvent(e);
            }
            public void mouseReleased(MouseEvent e){
                checkForTriggerEvent(e);
            }
            private void checkForTriggerEvent(MouseEvent e){
                if(e.isPopupTrigger())
                    popupMenu.show(e.getComponent(),e.getX(),e.getY());
                checkMenuItemEnabled();
                Text.requestFocus();
            }
        });
        this.setJMenuBar(MenuBar);
        container.add(scroll,BorderLayout.CENTER);
        this.pack();
        this.setSize(800,600);
        this.setLocation(250,50);
        this.setVisible(true);
        checkMenuItemEnabled();
        Text.requestFocus();
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                checkText();
            }
        });
    }
    public void checkText(){
        Text.requestFocus();
        String currentValue=Text.getText();
        boolean isTextChange=(currentValue.equals(oldValue))?false:true;
        if (isTextChange){
            int saveChoose=JOptionPane.showConfirmDialog(this,"您的文件尚未保存。是否保存？","提示",JOptionPane.YES_NO_CANCEL_OPTION);
        if (saveChoose==JOptionPane.YES_OPTION){
            JFileChooser fileChooser=new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setApproveButtonText("确定");
            fileChooser.setDialogTitle("另存为");
            int result=fileChooser.showSaveDialog(this);
            if (result==JFileChooser.CANCEL_OPTION){
                return;
            }
            saveFileName=fileChooser.getSelectedFile();
            if (saveFileName==null||saveFileName.getName().equals(""))
                JOptionPane.showMessageDialog(this,"不合法的文件名","不合法的文件名",JOptionPane.ERROR_MESSAGE);
            else{
                saveFile();
                Text.setText("");
                this.setTitle("新建文本");
            }
        }
            else if (saveChoose==JOptionPane.NO_OPTION){
                System.exit(0);
        }
            else if (saveChoose==JOptionPane.CANCEL_OPTION){
                Text.requestFocus();
        }
        }
        else if (!isTextChange){
            System.exit(0);
        }
    }
    public void checkMenuItemEnabled(){
        String selectText=Text.getSelectedText();
        if (selectText==null){
            mEdit_Cut.setEnabled(false);
            popupMenu_Cut.setEnabled(false);
            mEdit_Copy.setEnabled(false);
            popupMenu_Copy.setEnabled(false);
            mEdit_Del.setEnabled(false);
            popupMenu_Delete.setEnabled(false);
        }
        else{
            mEdit_Cut.setEnabled(true);
            popupMenu_Cut.setEnabled(true);
            mEdit_Copy.setEnabled(true);
            popupMenu_Copy.setEnabled(true);
            mEdit_Del.setEnabled(true);
            popupMenu_Delete.setEnabled(true);
        }
        Transferable contents=clipBoard.getContents(this);
        if (contents==null){
            mEdit_Paste.setEnabled(false);
            popupMenu_Paste.setEnabled(false);
        }
        else{
            mEdit_Paste.setEnabled(true);
            popupMenu_Paste.setEnabled(true);
        }
    }
    public int getlineNumber(){
        int totalLine=Text.getLineCount();
        int[] lineNumber=new int[totalLine+1];
        int pos=0,t=0,num=0,i=0;
        String s=Text.getText();
        while (true){
            pos=s.indexOf('\12',pos);
            if (pos==-1)
                break;
            lineNumber[t++]=pos++;
        }
        if (Text.getCaretPosition()<=lineNumber[0])
            num=1;
        else{
            if (Text.getCaretPosition()>lineNumber[Text.getLineCount()-1])
                num=Text.getLineCount();
            for (i=0;i<totalLine+1;i++){
                if (Text.getCaretPosition()<=lineNumber[i]){
                    num=i+1;
                    break;
            }else
                continue;
            }
        }
        return num;
    }
    private void saveFile(){
        try{
            FileWriter fw=new FileWriter(saveFileName);
            fw.write(Text.getText());
            fw.close();
        }catch (Exception e){
            e.getLocalizedMessage();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mFile_New) {
            Text.requestFocus();
            String currentValue = Text.getText();
            boolean isTextChange = (currentValue.equals(oldValue) ? false : true);
            if (isTextChange) {
                int saveChoose= JOptionPane.showConfirmDialog(this, "您的文件尚未保存。是否保存？", "提示", JOptionPane.YES_NO_CANCEL_OPTION);
                if (saveChoose == JOptionPane.YES_OPTION) {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    fileChooser.setApproveButtonText("确定");
                    fileChooser.setDialogTitle("另存为");
                    int result = fileChooser.showSaveDialog(this);
                    if (result == JFileChooser.CANCEL_OPTION) {
                        return;
                    }
                    saveFileName = fileChooser.getSelectedFile();
                    if (saveFileName == null || saveFileName.getName().equals(""))
                        JOptionPane.showMessageDialog(this, "不合法的文件名", "不合法的文件名", JOptionPane.ERROR_MESSAGE);
                    else {
                        saveFile();
                        Text.setText("");
                        this.setTitle("新建文本");
                    }
                } else if (saveChoose == JOptionPane.NO_OPTION) {
                    Text.replaceRange("", 0, Text.getText().length());
                    this.setTitle("无标题-记事本");
                    isNewFile = true;
                    undo.discardAllEdits();
                    mEdit_Undo.setEnabled(false);
                    popupMenu_Undo.setEnabled(false);
                    oldValue = Text.getText();
                } else if (saveChoose == JOptionPane.CANCEL_OPTION) {
                    return;
                }
            } else {
                Text.setText("");
                this.setTitle("无标题-记事本");
                isNewFile = true;
                undo.discardAllEdits();
                mEdit_Undo.setEnabled(false);
                popupMenu_Undo.setEnabled(false);
                oldValue = Text.getText();
            }
        } else if (e.getSource() == mFile_Open) {
            Text.requestFocus();
            String currentValue = Text.getText();
            boolean isTextChange = (currentValue.equals(oldValue)) ? false : true;
            if (isTextChange) {
                int saveChoose = JOptionPane.showConfirmDialog(this, "您的文件尚未保存。是否保存？", "提示", JOptionPane.YES_NO_CANCEL_OPTION);
                if (saveChoose == JOptionPane.YES_OPTION) {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    fileChooser.setApproveButtonText("确定");
                    fileChooser.setDialogTitle("另存为");
                    int result = fileChooser.showSaveDialog(this);
                    if (result == JFileChooser.CANCEL_OPTION) {
                        return;
                    }
                    fileName = fileChooser.getSelectedFile();
                    if (fileName == null || fileName.getName().equals(""))
                        JOptionPane.showMessageDialog(this, "不合法的文件名", "不合法的文件名", JOptionPane.ERROR_MESSAGE);

                    else {
                        saveFile();
                        isNewFile = false;
                        currentFile = saveFileName;
                        oldValue = Text.getText();
                        this.setTitle(saveFileName.getName() + "  -记事本");
                    }

                } else if (saveChoose == JOptionPane.NO_OPTION) {
                    String str = null;
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    fileChooser.setApproveButtonText("确定");
                    fileChooser.setDialogTitle("打开文件");
                    int result = fileChooser.showOpenDialog(this);
                    if (result == JOptionPane.CANCEL_OPTION) {
                        return;
                    }
                    fileName = fileChooser.getSelectedFile();
                    if (fileName == null || fileName.getName().equals(""))
                        JOptionPane.showMessageDialog(this, "不合法的文件名", "不合法的文件名", JOptionPane.ERROR_MESSAGE);
                    else {
                        try {
                            FileReader fr = new FileReader(fileName);
                            BufferedReader bfr = new BufferedReader(fr);
                            Text.setText("");
                            while ((str = bfr.readLine()) != null) {
                                Text.append(str + "\15\12");
                            }
                            this.setTitle(fileName.getName() + "记事本");
                            fr.close();
                            isNewFile = false;
                            currentFile = fileName;
                            oldValue = Text.getText();
                        } catch (IOException ioException) {
                        }
                    }
                } else {
                    return;
                }
            } else {
                String str = null;
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.setApproveButtonText("确定");
                fileChooser.setDialogTitle("打开文件");
                int result = fileChooser.showOpenDialog(this);
                if (result == JFileChooser.CANCEL_OPTION) {
                    return;
                }
                fileName = fileChooser.getSelectedFile();
                if (fileName == null || fileName.getName().equals(""))
                    JOptionPane.showMessageDialog(this, "不合法的文件名", "不合法的文件名", JOptionPane.ERROR_MESSAGE);
                else {
                    try {
                        FileReader fr = new FileReader(fileName);
                        BufferedReader bfr = new BufferedReader(fr);
                        Text.setText("");
                        while ((str = bfr.readLine()) != null) {
                            Text.append(str + "\15\12");
                        }
                        this.setTitle(fileName.getName() + "  -记事本");
                        fr.close();
                        isNewFile = false;
                        currentFile = fileName;
                        oldValue = Text.getText();

                    } catch (IOException ioException) {

                    }
                }
            }
        } else if (e.getSource() == mFile_Save) {
            Text.requestFocus();
            if (isNewFile) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.setApproveButtonText("确定");
                fileChooser.setDialogTitle("另存为");
                int result = fileChooser.showSaveDialog(this);
                if (result == JFileChooser.CANCEL_OPTION) {
                    return;
                }
                saveFileName = fileChooser.getSelectedFile();
                if (saveFileName == null || saveFileName.getName().equals(""))
                    JOptionPane.showMessageDialog(this, "不合法的文件名", "不合法的文件名", JOptionPane.ERROR_MESSAGE);

                else {
                    saveFile();
                    isNewFile = false;
                    currentFile = saveFileName;
                    oldValue = Text.getText();
                    this.setTitle(saveFileName.getName() + "  -记事本");
                }
            } else {
                try {
                    FileWriter fw = new FileWriter(currentFile);
                    BufferedWriter bfw = new BufferedWriter(fw);
                    bfw.write(Text.getText(), 0, Text.getText().length());
                    bfw.flush();
                    fw.close();
                } catch (IOException ioException) {

                }
            }
        } else if (e.getSource() == mFile_Exit) {
            int exitChoose = JOptionPane.showConfirmDialog(this, "确定要退出吗？", "提示", JOptionPane.OK_CANCEL_OPTION);
            if (exitChoose == JOptionPane.OK_OPTION) {
                checkText();
            } else {
                return;
            }
        } else if (e.getSource() == mEdit_Undo || e.getSource() == popupMenu_Undo) {
            Text.requestFocus();
            if (undo.canUndo()) {
                try {
                    undo.undo();
                } catch (CannotUndoException ex) {
                    ex.printStackTrace();
                }
                if (!undo.canUndo()) {
                    mEdit_Undo.setEnabled(false);
                    popupMenu_Undo.setEnabled(false);
                }
            }
        } else if (e.getSource() == mEdit_Cut || e.getSource() == popupMenu_Cut) {
            Text.requestFocus();
            String text = Text.getSelectedText();
            StringSelection selection = new StringSelection(text);
            clipBoard.setContents(selection, null);
            Text.replaceRange("", Text.getSelectionStart(), Text.getSelectionEnd());
            checkMenuItemEnabled();
        } else if (e.getSource() == mEdit_Copy || e.getSource() == popupMenu_Copy) {
            Text.requestFocus();
            String text = Text.getSelectedText();
            StringSelection selection = new StringSelection(text);
            clipBoard.setContents(selection, null);
            checkMenuItemEnabled();
        } else if (e.getSource() == mEdit_Paste || e.getSource() == popupMenu_Paste) {
            Text.requestFocus();
            Transferable contents = clipBoard.getContents(this);
            if (contents == null)
                return;
            String text;
            text = "";
            try {
                text = (String) contents.getTransferData(DataFlavor.stringFlavor);
            } catch (Exception exception) {
            }
            Text.replaceRange("", Text.getSelectionStart(), Text.getSelectionEnd());
            checkMenuItemEnabled();
        } else if (e.getSource() == mEdit_Del || e.getSource() == popupMenu_Delete) {
            Text.requestFocus();
            ;
            Text.replaceRange("", Text.getSelectionStart(), Text.getSelectionEnd());
            checkMenuItemEnabled();
        } else if (e.getSource() == mEdit_SelectAll || e.getSource() == popupMenu_SelectAll) {
            Text.selectAll();
        } else if (e.getSource() == formatMenu_Color_FgColor) {
            Text.requestFocus();
            Color color = JColorChooser.showDialog(this, "更改字体颜色", Color.BLACK);
            if (color != null) {
                Text.setForeground(color);
            } else
                return;
        } else if (e.getSource() == formatMenu_Color_BgColor) {
            Text.requestFocus();
            Color color = JColorChooser.showDialog(this, "更改背景颜色", Color.WHITE);
            if (color != null) {
                Text.setForeground(color);
            } else
                return;
        } else if (e.getSource() == mHelp_HelpTopics) {
            JOptionPane.showMessageDialog(this, "记事本支持拖入文本读取\n" + "", "帮助主题", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == mHelp_About) {
            JOptionPane.showMessageDialog(this, "记事本\n" + "欢迎使用本项目练习\n" + "项目练习\n", "关于记事本", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    @Override
    public void insertUpdate(DocumentEvent e) {
        mEdit_Undo.setEnabled(true);
        popupMenu_Undo.setEnabled(true);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        mEdit_Undo.setEnabled(true);
        popupMenu_Undo.setEnabled(true);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        mEdit_Undo.setEnabled(true);
        popupMenu_Undo.setEnabled(true);
    }
    class UndoHandler implements UndoableEditListener{
        public void undoableEditHappened(UndoableEditEvent uee){
            undo.addEdit(uee.getEdit());
        }
    }

    public static void main(String s[]) throws ClassNotFoundException,InstantiationException,IllegalAccessException,UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        Text=new JTextArea();
        Text.setDragEnabled(true);
        new JiShiBen();
    }
}


