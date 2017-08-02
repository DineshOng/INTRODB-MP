import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SelectedTicksRowwe extends JPanel{
  private JLabel TicketName;
  private JLabel Price;
  private JLabel Quantity;
  private JButton btremove;
  private int ticketid;
  private Double ticketprice;
  private int ticketquantity;

  public SelectedTicksRowwe(){
    this.TicketName = new JLabel();
    this.TicketName.setHorizontalAlignment(SwingConstants.CENTER);
    this.Price = new JLabel();
    //this.Price.setHorizontalAlignment(SwingConstants.CENTER);
    this.Quantity = new JLabel();
    this.Quantity.setHorizontalAlignment(SwingConstants.CENTER);
    this.btremove = new JButton("remove");

    this.setLayout(new GridLayout(1, 4, 15, 0));

    this.add(this.TicketName);
    this.add(this.Price);
    this.add(this.Quantity);
    this.add(this.btremove);
  }
  public JLabel getTicketName(){
    return TicketName;
  }
  public JLabel getPrice(){
    return Price;
  }
  public JLabel getQuantity(){
    return Quantity;
  }
  public JButton getbtremove(){
    return btremove;
  }
  public void setticketid(int i){
    ticketid=i;
  }
  public int getticketid(){
    return ticketid;
  }
  public void setticketprice(Double i){
    ticketprice=i;
  }
  public Double getticketprice(){
    return ticketprice;
  }
  public void setticketquantity(int i){
    ticketquantity=i;
  }
  public int getticketquantity(){
    return ticketquantity;
  }
}
