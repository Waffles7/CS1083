import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;

/**
	*This class creates a simulation of a movie theatre cash register
	*Uses the JFrame class for creation as a stand alone application
	*@author Michael Roscoe
**/

public class CinemaFrame extends JFrame implements ActionListener {

	private JLabel topLabel, couponLabel, totalLabel;
	private ProductButton adultTicket, childTicket, seniorTicket, popcorn, candy, pop;
	private JButton redeem, nextCustomer;
	private JTextField coupon;
	private double runningTotal;

	public CinemaFrame () {

		super ("Cinema Register");
		setSize(600,400);
		runningTotal = 0;

		//Creation of labels, buttons, fields, actionlisteners
		topLabel = new JLabel("Click on the products that the customer wishes to purchase:");
		couponLabel = new JLabel("Coupon: $");
		totalLabel = new JLabel("Current Total: $0.00");
		adultTicket = new ProductButton("Adult Ticket", 12.50);
		childTicket = new ProductButton("Child Ticket", 6.25);
		seniorTicket = new ProductButton("Senior Ticket", 8.75);
		popcorn = new ProductButton("Popcorn", 5.50);
		candy = new ProductButton("Candy", 3.25);
		pop = new ProductButton("Pop", 2.75);
		redeem = new JButton("Redeem");
		nextCustomer = new JButton("Next Customer");
		coupon = new JTextField(4);

		//Creation of the listeners
		adultTicket.addActionListener(this);
		childTicket.addActionListener(this);
		seniorTicket.addActionListener(this);
		popcorn.addActionListener(this);
		candy.addActionListener(this);
		pop.addActionListener(this);
		redeem.addActionListener(this);
		nextCustomer.addActionListener(this);

		//Creation of top panel
		JPanel topPanel = new JPanel();
		topPanel.add(topLabel);

		//Creation of the center panel
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(2,3));
		centerPanel.add(adultTicket);
		centerPanel.add(childTicket);
		centerPanel.add(seniorTicket);
		centerPanel.add(popcorn);
		centerPanel.add(pop);
		centerPanel.add(candy);

		//Creation of the bottom panel
		JPanel bottomPanel = new JPanel();
		bottomPanel.add(couponLabel);
		bottomPanel.add(coupon);
		bottomPanel.add(redeem);
		bottomPanel.add(totalLabel);
		bottomPanel.add(nextCustomer);

		//Creation of the full window
		Container contentPane = getContentPane();
		contentPane.add(topPanel, BorderLayout.PAGE_START);
		contentPane.add(centerPanel, BorderLayout.CENTER);
		contentPane.add(bottomPanel, BorderLayout.PAGE_END);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		
		if (e.getSource() == nextCustomer) {
			runningTotal = 0;
			totalLabel.setText("Current Total: " + formatter.format(runningTotal));
		} else if (e.getSource() == redeem) {
			double couponAmount = Double.parseDouble(coupon.getText());
			runningTotal -= couponAmount;
			totalLabel.setText("Current Total: " + formatter.format(runningTotal));
			coupon.setText("");
		} else {
			ProductButton temp = (ProductButton)(e.getSource());
			runningTotal += temp.getPrice();
			totalLabel.setText("Current Total: " + formatter.format(runningTotal));
		}
	}
	public static void main(String[] args) {
		new CinemaFrame().setVisible(true);
	}

}