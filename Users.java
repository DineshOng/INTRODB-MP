import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Users extends JPanel{
  private JLabel email;
  private JLabel name;

  public Users(){
    this.email = new JLabel();
    this.email.setForeground(Color.WHITE);

    this.name = new JLabel();
    this.name.setForeground(Color.WHITE);

    this.add(this.email);
    this.add(this.name);
  }
  public JLabel getemail(){
    return email;
  }
  public JLabel getname(){
    return name;
  }
}
