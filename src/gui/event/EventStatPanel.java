package gui.event;

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

import gui.main.LeagueGUI;
import gui.main.MyButton;

public class EventStatPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	protected JLabel quarterLabel[] = new JLabel[4];
	
	protected JLabel homeTeam[] = new JLabel[4];
	protected JLabel homeTeamIcon[] = new JLabel[4];
	protected JLabel awayTeam[] = new JLabel[4];
	protected JLabel awayTeamIcon[] = new JLabel[4];
	protected JLabel score[] = new JLabel[4];
	
	protected JLabel homePlayers[] = new JLabel[10];
	protected JLabel awayPlayers[] = new JLabel[10];
	
	protected JLabel homePlayersPoints[] = new JLabel[10];
	protected JLabel awayPlayersPoints[] = new JLabel[10];
	
	protected JLabel homePlayersAssists[] = new JLabel[10];
	protected JLabel awayPlayersAssists[] = new JLabel[10];
	
	protected JLabel infoStats[] = new JLabel[6];
	protected JLabel infoMatch[] = new JLabel[3];

	protected JLabel playerLabel = new JLabel("Joueurs du match");
	
	protected JLabel budgetStats[] = new JLabel[10];
	
	protected MyButton playButton = new MyButton("Cliquez ici pour simuler le match");
	
	protected MyButton homePlayersButton = new MyButton("Effectif indisponible");
	protected MyButton awayPlayersButton = new MyButton("Effectif indisponible");
	
	protected static int index = 0;
	protected static int match = 0;
	
	public EventStatPanel() {
		
		addLabel(quarterLabel);

		addLabel(homeTeam);
		
		addLabel(homeTeamIcon);

		addLabel(awayTeam);

		addLabel(awayTeamIcon);
		
		addLabel(score);
		
		addLabel(homePlayers);
		
		addLabel(awayPlayers);
		
		addLabel(homePlayersPoints);

		addLabel(awayPlayersPoints);
		
		addLabel(homePlayersAssists);
		
		addLabel(awayPlayersAssists);
		
		addLabel(infoStats);
		
		addLabel(budgetStats);
		
		addLabel(infoMatch);

		initActions();

		initStyle();
		
		initLayout();
		
	}
	
	protected void initActions() {
		playButton.addActionListener(new playEvent());
		homePlayersButton.addActionListener(new changePlayers(0));
		awayPlayersButton.addActionListener(new changePlayers(1));

	}
		
	
	protected void initStyle() {
		
		int y = 0;
		
		playButton.setBounds(460,250,300,30);
		
		homePlayersButton.setBounds(0,370,400,40);
		homePlayersButton.setForeground(Color.BLACK);
		homePlayersButton.setBackground(Color.WHITE);
		homePlayersButton.setBackground(Color.WHITE);
		homePlayersButton.setOpaque(true);
		
		awayPlayersButton.setBounds(400,370,375,40);
		awayPlayersButton.setForeground(Color.BLACK);
		awayPlayersButton.setBackground(Color.LIGHT_GRAY);
		awayPlayersButton.setOpaque(true);
		
		for(int i=0; i<quarterLabel.length;i++) {
			quarterLabel[i].setBounds(0,y,430,30);
			quarterLabel[i].setBackground(new Color(17,35,63));
			quarterLabel[i].setOpaque(true);
			quarterLabel[i].setForeground(Color.WHITE);
			quarterLabel[i].setHorizontalAlignment(SwingConstants.CENTER);
			y=y+70;
		}
		
		quarterLabel[0].setText("1st QT (0' - 12')");
		quarterLabel[1].setText("2nd QT (12' - 24')");
		quarterLabel[2].setText("3rd QT (24' - 36')");
		quarterLabel[3].setText("4th QT (36' - 48')");
		
		y=30;
		
		for(int i=0;i<homeTeam.length;i++) {
			homeTeam[i].setBounds(0,y,140,40);
			homeTeam[i].setHorizontalAlignment(SwingConstants.RIGHT);
			homeTeam[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
			homeTeam[i].setBackground(Color.WHITE);
			homeTeam[i].setOpaque(true);
			y=y+70;
		}
		
		y=30;
		
		for(int i=0; i<homeTeamIcon.length;i++) {
			homeTeamIcon[i].setBounds(140,y,30,40);
			homeTeamIcon[i].setHorizontalAlignment(SwingConstants.CENTER);
			homeTeamIcon[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
			homeTeamIcon[i].setBackground(Color.WHITE);
			homeTeamIcon[i].setOpaque(true);
			y=y+70;
		}
		
		y=30;
		
		for(int i=0; i<score.length;i++) {
			score[i].setBounds(170,y,80,40);
			score[i].setHorizontalAlignment(SwingConstants.CENTER);
			score[i].setText("En attente");
			score[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
			score[i].setBackground(Color.WHITE);
			score[i].setOpaque(true);
			y=y+70;
		}
		
		y=30;
		
		for(int i=0; i<awayTeamIcon.length;i++) {
			awayTeamIcon[i].setBounds(250,y,30,40);
			awayTeamIcon[i].setHorizontalAlignment(SwingConstants.CENTER);
			awayTeamIcon[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
			awayTeamIcon[i].setBackground(Color.WHITE);
			awayTeamIcon[i].setOpaque(true);
			y=y+70;
			
		}
		
		y=30;
		
		for(int i=0; i<awayTeam.length;i++) {
			awayTeam[i].setBounds(280,y,150,40);
			awayTeam[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
			awayTeam[i].setBackground(Color.WHITE);
			awayTeam[i].setOpaque(true);
			y=y+70;
		}
		
		y=450;
		
		for(int i=0; i<homePlayersPoints.length;i++) {
			if(i<5) {
				homePlayersPoints[i].setBounds(250,y,50,50);
				awayPlayersPoints[i].setBounds(250,y,50,50);
				y=y+50;
			}
			else if(i==5){
				y=450;
				homePlayersPoints[i].setBounds(650,y,50,50);
				awayPlayersPoints[i].setBounds(650,y,50,50);
				y=y+50;
				}
			else {
				homePlayersPoints[i].setBounds(650,y,50,50);
				awayPlayersPoints[i].setBounds(650,y,50,50);
				y=y+50;
			}
			homePlayersPoints[i].setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(221,221,221)));
			awayPlayersPoints[i].setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(221,221,221)));
			homePlayersPoints[i].setHorizontalAlignment(SwingConstants.CENTER);
			awayPlayersPoints[i].setHorizontalAlignment(SwingConstants.CENTER);
			homePlayersPoints[i].setBackground(Color.WHITE);
			awayPlayersPoints[i].setBackground(Color.WHITE);
			homePlayersPoints[i].setOpaque(true);
			awayPlayersPoints[i].setOpaque(true);
			

		}
		
		
		y=450;
		
		for(int i=0; i<homePlayers.length;i++) {
			if(i<5) {
				homePlayers[i].setBounds(0,y,250,50);
				awayPlayers[i].setBounds(0,y,250,50);
				y=y+50;
			}
			else if(i==5){
				y=450;
				homePlayers[i].setBounds(400,y,250,50);
				awayPlayers[i].setBounds(400,y,250,50);
				y=y+50;
				}
			else {
				homePlayers[i].setBounds(400,y,250,50);
				awayPlayers[i].setBounds(400,y,250,50);
				y=y+50;
			}
			homePlayers[i].setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(221,221,221)));
			awayPlayers[i].setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(221,221,221)));
			homePlayers[i].setBackground(Color.WHITE);
			awayPlayers[i].setBackground(Color.WHITE);
			homePlayers[i].setOpaque(true);
			awayPlayers[i].setOpaque(true);
		}
		
		y=450;
		
		for(int i=0; i<homePlayersAssists.length;i++) {
			if(i<5) {
				homePlayersAssists[i].setBounds(300,y,100,50);
				awayPlayersAssists[i].setBounds(300,y,100,50);
				y=y+50;
			}
			else if(i==5){
				y=450;
				homePlayersAssists[i].setBounds(700,y,75,50);
				awayPlayersAssists[i].setBounds(700,y,75,50);
				y=y+50;
				}
			else {
				homePlayersAssists[i].setBounds(700,y,75,50);
				awayPlayersAssists[i].setBounds(700,y,75,50);
				y=y+50;
			}
			homePlayersAssists[i].setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(221,221,221)));
			awayPlayersAssists[i].setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(221,221,221)));
			homePlayersAssists[i].setHorizontalAlignment(SwingConstants.CENTER);
			awayPlayersAssists[i].setHorizontalAlignment(SwingConstants.CENTER);
			homePlayersAssists[i].setBackground(Color.WHITE);
			awayPlayersAssists[i].setBackground(Color.WHITE);
			homePlayersAssists[i].setOpaque(true);
			awayPlayersAssists[i].setOpaque(true);

		}
		
		y=90;
		
		for(int i=0; i<budgetStats.length;i++) {
				
				if(i%2==0) {
					budgetStats[i].setBounds(460,y,120,30);
				}
				else {
					budgetStats[i].setBounds(580,y,180,30);
					y=y+30;
				}
				budgetStats[i].setBackground(Color.WHITE);
				budgetStats[i].setOpaque(true);
				budgetStats[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
	

		}
		
		budgetStats[0].setText(" Stade");
		budgetStats[2].setText(" Spectateurs");
		budgetStats[4].setText(" Prix du ticket");
		budgetStats[6].setText(" Tickets vendus");
		budgetStats[8].setText(" Téléspectateurs");
		
		infoMatch[0].setBounds(460,0,100,90);
		infoMatch[0].setBackground(new Color(17,35,63));
		infoMatch[0].setOpaque(true);
		infoMatch[0].setHorizontalAlignment(SwingConstants.RIGHT);
		infoMatch[1].setBounds(560,0,100,90);
		infoMatch[1].setBackground(new Color(17,35,63));
		infoMatch[1].setOpaque(true);
		infoMatch[1].setText("VS");
		infoMatch[1].setHorizontalAlignment(SwingConstants.CENTER);
		infoMatch[1].setForeground(Color.WHITE);
		infoMatch[2].setBounds(660,0,100,90);
		infoMatch[2].setBackground(new Color(17,35,63));
		infoMatch[2].setOpaque(true);
		infoMatch[2].setHorizontalAlignment(SwingConstants.LEFT);

		infoStats[0].setBounds(0,410,250,40);
		infoStats[0].setText("Joueurs");
		infoStats[1].setBounds(250,410,50,40);
		infoStats[1].setText("PM");
		infoStats[2].setBounds(300,410,100,40);
		infoStats[2].setText("PD");
		infoStats[3].setBounds(400,410,250,40);
		infoStats[3].setText("Joueurs");
		infoStats[4].setBounds(650,410,50,40);
		infoStats[4].setText("PM");
		infoStats[5].setBounds(700,410,75,40);
		infoStats[5].setText("PD");
		
		for(int i=0;i<infoStats.length;i++) {
			infoStats[i].setHorizontalAlignment(SwingConstants.CENTER);
			infoStats[i].setBackground(Color.WHITE);
			infoStats[i].setOpaque(true);
		}
		
		playerLabel.setBounds(0,300,770,40);
		playerLabel.setBackground(new Color(17,35,63));
		playerLabel.setOpaque(true);
		playerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		playerLabel.setForeground(Color.WHITE);

		
	}
	
	protected void initLayout() {
		
		setBounds(500,0,780,700);
		setBackground(new Color(240,240,240));
		setLayout(null);
		
		for(int i=0;i<quarterLabel.length;i++) {
			add(quarterLabel[i]);
			add(homeTeamIcon[i]);
			add(homeTeam[i]);
			add(score[i]);
			add(awayTeam[i]);
			add(awayTeamIcon[i]);
		}
		
		for(int i=0;i<homePlayers.length;i++) {
			add(homePlayers[i]);
			add(awayPlayers[i]);
			add(homePlayersPoints[i]);
			add(awayPlayersPoints[i]);
			add(homePlayersAssists[i]);
			add(awayPlayersAssists[i]);
			awayPlayers[i].setVisible(false);
			awayPlayersPoints[i].setVisible(false);
			awayPlayersAssists[i].setVisible(false);
		}
		
		for(int i=0;i<infoStats.length;i++) {
			add(infoStats[i]);
		}
		
		for(int i=0;i<budgetStats.length;i++) {
			add(budgetStats[i]);
		}
		
		for(int i=0;i<infoMatch.length;i++) {
			add(infoMatch[i]);
		}
		
		add(playButton);
		add(homePlayersButton);
		add(awayPlayersButton);
		add(playerLabel);
	
	}
	
	protected void addLabel (JLabel[] jlabel){
		
        for (int i = 0; i < jlabel.length; i++){
            jlabel[i] = new JLabel();
        }
        
    }
	
	public class changePlayers implements ActionListener {
		
		private int index;
		
		public changePlayers (int index){
			this.index = index;
		}
		
		public void actionPerformed(ActionEvent e) { 
			if(index==0) {
				for(int i=0;i<homePlayers.length;i++) {
					awayPlayers[i].setVisible(false);
					awayPlayersPoints[i].setVisible(false);
					awayPlayersAssists[i].setVisible(false);
					homePlayers[i].setVisible(true);
					homePlayersPoints[i].setVisible(true);
					homePlayersAssists[i].setVisible(true);
				}
				awayPlayersButton.setBackground(Color.LIGHT_GRAY);
				homePlayersButton.setBackground(Color.WHITE);
				
			}
			else {
				for(int i=0;i<awayPlayers.length;i++) {
					awayPlayers[i].setVisible(true);
					awayPlayersPoints[i].setVisible(true);
					awayPlayersAssists[i].setVisible(true);
					homePlayers[i].setVisible(false);
					homePlayersPoints[i].setVisible(false);
					homePlayersAssists[i].setVisible(false);
				}
				awayPlayersButton.setBackground(Color.WHITE);
				homePlayersButton.setBackground(Color.LIGHT_GRAY);

			}
		}
	}
	
	public class playEvent implements ActionListener {
		
		public void actionPerformed(ActionEvent e) { 
		if(index==0) {
			for(int i=0;i<homeTeam.length;i++) {
				homeTeam[i].setText("");
				homeTeamIcon[i].setIcon(null);
				awayTeam[i].setText("");
				awayTeamIcon[i].setIcon(null);
				score[i].setText("En attente");
			}
		}
		
		if(match<LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames().size()) {
			if(index==0) {
				homeTeam[0].setText(LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
						.get(match).getTeams().getHomeTeam().getNickname());
				homeTeamIcon[0].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/teams/16x16/"+LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague()
							.getNbJourney()-1).getGames().get(match).getTeams().getHomeTeam().getNickname()+".png")));
				awayTeamIcon[0].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/teams/16x16/"+LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague()
						.getNbJourney()-1).getGames().get(match).getTeams().getAwayTeam().getNickname()+".png")));
				
				awayTeam[0].setText(LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
						.get(match).getTeams().getAwayTeam().getNickname());
				score[0].setText(LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
						.get(match).getScore().getQuarterTimeHome().getFirstQT()+" - "+
						LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
						.get(match).getScore().getQuarterTimeAway().getFirstQT());
				infoMatch[0].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/teams/"+LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague()
							.getNbJourney()-1).getGames().get(match).getTeams().getHomeTeam().getNickname()+".png")));
				infoMatch[2].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/teams/"+LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague()
						.getNbJourney()-1).getGames().get(match).getTeams().getAwayTeam().getNickname()+".png")));
				for(int i=0;i<5;i++) {

					homePlayers[i].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/players/64x64/"+LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague()
								.getNbJourney()-1).getGames().get(match).getPlayers().getHomePlayers().get(i).getId()+".png")));
					homePlayers[i].setText(LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
						.get(match).getPlayers().getHomePlayers().get(i).getName());
					homePlayers[i+5].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/players/64x64/"+LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague()
								.getNbJourney()-1).getGames().get(match).getPlayers().getHomeSubPlayers().get(i).getId()+".png")));
					homePlayers[i+5].setText(LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
						.get(match).getPlayers().getHomeSubPlayers().get(i).getName());
					awayPlayers[i].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/players/64x64/"+LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague()
							.getNbJourney()-1).getGames().get(match).getPlayers().getAwayPlayers().get(i).getId()+".png")));
					awayPlayers[i].setText(LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
					.get(match).getPlayers().getAwayPlayers().get(i).getName());
					awayPlayers[i+5].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/players/64x64/"+LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague()
							.getNbJourney()-1).getGames().get(match).getPlayers().getAwaySubPlayers().get(i).getId()+".png")));
					awayPlayers[i+5].setText(LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
					.get(match).getPlayers().getAwaySubPlayers().get(i).getName());
	
				}
			
				
				homePlayersButton.setText(LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
						.get(match).getTeams().getHomeTeam().getName());
				awayPlayersButton.setText(LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
						.get(match).getTeams().getAwayTeam().getName());
				budgetStats[1].setText(LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
						.get(match).getCurrentStadium());
				budgetStats[3].setText(""+numberFormat(LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
						.get(match).getBudget().getEarnings().getTicketSelling())+" / "+
						numberFormat(LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames().get(match).getTeams().getHomeTeam()
						.getLocation().getStadium().getCapacity()));
				budgetStats[5].setText(""+numberFormat((LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
						.get(match).getBudget().getEarnings().getTicketEarnings()/LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
						.get(match).getBudget().getEarnings().getTicketSelling()))+" €");
				budgetStats[7].setText(""+numberFormat(LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
						.get(match).getBudget().getEarnings().getTicketEarnings())+" €");
				budgetStats[9].setText(""+numberFormat(LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
						.get(match).getBudget().getEarnings().getViewers()));
				budgetStats[9].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/red-circle.png")));
				
				for(int i=0;i<homePlayers.length;i++) {
		
						homePlayersPoints[i].setText("?");
						awayPlayersPoints[i].setText("?");
						homePlayersAssists[i].setText("?");
						awayPlayersAssists[i].setText("?");
					
				}
				index++;
			}
			else if(index==1) {
				homeTeam[1].setText(LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
						.get(match).getTeams().getHomeTeam().getNickname());
				awayTeam[1].setText(LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
						.get(match).getTeams().getAwayTeam().getNickname());
				score[1].setText((LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
						.get(match).getScore().getQuarterTimeHome().getFirstQT()+
						LeagueGUI.getLeague().getGames().get(
						LeagueGUI.getLeague().getNbJourney()-1).getGames().get(match).getScore().getQuarterTimeHome().getSecondQT())+" - "+
						(LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
						.get(match).getScore().getQuarterTimeAway().getSecondQT()+
						LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
						.get(match).getScore().getQuarterTimeAway().getFirstQT()));
				
				homeTeamIcon[1].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/teams/16x16/"+LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague()
						.getNbJourney()-1).getGames().get(match).getTeams().getHomeTeam().getNickname()+".png")));
				awayTeamIcon[1].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/teams/16x16/"+LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague()
					.getNbJourney()-1).getGames().get(match).getTeams().getAwayTeam().getNickname()+".png")));
				
				index++;
			}
			else if(index==2) {
				homeTeam[2].setText(LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
						.get(match).getTeams().getHomeTeam().getNickname());
				awayTeam[2].setText(LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
						.get(match).getTeams().getAwayTeam().getNickname());
				score[2].setText(LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
						.get(match).getScore().getQuarterTimeHome().getFirstQT()+
						LeagueGUI.getLeague().getGames().get(
						LeagueGUI.getLeague().getNbJourney()-1).getGames().get(match).getScore().getQuarterTimeHome().getSecondQT()+
						LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
						.get(match).getScore().getQuarterTimeHome().getThirdQT()+" - "+ (LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
							.get(match).getScore().getQuarterTimeAway().getSecondQT()+
							LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
							.get(match).getScore().getQuarterTimeAway().getFirstQT()+
						LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
						.get(match).getScore().getQuarterTimeAway().getThirdQT()));
				homeTeamIcon[2].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/teams/16x16/"+LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague()
						.getNbJourney()-1).getGames().get(match).getTeams().getHomeTeam().getNickname()+".png")));
				awayTeamIcon[2].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/teams/16x16/"+LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague()
					.getNbJourney()-1).getGames().get(match).getTeams().getAwayTeam().getNickname()+".png")));
				
				index++;
			}
			else {
				homeTeam[3].setText(LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
						.get(match).getTeams().getHomeTeam().getNickname());
				awayTeam[3].setText(LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
						.get(match).getTeams().getAwayTeam().getNickname());
				score[3].setText((LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
						.get(match).getScore().getQuarterTimeHome().getFirstQT()+
						LeagueGUI.getLeague().getGames().get(
						LeagueGUI.getLeague().getNbJourney()-1).getGames().get(match).getScore().getQuarterTimeHome().getSecondQT()+
						LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
						.get(match).getScore().getQuarterTimeHome().getThirdQT()+
						LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
						.get(match).getScore().getQuarterTimeHome().getFourthQT())+" - "+
						(LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
						.get(match).getScore().getQuarterTimeAway().getSecondQT()+
						LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
						.get(match).getScore().getQuarterTimeAway().getFirstQT()+
					LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
					.get(match).getScore().getQuarterTimeAway().getThirdQT()+
						LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
						.get(match).getScore().getQuarterTimeAway().getFourthQT()));
				homeTeamIcon[3].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/teams/16x16/"+LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague()
						.getNbJourney()-1).getGames().get(match).getTeams().getHomeTeam().getNickname()+".png")));
				awayTeamIcon[3].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/teams/16x16/"+LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague()
					.getNbJourney()-1).getGames().get(match).getTeams().getAwayTeam().getNickname()+".png")));
				
				for(int i=0;i<homePlayers.length;i++) {
					if(i<5) {

						homePlayersPoints[i].setText(""+(int)LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
							.get(match).getScore().getHomeScorers().get(LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
									.get(match).getPlayers().getHomePlayers().get(i)));
						awayPlayersPoints[i].setText(""+(int)LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
							.get(match).getScore().getAwayScorers().get(LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
									.get(match).getPlayers().getAwayPlayers().get(i)));
						homePlayersAssists[i].setText(""+(int)LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
								.get(match).getScore().getHomeAssists().get(LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
										.get(match).getPlayers().getHomePlayers().get(i)));
						awayPlayersAssists[i].setText(""+(int)LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
								.get(match).getScore().getAwayAssists().get(LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
										.get(match).getPlayers().getAwayPlayers().get(i)));
					}
					else {
						homePlayersPoints[i].setText(""+(int)LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
								.get(match).getScore().getHomeScorers().get(LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
										.get(match).getPlayers().getHomeSubPlayers().get(i-5)));
						awayPlayersPoints[i].setText(""+(int)LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
								.get(match).getScore().getAwayScorers().get(LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
										.get(match).getPlayers().getAwaySubPlayers().get(i-5)));
						homePlayersAssists[i].setText(""+(int)LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
								.get(match).getScore().getHomeAssists().get(LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
										.get(match).getPlayers().getHomeSubPlayers().get(i-5)));
						awayPlayersAssists[i].setText(""+(int)LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
								.get(match).getScore().getAwayAssists().get(LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames()
										.get(match).getPlayers().getAwaySubPlayers().get(i-5)));
					}
				}
				
				index=0;
				match++;
				EventMatchPanel.scoreEdit(LeagueGUI.getLeague());

			}
			
			if(match==LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames().size()) {
				playButton.setVisible(false);
			}
			
			if(index==4) {
				index=0;
			}
		
		}
		}
	}
	
	
	public void eventStatEdit() {
		playButton.setVisible(true);
		homePlayersButton.setText("Indisponible");
		awayPlayersButton.setText("Indisponible");

		for(int i=0; i<homePlayers.length;i++) {
			homePlayers[i].setText("");
			awayPlayers[i].setText("");
			homePlayers[i].setIcon(null);
			awayPlayers[i].setIcon(null);
			homePlayersPoints[i].setText("");
				awayPlayersPoints[i].setText("");
				homePlayersAssists[i].setText("");
				awayPlayersAssists[i].setText("");
		}
		for(int i=0;i<quarterLabel.length;i++) {
			homeTeamIcon[i].setIcon(null);
			awayTeamIcon[i].setIcon(null);
			homeTeam[i].setText("");
			score[i].setText("En attente");
			awayTeam[i].setText("");
			
		}
		for(int i=0;i<infoMatch.length;i++) {
			infoMatch[i].setIcon(null);			
		}
		for(int i=0;i<budgetStats.length;i++) {
			if(i%2==1) {
				budgetStats[i].setText("");	
				budgetStats[i].setIcon(null);		
			}
		}
		
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		EventStatPanel.index = index;
	}

	public static int getMatch() {
		return match;
	}

	public void setMatch(int match) {
		EventStatPanel.match = match;
	}
	
	public String numberFormat(long number) {
		DecimalFormat format = new DecimalFormat("###,###,###" ); 
		DecimalFormatSymbols s = format.getDecimalFormatSymbols();
		s.setGroupingSeparator(' ');
		format.setDecimalFormatSymbols(s);
		return 	format.format(number);

	}
	
}
	
