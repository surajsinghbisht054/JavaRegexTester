package sidebar;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SideBar extends JPanel
{
	
	JLabel first = new JLabel("Character Class");
	JLabel second= new JLabel("Predefined Character Class");
	JLabel third= new JLabel("Boundary Matchers");
	JLabel fourth= new JLabel("Greedy Quantifiers");
	JLabel fivth= new JLabel("Reluctaant Quantifiers");
	JLabel sixth= new JLabel("Posessive Quantifiers");
	JLabel seventh= new JLabel("Logical Operator");
	
	//table header 
	String column_name[] = {"Construct","Description"};
	
	/*table content start*/

	Object[][] CharacterClassData = {
						{"[abc]","a,b or c (simple class)"},
						{"[^abc]","Any character except a,b or c"},
						{"[a-zA-Z","a through z,or A through Z, inclusive(range)"},
						{"[a-d[m-p]]","a through d, or m through p:[a-dm-p] (uniion)"},
						{"[a-z&& [def]","d,e or f (intersection)"},
						{"[a-z&& [^bc]","a through z, except for b and c:[ad-z](substraction)"},
						{"[a-z&&[^m-p]]","a through z, and not m through p: [a-lq-z] (subtraction)"}
						};

	Object[][] PredefinedCharacterClassData = {
					{" . " ," Any character (may or may not match line terminators)"},
					{" \\d "," A digit: [0-9]"},
					{" \\D "," A non-digit: [^0-9]"},
					{" \\s "," A whitespace character: [ \\t\\n\\x0B\\f\\r]"},
					{" \\S "," A non-whitespace character: [^\\s]"},
					{" \\w "," A word character: [a-zA-Z_0-9]"},
					{" \\W "," A non-word character: [^\\w]"},


						};

	Object[][] BoundaryMatchersData = {
					{" ^ "," The beginning of a line"},
					{" $ ","	The end of a line"},
					{" \\b "," A word boundary"},
					{" \\B "," A non-word boundary"},
					{" \\A "," The beginning of the input"},
					{" \\G "," The end of the previous match"},
					{" \\Z "," The end of the input but for the final terminator, if any"},
					{" \\z "," The end of the input"},


						};

	Object[][] GreedyQuantifierData = {
					{" X? "," X, once or not at all"},
					{" X* "," X, zero or more times"},
					{" X+ "," X, one or more times"},
					{" X{n} "," X, exactly n times"},
					{" X{n,} "," X, at least n times"},
					{" X{n,m} "," X, at least n but not more than m times"},

						};

	
	//tables
	JTable table1,table2,table3,table4;

	public SideBar()
	{

		
		setBackground(Color.BLACK);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(209, 216, 224));
		panel.setForeground(new Color(47, 53, 66));
		
		JScrollPane scrollpane = new JScrollPane(panel);
		add(scrollpane);
		panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
	
		

		//charcter class table
		table1 = new JTable(CharacterClassData,column_name);
		/*JScrollPane scrollpane1 = new JScrollPane(table1);
		scrollpane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollpane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);*/
		table1.getColumnModel().getColumn(1).setPreferredWidth(400);
		table1.getColumnModel().getColumn(0).setPreferredWidth(100);
		table1.setRowHeight(30);
		table1.setBackground(Color.GRAY);
		table1.setForeground(Color.WHITE);
		table1.setFont(new Font("",Font.PLAIN,14));
		table1.setEnabled(false);
		table1.setGridColor(Color.WHITE);


		//predefined character class table
		table2 = new JTable(PredefinedCharacterClassData,column_name);
		/*JScrollPane scrollpane2 = new JScrollPane(table2);
		scrollpane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollpane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);*/
		table2.getColumnModel().getColumn(1).setPreferredWidth(400);
		table2.getColumnModel().getColumn(0).setPreferredWidth(100);
		table2.setRowHeight(30);
		table2.setBackground(Color.GRAY);
		table2.setForeground(Color.WHITE);
		table2.setFont(new Font("",Font.PLAIN,14));
		table2.setEnabled(false);
		table2.setGridColor(Color.WHITE);
	


		//Boundary Matcher class table
		table3 = new JTable(BoundaryMatchersData,column_name);
		/*JScrollPane scrollpane3 = new JScrollPane(table3);
		scrollpane3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollpane3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);*/
		table3.getColumnModel().getColumn(1).setPreferredWidth(400);
		table3.getColumnModel().getColumn(0).setPreferredWidth(100);
		table3.setRowHeight(30);
		table3.setBackground(Color.GRAY);
		table3.setForeground(Color.WHITE);
		table3.setFont(new Font("",Font.PLAIN,14));
		table3.setSize(100,50);
		table3.setEnabled(false);
		table3.setGridColor(Color.WHITE);
		

		//predefined charcter class table
		table4 = new JTable(PredefinedCharacterClassData,column_name);
		/*JScrollPane scrollpane4 = new JScrollPane(table4);
		scrollpane4.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollpane4.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);*/
		table4.getColumnModel().getColumn(1).setPreferredWidth(400);
		table4.getColumnModel().getColumn(0).setPreferredWidth(100);
		table4.setRowHeight(30);
		table4.setBackground(Color.GRAY);
		table4.setForeground(Color.WHITE);
		table4.setFont(new Font("",Font.PLAIN,14));
		table4.setEnabled(false);
		table4.setGridColor(Color.WHITE);
	
		//table headning
		first.setFont(new Font("",Font.BOLD,16));
		second.setFont(new Font("",Font.BOLD,16));
		third.setFont(new Font("",Font.BOLD,16));
		fourth.setFont(new Font("",Font.BOLD,16));

		
		
		panel.add(Box.createRigidArea(new Dimension(0,5)));
		panel.add(first);
		panel.add(Box.createRigidArea(new Dimension(0,5)));
		panel.add(table1.getTableHeader());
		panel.add(table1);
		
		panel.add(Box.createRigidArea(new Dimension(0,5)));
		panel.add(second);
		panel.add(Box.createRigidArea(new Dimension(0,5)));
		panel.add(table2.getTableHeader());
		panel.add(table2);
		
		panel.add(Box.createRigidArea(new Dimension(0,5)));
		panel.add(third);
		panel.add(Box.createRigidArea(new Dimension(0,5)));
		panel.add(table3.getTableHeader());
		panel.add(table3);
		
		panel.add(Box.createRigidArea(new Dimension(0,5)));
		panel.add(fourth);
		panel.add(Box.createRigidArea(new Dimension(0,5)));
		panel.add(table4.getTableHeader());
		panel.add(table4);
			
	}



	public static void main(String args[])
	{
		SideBar obj =new SideBar();

		JFrame frame=new JFrame("Test dropdown list");
		
		frame.add(obj,BorderLayout.WEST);
		frame.setSize(500,500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}