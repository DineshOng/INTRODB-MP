import java.awt.EventQueue;

public class smdb{
  public static void main(String[] args){
    EventQueue.invokeLater(new Runnable(){
      public void run(){
        try{
          MainFrame mainframe = new MainFrame();
          UserControls localUserControls = new UserControls(mainframe);
          mainframe.getFrame().setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
}
    
