package gui.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import gui.balancesheet.BalanceSheetPanel;
import gui.map.MapPanel;
import process.league.League;
import process.league.LeagueInterface;

public class LeagueGUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private final static LeagueInterface league =  new League();

	protected JPanel contentPane = new JPanel();
	
	protected JPanel menuPanel = new JPanel();
	protected JPanel infoPanel = new JPanel();
	
	protected HomePanel homePanel = new HomePanel();
	protected BudgetPanel budgetPanel = new BudgetPanel();
	protected RankPanel rankPanel = new RankPanel();
	protected PlayOffPanel playOffPanel = new PlayOffPanel();
	protected EventPanel eventPanel = new EventPanel();
	protected BalanceSheetPanel balanceSheetPanel = new BalanceSheetPanel();
	protected MapPanel mapPanel = new MapPanel();
	
	protected JLabel event = new JLabel("Saison régulière");
	protected JLabel year = new JLabel("Année 1/6 - 2019-2020");

	protected MyButton homeButton = new MyButton("Match joués");
	protected MyButton budgetButton = new MyButton("Budget");
	protected MyButton mapButton = new MyButton("Carte");
	protected MyButton poButton = new MyButton("PlayOff");
	protected MyButton infoButton = new MyButton("Info NBA");
	protected MyButton rankButton = new MyButton("Classement");
	
	protected MyButton nextButton = new MyButton("Suivant");
	protected MyButton skipButton = new MyButton("SKIP");
	
	public LeagueGUI(String title) {
		
		super(title);
		
		initActions();
		
		initStyle();

		initLayout();
						
		homePanel.edit(league);
		rankPanel.edit(league);
		budgetPanel.edit(league);
		playOffPanel.edit(league);
		eventPanel.edit(league);
		homePanel.setVisible(true);
	}
	
	protected void initActions() {
		
		homeButton.addActionListener(new changeHome());
		nextButton.addActionListener(new change());
		budgetButton.addActionListener(new changeBudget());
		rankButton.addActionListener(new changeRank());
		skipButton.addActionListener(new skip());
		mapButton.addActionListener(new changeMap());
		poButton.addActionListener(new changePlayOff());
		infoButton.addActionListener(new changeInfo());

	}
	
	protected void initStyle() {
		
		event.setBounds(20,0,400,45);
		event.setForeground(Color.WHITE);
		event.setFont(new Font("Times",Font.BOLD,20));
		
		year.setBounds(550,0,250,45);
		year.setForeground(Color.WHITE);
		year.setFont(new Font("Times",Font.BOLD,20));
		year.setHorizontalAlignment(SwingConstants.RIGHT);
		
		menuPanel.setBounds(0,0,110,870);
		menuPanel.setBackground(new Color(60,60,60));
		menuPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.WHITE));
		menuPanel.setLayout(null);
		
		infoPanel.setBounds(110,0,1300,45);
		infoPanel.setBackground(new Color(17,35,63));
		infoPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		infoPanel.setLayout(null);
		
		homeButton.setBounds(0, 0, 109, 60);
		homeButton.setForeground(Color.WHITE);
		rankButton.setBounds(0, 60,109, 60);
		rankButton.setForeground(Color.WHITE);
		budgetButton.setBounds(0, 120, 109, 60);
		budgetButton.setForeground(Color.WHITE);
		mapButton.setBounds(0, 180, 109, 60);
		mapButton.setForeground(Color.WHITE);
		poButton.setBounds(0, 240, 109, 60);
		poButton.setForeground(Color.WHITE);
		infoButton.setBounds(0, 300, 109, 60);
		infoButton.setForeground(Color.WHITE);
		
		nextButton.setBounds(1200, 5, 100, 33);

		skipButton.setBounds(900, 5, 200, 33);
		skipButton.setForeground(Color.WHITE);
		infoButton.setForeground(Color.WHITE);

		
	}
	
	protected void initLayout() {
		
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setBounds(0,0,1415,800);
		setResizable(false);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(240,240,240));

		
		menuPanel.add(homeButton);
		menuPanel.add(budgetButton);
		menuPanel.add(mapButton);
		menuPanel.add(poButton);
		menuPanel.add(rankButton);
		menuPanel.add(infoButton);
		
		infoPanel.add(nextButton);
		infoPanel.add(skipButton);
		infoPanel.add(event);
		infoPanel.add(year);
		
		contentPane.add(menuPanel);
		contentPane.add(infoPanel);
		contentPane.add(homePanel);
		contentPane.add(budgetPanel);
		contentPane.add(rankPanel);
		contentPane.add(playOffPanel);
		contentPane.add(eventPanel);
		contentPane.add(balanceSheetPanel);
		contentPane.add(mapPanel);
		
		budgetPanel.setVisible(false);
		rankPanel.setVisible(false);
		playOffPanel.setVisible(false);
		eventPanel.setVisible(false);
		balanceSheetPanel.setVisible(false);	
		mapPanel.setVisible(false);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public class changeHome implements ActionListener {
		
		public void actionPerformed(ActionEvent clic) {
			
			homeButton.setBackground(new Color(60,60,60));
			
			rankButton.setBackground(new Color(60,60,60));

			budgetButton.setBackground(new Color(60,60,60));

			mapButton.setBackground(new Color(60,60,60));

			poButton.setBackground(new Color(60,60,60));

			infoButton.setBackground(new Color(60,60,60));

			budgetPanel.setVisible(false);
			rankPanel.setVisible(false);
			homePanel.setVisible(true);
			playOffPanel.setVisible(false);
			balanceSheetPanel.setVisible(false);
			eventPanel.setVisible(false);
			mapPanel.setVisible(false);

			homeButton.setBackground(new Color(17,35,63));
			
		}
	}
	
	
	public class change implements ActionListener {
		
		public void actionPerformed(ActionEvent clic) {
			
			homeButton.setBackground(new Color(60,60,60));
			
			rankButton.setBackground(new Color(60,60,60));

			budgetButton.setBackground(new Color(60,60,60));

			mapButton.setBackground(new Color(60,60,60));

			poButton.setBackground(new Color(60,60,60));

			infoButton.setBackground(new Color(60,60,60));
	
			if(!eventPanel.isVisible()) {
				year.setText("Année "+((league.getGames().get(league.getNbJourney()-1).getYear())-2019)+"/5 - "+(league.getGames().get(league.getNbJourney()-1).getYear()-1)+"-"+
						league.getGames().get(league.getNbJourney()-1).getYear());
			homePanel.edit(league);
			rankPanel.edit(league);
			budgetPanel.edit(league);
			playOffPanel.edit(league);
			eventPanel.edit(league);
			balanceSheetPanel.edit(league);
			
			if((LeagueGUI.getLeague().getStep().equals("RegularSeason") &&
					LeagueGUI.getLeague().getCurrentSeason()<=174)) {
				
				budgetPanel.setVisible(false);
				rankPanel.setVisible(false);
				playOffPanel.setVisible(false);
				eventPanel.setVisible(false);
				homePanel.setVisible(true);
				mapPanel.setVisible(false);
				balanceSheetPanel.setVisible(false);
				
				if(LeagueGUI.getLeague().getStep().equals("RegularSeason"))
				event.setText("Saison régulière");

			}
			else {
				budgetPanel.setVisible(false);
				rankPanel.setVisible(false);
				playOffPanel.setVisible(false);
				eventPanel.setVisible(true);
				homePanel.setVisible(false);
				balanceSheetPanel.setVisible(false);
				mapPanel.setVisible(false);
				
				if(LeagueGUI.getLeague().getStep().equals("Christmas"))
					event.setText("Matchs de Noel & Ouverture des votes (All Star Game)");
				else if(LeagueGUI.getLeague().getStep().equals("FirstRound") ||
						LeagueGUI.getLeague().getStep().equals("Semi")||
						LeagueGUI.getLeague().getStep().equals("FinaleConference")||
						LeagueGUI.getLeague().getStep().equals("FinaleNBA")) {
					event.setText("Phase des PlayOff");
				}
				else if(LeagueGUI.getLeague().getStep().equals("AllStarGame")) {
					event.setText("All Star Game");
				}
				else if (league.getStep().equals("endSeason")) {
					
					event.setText("Fin de saison");
					budgetPanel.setVisible(false);
					rankPanel.setVisible(false);
					playOffPanel.setVisible(false);
					eventPanel.setVisible(false);
					homePanel.setVisible(true);
					balanceSheetPanel.setVisible(false);
					mapPanel.setVisible(false);
						
					if(league.getGames().get(league.getNbJourney()-1).getYear()==2025) {
							
					nextButton.setVisible(false);
					skipButton.setVisible(false);
					}
				}
				else {
					if(league.getCurrentSeason()==175)
						event.setText("PlayOff dans 3 jours");
						else if(league.getCurrentSeason()==176)
						event.setText("PlayOff dans 2 jours");
						else if(league.getCurrentSeason()==177)
						event.setText("PlayOff dans 1 jour");
					budgetPanel.setVisible(false);
					rankPanel.setVisible(false);
					playOffPanel.setVisible(false);
					eventPanel.setVisible(false);
					homePanel.setVisible(true);
					balanceSheetPanel.setVisible(false);
					mapPanel.setVisible(false);
				}
			}
			}
			else {
				budgetPanel.setVisible(false);
				rankPanel.setVisible(false);
				playOffPanel.setVisible(false);
				eventPanel.setVisible(false);
				homePanel.setVisible(true);
				mapPanel.setVisible(false);
				balanceSheetPanel.setVisible(false);
			}
				
			
		}
	}
	
	public class skip implements ActionListener {

		public void actionPerformed(ActionEvent clic) {
						
			homeButton.setBackground(new Color(60,60,60));
			
			rankButton.setBackground(new Color(60,60,60));

			budgetButton.setBackground(new Color(60,60,60));

			mapButton.setBackground(new Color(60,60,60));

			poButton.setBackground(new Color(60,60,60));

			infoButton.setBackground(new Color(60,60,60));
			
			 new Thread(new Runnable() {
		            public void run()
		            {
		                pass();
		            }}).start();
			
	
			budgetPanel.setVisible(false);
			rankPanel.setVisible(false);
			playOffPanel.setVisible(false);
			eventPanel.setVisible(false);
			homePanel.setVisible(true);
			mapPanel.setVisible(false);
			
			balanceSheetPanel.setVisible(false);
			
			

		}
	}
	
	public class changeBudget implements ActionListener {
		
		public void actionPerformed(ActionEvent clic) {
			
			homeButton.setBackground(new Color(60,60,60));
			
			rankButton.setBackground(new Color(60,60,60));

			budgetButton.setBackground(new Color(60,60,60));

			mapButton.setBackground(new Color(60,60,60));

			poButton.setBackground(new Color(60,60,60));

			infoButton.setBackground(new Color(60,60,60));

			rankPanel.setVisible(false);
			homePanel.setVisible(false);
			playOffPanel.setVisible(false);
			eventPanel.setVisible(false);
			budgetPanel.setVisible(true);
			balanceSheetPanel.setVisible(false);
			mapPanel.setVisible(false);
				
			budgetButton.setBackground(new Color(17,35,63));
		
		}
	}
	
	public class changeRank implements ActionListener {
		
		public void actionPerformed(ActionEvent clic) {
			
			homeButton.setBackground(new Color(60,60,60));
			
			rankButton.setBackground(new Color(60,60,60));

			budgetButton.setBackground(new Color(60,60,60));

			mapButton.setBackground(new Color(60,60,60));

			poButton.setBackground(new Color(60,60,60));

			infoButton.setBackground(new Color(60,60,60));

			homePanel.setVisible(false);
			budgetPanel.setVisible(false);
			playOffPanel.setVisible(false);
			eventPanel.setVisible(false);
			balanceSheetPanel.setVisible(false);
			rankPanel.setVisible(true);
			mapPanel.setVisible(false);
			
			rankButton.setBackground(new Color(17,35,63));
		
		}
	}
	
	public class changePlayOff implements ActionListener {
		
		public void actionPerformed(ActionEvent clic) {
			
			homeButton.setBackground(new Color(60,60,60));
			
			rankButton.setBackground(new Color(60,60,60));

			budgetButton.setBackground(new Color(60,60,60));

			mapButton.setBackground(new Color(60,60,60));

			poButton.setBackground(new Color(60,60,60));

			infoButton.setBackground(new Color(60,60,60));

			rankPanel.setVisible(false);
			homePanel.setVisible(false);
			budgetPanel.setVisible(false);
			eventPanel.setVisible(false);
			playOffPanel.setVisible(true);
			balanceSheetPanel.setVisible(false);
			mapPanel.setVisible(false);

			poButton.setBackground(new Color(17,35,63));
		
		}
	}
	
	public class changeMap implements ActionListener {
		
		public void actionPerformed(ActionEvent clic) {
			
			homeButton.setBackground(new Color(60,60,60));
			
			rankButton.setBackground(new Color(60,60,60));

			budgetButton.setBackground(new Color(60,60,60));

			mapButton.setBackground(new Color(60,60,60));

			poButton.setBackground(new Color(60,60,60));

			infoButton.setBackground(new Color(60,60,60));

			rankPanel.setVisible(false);
			homePanel.setVisible(false);
			budgetPanel.setVisible(false);
			playOffPanel.setVisible(false);
			mapPanel.setVisible(true);
			balanceSheetPanel.setVisible(false);

			mapButton.setBackground(new Color(17,35,63));
		
		}
	}
	
	public class changeInfo implements ActionListener {
		
		public void actionPerformed(ActionEvent clic) {
			
			homeButton.setBackground(new Color(60,60,60));
			
			rankButton.setBackground(new Color(60,60,60));

			budgetButton.setBackground(new Color(60,60,60));

			mapButton.setBackground(new Color(60,60,60));

			poButton.setBackground(new Color(60,60,60));

			infoButton.setBackground(new Color(60,60,60));

			budgetPanel.setVisible(false);
			rankPanel.setVisible(false);
			homePanel.setVisible(false);
			playOffPanel.setVisible(false);
			eventPanel.setVisible(false);
			balanceSheetPanel.setVisible(true);
			mapPanel.setVisible(false);
			
			infoButton.setBackground(new Color(17,35,63));
			
		}
	}

	public void pass() {
		
		nextButton.setVisible(false);
		skipButton.setVisible(false);
		
		if(league.getGames().get(league.getNbJourney()-1).getMonth().equals("Octobre") ||
				league.getGames().get(league.getNbJourney()-1).getMonth().equals("Novembre") ||
				(league.getGames().get(league.getNbJourney()-1).getMonth().equals("Decembre") &&
				league.getGames().get(league.getNbJourney()-1).getNumber()<25)) {
			while(!league.getStep().equals("Christmas")) {
				homePanel.edit(league);
				rankPanel.edit(league);
				eventPanel.edit(league);
				playOffPanel.edit(league);
				budgetPanel.edit(league);
				balanceSheetPanel.edit(league);
			}
			
			budgetPanel.setVisible(false);
			rankPanel.setVisible(false);
			playOffPanel.setVisible(false);
			eventPanel.setVisible(true);
			homePanel.setVisible(false);
			balanceSheetPanel.setVisible(false);
			mapPanel.setVisible(false);

			event.setText("Matchs de Noel");
			
			}
		
		else if(league.getGames().get(league.getNbJourney()-1).getMonth().equals("Janvier") ||
				(league.getGames().get(league.getNbJourney()-1).getMonth().equals("Fevrier")  &&
				league.getGames().get(league.getNbJourney()-1).getNumber()<18) ||
				(league.getGames().get(league.getNbJourney()-1).getMonth().equals("Decembre") &&
				league.getGames().get(league.getNbJourney()-1).getNumber()>=25)) {
			
			event.setText("Saison Regulière");

			while(!league.getStep().equals("AllStarGame")) {
				homePanel.edit(league);
				rankPanel.edit(league);
				eventPanel.edit(league);
				playOffPanel.edit(league);
				budgetPanel.edit(league);
				balanceSheetPanel.edit(league);
			}
			budgetPanel.setVisible(false);
			rankPanel.setVisible(false);
			playOffPanel.setVisible(false);
			eventPanel.setVisible(true);
			homePanel.setVisible(false);
			balanceSheetPanel.setVisible(false);
			mapPanel.setVisible(false);

			event.setText("All Star Game");
		}
				
		else if (league.getCurrentSeason()<=174){
			
			event.setText("Saison Regulière");

			while(league.getCurrentSeason()<=174) {
				homePanel.edit(league);
				rankPanel.edit(league);
				eventPanel.edit(league);
				playOffPanel.edit(league);
				budgetPanel.edit(league);
				balanceSheetPanel.edit(league);
			}
			budgetPanel.setVisible(false);
			rankPanel.setVisible(false);
			playOffPanel.setVisible(false);
			eventPanel.setVisible(true);
			homePanel.setVisible(false);
			balanceSheetPanel.setVisible(false);
			mapPanel.setVisible(false);
			
			if(league.getCurrentSeason()==175)
			event.setText("PlayOff dans 3 jours");
			else if(league.getCurrentSeason()==176)
			event.setText("PlayOff dans 2 jours");
			else if(league.getCurrentSeason()==177)
			event.setText("PlayOff dans 1 jour");

		}	
		else if (league.getCurrentSeason()>174 && !league.getStep().equals("endSeason")) {

			while(!league.getStep().equals("endSeason")) {
				homePanel.edit(league);
				rankPanel.edit(league);
				eventPanel.edit(league);
				playOffPanel.edit(league);
				budgetPanel.edit(league);
				balanceSheetPanel.edit(league);
			}
			if(league.getGames().get(league.getNbJourney()-1).getYear()==2025) {
				nextButton.setVisible(false);
				skipButton.setVisible(false);
			}
			budgetPanel.setVisible(false);
			rankPanel.setVisible(false);
			playOffPanel.setVisible(true);
			eventPanel.setVisible(false);
			homePanel.setVisible(false);
			balanceSheetPanel.setVisible(false);
			mapPanel.setVisible(false);

			event.setText("Fin de saison");
		}
		
		else {
			
			if(league.getGames().get(league.getNbJourney()-1).getYear()!=2025)
			while(!league.getGames().get(league.getNbJourney()-1).getMonth().equals("Octobre")) {
				homePanel.edit(league);
				rankPanel.edit(league);
				eventPanel.edit(league);
				playOffPanel.edit(league);
				budgetPanel.edit(league);
				balanceSheetPanel.edit(league);
			}
			
			budgetPanel.setVisible(false);
			rankPanel.setVisible(false);
			playOffPanel.setVisible(false);
			eventPanel.setVisible(false);
			homePanel.setVisible(true);
			balanceSheetPanel.setVisible(false);
			mapPanel.setVisible(false);

			event.setText("Saison Regulière");
		}
		
		year.setText("Année "+((league.getGames().get(league.getNbJourney()-1).getYear())-2019)+"/6 - "+(league.getGames().get(league.getNbJourney()-1).getYear()-1)+"-"+
				league.getGames().get(league.getNbJourney()-1).getYear());
		
		nextButton.setVisible(true);
		skipButton.setVisible(true);

		
	}

	
	public static LeagueInterface getLeague() {
		return league;
	}
	
	public static void main(String[] args) {
		new LeagueGUI("League NBA");
	}
}
