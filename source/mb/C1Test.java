package pb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;		// Locale
import java.text.*;		// NumberFormat

class C1 extends JFrame
{
	Container c;
	JLabel lbl_amount;
	JTextField txt_amount;
	JButton btn_convert;

	C1()
	{
		c = getContentPane();
		c.setLayout(new FlowLayout());
		
		lbl_amount = new JLabel("enter amount ");
		txt_amount = new JTextField(10);
		btn_convert = new JButton("convert");

		c.add(lbl_amount);
		c.add(txt_amount);
		c.add(btn_convert);

		ActionListener a1 = (ae) ->
		{
			try
			{
				String s = txt_amount.getText();
				double dollars = Double.parseDouble(s);
				double rupees = dollars * 75;
				String msg = "dollar = " + dollars + "  rupees = " + rupees;
				JOptionPane.showMessageDialog(c, msg);

				Locale usa = Locale.US;
				Locale india = new Locale("hi", "IN");

				NumberFormat nf_usa = NumberFormat.getCurrencyInstance(usa);
				NumberFormat nf_india = NumberFormat.getCurrencyInstance(india);
				String amsg = "dollar = " + nf_usa.format(dollars) + "  rupees = " + nf_india.format(rupees);
				
				JOptionPane.showMessageDialog(c, amsg);	
			}
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(c, "invalid amount");
				txt_amount.setText("");
				txt_amount.requestFocus();
			}
		};

		btn_convert.addActionListener(a1);
			
		setTitle("Currency Converter by Kamal Sir");
		setSize(400, 300);	
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		c.setBackground(Color.PINK);
			
	}
}

class C1Test
{
	public static void main(String args[])
	{
		C1 c = new C1();
	}
}