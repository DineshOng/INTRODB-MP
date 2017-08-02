import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rowwe extends JPanel{
  private JTextArea Name;
  private JTextArea Place;
  private JTextArea Category;
  private JButton btview;
  private String eventID;

  public Rowwe(){
    this.Name = new JTextArea();
    this.Name.setForeground(Color.WHITE);
    this.Name.setFont(new Font("Arial", Font.PLAIN, 16));
    this.Name.setWrapStyleWord(true);
    this.Name.setLineWrap(true);
    this.Name.setOpaque(false);
    this.Name.setEditable(false);
    this.Name.setFocusable(false);

    this.Place = new JTextArea();
    this.Place.setForeground(Color.WHITE);
    this.Place.setFont(new Font("Arial", Font.PLAIN, 16));
    this.Place.setWrapStyleWord(true);
    this.Place.setLineWrap(true);
    this.Place.setOpaque(false);
    this.Place.setEditable(false);
    this.Place.setFocusable(false);

    this.Category = new JTextArea();
    this.Category.setForeground(Color.WHITE);
    this.Category.setFont(new Font("Arial", Font.PLAIN, 16));
    this.Category.setWrapStyleWord(true);
    this.Category.setLineWrap(true);
    this.Category.setOpaque(false);
    this.Category.setEditable(false);
    this.Category.setFocusable(false);

    this.btview = new JButton("View Event");

    this.setLayout(new GridLayout(1, 4, 5, 0));
    this.setBackground(Color.GRAY);

    this.add(this.Name);
    this.add(this.Place);
    this.add(this.Category);
    this.add(this.btview);
  }
  public JTextArea getname(){
    return Name;
  }
  public JTextArea getPlace(){
    return Place;
  }
  public JTextArea getCategory(){
    return Category;
  }
  public JButton getBTview(){
    return btview;
  }
  public void setEventID(String i){
    eventID=i;
  }
  public String getEventID(){
    return eventID;
  }
}
