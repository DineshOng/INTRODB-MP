import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OLAP extends JPanel{
  private JLabel abc;
  private JLabel jan;
  private JLabel feb;
  private JLabel mar;
  private JLabel apr;
  private JLabel may;
  private JLabel jun;
  private JLabel jul;
  private JLabel aug;
  private JLabel sep;
  private JLabel oct;
  private JLabel nov;
  private JLabel dec;
  private JLabel tot;

  public OLAP(){
    this.abc = new JLabel();
    //this.abc.setHorizontalAlignment(SwingConstants.CENTER);
    this.jan = new JLabel("0");
    this.jan.setHorizontalAlignment(SwingConstants.CENTER);
    this.feb = new JLabel("0");
    this.feb.setHorizontalAlignment(SwingConstants.CENTER);
    this.mar = new JLabel("0");
    this.mar.setHorizontalAlignment(SwingConstants.CENTER);
    this.apr = new JLabel("0");
    this.apr.setHorizontalAlignment(SwingConstants.CENTER);
    this.may = new JLabel("0");
    this.may.setHorizontalAlignment(SwingConstants.CENTER);
    this.jun = new JLabel("0");
    this.jun.setHorizontalAlignment(SwingConstants.CENTER);
    this.jul = new JLabel("0");
    this.jul.setHorizontalAlignment(SwingConstants.CENTER);
    this.aug = new JLabel("0");
    this.aug.setHorizontalAlignment(SwingConstants.CENTER);
    this.sep = new JLabel("0");
    this.sep.setHorizontalAlignment(SwingConstants.CENTER);
    this.oct = new JLabel("0");
    this.oct.setHorizontalAlignment(SwingConstants.CENTER);
    this.nov = new JLabel("0");
    this.nov.setHorizontalAlignment(SwingConstants.CENTER);
    this.dec = new JLabel("0");
    this.dec.setHorizontalAlignment(SwingConstants.CENTER);
    this.tot = new JLabel("0");
    this.tot.setHorizontalAlignment(SwingConstants.CENTER);

    this.setLayout(new GridLayout(1, 14,3,0));

    this.add(this.abc);
    this.add(this.jan);
    this.add(this.feb);
    this.add(this.mar);
    this.add(this.apr);
    this.add(this.may);
    this.add(this.jun);
    this.add(this.jul);
    this.add(this.aug);
    this.add(this.sep);
    this.add(this.oct);
    this.add(this.nov);
    this.add(this.dec);
    this.add(this.tot);
  }
  public JLabel getAbc() {
		return abc;
	}
	public JLabel getJan() {
		return jan;
	}
	public JLabel getFeb() {
		return feb;
	}
	public JLabel getMar() {
		return mar;
	}
	public JLabel getApr() {
		return apr;
	}
	public JLabel getMay() {
		return may;
	}
	public JLabel getJun() {
		return jun;
	}
	public JLabel getJul() {
		return jul;
	}
	public JLabel getAug() {
		return aug;
	}
	public JLabel getSep() {
		return sep;
	}
	public JLabel getOct() {
		return oct;
	}
	public JLabel getNov() {
		return nov;
	}
	public JLabel getDec() {
		return dec;
	}
	public JLabel getTot() {
		return tot;
	}
}
