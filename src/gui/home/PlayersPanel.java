package gui.home;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import gui.main.LeagueGUI;
import gui.main.MyButton;
import process.league.LeagueInterface;

public class PlayersPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	protected static JLabel playersLabel[] = new JLabel[11];
	protected static JLabel pointLabel[] = new JLabel[11];
	protected static JLabel assistLabel[] = new JLabel[11]; 
	protected static JPanel playersPanel = new JPanel();
	
	protected static MyButton homeButton[] = new MyButton[10];
	protected static MyButton awayButton[] = new MyButton[10];
				
	public PlayersPanel() {
		
		addLabel(playersLabel);
		addLabel(assistLabel);
		
		addLabel(pointLabel);
		
		addButton(homeButton);
		addButton(awayButton);
		
		initStyle();
		
		initLayout();
		
		initActions();
				
	}
	
	protected void initActions() {
		for (int i = 0; i<10; i++) {
			homeButton[i].addActionListener(new changeTeam(i));
		
		}
		for (int i = 0; i<10; i++) {
			awayButton[i].addActionListener(new changeTeam2(i));
		
		}
	}
	
	protected void initStyle() {
		
		for(int i=0; i<homeButton.length;i++) {
		
		homeButton[i].setBounds(0,0,175,30);
		homeButton[i].setBackground(Color.WHITE);
		homeButton[i].setForeground(new Color(17,35,63));
		homeButton[i].setOpaque(true);
		}

		for(int i=0; i<awayButton.length;i++) {
		awayButton[i].setBounds(175,0,175,30);
		awayButton[i].setBackground(Color.LIGHT_GRAY);
		awayButton[i].setForeground(new Color(17,35,63));
		awayButton[i].setOpaque(true);
		}
		
		int y = 30;
		
		playersPanel.setBounds(0,0,350,380);
		playersPanel.setBackground(Color.WHITE);
		playersPanel.setLayout(null);
			
		
		for (int i = 0; i< playersLabel.length; i++) {
			if(i==0) 	{
				playersLabel[i].setBounds(0, y, 350, 80);
				playersLabel[i].setHorizontalAlignment(SwingConstants.CENTER);
				playersLabel[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
				playersLabel[i].setBackground(new Color(17,35,63));
				playersLabel[i].setOpaque(true);
				y = y+80;
			}
			else {
				playersLabel[i].setBounds(10, y, 190, 27);
				playersLabel[i].setHorizontalAlignment(SwingConstants.LEFT);
				if(i!=10) playersLabel[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));


				y=y+27;

			}
			
			playersLabel[i].setForeground(new Color(17,35,63));
		}
		
		y=30;
		
		for (int i = 0; i< pointLabel.length; i++) {
			if(i==0) 	{
				pointLabel[i].setBounds(0, y, 350, 80);
				pointLabel[i].setBackground(new Color(17,35,63));
				pointLabel[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
				pointLabel[i].setOpaque(true);
				y = y+80;
			}
			else {
				pointLabel[i].setBounds(190, y, 75, 27);
				pointLabel[i].setHorizontalAlignment(SwingConstants.LEFT);
				if(i!=10) pointLabel[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));


				y=y+27;

			}
			
			pointLabel[i].setForeground(new Color(17,35,63));
		}
		
		y=30;
		
		for (int i = 0; i< assistLabel.length; i++) {
			if(i==0) 	{
				assistLabel[i].setBounds(0, y, 350, 80);
				assistLabel[i].setBackground(new Color(17,35,63));
				assistLabel[i].setOpaque(true);
				y = y+80;
			}
			else {
				assistLabel[i].setBounds(265,y, 75, 27);
				assistLabel[i].setHorizontalAlignment(SwingConstants.LEFT);
				if(i!=10) assistLabel[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));


				y=y+27;

			}
			
			assistLabel[i].setForeground(new Color(17,35,63));
		}

	}
	
	protected void initLayout() {
		 
		setBounds(940, 10, 350, 380);
		setBackground(new Color(240,240,240));
		setLayout(null);
		
		for (int i = 0; i< playersLabel.length; i++) {
			playersPanel.add(playersLabel[i]);
		}
		
		for (int i = 0; i< pointLabel.length; i++) {
			playersPanel.add(pointLabel[i]);
		}
		
		for (int i = 0; i< assistLabel.length; i++) {
			playersPanel.add(assistLabel[i]);
		}
		
		for (int i = 0; i< homeButton.length; i++) {
			playersPanel.add(homeButton[i]);
			homeButton[i].setVisible(false);
		}
		
		for (int i = 0; i< awayButton.length; i++) {
			playersPanel.add(awayButton[i]);
			awayButton[i].setVisible(false);

		}
		
		add(playersPanel);
		
	}
	
	protected void addLabel (JLabel[] jlabel){
		
        for (int i = 0; i < jlabel.length; i++){
            jlabel[i] = new JLabel();
        }
        
    }
	
	protected void addButton (MyButton[] jbutton){
		
		for (int i=0; i< jbutton.length; i++) {
			jbutton[i] = new MyButton("");
		}
    }
	
	public class changeTeam implements ActionListener {
		
		private int i;
		
		public changeTeam(int i) {
			this.i=i;
		}
		
		public void actionPerformed(ActionEvent e) { 
			
			playersEdit(LeagueGUI.getLeague(),i, LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames().get(i).getTeams().getHomeTeam().getName());
		}
	}
	
	public class changeTeam2 implements ActionListener {
		
		private int i;
		
		public changeTeam2(int i) {
			this.i=i;
		}
		
		public void actionPerformed(ActionEvent e) { 
			
			playersEdit(LeagueGUI.getLeague(),i, LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames().get(i).getTeams().getAwayTeam().getName());
		}
	}
	
	public static void playersEdit(LeagueInterface league, int i, String team) {
		
		for(int j=0;j<homeButton.length; j++) {
			homeButton[j].setVisible(false);
			awayButton[j].setVisible(false);

		}
		
		if(team.equals(league.getGames().get(league.getNbJourney()-1).getGames().get(i).getTeams().getHomeTeam().getName())) {
			homeButton[i].setBackground(Color.WHITE);
			homeButton[i].setOpaque(true);
			awayButton[i].setBackground(Color.LIGHT_GRAY);
			awayButton[i].setOpaque(true);
			
			homeButton[i].setText(league.getGames().get(league.getNbJourney()-1).getGames().get(i).getTeams().getHomeTeam().getNickname());
			awayButton[i].setText(league.getGames().get(league.getNbJourney()-1).getGames().get(i).getTeams().getAwayTeam().getNickname());
			homeButton[i].setVisible(true);
			awayButton[i].setVisible(true);

		playersLabel[0].setIcon(new ImageIcon(LeagueGUI.class.getResource
				("/images/teams/"+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getTeams().getHomeTeam().getNickname()+".png")));	
		playersLabel[1].setText(league.getGames().get(league.getNbJourney()-1).getGames().get(i).getPlayers().getHomePlayers().get(0).getName());
		pointLabel[1].setText(""+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getHomeScorers().get(
						league.getGames().get(league.getNbJourney()-1).getGames().get(i).getPlayers().getHomePlayers().get(0)));
		playersLabel[2].setText(league.getGames().get(league.getNbJourney()-1).getGames().get(i).getPlayers().getHomePlayers().get(1).getName());
		pointLabel[2].setText(""+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getHomeScorers().get(
				league.getGames().get(league.getNbJourney()-1).getGames().get(i).getPlayers().getHomePlayers().get(1)));
		playersLabel[3].setText(league.getGames().get(league.getNbJourney()-1).getGames().get(i).getPlayers().getHomePlayers().get(2).getName());
		pointLabel[3].setText(""+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getHomeScorers().get(
				league.getGames().get(league.getNbJourney()-1).getGames().get(i).getPlayers().getHomePlayers().get(2)));
		playersLabel[4].setText(league.getGames().get(league.getNbJourney()-1).getGames().get(i).getPlayers().getHomePlayers().get(3).getName());
		pointLabel[4].setText(""+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getHomeScorers().get(
				league.getGames().get(league.getNbJourney()-1).getGames().get(i).getPlayers().getHomePlayers().get(3)));
		playersLabel[5].setText(league.getGames().get(league.getNbJourney()-1).getGames().get(i).getPlayers().getHomePlayers().get(4).getName());
		pointLabel[5].setText(""+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getHomeScorers().get(
				league.getGames().get(league.getNbJourney()-1).getGames().get(i).getPlayers().getHomePlayers().get(4)));
		playersLabel[6].setText(league.getGames().get(league.getNbJourney()-1).getGames().get(i).getPlayers().getHomeSubPlayers().get(0).getName());
		pointLabel[6].setText(""+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getHomeScorers().get(
				league.getGames().get(league.getNbJourney()-1).getGames().get(i).getPlayers().getHomeSubPlayers().get(0)));
		playersLabel[7].setText(league.getGames().get(league.getNbJourney()-1).getGames().get(i).getPlayers().getHomeSubPlayers().get(1).getName());
		pointLabel[7].setText(""+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getHomeScorers().get(
				league.getGames().get(league.getNbJourney()-1).getGames().get(i).getPlayers().getHomeSubPlayers().get(1)));
		playersLabel[8].setText(league.getGames().get(league.getNbJourney()-1).getGames().get(i).getPlayers().getHomeSubPlayers().get(2).getName());
		pointLabel[8].setText(""+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getHomeScorers().get(
				league.getGames().get(league.getNbJourney()-1).getGames().get(i).getPlayers().getHomeSubPlayers().get(2)));
		playersLabel[9].setText(league.getGames().get(league.getNbJourney()-1).getGames().get(i).getPlayers().getHomeSubPlayers().get(3).getName());
		pointLabel[9].setText(""+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getHomeScorers().get(
				league.getGames().get(league.getNbJourney()-1).getGames().get(i).getPlayers().getHomeSubPlayers().get(3)));
		playersLabel[10].setText(league.getGames().get(league.getNbJourney()-1).getGames().get(i).getPlayers().getHomeSubPlayers().get(4).getName());
		pointLabel[10].setText(""+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getHomeScorers().get(
				league.getGames().get(league.getNbJourney()-1).getGames().get(i).getPlayers().getHomeSubPlayers().get(4)));

		

		}
		else if (team.equals(league.getGames().get(league.getNbJourney()-1).getGames().get(i).getTeams().getAwayTeam().getName())) {
			
			homeButton[i].setText(league.getGames().get(league.getNbJourney()-1).getGames().get(i).getTeams().getHomeTeam().getNickname());
			awayButton[i].setText(league.getGames().get(league.getNbJourney()-1).getGames().get(i).getTeams().getAwayTeam().getNickname());
			homeButton[i].setVisible(true);
			awayButton[i].setVisible(true);
			
			homeButton[i].setBackground(Color.LIGHT_GRAY);
			homeButton[i].setOpaque(true);
			awayButton[i].setBackground(Color.WHITE);
			awayButton[i].setOpaque(true);
			
			playersLabel[0].setIcon(new ImageIcon(LeagueGUI.class.getResource
					("/images/teams/"+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getTeams().getAwayTeam().getNickname()+".png")));	
			playersLabel[1].setText(league.getGames().get(league.getNbJourney()-1).getGames().get(i).getPlayers().getAwayPlayers().get(0).getName());
			pointLabel[1].setText(""+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getAwayScorers().get(
							league.getGames().get(league.getNbJourney()-1).getGames().get(i).getPlayers().getAwayPlayers().get(0)));
			playersLabel[2].setText(league.getGames().get(league.getNbJourney()-1).getGames().get(i).getPlayers().getAwayPlayers().get(1).getName());
			pointLabel[2].setText(""+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getAwayScorers().get(
					league.getGames().get(league.getNbJourney()-1).getGames().get(i).getPlayers().getAwayPlayers().get(1)));
			playersLabel[3].setText(league.getGames().get(league.getNbJourney()-1).getGames().get(i).getPlayers().getAwayPlayers().get(2).getName());
			pointLabel[3].setText(""+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getAwayScorers().get(
					league.getGames().get(league.getNbJourney()-1).getGames().get(i).getPlayers().getAwayPlayers().get(2)));
			playersLabel[4].setText(league.getGames().get(league.getNbJourney()-1).getGames().get(i).getPlayers().getAwayPlayers().get(3).getName());
			pointLabel[4].setText(""+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getAwayScorers().get(
					league.getGames().get(league.getNbJourney()-1).getGames().get(i).getPlayers().getAwayPlayers().get(3)));
			playersLabel[5].setText(league.getGames().get(league.getNbJourney()-1).getGames().get(i).getPlayers().getAwayPlayers().get(4).getName());
			pointLabel[5].setText(""+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getAwayScorers().get(
					league.getGames().get(league.getNbJourney()-1).getGames().get(i).getPlayers().getAwayPlayers().get(4)));
			playersLabel[6].setText(league.getGames().get(league.getNbJourney()-1).getGames().get(i).getPlayers().getAwaySubPlayers().get(0).getName());
			pointLabel[6].setText(""+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getAwayScorers().get(
					league.getGames().get(league.getNbJourney()-1).getGames().get(i).getPlayers().getAwaySubPlayers().get(0)));
			playersLabel[7].setText(league.getGames().get(league.getNbJourney()-1).getGames().get(i).getPlayers().getAwaySubPlayers().get(1).getName());
			pointLabel[7].setText(""+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getAwayScorers().get(
					league.getGames().get(league.getNbJourney()-1).getGames().get(i).getPlayers().getAwaySubPlayers().get(1)));
			playersLabel[8].setText(league.getGames().get(league.getNbJourney()-1).getGames().get(i).getPlayers().getAwaySubPlayers().get(2).getName());
			pointLabel[8].setText(""+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getAwayScorers().get(
					league.getGames().get(league.getNbJourney()-1).getGames().get(i).getPlayers().getAwaySubPlayers().get(2)));
			playersLabel[9].setText(league.getGames().get(league.getNbJourney()-1).getGames().get(i).getPlayers().getAwaySubPlayers().get(3).getName());
			pointLabel[9].setText(""+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getAwayScorers().get(
					league.getGames().get(league.getNbJourney()-1).getGames().get(i).getPlayers().getAwaySubPlayers().get(3)));
			playersLabel[10].setText(league.getGames().get(league.getNbJourney()-1).getGames().get(i).getPlayers().getAwaySubPlayers().get(4).getName());
			pointLabel[10].setText(""+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getAwayScorers().get(
					league.getGames().get(league.getNbJourney()-1).getGames().get(i).getPlayers().getAwaySubPlayers().get(4)));
	
	
		}
		
		

	}
	

}
