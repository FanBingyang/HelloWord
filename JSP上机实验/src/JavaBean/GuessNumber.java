package JavaBean;

public class GuessNumber{
   int answer=0;//ϵͳ������ɵ�һ����
   int guessNumber=0;//�û��µ���
   int guessCount=0; //�û��µĴ���
   String result=null; 
   boolean right=false;
   public void setAnswer(int answer){
      this.answer=answer;
      guessCount=0;
   }
   public int  getAnswer(){
      return answer;
   }
   public void  setGuessNumber(int guessNumber){
      this.guessNumber=guessNumber;
      guessCount++;
      if(guessNumber==answer){
         result="��ϲ��¶��ˣ�";
         right=true;
      }
      else if(guessNumber>answer){
         result="������˼����´��ˣ�";
         right=false;  
     }
     else if(guessNumber<answer){
         result="������˼�����С�ˣ�";
         right=false; 
     }
     else if(this.answer==-1||this.answer>100){
         result="������1-100��������";
         right=false; 
         
     }
   }
   public int getGuessNumber(){
      return guessNumber;
   }
   public int getGuessCount(){
      return guessCount;
   }
   public String getResult(){
      return result;
   }
   public boolean isRight(){
      return right;
   }
}