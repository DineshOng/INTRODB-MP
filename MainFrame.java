import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;


public class MainFrame{
  private JFrame frame;
  private JLabel lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9, lb10, lb11, lb12, lb13, lb14, lb15, lb16, lb91, lb92, lb93, lb94;
  private JTextField tfregUserName, tf2, tfregFN, tfregMN, tfregLN, tfregAddress, tfregCountry, tfregState, tfregEmail, tfregMobile, tfsearch, tfloginUserName;
  private JPasswordField pfregister, pflogin, pfmyacc;
  private JComboBox  cbday, cbyear;
  private JComboBox cbmonth, cbtype, cbdatetime, cbcs, cbaddday, cbaddyear, cbaddmonth, cbaddhour, cbaddminute, cbaddseconds;
  private JButton btlogin, btcreateacc, btback, btsearch, btsearchmyaccount, btsearchlogout, btmyacclogout, btregister, btmyaccupdate, btmyacchome;
  private JPanel login, transpanel, mytranspanel;
  private JPanel register, searchpage, useraccountpage, viewevent;
  private JRadioButton rbmale, rbfemale;
  private ButtonGroup bg;
  private int found;
  private JTabbedPane tabbedPane;
  private String UserType;
  private JLabel lbeventID;
  private JButton btviewlogout, btviewmyaccount, btviewhome;
  private JTextArea tfdesc, taadddesc;
  private JLabel lbCategory, lbEventName, lbEventPlace;
  private ArrayList showids, upshowids, upticketids, eventids;
  private JPanel addeventpanel, editeventpanel, olapanel, olapanel1;
  private JTextField tfaddname, tfaddplace, tfaddticketname, tfaddonlinefee, tfaddticketprice, tfaddticketquantity;
  private JComboBox cbaddcategory;
  private JButton btaddevent, btaddticket, btaddshowtime, btaddnewevent, btaddticketdone, btaddshowtimedone;
  private int addeventid, addshowid, addticketid;
  private JButton btupdateshow, btupdateevent, btupdateticket, btcheventok, btchshowok, btchticketok;
  private JComboBox cbchevent, cbchshow, cbchticket, cbupmonth, cbupday, cbupyear, cbuphour, cbupminute, cbupseconds, cbupeventcategory;
  private JTextField tfupeventname, tfupeventplace, tfupeventonlinefee, tfupticketname, tfupquantity, tfupprice;
  private JTextArea taupeventdesc;
  private String[] Category = {"Attractions", "Arts & Science", "Family", "Hotels & Travel", "Music & Concerts", "Performing Arts", "Sports", "Others"};
  private String[] Month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
  private JComboBox cbsearchevents, cbsearchcategory, cbsearchshowtime;
  private JButton btsearchgo;
  private int totaltickets;
  private Double totalprice;
  private Double totaltotal;
  private ArrayList altickid, alquant;
  private int transid;
  private Double onlinefee;
  private JButton pay;
  private JLabel title, totick, toprice, transidd, place, date, transdate, name, username;
  private JDialog report;
  private int origquant;
  public MainFrame(){
    this.frame=new JFrame();

    this.frame.setTitle("Tickets DB");
    this.frame.setBounds(55, 10, 800, 600);
    this.frame.setResizable(false);
    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Login();
    Register();
    SearchPage();
    MyUserAccountPage();
    ViewEvent();
    totalreport();

    this.lbeventID = new JLabel();
    this.showids = new ArrayList();
    this.upshowids = new ArrayList();
    this.upticketids = new ArrayList();
    this.eventids = new ArrayList();

    this.altickid = new ArrayList();
    this.alquant = new ArrayList();

    this.frame.add(this.login);
    this.frame.revalidate();
    this.frame.repaint();
    this.frame.setVisible(true);
  }
  public JDialog getreport(){
    return report;
  }
  public JLabel gettitle(){
    return title;
  }
  public JLabel gettotick(){
    return totick;
  }
  public JLabel gettoprice(){
    return toprice;
  }
  public JLabel gettransidd(){
    return transidd;
  }
  public JLabel getplace(){
    return place;
  }
  public JLabel getdate(){
    return date;
  }
  public JLabel gettransdate(){
    return transdate;
  }
  public JLabel getname(){
    return name;
  }
  public JLabel getusername(){
    return username;
  }
  public JPanel getaddeventpanel(){
    return addeventpanel;
  }
  public JPanel getediteventpanel(){
    return editeventpanel;
  }
  public JTabbedPane getTabbedpane(){
    return tabbedPane;
  }
  public JButton getBTviewhome(){
    return btviewhome;
  }
  public JButton getBTviewmyaccount(){
    return btviewmyaccount;
  }
  public JButton getBTviewlogout(){
    return btviewlogout;
  }
  public void setUserType(String i){
    this.UserType=i;
  }
  public String getUserType(){
    return UserType;
  }
  public JFrame getFrame(){
    return frame;
  }
  public JButton getBTca(){
    return btcreateacc;
  }
  public JButton getBTmyaccupdate(){
    return btmyaccupdate;
  }
  public JButton getBTmyacchome(){
    return btmyacchome;
  }
  public JButton getBTlogin(){
    return btlogin;
  }
  public JButton getBTmyacclogout(){
    return btmyacclogout;
  }
  public JButton getBTsearchmyaccount(){
    return btsearchmyaccount;
  }
  public JTextField getTFloginUserName(){
    return tfloginUserName;
  }
  public JPasswordField getPFlogin(){
    return pflogin;
  }
  public JPasswordField getPFmyacc(){
    return pfmyacc;
  }
  public JButton getBTsearchlogout(){
    return btsearchlogout;
  }
  public JLabel getLB91(){
    return lb91;
  }
  public JLabel getLB92(){
    return lb92;
  }
  public JLabel getLB93(){
    return lb93;
  }
  public JLabel getLB94(){
    return lb94;
  }
  public JPanel getmytranspanel(){
    return mytranspanel;
  }
  public JPanel getolapanel(){
    return olapanel;
  }
  public void toLogin(){
    this.frame.remove(this.register);
    this.frame.remove(this.searchpage);
    this.frame.remove(this.viewevent);
    this.frame.remove(this.useraccountpage);
    this.frame.add(this.login);
    this.frame.revalidate();
    this.frame.repaint();
  }
  public void toRegister(){
    this.frame.remove(this.login);
    this.frame.add(this.register);
    this.frame.revalidate();
    this.frame.repaint();
  }
  public void toSearchPage(){
    this.frame.remove(this.login);
    this.frame.remove(this.register);
    this.frame.remove(this.useraccountpage);
    this.frame.remove(this.viewevent);
    this.frame.add(this.searchpage);
    this.searchpage.revalidate();
    this.searchpage.repaint();
    this.frame.revalidate();
    this.frame.repaint();
  }
  public void toMyUserAccount(){
    this.transpanel.removeAll();
    MyTransRowwe tr0 = new MyTransRowwe();
    tr0.getdate().setText("Transaction Date");
    tr0.getdate().setHorizontalAlignment(SwingConstants.CENTER);
    tr0.getname2().setText("Event Name");
    tr0.getname2().setHorizontalAlignment(SwingConstants.CENTER);
    tr0.gettime().setText("Showtime");
    tr0.gettime().setHorizontalAlignment(SwingConstants.CENTER);
    tr0.getquantity().setText("Quantity");
    tr0.getquantity().setHorizontalAlignment(SwingConstants.CENTER);
    tr0.gettotal().setText("Total Amount");
    tr0.gettotal().setHorizontalAlignment(SwingConstants.CENTER);
    tr0.setBackground(new Color(32, 178, 170));
    tr0.remove(tr0.getname());
    this.transpanel.add(tr0);
    try{
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/ticketsdb?useSSL=false", "root", "1234");
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery ("select t.transdatetime, e.name, s.datetime, sum(l.quantity), t.total from transactions t, events e, showtime s, lineitem l, tickets tt where t.BuyerID='"+this.tfloginUserName.getText()+"'and t.TransactionID=l.TransID and l.ticketid=tt.TicketID and tt.ShowID=s.ShowID and s.EventID=e.EventID group by t.transactionid order by t.Transdatetime desc");
      while(rs.next()){
        MyTransRowwe tr = new MyTransRowwe();
        tr.getdate().setText(rs.getString(1));
        tr.getname().setText(rs.getString(2));
        tr.gettime().setText(rs.getString(3));
        tr.getquantity().setText(rs.getString(4));
        tr.gettotal().setText("PhP "+rs.getString(5));
        tr.remove(tr.getname2());
        this.transpanel.add(tr);
      }
    }catch (Exception e){
      System.out.println(e);
    }
    this.frame.remove(this.login);
    this.frame.remove(this.register);
    this.frame.remove(this.searchpage);
    this.frame.remove(this.viewevent);
    this.frame.add(this.useraccountpage);
    this.frame.revalidate();
    this.frame.repaint();
  }
  public void toViewEvent(String s){
    System.out.println("s "+s);
    this.lbeventID.setText(s);
    try{
     Class.forName("com.mysql.jdbc.Driver");
     Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/ticketsdb?useSSL=false", "root", "1234");
     Statement stmt = con.createStatement();
     ResultSet rs = stmt.executeQuery ("select name, place, category, description from events where eventID='"+s+"'");
     while(rs.next()){
       this.lbEventName.setText(rs.getString(1));
       this.lbEventPlace.setText(rs.getString(2));
       this.lbCategory.setText(rs.getString(3));
       this.tfdesc.setText(rs.getString(4));
     }
      }catch (Exception ex) {
        System.out.println (ex);
      }
      this.showids.clear();
      this.cbdatetime.removeAllItems();
      try{
       Class.forName("com.mysql.jdbc.Driver");
       Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/ticketsdb?useSSL=false", "root", "1234");
       Statement stmt = con.createStatement();
      ResultSet rs1 = stmt.executeQuery ("select s.datetime, s.showid from showtime s, events e where e.eventid=s.EventID and e.eventid='"+s+"'");
      while(rs1.next()){
        this.cbdatetime.addItem(rs1.getString(1));
        this.showids.add(rs1.getString(2));

      }
    }catch (Exception ex) {
      System.out.println (ex);
    }
    onlinefee=0.0;
    try{
     Class.forName("com.mysql.jdbc.Driver");
     Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/ticketsdb?useSSL=false", "root", "1234");
     Statement stmt = con.createStatement();
    ResultSet rs2 = stmt.executeQuery ("select onlinefee from events where eventID='"+s+"'");
      while(rs2.next()){
        onlinefee=rs2.getDouble(1);
    }
    }catch (Exception ex) {
    System.out.println (ex);
    }
    System.out.println(this.showids);
    this.frame.remove(this.searchpage);
    this.frame.add(this.viewevent);
    this.frame.revalidate();
    this.frame.repaint();
  }

  private void MyUserAccountPage(){
    this.useraccountpage = new JPanel();
    this.useraccountpage.setLayout(null);

    this.btmyacchome = new JButton("Home");
    this.btmyacchome.setBounds(10, 11, 89, 23);
    this.useraccountpage.add(this.btmyacchome);

    this.btmyacclogout = new JButton("Logout");
    this.btmyacclogout.setBounds(685, 11, 89, 23);
    this.useraccountpage.add(this.btmyacclogout);

    this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
    this.tabbedPane.setBounds(0, 45, 784, 517);
    this.useraccountpage.add(this.tabbedPane);

    JPanel panel_2 = new JPanel();
		this.tabbedPane.addTab("My Profile", null, panel_2, null);
		panel_2.setLayout(null);

		this.lb91 = new JLabel("Name");
		this.lb91.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.lb91.setBounds(56, 64, 609, 22);
    panel_2.add(this.lb91);

		this.lb92 = new JLabel("Username");
		this.lb92.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.lb92.setBounds(56, 97, 609, 22);
    panel_2.add(this.lb92);

		this.lb93 = new JLabel("Email");
		this.lb93.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.lb93.setBounds(56, 130, 609, 22);
    panel_2.add(this.lb93);

    this.lb94 = new JLabel("Mobile");
		this.lb94.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.lb94.setBounds(56, 163, 609, 22);
    panel_2.add(this.lb94);

    JPanel changePassPanel = new JPanel();
    this.tabbedPane.addTab("Change Password", null, changePassPanel, null);
    changePassPanel.setLayout(null);

    this.lb10 = new JLabel("Enter New Password");
    this.lb10.setBounds(243, 125, 216, 14);
    changePassPanel.add(this.lb10);

    this.pfmyacc = new JPasswordField();
    this.pfmyacc.setColumns(10);
    this.pfmyacc.setBounds(243, 142, 285, 20);
    changePassPanel.add(this.pfmyacc);

    this.btmyaccupdate = new JButton("Update");
    this.btmyaccupdate.setBounds(307, 297, 164, 40);
    changePassPanel.add(this.btmyaccupdate);

    this.mytranspanel = new JPanel();
		//this.tabbedPane.addTab("My Transactions", null, this.mytranspanel, null);
		this.mytranspanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 779, 489);
		this.mytranspanel.add(scrollPane);

		this.transpanel = new JPanel();
		scrollPane.setViewportView(this.transpanel);
		this.transpanel.setLayout(new GridLayout(20, 1, 0,10));

    this.addeventpanel = new JPanel();
    //this.tabbedPane.addTab("Add Event", null,  this.addeventpanel, null);
    this.addeventpanel.setLayout(null);

    JLabel lblEventName = new JLabel("Event Name:");
		lblEventName.setBounds(10, 11, 92, 14);
		this.addeventpanel.add(lblEventName);

		this.tfaddname = new JTextField(10);
		this.tfaddname.setBounds(10, 27, 200, 20);
		this.addeventpanel.add(this.tfaddname);

		JLabel lblEventPlace = new JLabel("Event Place :");
		lblEventPlace.setBounds(10, 58, 92, 14);
		this.addeventpanel.add(lblEventPlace);

    JLabel lblOnlineFee = new JLabel("Online Fee :");
		lblOnlineFee.setBounds(10, 257, 92, 14);
		this.addeventpanel.add(lblOnlineFee);

    this.tfaddonlinefee = new JTextField();
		this.tfaddonlinefee.setColumns(10);
		this.tfaddonlinefee.setBounds(10, 271, 200, 20);
		this.addeventpanel.add(this.tfaddonlinefee);

		this.tfaddplace = new JTextField();
		this.tfaddplace.setColumns(10);
		this.tfaddplace.setBounds(10, 72, 200, 20);
		this.addeventpanel.add(this.tfaddplace);

		JLabel lblEventCategory = new JLabel("Event Category :");
		lblEventCategory.setBounds(10, 102, 92, 14);
		this.addeventpanel.add(lblEventCategory);

    //String[] Category = {"Attractions", "Arts & Science", "Family", "Hotels & Travel", "Music & Concerts", "Performing Arts", "Sports", "Others"};

		this.cbaddcategory = new JComboBox(this.Category);
		this.cbaddcategory.setBounds(10, 116, 200, 20);
		this.addeventpanel.add(this.cbaddcategory);

		JLabel lblEventDescription = new JLabel("Event Description :");
		lblEventDescription.setBounds(10, 147, 105, 14);
		this.addeventpanel.add(lblEventDescription);

		this.taadddesc = new JTextArea();
		this.taadddesc.setLineWrap(true);
		this.taadddesc.setWrapStyleWord(true);
		this.taadddesc.setBorder(UIManager.getBorder("TextField.border"));
		this.taadddesc.setBounds(10, 163, 200, 84);
		this.addeventpanel.add(this.taadddesc);

    JLabel lblAddTicketName = new JLabel("Ticket Name :");
    lblAddTicketName.setBounds(569, 11, 127, 14);
    this.addeventpanel.add(lblAddTicketName);

		this.tfaddticketname = new JTextField();
		this.tfaddticketname.setColumns(10);
    this.tfaddticketname.setEnabled(false);
		this.tfaddticketname.setBounds(569, 27, 200, 20);
		this.addeventpanel.add(this.tfaddticketname);

		JLabel lblQuantity = new JLabel("Quantity :");
		lblQuantity.setBounds(569, 58, 92, 14);
		this.addeventpanel.add(lblQuantity);

		this.tfaddticketquantity = new JTextField();
		this.tfaddticketquantity.setColumns(10);
    this.tfaddticketquantity.setEnabled(false);
		this.tfaddticketquantity.setBounds(569, 72, 200, 20);
		this.addeventpanel.add(this.tfaddticketquantity);

		JLabel lblPrice = new JLabel("Price :");
		lblPrice.setBounds(569, 102, 92, 14);
		this.addeventpanel.add(lblPrice);

		this.tfaddticketprice = new JTextField();
		this.tfaddticketprice.setColumns(10);
    this.tfaddticketprice.setEnabled(false);
		this.tfaddticketprice.setBounds(569, 116, 200, 20);
		this.addeventpanel.add(this.tfaddticketprice);

		JLabel lblAddShowtimes = new JLabel("Add Showtime");
		lblAddShowtimes.setBounds(233, 11, 92, 14);
		this.addeventpanel.add(lblAddShowtimes);

		//String[] Month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

		this.cbaddmonth = new JComboBox<Object>(this.Month);
    this.cbaddmonth.setEnabled(false);
		this.cbaddmonth.setBounds(233, 58, 86, 20);
		this.addeventpanel.add(this.cbaddmonth);

		this.cbaddday = new JComboBox<Integer>();
		for(int i=1; i<=31; i++)
			this.cbaddday.addItem(i);
    this.cbaddday.setEnabled(false);
		this.cbaddday.setBounds(333, 58, 86, 20);
		this.addeventpanel.add(this.cbaddday);

		this.cbaddyear = new JComboBox();
		for(int i=2016; i<=2026; i++)
			this.cbaddyear.addItem(i);
    this.cbaddyear.setEnabled(false);
		this.cbaddyear.setBounds(433, 58, 86, 20);
		this.addeventpanel.add(this.cbaddyear);

		this.cbaddhour = new JComboBox<Integer>();
		for(int i=0; i<=23; i++)
			this.cbaddhour.addItem(i);
    this.cbaddhour.setEnabled(false);
		this.cbaddhour.setBounds(233, 102, 86, 20);
		this.addeventpanel.add(this.cbaddhour);

		this.cbaddminute = new JComboBox();
		for(int i=0; i<=59; i++)
			this.cbaddminute.addItem(i);
    this.cbaddminute.setEnabled(false);
		this.cbaddminute.setBounds(333, 102, 86, 20);
		this.addeventpanel.add(this.cbaddminute);

		JLabel lblDate = new JLabel("Date :");
		lblDate.setBounds(233, 43, 92, 14);
		this.addeventpanel.add(lblDate);

		JLabel lblTime = new JLabel("Time :");
		lblTime.setBounds(233, 89, 92, 14);
		this.addeventpanel.add(lblTime);

		this.cbaddseconds = new JComboBox();
		for(int i=0; i<=59; i++)
			this.cbaddseconds.addItem(i);
    this.cbaddseconds.setEnabled(false);
		this.cbaddseconds.setBounds(433, 102, 86, 20);
		this.addeventpanel.add(this.cbaddseconds);

		this.btaddevent = new JButton("Add Event");
		this.btaddevent.setBounds(58, 302, 105, 23);
		this.addeventpanel.add(this.btaddevent);

    this.btaddevent.addMouseListener(new MouseAdapter(){
       @Override
       public void mouseClicked(MouseEvent e){
         if(tfaddname.getText().trim().equals("")||tfaddplace.getText().trim().equals("")||taadddesc.getText().trim().equals("")||tfaddonlinefee.getText().trim().equals("")){
           JOptionPane.showMessageDialog(null,"SOME FIELDS ARE EMPTY!",null,JOptionPane.ERROR_MESSAGE);
         }
         else{
         try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/ticketsdb?useSSL=false", "root", "1234");
           String sql = "INSERT INTO events (Name, Place, Category, Description, onlinefee) VALUES (?, ?, ?, ?, ?)";
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setString(1, tfaddname.getText().trim());
           ps.setString(2, tfaddplace.getText().trim());
           ps.setString(3, (String)cbaddcategory.getSelectedItem());
           ps.setString(4, taadddesc.getText().trim());
           ps.setString(5, tfaddonlinefee.getText().trim());
           ps.executeUpdate();
           ps.close();
           JOptionPane.showMessageDialog(null,"EVENT ADDED!",null,JOptionPane.INFORMATION_MESSAGE);
           tfaddname.setEnabled(false);
           tfaddplace.setEnabled(false);
           cbaddcategory.setEnabled(false);
           taadddesc.setEnabled(false);
           tfaddonlinefee.setEnabled(false);
           btaddevent.setVisible(false);

           cbaddmonth.setEnabled(true);
           cbaddday.setEnabled(true);
           cbaddyear.setEnabled(true);
           cbaddhour.setEnabled(true);
           cbaddminute.setEnabled(true);
           cbaddseconds.setEnabled(true);
           btaddshowtime.setVisible(true);
           Statement stmt = con.createStatement();
           ResultSet rs = stmt.executeQuery ("select eventid from events where name='"+tfaddname.getText()+"'");
           while(rs.next()){
             addeventid=rs.getInt(1);
             System.out.println(addeventid);
           }
         } catch (Exception er) {
           System.out.println (er);
         }
         addeventpanel.revalidate();
         addeventpanel.repaint();
       }
       }
     });

		this.btaddshowtime = new JButton("Add Showtime");
    this.btaddshowtime.setVisible(false);
		this.btaddshowtime.setBounds(317, 143, 127, 23);
		this.addeventpanel.add(this.btaddshowtime);

    this.btaddshowtime.addMouseListener(new MouseAdapter(){
       @Override
       public void mouseClicked(MouseEvent e){
         try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/ticketsdb?useSSL=false", "root", "1234");
           String sql = "INSERT INTO showtime (datetime, eventid) VALUES (?, ?)";
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setString(1, (int)cbaddyear.getSelectedItem()+"-"+(cbaddmonth.getSelectedIndex()+1)+"-"+(int)cbaddday.getSelectedItem()+" "+
                        (int)cbaddhour.getSelectedItem()+":"+(int)cbaddminute.getSelectedItem()+":"+(int)cbaddseconds.getSelectedItem());
           ps.setInt(2, addeventid);
           ps.executeUpdate();
           ps.close();
           JOptionPane.showMessageDialog(null,"SHOWTIME ADDED!",null,JOptionPane.INFORMATION_MESSAGE);
           cbaddmonth.setEnabled(false);
           cbaddday.setEnabled(false);
           cbaddyear.setEnabled(false);
           cbaddhour.setEnabled(false);
           cbaddminute.setEnabled(false);
           cbaddseconds.setEnabled(false);
           btaddshowtime.setVisible(false);
           btaddshowtimedone.setVisible(false);

           tfaddticketname.setEnabled(true);
           tfaddticketprice.setEnabled(true);
           tfaddticketquantity.setEnabled(true);
           btaddticket.setVisible(true);
           Statement stmt = con.createStatement();
           ResultSet rs = stmt.executeQuery ("select showid from showtime where eventid="+addeventid);
           while(rs.next()){
             addshowid=rs.getInt(1);
             System.out.println(addshowid);
           }
         } catch (Exception er) {
           System.out.println (er);
         }
         addeventpanel.revalidate();
         addeventpanel.repaint();
       }
     });

		this.btaddticket = new JButton("Add Ticket");
    this.btaddticket.setVisible(false);
		this.btaddticket.setBounds(611, 147, 105, 23);
		this.addeventpanel.add(this.btaddticket);

    this.btaddticket.addMouseListener(new MouseAdapter(){
       @Override
       public void mouseClicked(MouseEvent e){
         if(tfaddticketname.getText().trim().equals("")||tfaddticketprice.getText().trim().equals("")||tfaddticketquantity.getText().trim().equals("")){
           JOptionPane.showMessageDialog(null,"SOME FIELDS ARE EMPTY OR INVALID!",null,JOptionPane.ERROR_MESSAGE);
         }
         try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/ticketsdb?useSSL=false", "root", "1234");
           String sql = "INSERT INTO tickets (ticketname, price, quantity, showid) VALUES (?, ?, ?, ?)";
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setString(1, tfaddticketname.getText().trim());
           ps.setString(2, tfaddticketprice.getText().trim());
           ps.setString(3, tfaddticketquantity.getText().trim());
           ps.setInt(4, addshowid);
           ps.executeUpdate();
           ps.close();
           JOptionPane.showMessageDialog(null,"TICKET ADDED FOR THIS SHOW!",null,JOptionPane.INFORMATION_MESSAGE);
           tfaddticketname.setText("");
           tfaddticketprice.setText("");
           tfaddticketquantity.setText("");
           btaddticketdone.setVisible(true);
         } catch (Exception er) {
           //System.out.println (er);
           JOptionPane.showMessageDialog(null,"SOME FIELDS ARE EMPTY OR INVALID!",null,JOptionPane.ERROR_MESSAGE);
         }
         addeventpanel.revalidate();
         addeventpanel.repaint();
       }
     });

    this.btaddticketdone = new JButton("Done");
    this.btaddticketdone.setVisible(false);
 		this.btaddticketdone.setBounds(611, 177, 105, 23);
 		this.addeventpanel.add(this.btaddticketdone);

    this.btaddticketdone.addMouseListener(new MouseAdapter(){
       @Override
       public void mouseClicked(MouseEvent e){
         tfaddticketname.setEnabled(false);
         tfaddticketprice.setEnabled(false);
         tfaddticketquantity.setEnabled(false);
         btaddticket.setVisible(false);

         cbaddmonth.setEnabled(true);
         cbaddday.setEnabled(true);
         cbaddyear.setEnabled(true);
         cbaddhour.setEnabled(true);
         cbaddminute.setEnabled(true);
         cbaddseconds.setEnabled(true);
         btaddshowtime.setVisible(true);
         btaddshowtimedone.setVisible(true);
         btaddticketdone.setVisible(false);
         addeventpanel.revalidate();
         addeventpanel.repaint();
       }
     });

    this.btaddshowtimedone = new JButton("Done");
    this.btaddshowtimedone.setVisible(false);
		this.btaddshowtimedone.setBounds(317, 177, 127, 23);
		this.addeventpanel.add(this.btaddshowtimedone);

    this.btaddshowtimedone.addMouseListener(new MouseAdapter(){
       @Override
       public void mouseClicked(MouseEvent e){
         cbaddmonth.setEnabled(false);
         cbaddday.setEnabled(false);
         cbaddyear.setEnabled(false);
         cbaddhour.setEnabled(false);
         cbaddminute.setEnabled(false);
         cbaddseconds.setEnabled(false);
         btaddshowtime.setVisible(false);
         btaddnewevent.setVisible(true);
         btaddshowtimedone.setVisible(false);
         addeventpanel.revalidate();
         addeventpanel.repaint();
       }
     });

		this.btaddnewevent = new JButton("Add New Event");
    this.btaddnewevent.setVisible(false);
		this.btaddnewevent.setBounds(312, 368, 143, 23);
		this.addeventpanel.add(this.btaddnewevent);

    this.btaddnewevent.addMouseListener(new MouseAdapter(){
       @Override
       public void mouseClicked(MouseEvent e){
         tfaddname.setEnabled(true);
         tfaddname.setText("");
         tfaddplace.setEnabled(true);
         tfaddplace.setText("");
         cbaddcategory.setEnabled(true);
         cbaddcategory.setSelectedIndex(0);
         taadddesc.setEnabled(true);
         taadddesc.setText("");
         tfaddonlinefee.setEnabled(true);
         tfaddonlinefee.setText("");
         cbaddmonth.setSelectedIndex(0);
         cbaddday.setSelectedIndex(0);
         cbaddyear.setSelectedIndex(0);
         cbaddhour.setSelectedIndex(0);
         cbaddminute.setSelectedIndex(0);
         cbaddseconds.setSelectedIndex(0);
         btaddevent.setVisible(true);
         btaddnewevent.setVisible(false);
         addeventpanel.revalidate();
         addeventpanel.repaint();

       }
     });

    this.editeventpanel = new JPanel();
		//this.tabbedPane.addTab("Edit Events", null, this.editeventpanel, null);
		this.editeventpanel.setLayout(null);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    this.olapanel = new JPanel();
		//this.tabbedPane.addTab("OLAP, null, this.olapanel, null);
		this.olapanel.setLayout(null);

    JComboBox comboBox_17 = new JComboBox();
    comboBox_17.setActionCommand("yearr");
    comboBox_17.addItem("2016");
    comboBox_17.setBounds(10, 25, 72, 20);
    this.olapanel.add(comboBox_17);

    JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(10, 11, 46, 14);
		this.olapanel.add(lblYear);

    JLabel lblTotalNumber = new JLabel("Total Number of Bought Tickets by Category for the Year 2016");
		lblTotalNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalNumber.setBounds(227, 64, 335, 14);
		this.olapanel.add(lblTotalNumber);

    this.olapanel1 = new JPanel();
		this.olapanel1.setBorder(UIManager.getBorder("TextField.border"));
		this.olapanel1.setBounds(10, 89, 759, 239);
		this.olapanel.add(this.olapanel1);
		this.olapanel1.setLayout(new GridLayout(9, 1, 5, 0));


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		this.cbchevent = new JComboBox();
    this.cbchevent.setActionCommand("choose event to update");
		this.cbchevent.setBounds(10, 11, 233, 20);
		this.editeventpanel.add(this.cbchevent);

    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/ticketsdb?useSSL=false", "root", "1234");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select name from events");
        while(rs.next()){
            cbchevent.addItem(rs.getString(1));
        }
    }catch (Exception ex) {
        System.out.println (ex);
    }

    /*this.btcheventok = new JButton("OK");
		this.btcheventok.setBounds(82, 42, 89, 23);
		this.editeventpanel.add(this.btcheventok);*/

		this.cbchshow = new JComboBox();
    this.cbchshow.setActionCommand("choose show to update");
		this.cbchshow.setBounds(273, 11, 233, 20);
		this.editeventpanel.add(this.cbchshow);

		/*this.btchshowok = new JButton("OK");
		this.btchshowok.setBounds(341, 42, 89, 23);
		this.editeventpanel.add(this.btchshowok);*/

		this.cbchticket = new JComboBox();
		this.cbchticket.setBounds(536, 11, 233, 20);
    this.cbchticket.setActionCommand("choose ticket to update");
		this.editeventpanel.add(this.cbchticket);

		/*this.btchticketok = new JButton("OK");
		this.btchticketok.setBounds(611, 42, 89, 23);
		this.editeventpanel.add(this.btchticketok);*/
		/////////////////////////////////////////////////////////////////////
		JLabel label_3 = new JLabel("Event Name:");
		label_3.setBounds(10, 73, 92, 14);
		this.editeventpanel.add(label_3);

		this.tfupeventname = new JTextField();
		this.tfupeventname.setColumns(10);
		this.tfupeventname.setBounds(10, 89, 200, 20);
		this.editeventpanel.add(this.tfupeventname);

        JLabel label_4 = new JLabel("Event Place :");
        label_4.setBounds(10, 120, 92, 14);
        this.editeventpanel.add(label_4);

		this.tfupeventplace = new JTextField();
		this.tfupeventplace.setColumns(10);
		this.tfupeventplace.setBounds(10, 134, 200, 20);
		this.editeventpanel.add(this.tfupeventplace);

		JLabel label_5 = new JLabel("Event Category :");
		label_5.setBounds(10, 164, 92, 14);
		this.editeventpanel.add(label_5);

		this.cbupeventcategory = new JComboBox(this.Category);
		this.cbupeventcategory.setBounds(10, 178, 200, 20);
		this.editeventpanel.add(this.cbupeventcategory);

		JLabel label_6 = new JLabel("Event Description :");
		label_6.setBounds(10, 209, 105, 14);
		this.editeventpanel.add(label_6);

		this.taupeventdesc = new JTextArea();
		this.taupeventdesc.setWrapStyleWord(true);
		this.taupeventdesc.setLineWrap(true);
		this.taupeventdesc.setBorder(UIManager.getBorder("TextField.border"));
		this.taupeventdesc.setBounds(10, 225, 200, 84);
		this.editeventpanel.add(this.taupeventdesc);

    JLabel label_12 = new JLabel("Online Fee :");
		label_12.setBounds(10, 316, 92, 14);
		this.editeventpanel.add(label_12);

    this.tfupeventonlinefee = new JTextField();
		this.tfupeventonlinefee.setColumns(10);
		this.tfupeventonlinefee.setBounds(10, 330, 200, 20);
		this.editeventpanel.add(this.tfupeventonlinefee);

		this.btupdateevent = new JButton("Update Event");
    this.btupdateevent.setActionCommand("upevent");
		this.btupdateevent.setBounds(44, 361, 127, 23);
		this.editeventpanel.add(this.btupdateevent);

		//////////////////////////////////////////////////////////////////
		JLabel label_7 = new JLabel("Date :");
		label_7.setBounds(244, 73, 92, 14);
		this.editeventpanel.add(label_7);

		this.cbupmonth = new JComboBox(this.Month);
		this.cbupmonth.setBounds(244, 88, 86, 20);
		this.editeventpanel.add(this.cbupmonth);

		this.cbupday = new JComboBox();
        for(int i=1; i<=31; i++)
            this.cbupday.addItem(i);
		this.cbupday.setBounds(344, 88, 86, 20);
		this.editeventpanel.add(this.cbupday);

		this.cbupyear = new JComboBox();
        for(int i=2016; i<=2026; i++)
            this.cbupyear.addItem(i);
		this.cbupyear.setBounds(444, 88, 86, 20);
		this.editeventpanel.add(this.cbupyear);

		this.cbuphour = new JComboBox();
        for(int i=0; i<=23; i++)
            this.cbuphour.addItem(i);
		this.cbuphour.setBounds(244, 132, 86, 20);
		this.editeventpanel.add(this.cbuphour);

		this.cbupminute = new JComboBox();
        for(int i=0; i<=59; i++)
            this.cbupminute.addItem(i);
		this.cbupminute.setBounds(344, 132, 86, 20);
		this.editeventpanel.add(this.cbupminute);

		JLabel label_8 = new JLabel("Time :");
		label_8.setBounds(244, 119, 92, 14);
		this.editeventpanel.add(label_8);

		this.cbupseconds = new JComboBox();
        for(int i=0; i<=59; i++)
            this.cbupseconds.addItem(i);
		this.cbupseconds.setBounds(444, 132, 86, 20);
		this.editeventpanel.add(this.cbupseconds);

		this.btupdateshow = new JButton("Update Showtime");
    this.btupdateshow.setActionCommand("upshow");
		this.btupdateshow.setBounds(317, 177, 149, 23);
		this.editeventpanel.add(this.btupdateshow);
		//////////////////////////////////////////////////////////////////////////
		JLabel label_9 = new JLabel("Ticket Name :");
		label_9.setBounds(554, 73, 127, 14);
		this.editeventpanel.add(label_9);

		this.tfupticketname = new JTextField();
		this.tfupticketname.setColumns(10);
		this.tfupticketname.setBounds(554, 89, 200, 20);
		this.editeventpanel.add(this.tfupticketname);

		JLabel label_10 = new JLabel("Quantity :");
		label_10.setBounds(554, 120, 92, 14);
		this.editeventpanel.add(label_10);

		this.tfupquantity = new JTextField();
		this.tfupquantity.setColumns(10);
		this.tfupquantity.setBounds(554, 134, 200, 20);
		this.editeventpanel.add(this.tfupquantity);

		JLabel label_11 = new JLabel("Price :");
		label_11.setBounds(554, 164, 92, 14);
		this.editeventpanel.add(label_11);

		this.tfupprice = new JTextField();
		this.tfupprice.setColumns(10);
		this.tfupprice.setBounds(554, 178, 200, 20);
		this.editeventpanel.add(this.tfupprice);

		this.btupdateticket = new JButton("Update Ticket");
    this.btupdateticket.setActionCommand("upticket");
		this.btupdateticket.setBounds(592, 209, 127, 23);
		this.editeventpanel.add(this.btupdateticket);

    ActionListener actionListener = new ActionListener() {
        public void actionPerformed(ActionEvent actionEvent) {
          cbchevent.removeAllItems();
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/ticketsdb?useSSL=false", "root", "1234");
                Statement stmt = con.createStatement();
                if(actionEvent.getActionCommand().equals("choose event to update")){
                  try{
                      Class.forName("com.mysql.jdbc.Driver");
                      Connection con11 = DriverManager.getConnection ("jdbc:mysql://localhost:3306/ticketsdb?useSSL=false", "root", "1234");
                      Statement stmt11 = con11.createStatement();
                      ResultSet rs = stmt11.executeQuery("select name from events");
                      while(rs.next()){
                          cbchevent.addItem(rs.getString(1));
                      }
                  }catch (Exception ex) {
                      System.out.println (ex);
                  }
                    cbchshow.removeAllItems();
                    upshowids.clear();
                    ResultSet rs = stmt.executeQuery("select month(s.datetime), day(s.datetime), year(s.datetime), hour(s.DateTime), minute(s.DateTime), second(s.DateTime), s.showid from showtime s, events e where s.EventID=e.EventID and e.name='"+cbchevent.getSelectedItem()+"' order by 1, 2, 3, 4, 5, 6");
                    while(rs.next()){
                        cbchshow.addItem(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+
                                         rs.getString(4)+":"+rs.getString(5)+":"+rs.getString(6));
                        upshowids.add(rs.getString(7));
                    }
                    System.out.println(upshowids);
                    ResultSet rs1 = stmt.executeQuery("select name, place, category, description, onlinefee from events where name='"+cbchevent.getSelectedItem()+"'");
                    while(rs1.next()){
                        tfupeventname.setText(rs1.getString(1));
                        tfupeventplace.setText(rs1.getString(2));
                        cbupeventcategory.setSelectedItem(rs1.getString(3));
                        taupeventdesc.setText(rs1.getString(4));
                        tfupeventonlinefee.setText(rs1.getString(5));
                    }
                }else if(actionEvent.getActionCommand().equals("choose show to update")){
                  cbchticket.removeAllItems();
                  upticketids.clear();
                  ResultSet rs2 = stmt.executeQuery("select ticketname, ticketid from tickets where showid="+upshowids.get(cbchshow.getSelectedIndex()));
                  while(rs2.next()){
                      cbchticket.addItem(rs2.getString(1));
                      upticketids.add(rs2.getString(2));
                  }
                }else if(actionEvent.getActionCommand().equals("choose ticket to update")){
                  ResultSet rs3 = stmt.executeQuery("select ticketname, quantity, price from tickets where ticketid="+upticketids.get(cbchticket.getSelectedIndex()));
                  while(rs3.next()){
                      tfupticketname.setText(rs3.getString(1));
                      tfupquantity.setText(rs3.getString(2));
                      tfupprice.setText(rs3.getString(3));
                  }
                }else if(actionEvent.getActionCommand().equals("upevent")){
                  if(tfupeventname.getText().trim().equals("")||tfupeventplace.getText().trim().equals("")||taupeventdesc.getText().trim().equals("")||tfupeventonlinefee.getText().trim().equals("")){
                    JOptionPane.showMessageDialog(null,"SOME FIELDS ARE EMPTY!",null,JOptionPane.ERROR_MESSAGE);
                  }
                  else{
                  try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con27 = DriverManager.getConnection ("jdbc:mysql://localhost:3306/ticketsdb?useSSL=false", "root", "1234");
                    String sql = "update events set name=?, place=?, category=?, description=?, onlinefee=? where name='"+cbchevent.getSelectedItem()+"'";
                    PreparedStatement ps = con27.prepareStatement(sql);
                    ps.setString(1, tfupeventname.getText().trim());
                    ps.setString(2, tfupeventplace.getText().trim());
                    ps.setString(3, (String)cbupeventcategory.getSelectedItem());
                    ps.setString(4, taupeventdesc.getText().trim());
                    ps.setString(5, tfupeventonlinefee.getText().trim());
                    int rowsUpdated = ps.executeUpdate();
                    if (rowsUpdated > 0) {
                      System.out.println("A ticket was updated successfully!");
                    }
                    JOptionPane.showMessageDialog(null,"EVENT UPDATED!",null,JOptionPane.INFORMATION_MESSAGE);
                  }catch (Exception er) {
                    System.out.println (er);
                  }
                }
                }else if(actionEvent.getActionCommand().equals("upshow")){
                  try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con66 = DriverManager.getConnection ("jdbc:mysql://localhost:3306/ticketsdb?useSSL=false", "root", "1234");
                    String sql = "UPDATE showtime set datetime=? where showid="+upshowids.get(cbchshow.getSelectedIndex());
                    PreparedStatement ps = con66.prepareStatement(sql);
                    ps.setString(1, (int)cbupyear.getSelectedItem()+"-"+(cbupmonth.getSelectedIndex()+1)+"-"+(int)cbupday.getSelectedItem()+" "+
                                 (int)cbuphour.getSelectedItem()+":"+(int)cbupminute.getSelectedItem()+":"+(int)cbupseconds.getSelectedItem());
                    int rowsUpdated = ps.executeUpdate();
                    if (rowsUpdated > 0) {
                      System.out.println("A ticket was updated successfully!");
                    }
                    JOptionPane.showMessageDialog(null,"SHOW TIME UPDATED!",null,JOptionPane.INFORMATION_MESSAGE);
                  }catch (Exception er) {
                    System.out.println (er);
                  }
                } else if(actionEvent.getActionCommand().equals("upticket")){
                  try{
                    if(tfupticketname.getText().trim().equals("")||tfupquantity.getText().trim().equals("")||tfupprice.getText().trim().equals("")){
                      JOptionPane.showMessageDialog(null,"SOME FIELDS ARE EMPTY OR INVALID!",null,JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con99 = DriverManager.getConnection ("jdbc:mysql://localhost:3306/ticketsdb?useSSL=false", "root", "1234");
                    String sql = "UPDATE tickets SET ticketname=?, quantity=?, price=? WHERE ticketid="+upticketids.get(cbchticket.getSelectedIndex());
                    PreparedStatement ps = con99.prepareStatement(sql);
                    ps.setString(1, tfupticketname.getText().trim());
                    ps.setString(2, tfupquantity.getText().trim());
                    ps.setString(3, tfupprice.getText().trim());
                    int rowsUpdated = ps.executeUpdate();
                    if (rowsUpdated > 0) {
                      System.out.println("A ticket was updated successfully!");
                    }
                    JOptionPane.showMessageDialog(null,"TICKET UPDATED!",null,JOptionPane.INFORMATION_MESSAGE);
                  }
                }catch (Exception er) {
                  System.out.println (er);
                  JOptionPane.showMessageDialog(null,"SOME FIELDS ARE EMPTY OR INVALID!",null,JOptionPane.ERROR_MESSAGE);
                }
              }  else if(actionEvent.getActionCommand().equals("yearr")){
                olapanel1.removeAll();
                OLAP a = new OLAP();
                a.getJan().setText("Jan");
                a.getFeb().setText("Feb");
                a.getMar().setText("Mar");
                a.getApr().setText("Apr");
                a.getMay().setText("May");
                a.getJun().setText("Jun");
                a.getJul().setText("Jul");
                a.getAug().setText("Aug");
                a.getSep().setText("Sep");
                a.getOct().setText("Oct");
                a.getNov().setText("Nov");
                a.getDec().setText("Dec");
                a.getTot().setText("Total");
                a.setBorder(UIManager.getBorder("TextField.border"));
                olapanel1.add(a);
                    try{
                      for(int i=0; i<8; i++){
                      Class.forName("com.mysql.jdbc.Driver");
                      Connection con99 = DriverManager.getConnection ("jdbc:mysql://localhost:3306/ticketsdb?useSSL=false", "root", "1234");
                      Statement stmt99 = con99.createStatement();
                      ResultSet rs1 = stmt99.executeQuery("select e.category, month(tt.transdatetime), sum(l.quantity) from events e, showtime s, tickets t, lineitem l, transactions tt where year(tt.TransDateTime)=2016 and e.category='"+Category[i]+"' and e.EventID=s.EventID and s.ShowID=t.ShowID and l.TicketID=t.TicketID and tt.TransactionID=l.TransID group by e.category, month(tt.transdatetime) order by month(tt.transdatetime)");
                      OLAP o = new OLAP();
                      while(rs1.next()){
                          o.getAbc().setText(rs1.getString(1));

                          if(rs1.getInt(2)==1){
                            o.getJan().setText(rs1.getInt(3)+"");
                          } else if (rs1.getInt(2)==2){
                            o.getFeb().setText(rs1.getInt(3)+"");
                          }
                          else if (rs1.getInt(2)==3){
                            o.getMar().setText(rs1.getInt(3)+"");
                          }
                          else if (rs1.getInt(2)==4){
                            o.getApr().setText(rs1.getInt(3)+"");
                          }
                          else if (rs1.getInt(2)==5){
                            o.getMay().setText(rs1.getInt(3)+"");
                          }
                          else if (rs1.getInt(2)==6){
                            o.getJun().setText(rs1.getInt(3)+"");
                          }
                          else if (rs1.getInt(2)==7){
                            o.getJul().setText(rs1.getInt(3)+"");
                          }
                          else if (rs1.getInt(2)==8){
                            o.getAug().setText(rs1.getInt(3)+"");
                          }
                          else if (rs1.getInt(2)==9){
                            o.getSep().setText(rs1.getInt(3)+"");
                          }
                          else if (rs1.getInt(2)==10){
                            o.getOct().setText(rs1.getInt(3)+"");
                          }
                          else if (rs1.getInt(2)==11){
                            o.getNov().setText(rs1.getInt(3)+"");
                          }
                          else if (rs1.getInt(2)==12){
                            o.getDec().setText(rs1.getInt(3)+"");
                          }
                          olapanel1.add(o);
                      }
                      Class.forName("com.mysql.jdbc.Driver");
                      Connection con88 = DriverManager.getConnection ("jdbc:mysql://localhost:3306/ticketsdb?useSSL=false", "root", "1234");
                      Statement stmt88 = con88.createStatement();
                      ResultSet rs88 = stmt88.executeQuery("select sum(l.quantity) from events e, showtime s, tickets t, lineitem l, transactions tt where year(tt.TransDateTime)=2016 and e.Category='"+Category[i]+"' and e.EventID=s.EventID and s.ShowID=t.ShowID and l.TicketID=t.TicketID and tt.TransactionID=l.TransID group by e.category");
                      while(rs88.next()){
                        o.getTot().setText(rs88.getString(1));
                      }
                    }
                    }catch (Exception e2) {
                        System.out.println (e2);
                    }
                  }
            }catch (Exception ex) {
                System.out.println (ex);
            }
        }
    };
    this.cbchevent.addActionListener(actionListener);
    this.cbchshow.addActionListener(actionListener);
    this.cbchticket.addActionListener(actionListener);
    this.btupdateevent.addActionListener(actionListener);
    this.btupdateshow.addActionListener(actionListener);
    this.btupdateticket.addActionListener(actionListener);
    comboBox_17.addActionListener(actionListener);
  }
  private void SearchPage(){
    this.searchpage = new JPanel();
    this.searchpage.setLayout(null);

    this.tfsearch = new JTextField();
    this.tfsearch.setBounds(499, 10, 182, 23);
    this.searchpage.add(this.tfsearch);
    this.tfsearch.setColumns(10);

    this.btsearch = new JButton("Search");
    this.btsearch.setBounds(691, 10, 83, 23);
    this.searchpage.add(this.btsearch);

    this.btsearchmyaccount = new JButton("My Account");
    this.btsearchmyaccount.setBounds(571, 44, 104, 23);
    this.searchpage.add(this.btsearchmyaccount);

    this.btsearchlogout = new JButton("Logout");
    this.btsearchlogout.setBounds(685, 44, 89, 23);
    this.searchpage.add(this.btsearchlogout);

    this.cbsearchcategory = new JComboBox(Category);
		this.cbsearchcategory.setBounds(10, 45, 128, 20);
    this.cbsearchcategory.setActionCommand("category");
		this.searchpage.add(this.cbsearchcategory);

    this.cbsearchevents = new JComboBox();
		this.cbsearchevents.setBounds(148, 45, 213, 20);
    this.cbsearchevents.setActionCommand("events");
		this.searchpage.add(this.cbsearchevents);

    this.btsearchgo = new JButton("GO");
      this.btsearchgo.setActionCommand("go");
		this.btsearchgo.setBounds(371, 44, 54, 23);
		this.searchpage.add(this.btsearchgo);

    ActionListener actionListener = new ActionListener() {
     public void actionPerformed(ActionEvent actionEvent) {
       try{
         Class.forName("com.mysql.jdbc.Driver");
         Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/ticketsdb?useSSL=false", "root", "1234");
         Statement stmt = con.createStatement();
         if(actionEvent.getActionCommand().equals("category")){
           cbsearchevents.removeAllItems();
           eventids.clear();
           ResultSet rs = stmt.executeQuery("select name, eventid from events where category='"+cbsearchcategory.getSelectedItem()+"' order by name");
           while(rs.next()){
             cbsearchevents.addItem(rs.getString(1));
             eventids.add(rs.getString(2));
           }
       }else if(actionEvent.getActionCommand().equals("go")){
         toViewEvent(eventids.get(cbsearchevents.getSelectedIndex()).toString());
       }
       }catch (Exception ex) {
         System.out.println (ex);
       }
     }
   };
   this.cbsearchcategory.addActionListener(actionListener);
   this.btsearchgo.addActionListener(actionListener);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(0, 78, 795, 495);
    this.searchpage.add(scrollPane);

    JPanel panel = new JPanel();
    scrollPane.setViewportView(panel);
    panel.setLayout(new GridLayout(100, 1, 0, 5));

    btsearch.addMouseListener(new MouseAdapter(){
       @Override
       public void mouseClicked(MouseEvent e){
         panel.removeAll();
         Rowwe r1 = new Rowwe();
         r1.getname().setText("Event Name");
         r1.getPlace().setText("Place");
         r1.getCategory().setText("Category");
         r1.setBackground(new Color(32, 178, 170));
         r1.getBTview().setVisible(false);
         panel.add(r1);
         try{
          Class.forName("com.mysql.jdbc.Driver");
          Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/ticketsdb?useSSL=false", "root", "1234");
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery ("select name, place, category, eventid from events where name like '%" + tfsearch.getText() + "%' order by name");
          while(rs.next()){
             Rowwe r = new Rowwe();
             r.getname().setText(rs.getString(1));
             r.getPlace().setText(rs.getString(2));
             r.getCategory().setText(rs.getString(3));
             r.setEventID(rs.getString(4));
             r.getBTview().addMouseListener(new MouseAdapter(){
               @Override
               public void mouseClicked(MouseEvent e){
                 toViewEvent(r.getEventID());
               }
             });
             panel.add(r);
             panel.revalidate();
             panel.repaint();
           }
           }catch (Exception ex) {
             System.out.println (ex);
           }
         }
    });
  }
  private void ViewEvent(){
    this.viewevent=new JPanel();
    this.viewevent.setLayout(null);

    this.btviewhome = new JButton("Home");
    this.btviewhome.setBounds(10, 11, 89, 23);
    this.viewevent.add(this.btviewhome);

    this.btviewlogout = new JButton("Logout");
    this.btviewlogout.setBounds(685, 11, 89, 23);
    this.viewevent.add(this.btviewlogout);

    this.btviewmyaccount = new JButton("My Account");
    this.btviewmyaccount.setBounds(571, 11, 104, 23);
    this.viewevent.add(this.btviewmyaccount);

    JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("TextField.border"));
		panel.setBounds(0, 49, 784, 171);
		this.viewevent.add(panel);
		panel.setLayout(null);

    this.lbEventName = new JLabel();
    this.lbEventName.setBounds(10, 11, 764, 14);
    panel.add(this.lbEventName);

    this.lbEventPlace = new JLabel();
    this.lbEventPlace.setBounds(10, 28, 764, 14);
    panel.add(this.lbEventPlace);

    this.lbCategory = new JLabel();
    this.lbCategory.setBounds(10, 44, 764, 14);
    panel.add(this.lbCategory);

    this.tfdesc = new JTextArea();
    this.tfdesc.setWrapStyleWord(true);
    this.tfdesc.setLineWrap(true);
    this.tfdesc.setOpaque(false);
    this.tfdesc.setEditable(false);
    this.tfdesc.setFocusable(false);
    this.tfdesc.setBounds(10, 60, 764, 14);
    panel.add(this.tfdesc);

    this.cbdatetime = new JComboBox<Object>();
    this.cbdatetime.setActionCommand("choose datetime");
    this.cbdatetime.setBounds(10, 82, 204, 20);
    panel.add(this.cbdatetime);

    JPanel panel_1 = new JPanel();
		panel_1.setBorder(UIManager.getBorder("TextField.border"));
		panel_1.setBounds(0, 220, 784, 171);
		this.viewevent.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 784, 171);
    //scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel_1.add(scrollPane);

		JPanel panel_3 = new JPanel();
		scrollPane.setViewportView(panel_3);
		panel_3.setLayout(new GridLayout(30, 1, 0, 5));

    JPanel panel_2 = new JPanel();
		panel_2.setBorder(UIManager.getBorder("TextField.border"));
		panel_2.setBounds(0, 391, 470, 171);
		this.viewevent.add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 470, 171);
		panel_2.add(scrollPane_1);

		JPanel panel_6 = new JPanel();
		scrollPane_1.setViewportView(panel_6);
		panel_6.setLayout(new GridLayout(50, 1, 0, 5));
    //this.transid=1127;
    JPanel panel_4 = new JPanel();
 		panel_4.setBorder(UIManager.getBorder("TextField.border"));
 		panel_4.setBounds(471, 391, 313, 171);
 		this.viewevent.add(panel_4);
 		panel_4.setLayout(null);

 		JLabel lblNewLabel_1 = new JLabel("Summary");
 		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
 		lblNewLabel_1.setBounds(10, 11, 84, 19);
 		panel_4.add(lblNewLabel_1);

 		JLabel lblNewLabel_2 = new JLabel("Total Ticket Price");
 		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
 		lblNewLabel_2.setBounds(20, 41, 129, 14);
 		panel_4.add(lblNewLabel_2);

 		JLabel lblOnlineFee = new JLabel("Online Fee");
 		lblOnlineFee.setFont(new Font("Tahoma", Font.PLAIN, 13));
 		lblOnlineFee.setBounds(20, 74, 129, 14);
 		panel_4.add(lblOnlineFee);

 		JLabel lblNewLabel_3 = new JLabel("Total");
 		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
 		lblNewLabel_3.setBounds(48, 109, 84, 14);
 		panel_4.add(lblNewLabel_3);

 		JLabel tprice = new JLabel();
 		tprice.setFont(new Font("Tahoma", Font.PLAIN, 13));
 		tprice.setBounds(154, 41, 84, 14);
 		panel_4.add(tprice);

 		JLabel totalonlinefee = new JLabel();
 		totalonlinefee.setFont(new Font("Tahoma", Font.PLAIN, 13));
 		totalonlinefee.setBounds(154, 75, 84, 14);
 		panel_4.add(totalonlinefee);

 		this.pay = new JButton("PAY");
    this.pay.setActionCommand("pay");
 		this.pay.setBounds(115, 137, 89, 23);
 		panel_4.add(this.pay);

 		JLabel totalticketcount = new JLabel();
 		totalticketcount.setBounds(246, 42, 46, 14);
 		panel_4.add(totalticketcount);

 		JLabel total = new JLabel();
 		total.setFont(new Font("Tahoma", Font.BOLD, 15));
 		total.setBounds(154, 109, 119, 14);
 		panel_4.add(total);

    ActionListener actionListener = new ActionListener() {
     public void actionPerformed(ActionEvent actionEvent) {
       try{
         Class.forName("com.mysql.jdbc.Driver");
         Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/ticketsdb?useSSL=false", "root", "1234");
         Statement stmt = con.createStatement();
         if(actionEvent.getActionCommand().equals("choose datetime")){
          totalprice=0.0;
          totaltickets=0;
          tprice.setText("");
          totalticketcount.setText("");
          totalonlinefee.setText("");
          total.setText("");
          //cbdatetime.setEnabled(false);
           panel_3.removeAll();
           panel_6.removeAll();
           TicketPricesRowwe r1 = new TicketPricesRowwe();
           r1.getTicketName().setText("Ticket Name");
           r1.getPrice().setText("Price");
           //r1.getPrice().setHorizontalAlignment(SwingConstants.CENTER);
           r1.getbtaddtocart().setVisible(false);
           r1.getjsQuantity().setVisible(false);
           panel_3.add(r1);
           SelectedTicksRowwe str1 = new SelectedTicksRowwe();
           str1.getTicketName().setText("Name");
           str1.getQuantity().setText("Quantity");
           str1.getPrice().setText("Price");
           str1.getbtremove().setVisible(false);
           panel_6.add(str1);
           ResultSet rs = stmt.executeQuery("select ticketname, price, ticketid, Quantity from tickets where showid="+showids.get(cbdatetime.getSelectedIndex())+" order by price desc");
           try{
             DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
             LocalDateTime now = LocalDateTime.now();
             Class.forName("com.mysql.jdbc.Driver");
             Connection con9 = DriverManager.getConnection ("jdbc:mysql://localhost:3306/ticketsdb?useSSL=false", "root", "1234");
           String sql = "INSERT INTO transactions (TransDateTime, total, buyerid) VALUES (?, ?, ?)";
           PreparedStatement ps = con9.prepareStatement(sql);
           ps.setString(1, dtf.format(now));
           ps.setString(2, "0");
           ps.setString(3, tfloginUserName.getText());
           ps.executeUpdate();
           ps.close();
         }catch (Exception ex){
           System.out.println(ex);
         }
         try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection con8 = DriverManager.getConnection ("jdbc:mysql://localhost:3306/ticketsdb?useSSL=false", "root", "1234");
           Statement stmt8 = con8.createStatement();
           ResultSet rs8 = stmt8.executeQuery("select transactionID from transactions");
           while(rs8.next()){
             transid=rs8.getInt(1);
           }
         }catch (Exception ex){
           System.out.println(ex);
         }
           while(rs.next()){
             if(rs.getInt(4)!=0){
             TicketPricesRowwe r = new TicketPricesRowwe();
             r.getTicketName().setText(rs.getString(1));
             r.setticketprice(rs.getDouble(2));
             r.getPrice().setText("PhP "+r.getticketprice());
             r.setticketid(rs.getInt(3));
             r.getbtaddtocart().addMouseListener(new MouseAdapter(){
               @Override
               public void mouseClicked(MouseEvent e){
                 if(r.getspinner().getNumber().intValue()!=0){
                  try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/ticketsdb?useSSL=false", "root", "1234");
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery ("select quantity from tickets where ticketid="+r.getticketid());
                    while(rs.next()){
                      origquant=rs.getInt(1);
                    }
                  }catch (Exception er) {
                    System.out.println (er);
                  }
                   try{
                     Class.forName("com.mysql.jdbc.Driver");
                     Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/ticketsdb?useSSL=false", "root", "1234");
                     String sql = "UPDATE tickets SET quantity=? WHERE ticketid="+r.getticketid();
                     PreparedStatement ps = con.prepareStatement(sql);
                     ps.setInt(1, origquant-r.getspinner().getNumber().intValue());
                     int rowsUpdated = ps.executeUpdate();
                     if (rowsUpdated > 0) {
                       System.out.println("An existing user was updated successfully!");
                     }
                   }catch (Exception er) {
                     System.out.println (er);
                   }
                 SelectedTicksRowwe str = new SelectedTicksRowwe();
                 str.getTicketName().setText(r.getTicketName().getText());
                 str.getQuantity().setText(r.getjsQuantity().getValue().toString());
                 str.setticketprice(r.getticketprice());
                 str.setticketid(r.getticketid());
                 str.setticketquantity(r.getspinner().getNumber().intValue());
                 str.getPrice().setText("Php "+r.getticketprice()*r.getspinner().getNumber().intValue());
                 totalprice+=(r.getticketprice()*r.getspinner().getNumber().intValue());
                 totaltickets+=r.getspinner().getNumber().intValue();
                 totaltotal=totalprice+(onlinefee*totaltickets);
                 tprice.setText(""+totalprice);
                 totalticketcount.setText("x "+totaltickets);
                 totalonlinefee.setText(""+onlinefee*totaltickets);
                 total.setText(""+totaltotal);
                 str.getbtremove().addMouseListener(new MouseAdapter(){
                   @Override
                   public void mouseClicked(MouseEvent e){
                     try{
                       Class.forName("com.mysql.jdbc.Driver");
                       Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/ticketsdb?useSSL=false", "root", "1234");
                       Statement stmt = con.createStatement();
                       ResultSet rs = stmt.executeQuery ("select quantity from tickets where ticketid="+r.getticketid());
                       while(rs.next()){
                         origquant=rs.getInt(1);
                       }
                     }catch (Exception er) {
                       System.out.println (er);
                     }
                     try{
                       Class.forName("com.mysql.jdbc.Driver");
                       Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/ticketsdb?useSSL=false", "root", "1234");
                       String sql = "UPDATE tickets SET quantity=? WHERE ticketid="+str.getticketid();
                       PreparedStatement ps = con.prepareStatement(sql);
                       ps.setInt(1, origquant+str.getticketquantity());
                       int rowsUpdated = ps.executeUpdate();
                       if (rowsUpdated > 0) {
                         System.out.println("An existing user was updated successfully!");
                       }
                     }catch (Exception er) {
                       System.out.println (er);
                     }
                     totalprice-=(str.getticketprice()*str.getticketquantity());
                     totaltickets-=str.getticketquantity();
                     totaltotal=totalprice+(onlinefee*totaltickets);
                     tprice.setText(""+totalprice);
                     totalticketcount.setText("x "+totaltickets);
                     totalonlinefee.setText(""+onlinefee*totaltickets);
                     total.setText(""+totaltotal);
                     try{
                       Class.forName("com.mysql.jdbc.Driver");
                       Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/ticketsdb?useSSL=false", "root", "1234");
                        Statement s= con.createStatement();
                     String safe = "SET SQL_SAFE_UPDATES = 0;";
                     s.executeQuery(safe);
                       Class.forName("com.mysql.jdbc.Driver");
                       Connection con1 = DriverManager.getConnection ("jdbc:mysql://localhost:3306/ticketsdb?useSSL=false", "root", "1234");
                     String sql1 = "DELETE FROM lineitem where TransID=? and Quantity=? and TicketID=?";
                     PreparedStatement ps1 = con.prepareStatement(sql1);
                     ps1.setInt(1, transid);
                     ps1.setInt(2, str.getticketquantity());
                      ps1.setInt(3, str.getticketid());
                     ps1.executeUpdate();
                     ps1.close();
                   }catch (Exception ex){
                     System.out.println(ex);
                   }
                    panel_6.remove(str);
                    panel_6.revalidate();
                    panel_6.repaint();
                   }
                 });
                 panel_6.add(str);
                 panel_6.revalidate();
                 panel_6.repaint();
               try{
                 Class.forName("com.mysql.jdbc.Driver");
                 Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/ticketsdb?useSSL=false", "root", "1234");
               String sql = "INSERT INTO lineitem (TransID, Quantity, TicketID) VALUES (?, ?, ?)";
               PreparedStatement ps = con.prepareStatement(sql);
               ps.setInt(1, transid);
               ps.setString(2, r.getjsQuantity().getValue().toString());
               ps.setInt(3, r.getticketid());
               ps.executeUpdate();
               ps.close();
             }catch (Exception ex){
               System.out.println(ex);
             }
             }
               }
             });
             panel_3.add(r);
             panel_3.revalidate();
             panel_3.repaint();
           }
         }
       } else if(actionEvent.getActionCommand().equals("pay")){
         if(totalprice!=0.0){
           try{
             DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
             LocalDateTime now = LocalDateTime.now();
             Class.forName("com.mysql.jdbc.Driver");
             Connection con1 = DriverManager.getConnection ("jdbc:mysql://localhost:3306/ticketsdb?useSSL=false", "root", "1234");
           String sql = "UPDATE transactions SET TransDateTime=?, total=? WHERE buyerid='"+tfloginUserName.getText()+"' and transactionid="+transid;
           PreparedStatement ps = con1.prepareStatement(sql);
           ps.setString(1, dtf.format(now));
           ps.setDouble(2, totaltotal);
           int rowsUpdated = ps.executeUpdate();
           if (rowsUpdated > 0) {
             System.out.println("a transaction was updated successfully!");
           }
           try{
             Class.forName("com.mysql.jdbc.Driver");
             Connection con77 = DriverManager.getConnection ("jdbc:mysql://localhost:3306/ticketsdb?useSSL=false", "root", "1234");
             Statement stmt77 = con77.createStatement();
             ResultSet rs77 = stmt77.executeQuery ("select u.username, concat(u.firstname, ' ', u.lastname),e.name,e.place, s.datetime,t.transactionid, t.transdatetime,sum(l.quantity),t.total from users u, events e, transactions t, tickets tt, showtime s, lineitem l where t.BuyerID='"+tfloginUserName.getText()+"' and t.transactionid="+transid+" and t.buyerid=u.username and t.TransactionID=l.transid and l.ticketid=tt.TicketID and tt.ShowID=s.ShowID and s.EventID=e.EventID");
            while(rs77.next()){
              username.setText(rs77.getString(1));
              name.setText(rs77.getString(2));
              title.setText(rs77.getString(3));
              place.setText(rs77.getString(4));
              date.setText(rs77.getString(5));
              transidd.setText(rs77.getString(6));
              transdate.setText(rs77.getString(7));
              totick.setText(rs77.getString(8));
              toprice.setText(rs77.getString(9));
            }
           }catch (Exception exe){
             System.out.println(exe);
           }
           try{
             Class.forName("com.mysql.jdbc.Driver");
             Connection con3 = DriverManager.getConnection ("jdbc:mysql://localhost:3306/ticketsdb?useSSL=false", "root", "1234");
              Statement s2= con3.createStatement();
           String safe2 = "SET SQL_SAFE_UPDATES = 0;";
           s2.executeQuery(safe2);
           Class.forName("com.mysql.jdbc.Driver");
           Connection con4 = DriverManager.getConnection ("jdbc:mysql://localhost:3306/ticketsdb?useSSL=false", "root", "1234");
         String sql1 = "DELETE FROM transactions where total=?";
         PreparedStatement ps2 = con4.prepareStatement(sql1);
         ps2.setInt(1, 0);
         ps2.executeUpdate();
         ps2.close();
           }catch (Exception err){
             System.out.println(err);
           }
           getreport().setVisible(true);
         }catch (Exception ex){
           System.out.println(ex);
         }
       } else{
         JOptionPane.showMessageDialog(null,"NO TICKETS SELECTED",null,JOptionPane.ERROR_MESSAGE);
       }
       }
       }catch (Exception ex) {
         System.out.println (ex);
       }
     }
   };
   this.cbdatetime.addActionListener(actionListener);
   this.pay.addActionListener(actionListener);
 }
 private void totalreport(){
  this.report = new JDialog(this.frame);
  this.report.setTitle("Report");
  //this.report.setLayout(null);
  this.report.setSize(350, 400);
  this.report.setDefaultCloseOperation(0);
  this.report.setLocationRelativeTo(this.frame);

  JPanel neww = new JPanel();
  neww.setBounds(0,0,0,0);
  neww.setLayout(null);

  JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("untitled.png"));
		lblNewLabel.setBounds(127, 0, 104, 51);
		neww.add(lblNewLabel);

    JLabel lblAccountName = new JLabel("Username");
		lblAccountName.setBounds(10, 62, 94, 14);
		neww.add(lblAccountName);

		JLabel label = new JLabel("Account Name");
		label.setBounds(10, 78, 94, 14);
		neww.add(label);

		this.username = new JLabel("Username");
		this.username.setBounds(114, 62, 133, 14);
		neww.add(this.username);

		this.name = new JLabel("Username");
		this.name.setBounds(114, 78, 133, 14);
		neww.add(this.name);

    JLabel lblTransactionId = new JLabel("Event Title");
		lblTransactionId.setBounds(10, 106, 104, 14);
		neww.add(lblTransactionId);

		JLabel lblTransactionDate = new JLabel("Date/Time");
		lblTransactionDate.setBounds(10, 120, 104, 14);
		neww.add(lblTransactionDate);

		JLabel lblVenue = new JLabel("Venue");
		lblVenue.setBounds(10, 135, 104, 14);
		neww.add(lblVenue);

		JLabel lblTransactionId_1 = new JLabel("Transaction ID");
		lblTransactionId_1.setBounds(10, 160, 104, 14);
		neww.add(lblTransactionId_1);

		JLabel label_3 = new JLabel("Transaction Date");
		label_3.setBounds(10, 174, 104, 14);
		neww.add(label_3);

		JLabel lblTotalTickets = new JLabel("Total Ticket(s)");
		lblTotalTickets.setBounds(10, 199, 104, 14);
		neww.add(lblTotalTickets);

		JLabel lblAmountPaid = new JLabel("Amount Paid");
		lblAmountPaid.setBounds(10, 214, 104, 14);
		neww.add(lblAmountPaid);

		this.title = new JLabel("Username");
		this.title.setBounds(114, 103, 236, 14);
		neww.add(this.title);

		this.date = new JLabel("Username");
		this.date.setBounds(114, 120, 236, 14);
		neww.add(this.date);

		this.place = new JLabel("Username");
		this.place.setBounds(114, 135, 236, 14);
		neww.add(this.place);

		this.transidd = new JLabel("Username");
		this.transidd.setBounds(114, 160, 159, 14);
		neww.add(this.transidd);

		this.transdate = new JLabel("Username");
		this.transdate.setBounds(114, 174, 159, 14);
		neww.add(this.transdate);

		this.totick = new JLabel("Username");
		this.totick.setBounds(114, 199, 133, 14);
		neww.add(this.totick);

		this.toprice = new JLabel("Username");
		this.toprice.setBounds(114, 214, 133, 14);
		neww.add(this.toprice);

    JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("upccode (1).png"));
		lblNewLabel_1.setBounds(115, 266, 137, 51);
		neww.add(lblNewLabel_1);

		JLabel lblTicketRedemptionCode = new JLabel("Ticket Redemption Code");
		lblTicketRedemptionCode.setHorizontalAlignment(SwingConstants.CENTER);
		lblTicketRedemptionCode.setBounds(104, 249, 159, 14);
		neww.add(lblTicketRedemptionCode);

    JButton print = new JButton("Print");
    print.setActionCommand("print");
		print.setBounds(140, 328, 89, 23);
		neww.add(print);

    print.addMouseListener(new MouseAdapter(){
       @Override
       public void mouseClicked(MouseEvent e){
         toSearchPage();
         report.setVisible(false);
       }
     });

  this.report.add(neww);
}
  private void Register(){
    this.register=new JPanel();
    this.register.setLayout(null);

    this.lb1 = new JLabel("Sign up Form");
    this.lb1.setHorizontalAlignment(SwingConstants.CENTER);
    this.lb1.setBounds(0, 0, 784, 46);
    this.register.add(this.lb1);

    this.lb2 = new JLabel("Username");
    this.lb2.setHorizontalAlignment(SwingConstants.LEFT);
    this.lb2.setBounds(10, 50, 59, 14);
    this.register.add(this.lb2);

    this.tfregUserName = new JTextField();
    this.tfregUserName.setColumns(10);
    this.tfregUserName.setBounds(10, 66, 285, 20);
    this.register.add(this.tfregUserName);

    this.lb3 = new JLabel("Password");
    this.lb3.setBounds(10, 91, 59, 14);
    this.register.add(this.lb3);

    this.pfregister = new JPasswordField();
    this.pfregister.setColumns(10);
    this.pfregister.setBounds(10, 108, 285, 20);
    this.register.add(this.pfregister);

    this.lb4 = new JLabel("First Name");
    this.lb4.setBounds(10, 133, 69, 14);
    this.register.add(this.lb4);

    this.lb5 = new JLabel("Middle Name");
    this.lb5.setBounds(110, 133, 81, 14);
    this.register.add(this.lb5);

    this.lb6 = new JLabel("Last Name");
    this.lb6.setBounds(210, 133, 74, 14);
    this.register.add(this.lb6);

    this.tfregFN = new JTextField();
    this.tfregFN.setBounds(10, 149, 86, 20);
    this.register.add(this.tfregFN);
    this.tfregFN.setColumns(10);

    this.tfregMN = new JTextField();
    this.tfregMN.setBounds(110, 149, 86, 20);
    this.register.add(this.tfregMN);
    this.tfregMN.setColumns(10);

    this.tfregLN = new JTextField();
    this.tfregLN.setBounds(209, 149, 86, 20);
    this.register.add(this.tfregLN);
    this.tfregLN.setColumns(10);

    this.lb6 = new JLabel("Date of Birth");
    this.lb6.setBounds(10, 174, 86, 14);
    this.register.add(this.lb6);

    //String[] Month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    this.cbmonth = new JComboBox<Object>(this.Month);
    this.cbmonth.setBounds(10, 190, 86, 20);
    this.register.add(this.cbmonth);

    this.cbday = new JComboBox<Integer>();
    for(int i=1; i<=31; i++)
      this.cbday.addItem(i);
    this.cbday.setBounds(110, 190, 86, 20);
    this.register.add(this.cbday);

    this.cbyear = new JComboBox<Integer>();
    for(int i=1999; i>=1931; i--)
      this.cbyear.addItem(i);
    this.cbyear.setBounds(210, 190, 86, 20);
    this.register.add(this.cbyear);

    this.lb7 = new JLabel("Gender");
    this.lb7.setBounds(10, 215, 46, 14);
    this.register.add(this.lb7);

    this.bg = new ButtonGroup();

    this.rbmale = new JRadioButton("Male");
    this.rbmale.setBounds(6, 229, 63, 23);
    this.rbmale.setActionCommand("Male");
    this.register.add(this.rbmale);

    this.rbfemale = new JRadioButton("Female");
    this.rbfemale.setBounds(71, 229, 69, 23);
    this.rbfemale.setActionCommand("Female");
    this.register.add(this.rbfemale);

    bg.add(this.rbmale);
    bg.add(this.rbfemale);

    this.lb8 = new JLabel("Civil Status");
    this.lb8.setBounds(150, 215, 81, 14);
    this.register.add(this.lb8);

    String[] CivilStatus = {"Single", "Married", "Widowed", "Separated"};

    this.cbcs = new JComboBox<Object>(CivilStatus);
    this.cbcs.setBounds(150, 230, 86, 20);
    this.register.add(this.cbcs);

    this.lb9 = new JLabel("Address");
    this.lb9.setBounds(337, 50, 59, 14);
    this.register.add(this.lb9);

    this.tfregAddress = new JTextField();
    this.tfregAddress.setColumns(10);
    this.tfregAddress.setBounds(337, 66, 437, 20);
    this.register.add(this.tfregAddress);

    this.lb10 = new JLabel("Country");
    this.lb10.setBounds(337, 91, 59, 14);
    this.register.add(this.lb10);

    this.tfregCountry = new JTextField();
    this.tfregCountry.setBounds(337, 108, 215, 20);
    this.register.add(this.tfregCountry);
    this.tfregCountry.setColumns(10);

    this.lb11 = new JLabel("State");
    this.lb11.setBounds(559, 91, 46, 14);
    this.register.add(this.lb11);

    this.tfregState = new JTextField();
    this.tfregState.setColumns(10);
    this.tfregState.setBounds(559, 108, 215, 20);
    this.register.add(this.tfregState);

    this.lb12 = new JLabel("Email Address");
    this.lb12.setBounds(337, 133, 86, 14);
    this.register.add(this.lb12);

    this.tfregEmail = new JTextField();
    this.tfregEmail.setBounds(337, 149, 437, 20);
    this.register.add(this.tfregEmail);
    this.tfregEmail.setColumns(10);

    this.lb13 = new JLabel("Mobile Number");
    this.lb13.setBounds(337, 174, 134, 14);
    this.register.add(this.lb13);

    this.tfregMobile = new JTextField();
    this.tfregMobile.setBounds(337, 190, 437, 20);
    this.register.add(this.tfregMobile);
    this.tfregMobile.setColumns(10);

    this.lb14 = new JLabel("Account Type");
    this.lb14.setBounds(337, 215, 86, 14);
    this.register.add(this.lb14);

    String[] AccType = {"User", "Admin"};

    this.cbtype = new JComboBox<Object>(AccType);
    this.cbtype.setBounds(337, 230, 86, 20);
    this.register.add(this.cbtype);

    this.btregister = new JButton("Register");
    this.btregister.setBounds(307, 297, 164, 40);
    this.register.add(this.btregister);

    btregister.addMouseListener(new MouseAdapter(){
       @Override
       public void mouseClicked(MouseEvent e){
         if(tfregUserName.getText().trim().equals("")||tfregLN.getText().trim().length()<2||tfregLN.getText().trim().length()>40||tfregFN.getText().trim().length()<2||tfregFN.getText().trim().length()>40||tfregMN.getText().trim().length()>40
            ||pfregister.getPassword().length<2||pfregister.getPassword().length>40||tfregEmail.getText().trim().equals("")||tfregMobile.getText().trim().equals("")||tfregAddress.getText().trim().length()<2
            ||tfregAddress.getText().trim().length()>40||tfregCountry.getText().trim().equals("")||tfregState.getText().trim().equals("")||bg.getSelection()==null){
           JOptionPane.showMessageDialog(null,"SOME FIELDS ARE EMPTY OR INVALID!",null,JOptionPane.ERROR_MESSAGE);
         } else {
           try{
             Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/ticketsdb?useSSL=false", "root", "1234");
             String sql = "INSERT INTO users (Username, LastName, FirstName, MiddleName, Password, Email, MobileNum, Address, Country, State, DOB, Gender, CivilStatus, Type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setString(1, tfregUserName.getText().trim()); //Username
             ps.setString(2, tfregLN.getText().trim()); //LastName
             ps.setString(3, tfregFN.getText().trim()); //FirstName
             ps.setString(4, tfregMN.getText().trim()); //MiddleName
             ps.setString(5, pfregister.getText()); //Password
             ps.setString(6, tfregEmail.getText().trim()); //Email
             ps.setString(7, tfregMobile.getText().trim()); //MobileNum
             ps.setString(8, tfregAddress.getText().trim()); //Address
             ps.setString(9, tfregCountry.getText().trim()); //Country
             ps.setString(10, tfregState.getText().trim()); //State
             ps.setString(11, (int)cbyear.getSelectedItem()+"-"+(cbmonth.getSelectedIndex()+1)+"-"+(int)cbday.getSelectedItem()); //DOB
             ps.setString(12, (String)bg.getSelection().getActionCommand()); //Gender
             ps.setString(13, (String)cbcs.getSelectedItem()); //CivilStatus
             ps.setString(14, (String)cbtype.getSelectedItem()); //Type
             ps.executeUpdate();
           ps.close();
             JOptionPane.showMessageDialog(null,"ACCOUNT CREATED!",null,JOptionPane.INFORMATION_MESSAGE);
             toLogin();
             tfregUserName.setText("");
             tfregLN.setText("");
             tfregFN.setText("");
             tfregMN.setText("");
             pfregister.setText("");
             tfregEmail.setText("");
             tfregMobile.setText("");
             tfregAddress.setText("");
             tfregCountry.setText("");
             tfregState.setText("");
             cbyear.setSelectedIndex(0);
             cbmonth.setSelectedIndex(0);
             cbday.setSelectedIndex(0);
             bg.clearSelection();
             cbcs.setSelectedIndex(0);
             cbtype.setSelectedIndex(0);
             tfloginUserName.setText("");
             pflogin.setText("");
           } catch (Exception er) {
             System.out.println (er);
             JOptionPane.showMessageDialog(null,"SOME FIELDS ARE EMPTY OR INVALID!",null,JOptionPane.ERROR_MESSAGE);
           }
         }
       }
     });
    this.btback= new JButton("Back");
    this.btback.setBounds(7, 528, 89, 23);
    this.register.add(this.btback);

    btback.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent paramAnonymousMouseEvent){
        toLogin();
        tfregUserName.setText("");
        tfregLN.setText("");
        tfregFN.setText("");
        tfregMN.setText("");
        pfregister.setText("");
        tfregEmail.setText("");
        tfregMobile.setText("");
        tfregAddress.setText("");
        tfregCountry.setText("");
        tfregState.setText("");
        cbyear.setSelectedIndex(0);
        cbmonth.setSelectedIndex(0);
        cbday.setSelectedIndex(0);
        bg.clearSelection();
        cbcs.setSelectedIndex(0);
        cbtype.setSelectedIndex(0);
        tfloginUserName.setText("");
        pflogin.setText("");
      }
    });
  }
  private void Login(){
    this.login=new JPanel();
    this.login.setLayout(null);

    JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("untitled.png"));
		lblNewLabel.setBounds(357, 67, 104, 51);
		this.login.add(lblNewLabel);

    this.lb1=new JLabel("Username");
    this.lb1.setBounds(174, 172, 109, 14);
    this.login.add(this.lb1);

    this.tfloginUserName = new JTextField(10);
    this.tfloginUserName.setBounds(174, 187, 183, 20);
    this.login.add(this.tfloginUserName);

    this.lb2 = new JLabel("Password");
    this.lb2.setBounds(174, 220, 109, 14);
    this.login.add(this.lb2);

    this.pflogin = new JPasswordField(10);
    this.pflogin.setBounds(174, 235, 183, 20);
    this.login.add(this.pflogin);

    this.btlogin = new JButton("Login");
    this.btlogin.setBounds(222, 280, 89, 23);
    this.login.add(this.btlogin);

    this.btcreateacc = new JButton("Create Account");
    this.btcreateacc.setBounds(471, 211, 126, 23);
    this.login.add(this.btcreateacc);
  }
  }
