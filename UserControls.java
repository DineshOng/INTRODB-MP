import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UserControls{
  private MainFrame mf;
  private int found;

  public UserControls(MainFrame paramMainFrame){
    this.mf = paramMainFrame;

    actionCA(this.mf.getBTca());
    actionMyaccLogout(this.mf.getBTmyacclogout());
    actionSearchLogout(this.mf.getBTsearchlogout());
    actionLogin(this.mf.getBTlogin());
    actionMyaccUpdate(this.mf.getBTmyaccupdate());
    actionSearchMyacc(this.mf.getBTsearchmyaccount());
    actionMyaccHome(this.mf.getBTmyacchome());
    actionViewHome(this.mf.getBTviewhome());
    actionViewLogout(this.mf.getBTviewlogout());
    actionViewMyacc(this.mf.getBTviewmyaccount());
  }
  private void actionViewHome(JButton paramJButton){
    paramJButton.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent paramAnonymousMouseEvent){
        UserControls.this.mf.toSearchPage();
      }
    });
  }
  private void actionViewLogout(JButton paramJButton){
    paramJButton.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent paramAnonymousMouseEvent){
        UserControls.this.mf.getTFloginUserName().setText("");
        UserControls.this.mf.getPFlogin().setText("");
        UserControls.this.mf.toLogin();
      }
    });
  }
  private void actionViewMyacc(JButton paramJButton){
    paramJButton.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent paramAnonymousMouseEvent){
        UserControls.this.mf.toMyUserAccount();
      }
    });
  }

  private void actionMyaccHome(JButton paramJButton){
    paramJButton.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent paramAnonymousMouseEvent){
        UserControls.this.mf.toSearchPage();
      }
    });
  }
  private void actionMyaccLogout(JButton paramJButton){
    paramJButton.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent paramAnonymousMouseEvent){
        UserControls.this.mf.getTFloginUserName().setText("");
        UserControls.this.mf.getPFlogin().setText("");
        UserControls.this.mf.toLogin();
        try{
        UserControls.this.mf.getTabbedpane().removeTabAt(2);
      }catch (Exception e){
        System.out.println(e);
      }
      try{
      UserControls.this.mf.getTabbedpane().removeTabAt(2);
    }catch (Exception e){
      System.out.println(e);
    }
    try{
    UserControls.this.mf.getTabbedpane().removeTabAt(2);
  }catch (Exception e){
    System.out.println(e);
  }
      }
    });
  }
  private void actionMyaccUpdate(JButton paramJButton){
    paramJButton.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent paramAnonymousMouseEvent){
        try{
          Class.forName("com.mysql.jdbc.Driver");
          Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/ticketsdb?useSSL=false", "root", "1234");
          String sql = "UPDATE users SET Password=? WHERE Username=?";
          PreparedStatement ps = con.prepareStatement(sql);
          if(UserControls.this.mf.getPFmyacc().getPassword().length>=2){
          ps.setString(1, UserControls.this.mf.getPFmyacc().getText());
          ps.setString(2, UserControls.this.mf.getTFloginUserName().getText());
          int rowsUpdated = ps.executeUpdate();
          if (rowsUpdated > 0) {
            System.out.println("An existing user was updated successfully!");
          }
          JOptionPane.showMessageDialog(null,"PASSWORD UPDATED!",null,JOptionPane.INFORMATION_MESSAGE);
          UserControls.this.mf.getPFmyacc().setText("");
        }else JOptionPane.showMessageDialog(null,"PASSWORD CANNOT BE NULL OR LESS THAN 2 CHARACTERS!",null,JOptionPane.ERROR_MESSAGE);

      }catch (Exception er) {
        System.out.println (er);
      }
      }
    });
  }

  private void actionSearchMyacc(JButton paramJButton){
    paramJButton.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent paramAnonymousMouseEvent){
        UserControls.this.mf.toMyUserAccount();
      }
    });
  }
  private void actionSearchLogout(JButton paramJButton){
    paramJButton.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent paramAnonymousMouseEvent){
        UserControls.this.mf.getTFloginUserName().setText("");
        UserControls.this.mf.getPFlogin().setText("");
        UserControls.this.mf.toLogin();
        try{
        UserControls.this.mf.getTabbedpane().removeTabAt(2);
      }catch (Exception e){
        System.out.println(e);
      }
      try{
      UserControls.this.mf.getTabbedpane().removeTabAt(2);
    }catch (Exception e){
      System.out.println(e);
    }
    try{
    UserControls.this.mf.getTabbedpane().removeTabAt(2);
  }catch (Exception e){
    System.out.println(e);
  }
      }
    });
  }

  private void actionLogin(JButton paramJButton){
    paramJButton.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent paramAnonymousMouseEvent){
        try{
          found=0;
         Class.forName("com.mysql.jdbc.Driver");
         Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/ticketsdb?useSSL=false", "root", "1234");
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery ("select username, password, type from users");
         while(rs.next()){
           if(UserControls.this.mf.getTFloginUserName().getText().equals(rs.getString(1)) && UserControls.this.mf.getPFlogin().getText().equals(rs.getString(2)) && found!=1){
             found=1;
             if(rs.getString(3).equals("Admin")){
               JOptionPane.showMessageDialog(null,"ADMIN MODE!",null,JOptionPane.INFORMATION_MESSAGE);
               //UserControls.this.mf.toAdminPage();
                UserControls.this.mf.getBTmyacchome().setVisible(false);
               UserControls.this.mf.getTabbedpane().addTab("Add Event", null,  UserControls.this.mf.getaddeventpanel(), null);
               UserControls.this.mf.getTabbedpane().addTab("Edit Event", null,  UserControls.this.mf.getediteventpanel(), null);
               UserControls.this.mf.getTabbedpane().addTab("OLAP", null,  UserControls.this.mf.getolapanel(), null);
               UserControls.this.mf.setUserType("Admin");
               //UserControls.this.mf.getTabbedpane().removeTabAt(2);
               UserControls.this.mf.toMyUserAccount();

             }
             else {
               //JOptionPane.showMessageDialog(null,"USER MODE!",null,JOptionPane.INFORMATION_MESSAGE);
               UserControls.this.mf.toSearchPage();
               //UserControls.this.mf.toMyUserAccount();
                UserControls.this.mf.getBTmyacchome().setVisible(true);
               UserControls.this.mf.getTabbedpane().addTab("My Transactions", null,  UserControls.this.mf.getmytranspanel(), null);
               UserControls.this.mf.setUserType("User");
             }
           }
          }
          }catch (Exception ex) {
            System.out.println (ex);
          }
          if(found!=1)
            JOptionPane.showMessageDialog(null,"TRY AGAIN!",null,JOptionPane.ERROR_MESSAGE);
          else{
            try{
              Class.forName("com.mysql.jdbc.Driver");
              Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/ticketsdb?useSSL=false", "root", "1234");
              Statement stmt = con.createStatement();
              ResultSet rs = stmt.executeQuery("select concat(Firstname, ' ', LastName), username, email, MobileNum from users where username='"+UserControls.this.mf.getTFloginUserName().getText()+"'");
              while(rs.next()){
                UserControls.this.mf.getLB91().setText("Name : "+rs.getString(1));
                UserControls.this.mf.getLB92().setText("Username : "+rs.getString(2));
                UserControls.this.mf.getLB93().setText("E-mail Address : "+rs.getString(3));
                UserControls.this.mf.getLB94().setText("Mobile Number : "+rs.getString(4));
                System.out.println(rs.getString(1)+rs.getString(2)+rs.getString(3)+rs.getString(4));
              }
            }catch (Exception ex) {
              System.out.println (ex);
            }
          }
      }
    });
  }
  private void actionCA(JButton paramJButton){
    paramJButton.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent paramAnonymousMouseEvent){
        UserControls.this.mf.toRegister();
      }
    });
  }
}
