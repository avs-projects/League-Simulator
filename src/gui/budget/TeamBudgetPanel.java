package gui.budget;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import gui.main.LeagueGUI;
import gui.main.MyButton;
import gui.main.MyImageButton;
import process.league.LeagueInterface;

public class TeamBudgetPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	protected JPanel revbudget = new JPanel();
	protected static JLabel revLabel[] = new JLabel[7];
	
	protected JLabel info[] = new JLabel[6];
	
	protected static MyButton revButton[] = new MyButton[30];
	protected static MyButton depButton[] = new MyButton[30];
	
	protected static MyImageButton[] pieRevButton = new MyImageButton[1];
	protected static MyImageButton[] pieDepButton = new MyImageButton[3];
	
	protected static JLabel teamsPlayers[] = new JLabel[10];
	protected static JLabel salaryPlayers[] = new JLabel[10];
	protected static JLabel ratingPlayers[] = new JLabel[10];

	protected static JPanel revpie = new JPanel();
	protected static JPanel deppie = new JPanel();
	
	protected static LeagueInterface l = LeagueGUI.getLeague();
	
	public TeamBudgetPanel() {
		
		addLabel(revLabel);
		
		addButton(revButton,0);
		
		addButton(depButton,1);
		
		addIcon(pieRevButton);
		
		addIcon(pieDepButton);
		
		addLabel(teamsPlayers);
		
		addLabel(salaryPlayers);
		
		addLabel(ratingPlayers);
		
		addLabel(info);

		initStyle();
		
		initLayout();
		
		initActions();
		
	}
	
	private void initActions() {
		
		for(int i=0;i<revButton.length;i++) {
		revButton[i].addActionListener(new changeBudget(i,"Revenus"));
		depButton[i].addActionListener(new changeBudget(i,"Dépenses"));
		}
		
		pieRevButton[0].addActionListener(new showRevPie());
		pieDepButton[0].addActionListener(new showDepPie());
		pieDepButton[1].addActionListener(new showDepPieSalary());
		pieDepButton[2].addActionListener(new showDepPieLogistic());


	}
	
	protected void initStyle() {
		
		setBounds(500,10,750,750);
		setBackground(new Color(240,240,240));
		setLayout(null);
		
		revpie.setBounds(440,0,270,190);
		revpie.setLayout(new java.awt.BorderLayout());
		
		deppie.setBounds(440,190,270,190);
		deppie.setLayout(new java.awt.BorderLayout());
		
		revbudget.setBounds(0,0,350,380);
		revbudget.setBackground(Color.WHITE);
		revbudget.setLayout(null);
		
		for(int i=0;i<revButton.length;i++) {
		
		revButton[i].setBounds(0,0,175,40);
		revButton[i].setBackground(Color.WHITE);
		revButton[i].setForeground(Color.BLACK);
		
		depButton[i].setBounds(175,0,175,40);
		depButton[i].setBackground(Color.LIGHT_GRAY);
		depButton[i].setForeground(Color.BLACK);
		
		}
		
		int y = 250;
		
		for (int i = 0; i< pieRevButton.length; i++) {
			pieRevButton[i].setBounds(320, y, 30, 34);			
			pieRevButton[i].setBackground(Color.WHITE);
			y=y+35;
		}
		
		y = 250;
		
		for (int i = 0; i< pieDepButton.length; i++) {
			pieDepButton[i].setBounds(320, y, 30, 34);			
			pieDepButton[i].setBackground(Color.WHITE);
			y=y+35;
		}
		
		y = 430;
		
		for (int i = 0; i< teamsPlayers.length; i++) {
			if(i%2==0) {
				teamsPlayers[i].setBounds(0,y,200,42);
				salaryPlayers[i].setBounds(200,y,100,42);
				ratingPlayers[i].setBounds(300,y,50,42);
			}
			else {
				teamsPlayers[i].setBounds(360,y,200,42);
				salaryPlayers[i].setBounds(560,y,100,42);
				ratingPlayers[i].setBounds(660,y,50,42);
				y=y+42;
			}
			salaryPlayers[i].setForeground(Color.BLACK);
			salaryPlayers[i].setBackground(Color.WHITE);
			salaryPlayers[i].setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
			salaryPlayers[i].setOpaque(true);

			teamsPlayers[i].setForeground(Color.BLACK);
			teamsPlayers[i].setBackground(Color.WHITE);
			teamsPlayers[i].setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
			teamsPlayers[i].setOpaque(true);
			
			ratingPlayers[i].setForeground(Color.BLACK);
			ratingPlayers[i].setBackground(Color.WHITE);
			ratingPlayers[i].setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
			ratingPlayers[i].setOpaque(true);
		}
		
		info[0].setBounds(0,400,200,30);
		info[0].setText("Nom");
		info[0].setHorizontalAlignment(SwingConstants.CENTER);

		info[1].setBounds(200,400,100,30);
		info[1].setText("Salaire (en €)");

		info[2].setBounds(300,400,50,30);
		info[2].setText("Note");

		info[3].setBounds(360,400,200,30);
		info[3].setText("Nom");
		info[3].setHorizontalAlignment(SwingConstants.CENTER);

		info[4].setBounds(560,400,100,30);
		info[4].setText("Salaire (en $)");

		info[5].setBounds(660,400,50,30);
		info[5].setText("Note");
		
		for(int i=0;i<info.length;i++) {
			info[i].setForeground(Color.WHITE);
			info[i].setBackground(new Color(17,35,63));
			info[i].setOpaque(true);
		}


		setRevLabelStyle(revLabel,0,40,350,35,35);
		
	}
	
	protected void initLayout() {
		
		setLabelLayout(revLabel,true,revbudget);
		
		for(int i=0;i<revButton.length;i++) {
			add(revButton[i]);
			add(depButton[i]);
			revButton[i].setVisible(false);
			depButton[i].setVisible(false);

		}
		
		add(deppie);
		add(revpie);
		add(revbudget);
		
		for(int i=0;i<pieRevButton.length;i++) {
			revbudget.add(pieRevButton[i]);
			revbudget.add(pieDepButton[i]);
			pieRevButton[i].setVisible(false);
			pieDepButton[i].setVisible(false);
		}
		
		for(int i=0;i<teamsPlayers.length;i++) {
			add(teamsPlayers[i]);
			add(salaryPlayers[i]);
			add(ratingPlayers[i]);
		
		}
		
		for(int i=0;i<info.length;i++) {
			add(info[i]);
		}
		
		for(int i=0;i<pieDepButton.length;i++) {
			revbudget.add(pieDepButton[i]);
			pieDepButton[i].setVisible(false);
		}
		
	}
	
	public void setRevLabelStyle (JLabel[] jlabel, int x, int y, int width, int height, int sum) {
		for (int i = 0; i< jlabel.length; i++) {
			if(i==0) { 
				jlabel[i].setBounds(x, y, width, height+50); 
				jlabel[i].setHorizontalAlignment(SwingConstants.CENTER);

				y=y+sum+50;
			}
			else if(i==1) {
				jlabel[i].setBounds(x, y, width, height+20); 
				jlabel[i].setHorizontalAlignment(SwingConstants.CENTER);
				jlabel[i].setBackground(new Color(17,35,63));
				jlabel[i].setForeground(Color.WHITE);
				jlabel[i].setOpaque(true);
				y=y+sum+20;

			}
			else {
				jlabel[i].setBounds(x, y, width, height);
				jlabel[i].setForeground(Color.BLACK);		

				y=y+sum;
			}
			jlabel[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
		}
	}
	
	public void setLabelLayout (JLabel[] jlabel, Boolean bool, JPanel jpanel) {
		for (int i = 0; i< jlabel.length; i++) {
			jpanel.add(jlabel[i]);
			jlabel[i].setVisible(bool);
		}
	}	

	public void addLabel(JLabel[] jlabel){
        for (int i = 0; i < jlabel.length; i++){
            jlabel[i] = new JLabel();
        }
    }
	
	public void addButton(MyButton[] jbutton, int bool){
		if(bool==0) {
        for (int i = 0; i < jbutton.length; i++){
        	jbutton[i] = new MyButton("Revenus");
        }
		}
		else {
			for (int i = 0; i < jbutton.length; i++){
	        	jbutton[i] = new MyButton("Dépenses");
	        }
		}
    }
	
	public void addIcon(MyImageButton[] Jbutton){
        for (int i = 0; i < Jbutton.length; i++){
        	Jbutton[i] = new MyImageButton("/images/pie-24.png","pie");
        	Jbutton[i].setBackground(new Color(67, 31, 114));
        }
    }
	
	public class changeBudget implements ActionListener {
		
		private String category;
		private int index;
		
		public changeBudget(int index,String category) {
			this.category=category;
			this.index=index;
		}
		
		public void actionPerformed(ActionEvent e) { 
			
			searchAction(index,category);
		
		}
	}
	
	public void teamBudgetEdit(int index) {
		
		 searchAction(index,"Revenus");
		 
		 revpie.setVisible(false); 
			revpie.removeAll();
			
			String name = revLabel[1].getText();
			
			final DefaultPieDataset pieDataset = new DefaultPieDataset();
			pieDataset.setValue("Tickets", l.getTeam(name).getBudget().getEarnings().getEarningsPerMonth().getSeatSellingPerMonth()
					.get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()).get(l.getTeam(name).getBudget().getEarnings().getEarningsPerMonth().
							getSeatSellingPerMonth().get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()).size()-1));
			pieDataset.setValue("Droits TV", l.getTeam(name).getBudget().getEarnings().getEarningsPerMonth().getTvRightPerMonth()	
					.get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()).get(l.getTeam(name).getBudget().getEarnings().getEarningsPerMonth().
							getTvRightPerMonth().get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()).size()-1));
			JFreeChart chart = ChartFactory.createPieChart("", pieDataset, true, true, false);
			ChartPanel frame = new ChartPanel(chart);
			frame.setBackground(Color.WHITE);
			revpie.add(frame, BorderLayout.CENTER);
			revpie.setVisible(true); 
			
			deppie.setVisible(false); 
			deppie.removeAll();
						
			final DefaultPieDataset pieDataset2 = new DefaultPieDataset();
			pieDataset2.setValue("Salaires", l.getTeam(name).getBudget().getExpenses().getExpensesPerMonth().getSalaryPerMonth()
					.get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()).get(l.getTeam(name).getBudget().getExpenses().getExpensesPerMonth().
							getSalaryPerMonth().get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()).size()-1));
			pieDataset2.setValue("Logistiques",l.getTeam(name).getBudget().getExpenses().getExpensesPerMonth().getLogisticPerMonth()
					.get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()).get(l.getTeam(name).getBudget().getExpenses().getExpensesPerMonth().
							getLogisticPerMonth().get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()).size()-1));
			JFreeChart chart2 = ChartFactory.createPieChart("", pieDataset2, true, true, false);
			ChartPanel frame2 = new ChartPanel(chart2);
			deppie.add(frame2, BorderLayout.CENTER);
			deppie.setVisible(true); 
	}
	
	public static void searchAction (int i, String category) {
		
		for(int j=0;j<revButton.length;j++) {
			revButton[j].setVisible(false);
		}
		for(int j=0;j<depButton.length;j++) {
			depButton[j].setVisible(false);
		}
		
		if(category.equals("Revenus")) {
			
			for(int j=0;j<pieRevButton.length;j++) {
				pieRevButton[j].setVisible(true);
			}
			for(int j=0;j<pieDepButton.length;j++) {
				pieDepButton[j].setVisible(false);
			}
			revButton[i].setBackground(Color.WHITE);
			
			depButton[i].setBackground(Color.LIGHT_GRAY);
			revLabel[0].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/teams/"+l.getTeamList().get(i).getNickname()+".png")));
			revLabel[1].setText(l.getTeamList().get(i).getName());
			revLabel[2].setText("  Budget : "+numberFormat(l.getTeamList().get(i).getBudget().getBudget())+" €");
			revLabel[3].setText("  Revenus total : "+ numberFormat(l.getTeamList().get(i).getBudget().getEarnings().getTvRight().getTvRight()
					+l.getTeamList().get(i).getBudget().getEarnings().getTicketSales().getTicketSales())+" €");
			revLabel[4].setText("  Revenus ce mois-ci : "+numberFormat(l.getTeamList().get(i).getBudget().getEarnings().getEarningsPerMonth().getSeatSellingPerMonth()
					.get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()).get(l.getTeamList().get(i).getBudget().getEarnings().getEarningsPerMonth().
							getSeatSellingPerMonth().get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()).size()-1)+l.getTeamList().get(i).getBudget().getEarnings().getEarningsPerMonth().getTvRightPerMonth()
					.get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()).get(l.getTeamList().get(i).getBudget().getEarnings().getEarningsPerMonth().
							getTvRightPerMonth().get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()).size()-1)
					)+ " €");
			revLabel[5].setText("  Recettes au guichet : "+numberFormat(l.getTeamList().get(i).getBudget().getEarnings().getEarningsPerMonth().getSeatSellingPerMonth()
					.get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()).get(l.getTeamList().get(i).getBudget().getEarnings().getEarningsPerMonth().
							getSeatSellingPerMonth().get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()).size()-1))+" €");
			revLabel[6].setText("  Droits de diffusion : "+numberFormat(l.getTeamList().get(i).getBudget().getEarnings().getEarningsPerMonth().getTvRightPerMonth()	
					.get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()).get(l.getTeamList().get(i).getBudget().getEarnings().getEarningsPerMonth().
							getTvRightPerMonth().get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()).size()-1))+" €");
			
			for(int j=0; j<teamsPlayers.length;j++) {
				teamsPlayers[j].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/players/64x64/"
						+l.getTeamList().get(i).getSquad().get(j).getId()+".png")));
				teamsPlayers[j].setText(l.getTeamList().get(i).getSquad().get(j).getName());
				salaryPlayers[j].setText(""+numberFormat(l.getTeamList().get(i).getSquad().get(j).getSalary()));
				ratingPlayers[j].setText(""+l.getTeamList().get(i).getSquad().get(j).getOverallRating());
			}
		}
	else {
		
		for(int j=0;j<pieRevButton.length;j++) {
			pieRevButton[j].setVisible(false);
		}
		for(int j=0;j<pieDepButton.length;j++) {
			pieDepButton[j].setVisible(true);
		}
		
		depButton[i].setBackground(Color.WHITE);
		revButton[i].setBackground(Color.LIGHT_GRAY);
		
		revLabel[0].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/teams/"+l.getTeamList().get(i).getNickname()+".png")));
		revLabel[1].setText(l.getTeamList().get(i).getName());
		revLabel[2].setText("  Budget : "+numberFormat(l.getTeamList().get(i).getBudget().getBudget())+" €" );
		revLabel[3].setText("  Dépenses total : "+ numberFormat((l.getTeamList().get(i).getBudget().getExpenses().getSalary()+l.getTeamList().get(i).getBudget().getExpenses().getLogistic()))+" €");
		revLabel[4].setText("  Dépenses ce mois-ci : "+numberFormat(l.getTeamList().get(i).getBudget().getExpenses().getExpensesPerMonth().getLogisticPerMonth()
				.get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()).get(l.getTeamList().get(i).getBudget().getExpenses().getExpensesPerMonth().
						getLogisticPerMonth().get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()).size()-1)+l.getTeamList().get(i).getBudget().getExpenses().getExpensesPerMonth().getSalaryPerMonth()
				.get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()).get(l.getTeamList().get(i).getBudget().getExpenses().getExpensesPerMonth().getSalaryPerMonth().
						get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()).size()-1))+ " €");
		revLabel[5].setText("  Salaires : "+numberFormat(l.getTeamList().get(i).getBudget().getExpenses().getExpensesPerMonth().getSalaryPerMonth()
				.get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()).get(l.getTeamList().get(i).getBudget().getExpenses().getExpensesPerMonth().getSalaryPerMonth()
						.get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()).size()-1))+" €");
		revLabel[6].setText("  Logistiques : "+numberFormat(l.getTeamList().get(i).getBudget().getExpenses().getExpensesPerMonth().getLogisticPerMonth()
				.get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()).get(l.getTeamList().get(i).getBudget().getExpenses().getExpensesPerMonth().
						getLogisticPerMonth().get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()).size()-1))+" €");
	}
		revButton[i].setVisible(true);
		depButton[i].setVisible(true);
		
		revpie.setVisible(false); 
		revpie.removeAll();
		
		String name = revLabel[1].getText();
		
		final DefaultPieDataset pieDataset = new DefaultPieDataset();
		pieDataset.setValue("Tickets", l.getTeam(name).getBudget().getEarnings().getEarningsPerMonth().getSeatSellingPerMonth()
				.get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()).get(l.getTeam(name).getBudget().getEarnings().getEarningsPerMonth().
						getSeatSellingPerMonth().get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()).size()-1));
		pieDataset.setValue("Droits TV", l.getTeam(name).getBudget().getEarnings().getEarningsPerMonth().getTvRightPerMonth()	
				.get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()).get(l.getTeam(name).getBudget().getEarnings().getEarningsPerMonth().
						getTvRightPerMonth().get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()).size()-1));
		
		JFreeChart chart = ChartFactory.createPieChart("", pieDataset, true, true, false);
		ChartPanel frame = new ChartPanel(chart);
		frame.setBackground(Color.WHITE);
		revpie.add(frame, BorderLayout.CENTER);	
		revpie.setVisible(true);
		
		deppie.setVisible(false); 
		deppie.removeAll();
		final DefaultPieDataset pieDataset2 = new DefaultPieDataset();
		pieDataset2.setValue("Salaires", l.getTeam(name).getBudget().getExpenses().getExpensesPerMonth().getSalaryPerMonth()
				.get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()).get(l.getTeam(name).getBudget().getExpenses().getExpensesPerMonth().
						getSalaryPerMonth().get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()).size()-1));
		pieDataset2.setValue("Logistiques",l.getTeam(name).getBudget().getExpenses().getExpensesPerMonth().getLogisticPerMonth()
				.get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()).get(l.getTeam(name).getBudget().getExpenses().getExpensesPerMonth().
						getLogisticPerMonth().get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()).size()-1));
		JFreeChart chart2 = ChartFactory.createPieChart("", pieDataset2, true, true, false);
		ChartPanel frame2 = new ChartPanel(chart2);
		deppie.add(frame2, BorderLayout.CENTER);
		deppie.setVisible(true); 
}
	
	private class showRevPie implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			revpie.setVisible(false); 
			revpie.removeAll();
			
			String name = revLabel[1].getText();
			
			final DefaultPieDataset pieDataset = new DefaultPieDataset();
			pieDataset.setValue("Tickets", l.getTeam(name).getBudget().getEarnings().getEarningsPerMonth().getSeatSellingPerMonth()
					.get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()).get(l.getTeam(name).getBudget().getEarnings().getEarningsPerMonth().
							getSeatSellingPerMonth().get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()).size()-1));
			pieDataset.setValue("Droits TV", l.getTeam(name).getBudget().getEarnings().getEarningsPerMonth().getTvRightPerMonth()	
					.get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()).get(l.getTeam(name).getBudget().getEarnings().getEarningsPerMonth().
							getTvRightPerMonth().get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()).size()-1));
			JFreeChart chart = ChartFactory.createPieChart("", pieDataset, true, true, false);
			ChartPanel frame = new ChartPanel(chart);
			frame.setBackground(Color.WHITE);
			revpie.add(frame, BorderLayout.CENTER);
			revpie.setVisible(true); 
		}
	}
	
	private class showDepPie implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			deppie.setVisible(false); 
			deppie.removeAll();
			
			String name = revLabel[1].getText();
			
			final DefaultPieDataset pieDataset = new DefaultPieDataset();
			pieDataset.setValue("Salaires", l.getTeam(name).getBudget().getExpenses().getExpensesPerMonth().getSalaryPerMonth()
					.get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()).get(l.getTeam(name).getBudget().getExpenses().getExpensesPerMonth().
							getSalaryPerMonth().get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()).size()-1));
			pieDataset.setValue("Logistiques",l.getTeam(name).getBudget().getExpenses().getExpensesPerMonth().getLogisticPerMonth()
					.get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()).get(l.getTeam(name).getBudget().getExpenses().getExpensesPerMonth().
							getLogisticPerMonth().get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()).size()-1));
			JFreeChart chart = ChartFactory.createPieChart("", pieDataset, true, true, false);
			ChartPanel frame = new ChartPanel(chart);
			deppie.add(frame, BorderLayout.CENTER);
			deppie.setVisible(true); 
		}
	}
	
	private class showDepPieSalary implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			deppie.setVisible(false); 
			deppie.removeAll();
			
			String name = revLabel[1].getText();
			
			final DefaultPieDataset pieDataset = new DefaultPieDataset();
			pieDataset.setValue("Salaires(joueurs)", l.getTeam(name).getBudget().getExpenses().getExpensesPerMonth().getSpm().getPlayersSalary()
					.get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()));
			pieDataset.setValue("Salaire(coach)",l.getTeam(name).getBudget().getExpenses().getExpensesPerMonth().getSpm().getCoachSalary()
					.get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()));
			JFreeChart chart = ChartFactory.createPieChart("", pieDataset, true, true, false);
			ChartPanel frame = new ChartPanel(chart);
			deppie.add(frame, BorderLayout.CENTER);
			deppie.setVisible(true); 
		}
	}
	
	private class showDepPieLogistic implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			deppie.setVisible(false); 
			deppie.removeAll();
			
			String name = revLabel[1].getText();
			
			final DefaultPieDataset pieDataset = new DefaultPieDataset();
			pieDataset.setValue("Voyages", l.getTeam(name).getBudget().getExpenses().getExpensesPerMonth().getLpm().getTravel()
					.get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()));
			pieDataset.setValue("Loyer du stade",l.getTeam(name).getBudget().getExpenses().getExpensesPerMonth().getLpm().getStadiumRent()
					.get(l.getGames().get(l.getNbJourney()-1).getMonth()+l.getGames().get(l.getNbJourney()-1).getYear()));
			JFreeChart chart = ChartFactory.createPieChart("", pieDataset, true, true, false);
			ChartPanel frame = new ChartPanel(chart);
			deppie.add(frame, BorderLayout.CENTER);
			deppie.setVisible(true); 
		}
	}
	
	public static String numberFormat(long number) {
		DecimalFormat format = new DecimalFormat("###,###,###" ); 
		DecimalFormatSymbols s = format.getDecimalFormatSymbols();
		s.setGroupingSeparator(' ');
		format.setDecimalFormatSymbols(s);
		return 	format.format(number);

	}
}
