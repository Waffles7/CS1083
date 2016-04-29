import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
/**
	*This class creates a GUI to calculate a student's GPA
	*Uses the JFrame class to create stand alone application
	*@author Michael Roscoe
**/

public class GradeCalculator extends JFrame implements ActionListener {

	//Delcaring instance variables
	private JLabel gradeLabel;
	private JLabel creditLabel;
	private JTextField gradeField;
	private JTextField creditField;
	private JButton addGPA;
	private JButton clearGPA;
	private JLabel messageLabel;
	private JLabel gradeMessage;
	private double creditHours;
	private double currentPoints;

	public GradeCalculator () {

		setSize (280, 250);

		//Default values
		creditHours = 0.0;
		currentPoints = 0.0;

		//Creation of labels, buttons, fields, actionlisteners
		gradeLabel = new JLabel("Course Letter Grade:");
		creditLabel = new JLabel("Course Credit Hours:");
		gradeField = new JTextField(2);
		creditField = new JTextField(2);
		addGPA = new JButton("Add to GPA");
		clearGPA = new JButton("Clear GPA");
		addGPA.addActionListener(this);
		clearGPA.addActionListener(this);
		messageLabel = new JLabel("Welcome to my GPA calculator!");
		gradeMessage = new JLabel("Enter your first grade & credit hours.");

		//Filling of the container
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.add(gradeLabel);
		contentPane.add(gradeField);
		contentPane.add(creditLabel);
		contentPane.add(creditField);
		contentPane.add(addGPA);
		contentPane.add(clearGPA);
		contentPane.add(messageLabel);
		contentPane.add(gradeMessage);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		NumberFormat formatter = NumberFormat.getInstance();
		formatter.setMaximumFractionDigits(2);
		formatter.setMinimumFractionDigits(2);
		double cumulativeGrade = 0;
		if (e.getSource() == addGPA) {
			String grade = gradeField.getText().toUpperCase();
			String gradeIn; 
			switch (grade) {
				case "A+": gradeIn = "4.3"; break;
				case "A": gradeIn = "4.0"; break;
				case "A-": gradeIn = "3.7"; break;
				case "B+": gradeIn = "3.3"; break;
				case "B": gradeIn = "3.0"; break;
				case "B-": gradeIn = "2.7"; break;
				case "C+": gradeIn = "2.3"; break;
				case "C": gradeIn = "2.0"; break;
				case "D": gradeIn = "1.0"; break;
				case "F": gradeIn = "0.0"; break;
				case "WF": gradeIn = "0.0"; break;
				default: gradeIn = "Invalid";
			}
			if (gradeIn.equals("Invalid")) {
				messageLabel.setText("Invalid Grade - GPA not Changed");
			} else {
				double gradeNumber = Double.parseDouble(gradeIn);
				double courseHours = Double.parseDouble(creditField.getText());
				currentPoints += gradeNumber * courseHours;
				creditHours += courseHours;
				cumulativeGrade = currentPoints / creditHours;
				messageLabel.setText("Points for this course: " + formatter.format(gradeNumber * courseHours));
			}
			gradeMessage.setText("Your cumulative GPA is: " + formatter.format(cumulativeGrade));	
		} else {
			currentPoints = 0.0;
			creditHours = 0.0;
			cumulativeGrade = 0.0;
			messageLabel.setText("Totals have been reset.");
			gradeMessage.setText("Enter your first grade & credit hours.");
		}
		gradeField.setText("");
		creditField.setText("");

	}
	public static void main(String[] args) {
		new GradeCalculator().setVisible(true);
	}
}