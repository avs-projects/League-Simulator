package gui.home;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import gui.main.LeagueGUI;
import process.league.LeagueInterface;

public class InfoPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	protected static JLabel infoMatchLabel[] = new JLabel[9];
	protected static JLabel headInfoLabel[] = new JLabel[3];
	
	public InfoPanel() {
		
		addLabel(infoMatchLabel);
		
		addLabel(headInfoLabel);
		
		initStyle();
		
		initLayout();
	}
	
	protected void initStyle() {
		
		int x = 1;
		
		for (int i = 0; i< headInfoLabel.length; i++) {
			headInfoLabel[i].setHorizontalAlignment(SwingConstants.CENTER);
			if(i==1) {headInfoLabel[i].setBounds(x,1,70,30);
			x=x+70;
			}
			else {
			headInfoLabel[i].setBounds(x,1,189,30);
			x=x+189;
			}
			headInfoLabel[i].setForeground(Color.GRAY);
			headInfoLabel[i].setFont(new Font("Arial",Font.BOLD,11));
			headInfoLabel[i].setBackground(new Color(17,35,63));
			headInfoLabel[i].setOpaque(true);
		}
		
		x = 0;
		
		for (int i = 0; i< infoMatchLabel.length; i++) {
			if((i==3) || (i==6))  x = 0;
			if(i>=6) infoMatchLabel[i].setBounds(x,150,150,30);
			else if(i>=3) infoMatchLabel[i].setBounds(x,120,150,30);
			else  infoMatchLabel[i].setBounds(x,50,150,70); 
			infoMatchLabel[i].setForeground(Color.WHITE);
			infoMatchLabel[i].setFont(new Font("Helvetica",Font.BOLD,18));
			infoMatchLabel[i].setHorizontalAlignment(SwingConstants.CENTER);
			x=x+150;
		}
		
	}
	
	protected void initLayout() {
		
		setBounds(455,40,450,200);
		setBackground(new Color(22,22,22));
		setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(192,144,240)));
		setLayout(null);
		
		for (int i = 0; i< infoMatchLabel.length; i++) {
			add(infoMatchLabel[i]);
		}
		
		for (int i = 0; i< headInfoLabel.length; i++) {
			add(headInfoLabel[i]);
		}
		
		
	}
	
	protected void addLabel (JLabel[] jlabel){
		
        for (int i = 0; i < jlabel.length; i++){
            jlabel[i] = new JLabel();
        }  
    }
	 
	public static void infoEdit(LeagueInterface league, int i) {
		
		infoMatchLabel[0].setIcon(new ImageIcon(LeagueGUI.class.getResource
				("/images/teams/"+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getTeams().getHomeTeam().getNickname()+".png")));
		infoMatchLabel[1].setText(league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getHomeTScore()+" - "+
				league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getAwayTScore());
		infoMatchLabel[1].setFont(new Font("Times", Font.BOLD, 30));
		infoMatchLabel[2].setIcon(new ImageIcon(LeagueGUI.class.getResource
				("/images/teams/"+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getTeams().getAwayTeam().getNickname()+".png")));
		infoMatchLabel[3].setText(league.getGames().get(league.getNbJourney()-1).getGames().get(i).getTeams().getHomeTeam().getNickname());
		infoMatchLabel[4].setText(league.getGames().get(league.getNbJourney()-1).getDay().substring(0,3)+". "+
		league.getGames().get(league.getNbJourney()-1).getNumber()+" "+league.getGames().get(league.getNbJourney()-1).getMonth().substring(0,3)+".");
		infoMatchLabel[4].setFont(new Font("Helvetica",Font.BOLD,12));
		infoMatchLabel[5].setText(league.getGames().get(league.getNbJourney()-1).getGames().get(i).getTeams().getAwayTeam().getNickname());
		infoMatchLabel[6].setText("("+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getTeams().getHomeTeam().getRank().getVictory()+
				"-"+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getTeams().getHomeTeam().getRank().getDefeat()+")");
		infoMatchLabel[7].setText("TERMINÉ");
		infoMatchLabel[7].setForeground(new Color(219,225,32));
		infoMatchLabel[8].setText("("+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getTeams().getAwayTeam().getRank().getVictory()+
				"-"+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getTeams().getAwayTeam().getRank().getDefeat()+")");
		
		headInfoLabel[0].setText("Saison Régulière");
		headInfoLabel[1].setText("Jour."+(league.getNbJourney()+2)/3);
		headInfoLabel[1].setForeground(new Color(219,225,32));
		headInfoLabel[1].setFont(new Font("Times", Font.BOLD, 17));

		headInfoLabel[2].setText(league.getGames().get(league.getNbJourney()-1).getGames().get(i).getCurrentStadium());
		
		
	}
}
