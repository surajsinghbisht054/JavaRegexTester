package sidebar;


/*
	=========================================================================
			Java Based Regex Expression Testing App
	=========================================================================

	Author : 	Suraj Singh Bisht
				surajsinghbisht054@gmail.com
				www.bitforestinfo.com
				www.blaregroup.com
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SideBar extends JPanel
{
	
	JLabel characterClassHeading = new JLabel("Character Class");
	JLabel predefinedCharacterClassHeading= new JLabel("Predefined Character Class");
	JLabel boundaryMatcherClassHeading= new JLabel("Boundary Matchers");
	JLabel greedyQuantifierHeading= new JLabel("Greedy Quantifiers");
	JLabel reluctantQuantifierHeading= new JLabel("Reluctaant Quantifiers");
	JLabel posessiveQuantifierHeading= new JLabel("Posessive Quantifiers");
	JLabel logicalOperatorHeading= new JLabel("Logical Operator");
	JLabel commonClassHeading = new JLabel("Common Class ");
	JLabel posixCharacterClassHeading = new JLabel("POSIX character classes (US-ASCII only)");
	JLabel someUsefulClassHeading = new JLabel("unicode scripts, blocks, categories and binary properties");
	JLabel linebreakMatcherClassHeading = new JLabel("Linebreak matcher");
	JLabel backReferencesHeading = new JLabel("Back References Heading");
	JLabel quotationHeading =new JLabel("Quotation");
	JLabel specialConstructsHeading = new JLabel("Special constructs");
	
	//table header 
	String column_name[] = {"Construct","Description"};
	
	/*table content start*/

	Object[][] CharacterClassData = {
						{" [abc]"," a,b or c (simple class)"},
						{" [^abc]"," Any character except a,b or c"},
						{" [a-zA-Z"," a through z,or A through Z, inclusive(range)"},
						{" [a-d[m-p]]"," a through d, or m through p:[a-dm-p] (uniion)"},
						{" [a-z&& [def]"," d,e or f (intersection)"},
						{" [a-z&& [^bc]"," a through z, except for b and c:[ad-z](substraction)"},
						{" [a-z&&[^m-p]]"," a through z, and not m through p: [a-lq-z] (subtraction)"},
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

	Object[][] ReluctantQuantifierData = {
					{" X?? "," X, once or not at all"},
					{" X*? "," X, zero or more times"},
					{" X+? "," X, one or more times"},
					{" X{n}? "," X, exactly n times"},
					{" X{n,}? "," X, at least n times"},
					{" X{n,m}? "," X, at least n but not more than m times"},

						};
	
	Object[][] PosessiveQuantifierData = {
					{" X?+ ","	X, once or not at all"},
					{" X*+ ","	X, zero or more times"},
					{" X++ ","	X, one or more times"},
					{" X{n}+ "," X, exactly n times"},
					{" X{n,}+ "," X, at least n times"},
					{" X{n,m}+ "," X, at least n but not more than m times"},
						};


	Object[][] LogicalOperatorData = {
					{"XY "," X followed by Y"},
					{"X|Y "," Either X or Y"},
					{"(X) "," X, as a capturing group"},

						};
	Object[][] CommonClassData = {
					{" x "," The character x"},
					{"\\ "," The backslash character"},
					{"\\x{h...h} "," The character with hexadecimal value 0xh...h"},
					{"\\t "," The tab character ('\\u0009')"},
					{"\\n "," The newline (line feed) character ('\\u000A')"},
					{"\\r "," The carriage-return character ('\\u000D')"},
					{"\\f "," The form-feed character ('\\u000C')"},
					{"\\a "," The alert (bell) character ('\\u0007')"},
					{"\\e "," The escape character ('\\u001B')"},
					{"\\cx "," The control character corresponding to x"},
						};

	Object[][] posixCharacterClassData = {
					{" \\p{Lower} "," A lower-case alphabetic character: [a-z]"},
					{" \\p{Upper} "," An upper-case alphabetic character:[A-Z]"},
					{" \\p{ASCII} "," All ASCII:[\\x00-\\x7F]"},
					{" \\p{Alpha} "," An alphabetic character:[\\p{Lower}\\p{Upper}]"},
					{" \\p{Digit} "," A decimal digit: [0-9]"},
					{" \\p{Alnum} "," An alphanumeric character:[\\p{Alpha}\\p{Digit}]"},
					{" \\p{Punct} "," Punctuation: One of !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~"},
					{" \\p{Graph} "," A visible character: [\\p{Alnum}\\p\\{Punct}]"},
					{" \\p{Print} "," A printable character: [\\p{Graph}\\x20]"},
					{" \\p{Blank} "," A space or a tab: [ \\t]"},
					{" \\p{Cntrl} "," A control character: [\\x00-\\x1F\\x7F]"},
					{" \\p{XDigit} "," A hexadecimal digit: [0-9a-fA-F]"},
					{" \\p{Space} "," A whitespace character: [ \\t\\n\\x0B\\f\\r]"},
						};

	Object[][] someUsefuleClassData = {
					{" \\p{IsLatin} ","	A Latin script character (script)"},
					{" \\p{InGreek} ","	A character in the Greek block (block)"},
					{" \\p{Lu} ","	An uppercase letter (category)"},
					{" \\p{IsAlphabetic} "," An alphabetic character (binary property)"},
					{" \\p{Sc} "," A currency symbol"},
					{" \\P{InGreek} ","	Any character except one in the Greek block (negation)"},
					{" [\\p{L}&&[^\\p{Lu}]] ","	Any letter except an uppercase letter (subtraction)"},

						};

	Object[][]  linebreakMatcerClassData = {
					{" \\R ","Any Unicode linebreak sequence, is equivalent to \\u000D\\u000A"},
						
						};


	Object[][]  backReferencesData = {
					{" \\n "," Whatever the nth capturing group matched"},
					{" \\k<name> "," Whatever the named-capturing group \"name\" matched"},

						};


	Object[][]  quotationData = {
					{" \\ "," Nothing, but quotes the following character"},
					{" \\Q "," Nothing, but quotes all characters until \\E"},
					{" \\E "," Nothing, but ends quoting started by \\Q"},
									
						};


    Object[][]  specialConstructsData = {
					{" (?<name>X) "," X, as a named-capturing group"},
					{" (?:X) "," X, as a non-capturing group"},
					{" (?idmsuxU-idmsuxU) "," Nothing, but turns match flags i d m s u x U on - off"},
					{" (?idmsux-idmsux:X)  "," 	X, as a non-capturing group with the given flags i d m s u x on - off"},
					{" (?=X) "," X, via zero-width positive lookahead"},
					{" (?!X) "," X, via zero-width negative lookahead"},
					{" (?<=X) "," X, via zero-width positive lookbehind"},
					{" (?<!X) "," X, via zero-width negative lookbehind"},
					{" (?>X) "," X, as an independent, non-capturing group"},						
						

						};


	//tables
	JTable characterClassTable,predefinedCharacterClassTable,boundaryMatcherTable;
	JTable greedyQuantifierTable,reluctantQuantifierTable,posessiveQuantifierTable,logicalOperatorTable;
	JTable commonClassTable,posixCharacterClassTable,someUsefulClassTable,linebreakMatcherClassTable;
	JTable quotationTable,backReferencesTable,specialConstructsTable;
	
	

	public SideBar()
	{

		
		setBackground(Color.BLACK);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(209, 216, 224));
		panel.setForeground(new Color(47, 53, 66));
		panel.setSize(250,500);
		
		JScrollPane scrollpane = new JScrollPane(panel);
		add(scrollpane);
		panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
	
		

		//charcter class table
		characterClassTable = new JTable(CharacterClassData,column_name);
		/*JScrollPane scrollpane1 = new JScrollPane(characterClassTable);
		scrollpane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollpane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);*/
		characterClassTable.getColumnModel().getColumn(1).setPreferredWidth(350);
		characterClassTable.getColumnModel().getColumn(0).setPreferredWidth(5);
		characterClassTable.setRowHeight(30);
		characterClassTable.setBackground(Color.GRAY);
		characterClassTable.setForeground(Color.WHITE);
		characterClassTable.setFont(new Font("",Font.PLAIN,14));
		characterClassTable.setEnabled(false);
		characterClassTable.setGridColor(Color.WHITE);


		//predefined character class table
		predefinedCharacterClassTable = new JTable(PredefinedCharacterClassData,column_name);
		/*JScrollPane scrollpane2 = new JScrollPane(predefinedCharacterClassTable);
		scrollpane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollpane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);*/
		predefinedCharacterClassTable.getColumnModel().getColumn(1).setPreferredWidth(350);
		predefinedCharacterClassTable.getColumnModel().getColumn(0).setPreferredWidth(5);
		predefinedCharacterClassTable.setRowHeight(30);
		predefinedCharacterClassTable.setBackground(Color.GRAY);
		predefinedCharacterClassTable.setForeground(Color.WHITE);
		predefinedCharacterClassTable.setFont(new Font("",Font.PLAIN,14));
		predefinedCharacterClassTable.setEnabled(false);
		predefinedCharacterClassTable.setGridColor(Color.WHITE);
	


		//Boundary Matcher class table
		boundaryMatcherTable = new JTable(BoundaryMatchersData,column_name);
		/*JScrollPane scrollpane3 = new JScrollPane(boundaryMatcherTable);
		scrollpane3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollpane3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);*/
		boundaryMatcherTable.getColumnModel().getColumn(1).setPreferredWidth(350);
		boundaryMatcherTable.getColumnModel().getColumn(0).setPreferredWidth(5);
		boundaryMatcherTable.setRowHeight(30);
		boundaryMatcherTable.setBackground(Color.GRAY);
		boundaryMatcherTable.setForeground(Color.WHITE);
		boundaryMatcherTable.setFont(new Font("",Font.PLAIN,14));
		boundaryMatcherTable.setSize(20,20);
		boundaryMatcherTable.setEnabled(false);
		boundaryMatcherTable.setGridColor(Color.WHITE);
		

		//predefined charcter class table
		greedyQuantifierTable = new JTable(GreedyQuantifierData,column_name);
		/*JScrollPane scrollpane4 = new JScrollPane(greedyQuantifierTable);
		scrollpane4.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollpane4.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);*/
		greedyQuantifierTable.getColumnModel().getColumn(1).setPreferredWidth(350);
		greedyQuantifierTable.getColumnModel().getColumn(0).setPreferredWidth(5);
		greedyQuantifierTable.setRowHeight(30);
		greedyQuantifierTable.setBackground(Color.GRAY);
		greedyQuantifierTable.setForeground(Color.WHITE);
		greedyQuantifierTable.setFont(new Font("",Font.PLAIN,14));
		greedyQuantifierTable.setEnabled(false);
		greedyQuantifierTable.setGridColor(Color.WHITE);
	
		reluctantQuantifierTable = new JTable(ReluctantQuantifierData,column_name);
		/*JScrollPane scrollpane1 = new JScrollPane(reluctantQuantifierTable);
		scrollpane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollpane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);*/
		reluctantQuantifierTable.getColumnModel().getColumn(1).setPreferredWidth(350);
		reluctantQuantifierTable.getColumnModel().getColumn(0).setPreferredWidth(5);
		reluctantQuantifierTable.setRowHeight(30);
		reluctantQuantifierTable.setBackground(Color.GRAY);
		reluctantQuantifierTable.setForeground(Color.WHITE);
		reluctantQuantifierTable.setFont(new Font("",Font.PLAIN,14));
		reluctantQuantifierTable.setEnabled(false);
		reluctantQuantifierTable.setGridColor(Color.WHITE);


		posessiveQuantifierTable = new JTable(PosessiveQuantifierData,column_name);
		/*JScrollPane scrollpane1 = new JScrollPane(posessiveQuantifierTable);
		scrollpane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollpane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);*/
		posessiveQuantifierTable.getColumnModel().getColumn(1).setPreferredWidth(350);
		posessiveQuantifierTable.getColumnModel().getColumn(0).setPreferredWidth(5);
		posessiveQuantifierTable.setRowHeight(30);
		posessiveQuantifierTable.setBackground(Color.GRAY);
		posessiveQuantifierTable.setForeground(Color.WHITE);
		posessiveQuantifierTable.setFont(new Font("",Font.PLAIN,14));
		posessiveQuantifierTable.setEnabled(false);
		posessiveQuantifierTable.setGridColor(Color.WHITE);


		logicalOperatorTable = new JTable(LogicalOperatorData,column_name);
		/*JScrollPane scrollpane1 = new JScrollPane(logicalOperatorTable);
		scrollpane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollpane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);*/
		logicalOperatorTable.getColumnModel().getColumn(1).setPreferredWidth(350);
		logicalOperatorTable.getColumnModel().getColumn(0).setPreferredWidth(5);
		logicalOperatorTable.setRowHeight(30);
		logicalOperatorTable.setBackground(Color.GRAY);
		logicalOperatorTable.setForeground(Color.WHITE);
		logicalOperatorTable.setFont(new Font("",Font.PLAIN,14));
		logicalOperatorTable.setEnabled(false);
		logicalOperatorTable.setGridColor(Color.WHITE);

		commonClassTable = new JTable(CommonClassData,column_name);
		/*JScrollPane scrollpane1 = new JScrollPane(commonClassTable);
		scrollpane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollpane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);*/
		commonClassTable.getColumnModel().getColumn(1).setPreferredWidth(350);
		commonClassTable.getColumnModel().getColumn(0).setPreferredWidth(5);
		commonClassTable.setRowHeight(30);
		commonClassTable.setBackground(Color.GRAY);
		commonClassTable.setForeground(Color.WHITE);
		commonClassTable.setFont(new Font("",Font.PLAIN,14));
		commonClassTable.setEnabled(false);
		commonClassTable.setGridColor(Color.WHITE);


		posixCharacterClassTable = new JTable(posixCharacterClassData,column_name);
		/*JScrollPane scrollpane1 = new JScrollPane(posixCharacterClassTable);
		scrollpane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollpane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);*/
		posixCharacterClassTable.getColumnModel().getColumn(1).setPreferredWidth(350);
		posixCharacterClassTable.getColumnModel().getColumn(0).setPreferredWidth(5);
		posixCharacterClassTable.setRowHeight(30);
		posixCharacterClassTable.setBackground(Color.GRAY);
		posixCharacterClassTable.setForeground(Color.WHITE);
		posixCharacterClassTable.setFont(new Font("",Font.PLAIN,14));
		posixCharacterClassTable.setEnabled(false);
		posixCharacterClassTable.setGridColor(Color.WHITE);


		someUsefulClassTable = new JTable(someUsefuleClassData,column_name);
		/*JScrollPane scrollpane1 = new JScrollPane(someUsefulClassTable);
		scrollpane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollpane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);*/
		someUsefulClassTable.getColumnModel().getColumn(1).setPreferredWidth(350);
		someUsefulClassTable.getColumnModel().getColumn(0).setPreferredWidth(5);
		someUsefulClassTable.setRowHeight(30);
		someUsefulClassTable.setBackground(Color.GRAY);
		someUsefulClassTable.setForeground(Color.WHITE);
		someUsefulClassTable.setFont(new Font("",Font.PLAIN,14));
		someUsefulClassTable.setEnabled(false);
		someUsefulClassTable.setGridColor(Color.WHITE);

		linebreakMatcherClassTable = new JTable(linebreakMatcerClassData,column_name);
		/*JScrollPane scrollpane1 = new JScrollPane(linebreakMatcherClassTable);
		scrollpane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollpane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);*/
		linebreakMatcherClassTable.getColumnModel().getColumn(1).setPreferredWidth(350);
		linebreakMatcherClassTable.getColumnModel().getColumn(0).setPreferredWidth(5);
		linebreakMatcherClassTable.setRowHeight(30);
		linebreakMatcherClassTable.setBackground(Color.GRAY);
		linebreakMatcherClassTable.setForeground(Color.WHITE);
		linebreakMatcherClassTable.setFont(new Font("",Font.PLAIN,14));
		linebreakMatcherClassTable.setEnabled(false);
		linebreakMatcherClassTable.setGridColor(Color.WHITE);


		backReferencesTable = new JTable(backReferencesData,column_name);
		/*JScrollPane scrollpane1 = new JScrollPane(backReferencesTable);
		scrollpane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollpane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);*/
		backReferencesTable.getColumnModel().getColumn(1).setPreferredWidth(350);
		backReferencesTable.getColumnModel().getColumn(0).setPreferredWidth(5);
		backReferencesTable.setRowHeight(30);
		backReferencesTable.setBackground(Color.GRAY);
		backReferencesTable.setForeground(Color.WHITE);
		backReferencesTable.setFont(new Font("",Font.PLAIN,14));
		backReferencesTable.setEnabled(false);
		backReferencesTable.setGridColor(Color.WHITE);

		quotationTable = new JTable(quotationData,column_name);
		/*JScrollPane scrollpane1 = new JScrollPane(quotationTable);
		scrollpane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollpane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);*/
		quotationTable.getColumnModel().getColumn(1).setPreferredWidth(350);
		quotationTable.getColumnModel().getColumn(0).setPreferredWidth(5);
		quotationTable.setRowHeight(30);
		quotationTable.setBackground(Color.GRAY);
		quotationTable.setForeground(Color.WHITE);
		quotationTable.setFont(new Font("",Font.PLAIN,14));
		quotationTable.setEnabled(false);
		quotationTable.setGridColor(Color.WHITE);

		specialConstructsTable = new JTable(specialConstructsData,column_name);
		/*JScrollPane scrollpane1 = new JScrollPane(specialConstructsTable);
		scrollpane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollpane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);*/
		specialConstructsTable.getColumnModel().getColumn(1).setPreferredWidth(350);
		specialConstructsTable.getColumnModel().getColumn(0).setPreferredWidth(5);
		specialConstructsTable.setRowHeight(30);
		specialConstructsTable.setBackground(Color.GRAY);
		specialConstructsTable.setForeground(Color.WHITE);
		specialConstructsTable.setFont(new Font("",Font.PLAIN,14));
		specialConstructsTable.setEnabled(false);
		specialConstructsTable.setGridColor(Color.WHITE);

		//table headning
		characterClassHeading.setFont(new Font("",Font.BOLD,16));
		predefinedCharacterClassHeading.setFont(new Font("",Font.BOLD,16));
		boundaryMatcherClassHeading.setFont(new Font("",Font.BOLD,16));
		greedyQuantifierHeading.setFont(new Font("",Font.BOLD,16));
		reluctantQuantifierHeading.setFont(new Font("",Font.BOLD,16));
		posessiveQuantifierHeading.setFont(new Font("",Font.BOLD,16));
		logicalOperatorHeading.setFont(new Font("",Font.BOLD,16));
		commonClassHeading.setFont(new Font("",Font.BOLD,16));
		posixCharacterClassHeading.setFont(new Font("",Font.BOLD,16));
		someUsefulClassHeading.setFont(new Font("",Font.BOLD,16));
		linebreakMatcherClassHeading.setFont(new Font("",Font.BOLD,16));
		backReferencesHeading.setFont(new Font("",Font.BOLD,16));
		quotationHeading.setFont(new Font("",Font.BOLD,16));
		specialConstructsHeading.setFont(new Font("",Font.BOLD,16));






		
		panel.add(Box.createRigidArea(new Dimension(0,5)));
		panel.add(characterClassHeading);
		panel.add(Box.createRigidArea(new Dimension(0,5)));
		panel.add(characterClassTable.getTableHeader());
		panel.add(characterClassTable);
		
		panel.add(Box.createRigidArea(new Dimension(0,5)));
		panel.add(predefinedCharacterClassHeading);
		panel.add(Box.createRigidArea(new Dimension(0,5)));
		panel.add(predefinedCharacterClassTable.getTableHeader());
		panel.add(predefinedCharacterClassTable);
		
		panel.add(Box.createRigidArea(new Dimension(0,5)));
		panel.add(boundaryMatcherClassHeading);
		panel.add(Box.createRigidArea(new Dimension(0,5)));
		panel.add(boundaryMatcherTable.getTableHeader());
		panel.add(boundaryMatcherTable);
		
		panel.add(Box.createRigidArea(new Dimension(0,5)));
		panel.add(greedyQuantifierHeading);
		panel.add(Box.createRigidArea(new Dimension(0,5)));
		panel.add(greedyQuantifierTable.getTableHeader());
		panel.add(greedyQuantifierTable);

		panel.add(Box.createRigidArea(new Dimension(0,5)));
		panel.add(reluctantQuantifierHeading);
		panel.add(Box.createRigidArea(new Dimension(0,5)));
		panel.add(reluctantQuantifierTable.getTableHeader());
		panel.add(reluctantQuantifierTable);

		panel.add(Box.createRigidArea(new Dimension(0,5)));
		panel.add(posessiveQuantifierHeading);
		panel.add(Box.createRigidArea(new Dimension(0,5)));
		panel.add(posessiveQuantifierTable.getTableHeader());
		panel.add(posessiveQuantifierTable);

		panel.add(Box.createRigidArea(new Dimension(0,5)));
		panel.add(logicalOperatorHeading);
		panel.add(Box.createRigidArea(new Dimension(0,5)));
		panel.add(logicalOperatorTable.getTableHeader());
		panel.add(logicalOperatorTable);
			
		panel.add(Box.createRigidArea(new Dimension(0,5)));
		panel.add(commonClassHeading);
		panel.add(Box.createRigidArea(new Dimension(0,5)));
		panel.add(commonClassTable.getTableHeader());
		panel.add(commonClassTable);

		panel.add(Box.createRigidArea(new Dimension(0,5)));
		panel.add(someUsefulClassHeading);
		panel.add(Box.createRigidArea(new Dimension(0,5)));
		panel.add(someUsefulClassTable.getTableHeader());
		panel.add(someUsefulClassTable);

		panel.add(Box.createRigidArea(new Dimension(0,5)));
		panel.add(posixCharacterClassHeading);
		panel.add(Box.createRigidArea(new Dimension(0,5)));
		panel.add(posixCharacterClassTable.getTableHeader());
		panel.add(posixCharacterClassTable);

		panel.add(Box.createRigidArea(new Dimension(0,5)));
		panel.add(linebreakMatcherClassHeading);
		panel.add(Box.createRigidArea(new Dimension(0,5)));
		panel.add(linebreakMatcherClassTable.getTableHeader());
		panel.add(linebreakMatcherClassTable);

		panel.add(Box.createRigidArea(new Dimension(0,5)));
		panel.add(quotationHeading);
		panel.add(Box.createRigidArea(new Dimension(0,5)));
		panel.add(quotationTable.getTableHeader());
		panel.add(quotationTable);

		panel.add(Box.createRigidArea(new Dimension(0,5)));
		panel.add(backReferencesHeading);
		panel.add(Box.createRigidArea(new Dimension(0,5)));
		panel.add(backReferencesTable.getTableHeader());
		panel.add(backReferencesTable);

		panel.add(Box.createRigidArea(new Dimension(0,5)));
		panel.add(specialConstructsHeading);
		panel.add(Box.createRigidArea(new Dimension(0,5)));
		panel.add(specialConstructsTable.getTableHeader());
		panel.add(specialConstructsTable);

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