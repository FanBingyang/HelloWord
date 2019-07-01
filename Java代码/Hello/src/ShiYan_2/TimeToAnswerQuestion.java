package ShiYan_2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;
import javax.swing.*;

public class TimeToAnswerQuestion extends JFrame implements ActionListener, ItemListener {
    File questionFile;
    int MAX=10;
    int maxTime=MAX;
    int score=0;
    Timer time;
    JTextArea showQuestion;
    JCheckBox choiceA,choiceB,choiceC,choiceD;
    JLabel showScore,showTime;
    String correctAnswer;
    JButton reStart;
    FileReader inOne;
    BufferedReader inTwo;
    public TimeToAnswerQuestion(){
        time=new Timer(1000,this);
        showQuestion=new JTextArea(4,18);
        setLayout(new FlowLayout());
        showScore=new JLabel("分数"+score);
        showTime=new JLabel();
        add(showTime);
        add(new JLabel("问题："));
        add(showQuestion);
        choiceA=new JCheckBox("A");
        choiceB=new JCheckBox("B");
        choiceC=new JCheckBox("C");
        choiceD=new JCheckBox("D");
        choiceA.addItemListener(this);
        choiceB.addItemListener(this);
        choiceC.addItemListener(this);
        choiceD.addItemListener(this);
        add(choiceA);
        add(choiceB);
        add(choiceC);
        add(choiceD);
        add(showScore);
        reStart=new JButton("再做一遍");
        reStart.setEnabled(false);
        add(reStart);
        reStart.addActionListener(this);
        setBounds(200,200,330,300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void setMAX(int n){
        MAX=n;
    }
    public void setTestFlie(File f){
        questionFile=f;
        score=0;
        try{
            inOne=new FileReader(questionFile);
            inTwo=new BufferedReader(inOne);
            readOneQuestion();
            reStart.setEnabled(false);
        }
        catch (IOException exp){
            showQuestion.setText("没有选题");
        }
    }
    public void readOneQuestion() {
        showQuestion.setText(null);
        try {
            String s = null;
            while ((s = inTwo.readLine()) != null) {
                if (!s.startsWith("-")) {
                    showQuestion.append(s+"\n");
                    System.out.println(s);
                }
                else {
                    s = s.replaceAll("-", "");
                    correctAnswer = s;
                    break;
                }
            }
            time.start();
            if (s == null) {
            	inTwo.close();
            	reStart.setEnabled(true);
            	showQuestion.setText("题目完毕");
            	time.stop();
            }
        }catch (IOException exp){ }
    }
    public void itemStateChanged(ItemEvent e){
        JCheckBox box=(JCheckBox)e.getSource();
        String str=box.getText();
        boolean booOne=box.isSelected();
        boolean booTwo=str.compareToIgnoreCase(correctAnswer)==0;
        if (booOne&&booTwo){
            score++;
            showScore.setText("分数："+score);
            time.stop();
            maxTime=MAX;
            readOneQuestion();
        }
        box.setSelected(false);
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==time){
            showTime.setText("剩："+maxTime+"秒");
//            add(showTime);
            maxTime--;
            if (maxTime<=0){
                maxTime=MAX;
                readOneQuestion();
            }
        }
        else if (e.getSource()==reStart) {
            setTestFlie(questionFile);
        }
    }

    public static void main(String[] args) {
        TimeToAnswerQuestion ttaq=new TimeToAnswerQuestion();
        ttaq.setTitle("限时回答问题");
        ttaq.setTestFlie(new File("quesn.txt"));
        ttaq.setMAX(10);
    }
}
