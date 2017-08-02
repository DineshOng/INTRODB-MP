import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyTransRowwe extends JPanel{
  private JLabel date;
  private JTextArea name;
  private JLabel name2;
  private JLabel time;
  private JLabel quantity;
  private JLabel total;

  public MyTransRowwe(){
    this.date = new JLabel();
    this.date.setForeground(Color.WHITE);
    this.date.setHorizontalAlignment(SwingConstants.CENTER);

    this.name = new JTextArea();
    this.name.setForeground(Color.WHITE);
    this.name.setForeground(Color.WHITE);
    this.name.setWrapStyleWord(true);
    this.name.setLineWrap(true);
    this.name.setOpaque(false);
    this.name.setEditable(false);
    this.name.setFocusable(false);
    this.name.setFont(UIManager.getFont("Label.font"));

    this.name2 = new JLabel();
    this.name2.setForeground(Color.WHITE);

    this.time = new JLabel();
    this.time.setForeground(Color.WHITE);
    this.time.setHorizontalAlignment(SwingConstants.CENTER);

    this.quantity = new JLabel();
    this.quantity.setForeground(Color.WHITE);
    this.quantity.setHorizontalAlignment(SwingConstants.CENTER);

    this.total = new JLabel();
    this.total.setForeground(Color.WHITE);
    this.total.setHorizontalAlignment(SwingConstants.CENTER);

    this.setLayout(new GridLayout(1, 5, 5, 0));
    this.setBackground(Color.GRAY);

    this.add(this.date);
    this.add(this.name);
    this.add(this.name2);
    this.add(this.time);
    this.add(this.quantity);
    this.add(this.total);
  }
  public JLabel getdate(){
    return date;
  }
  public JTextArea getname(){
    return name;
  }
  public JLabel getname2(){
    return name2;
  }
  public JLabel gettime(){
    return time;
  }
  public JLabel getquantity(){
    return quantity;
  }
  public JLabel gettotal(){
    return total;
  }
}
