package map;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jpl7.*;

public class gui extends JFrame implements ActionListener

{
	private static final LayoutManager GridLayout = null;
	private static final LayoutManager FlowLayout = null;
	JLabel l1;
	JButton b1;
	JTextField t1;
	JPanel p1;

	public gui(String Title)

	{

		l1 = new JLabel(" rethus ");
		b1 = new JButton("find");
		t1 = new JTextField();
		p1 = new JPanel();
		this.setTitle(Title);
		this.setSize(700, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		p1.setSize(700, 400);
		this.setLayout(new GridLayout(3, 1));

		this.add(t1);

		this.add(p1);

		this.add(l1);

		p1.add(b1);

		String swi = "consult('C:/Users/asdcx/eclipse-workspace/map/map.pl')";
		Query q1 = new Query(swi);
		System.out.println(q1.hasSolution() ? "ss" : "ff");

		b1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {

			String s1 = t1.getText().toString().toLowerCase();

			char[] c = s1.toCharArray();

			int size = s1.length();

			c[size - 1] = ',';

			//System.out.println(c);
			String s2 = new String(c);
		//	System.out.println(s2);
			String s3 = s2 + "A).";
			System.out.println(s3);
			Query Q2 = new Query(s3);
			if (Q2.hasSolution()) {

				String s = Q2.oneSolution().get("A").toString();
			
				s=s.replace("\'", "");
				s=s.replace("|", "");
				s=s.replace("[", "");
				s=s.replace(")", "");
				s=s.replace("(", "");
				s=s.replace("]", "");
				s=s.replace("_", " ");
				s=s.replace(",", " ");
				
		
			//	System.out.println(s);
				l1.setText(s);

			} else
				l1.setText("that not place plese enter again ");

		}

	}

}
