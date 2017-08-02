import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicketPricesRowwe extends JPanel{
  private JLabel TicketName;
  private JLabel Price;
  private SpinnerNumberModel spinner;
  private JSpinner jsQuantity;
  private JButton btaddtocart;
  private int ticketid;
  private Double ticketprice;

  public TicketPricesRowwe(){
    this.TicketName = new JLabel();
    this.TicketName.setHorizontalAlignment(SwingConstants.CENTER);
    this.Price = new JLabel();
    //this.Price.setHorizontalAlignment(SwingConstants.CENTER);
    this.spinner = new SpinnerNumberModel(0, 0, 10, 1);
    this.jsQuantity = new JSpinner(this.spinner);
    this.btaddtocart = new JButton("Add to Cart");

    this.setLayout(new GridLayout(1, 4, 30, 0));

    this.add(this.TicketName);
    this.add(this.Price);
    this.add(this.jsQuantity);
    this.add(this.btaddtocart);
  }
  public JLabel getTicketName(){
    return TicketName;
  }
  public JLabel getPrice(){
    return Price;
  }
  public SpinnerNumberModel getspinner(){
    return spinner;
  }
  public JSpinner getjsQuantity(){
    return jsQuantity;
  }
  public JButton getbtaddtocart(){
    return btaddtocart;
  }
  public void setticketid(int i){
    ticketid=i;
  }
  public int getticketid(){
    return ticketid;
  }
  public JPanel getPanel(){
    return this;
  }
  public void setticketprice(Double i){
    ticketprice=i;
  }
  public Double getticketprice(){
    return ticketprice;
  }
}
