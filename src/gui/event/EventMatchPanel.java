package gui.event;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import gui.main.LeagueGUI;
import gui.main.MyImageButton;
import process.league.LeagueInterface;

public class EventMatchPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	protected static JLabel teamHome[] = new JLabel[10];
	protected static JLabel teamHomePic[] = new JLabel[10];
	protected static JLabel teamAway[] = new JLabel[10];
	protected static JLabel teamAwayPic[] = new JLabel[10];
	
	protected static JLabel scoreHome[] = new JLabel[10];
	protected static JLabel scoreAway[] = new JLabel[10];
	protected static JLabel score[] = new JLabel[10];
	
	protected static JLabel infoEvent[] = new JLabel[10];

	protected static JLabel dateLabel = new JLabel ("");
	protected JLabel calendrier[] = new JLabel[2];
	
	public EventMatchPanel() {
		
		addLabel(teamHome);
		
		addLabel(teamAway);
		
		addLabel(teamHomePic);
		
		addLabel(teamAwayPic);
		
		addLabel(scoreHome);
		
		addLabel(scoreAway);
		
		addLabel(score);
		
		addLabel(calendrier);
		
		addLabel(infoEvent);
				
		initActions();

		initStyle();
		
		initLayout();
		
	}
	
	protected void initActions() {
	

	}
		
	
	protected void initStyle() {
		
		int x = 0;
		
		for(int i = 0; i<calendrier.length; i++) {
			calendrier[i].setBounds(x,0,190,30);
			calendrier[i].setForeground(new Color(17,35,63));
			calendrier[i].setBackground(Color.WHITE);
			calendrier[i].setHorizontalAlignment(SwingConstants.CENTER);
			calendrier[i].setOpaque(true);
			x=x+190;
		}
		
		calendrier[0].setText("MATCHS DU MOMENT");
		calendrier[1].setText("En direct");
		calendrier[1].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/red-circle.png")));

		dateLabel.setBounds(0,30,380,30);
		dateLabel.setForeground(Color.WHITE);
		dateLabel.setBackground(new Color(17,35,63));
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setOpaque(true);


		int y = 60;
		
		for (int i = 0; i< teamHome.length; i++) {
			teamHome[i].setBounds(20, y, 100, 30);
			teamHome[i].setForeground(new Color(17,35,63));
			teamHome[i].setHorizontalAlignment(SwingConstants.RIGHT);
			teamHome[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(221,221,221)));
			y=y+30;
		}

		y = 60;
		
		for (int i = 0; i< teamHomePic.length; i++) {
			teamHomePic[i].setBounds(120, y, 30, 30);
			teamHomePic[i].setHorizontalAlignment(SwingConstants.LEFT);
			teamHomePic[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(221,221,221)));
			y=y+30;
		}
		
		y = 60;
		
		for (int i = 0; i< scoreHome.length; i++) {
			scoreHome[i].setBounds(150, y, 30, 30);
			scoreHome[i].setForeground(new Color(17,35,63));
			scoreHome[i].setHorizontalAlignment(SwingConstants.CENTER);
			scoreHome[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(221,221,221)));
			y=y+30;
		}
		
		y = 60;
		
		for (int i = 0; i< score.length; i++) {
			score[i].setBounds(180, y, 10, 30);
			score[i].setForeground(new Color(17,35,63));
			score[i].setHorizontalAlignment(SwingConstants.CENTER);
			score[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(221,221,221)));
			y=y+30;
		}
		
		y = 60;
		
		for (int i = 0; i< scoreAway.length; i++) {
			scoreAway[i].setBounds(190, y, 30, 30);
			scoreAway[i].setForeground(new Color(17,35,63));
			scoreAway[i].setHorizontalAlignment(SwingConstants.CENTER);
			scoreAway[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(221,221,221)));
			y=y+30;
		}
		
		y = 60;
		
		for (int i = 0; i< teamAwayPic.length; i++) {
			teamAwayPic[i].setBounds(220, y, 30, 30);
			teamAwayPic[i].setHorizontalAlignment(SwingConstants.RIGHT);
			teamAwayPic[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(221,221,221)));
			y=y+30;
		}
	
		y = 60;
	
		for (int i = 0; i< teamAway.length; i++) {
			teamAway[i].setBounds(250, y, 100, 30);
			teamAway[i].setForeground(new Color(17,35,63));
			teamAway[i].setHorizontalAlignment(SwingConstants.LEFT);
			teamAway[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(221,221,221)));
			y=y+30;
		}
		
		y = 380;
		
		for (int i = 0; i< infoEvent.length; i++) {
			infoEvent[i].setBounds(20, y, 330, 30);
			infoEvent[i].setForeground(new Color(17,35,63));
			infoEvent[i].setHorizontalAlignment(SwingConstants.LEFT);
			infoEvent[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(221,221,221)));
			y=y+30;
		}
		
		infoEvent[0].setBackground(new Color(17,35,63));
		infoEvent[0].setOpaque(true);
		infoEvent[0].setHorizontalAlignment(SwingConstants.CENTER);
		infoEvent[0].setForeground(Color.white);

	
	}
	
	protected void initLayout() {
		
		setBounds(40,0,380,700);
		setBackground(Color.WHITE);
		setLayout(null);
		
		add(dateLabel);
		
		for (int i = 0; i< calendrier.length; i++) {
			add(calendrier[i]);
		}		
		for (int i = 0; i< teamHome.length; i++) {
			add(teamHome[i]);
		}
		
		for (int i = 0; i< scoreHome.length; i++) {
			add(scoreHome[i]);
		}
		
		for (int i = 0; i< score.length; i++) {
			add(score[i]);
		}
		
		for (int i = 0; i< scoreAway.length; i++) {
			add(scoreAway[i]);
		}
		
		for (int i = 0; i< teamAway.length; i++) {
			add(teamAway[i]);
		}
		
		for (int i = 0; i< teamAwayPic.length; i++) {
			add(teamAwayPic[i]);
		}
		
		for (int i = 0; i< teamHomePic.length; i++) {
			add(teamHomePic[i]);
		}
		
		for (int i = 0; i< infoEvent.length; i++) {
			add(infoEvent[i]);
		}
	
	}
	
	protected void addLabel (JLabel[] jlabel){
		
        for (int i = 0; i < jlabel.length; i++){
            jlabel[i] = new JLabel();
        }
        
    }
	
	protected void addImageButton (MyImageButton[] jbutton){
        for (int i = 0; i < jbutton.length; i++){
        	jbutton[i] = new MyImageButton("/images/analyse.png","analyse");
        	jbutton[i].setBackground(new Color(67, 31, 114));
        }
    }
	
	public void eventMatchEdit(LeagueInterface league) {
		
		for(int i=0;i<infoEvent.length;i++)
			infoEvent[i].setText("");
		
		if(LeagueGUI.getLeague().getStep().equals("Christmas")) {
			infoEvent[0].setText("Christmas Day");
			infoEvent[2].setText("Joyeux Noel à tous");
			infoEvent[3].setText("Les matchs de Noel ont été annoncés il y a peu!");
			infoEvent[4].setText("Les matchs vont commencé aujourd'hui");
			infoEvent[5].setText("Tout les billets ont été vendus, les stades seront remplis!");
			dateLabel.setText("Match de Noel");

		}
		
		if(LeagueGUI.getLeague().getStep().equals("AllStarGame")) {
			infoEvent[0].setText("All Star Game");
			infoEvent[2].setText("Bonjour à tous. Aujourd'hui,");
			infoEvent[3].setText("Les meilleurs joueurs de la NBA vont se confronter");
			infoEvent[4].setText("L'ambiance sera au rendez-vous!");
			infoEvent[4].setText("Laquelle des deux équipes prendra le dessus sur l'autre?!");
			dateLabel.setText("All Star Game");

		}
		
		if(LeagueGUI.getLeague().getStep().equals("FirstRound") || LeagueGUI.getLeague().getCurrentSeason()>=174) {
			infoEvent[0].setText("Premier tour des playOff");
			infoEvent[2].setText("Le montant des droits TV a été partagé!");
			infoEvent[3].setText("Les équipes vont se battre pour une place en demi");
			infoEvent[4].setText("Le premier à atteindre 4 victoires gagne sa place! ");
			dateLabel.setText("Premier tour");
		}
		if(LeagueGUI.getLeague().getStep().equals("Semi")) {
			infoEvent[0].setText("Demi finale des playOff");
			dateLabel.setText("Demi Finale");

		}
		
		if(LeagueGUI.getLeague().getStep().equals("FinaleConference")) {
			infoEvent[0].setText("Finale conférence");
			dateLabel.setText("Finale Conference");
		}
		if(LeagueGUI.getLeague().getStep().equals("FinaleNBA")) {
			infoEvent[0].setText("Finale NBA");
			dateLabel.setText("Finale NBA");
		}
		
		for (int i = 0; i< teamHome.length; i++) {
			teamHome[i].setText("");
				
			teamAway[i].setText("");
				
			scoreHome[i].setText("");
			
			score[i].setText("");
			
			scoreAway[i].setText("");
				
			teamHomePic[i].setIcon(null);
				
			teamAwayPic[i].setIcon(null);
		}
		
		for (int i = 0; i<league.getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames().size(); i++) {
			
			teamHomePic[i].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/teams/16x16/"+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getTeams().getHomeTeam().getNickname()+".png")));
			teamAwayPic[i].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/teams/16x16/"+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getTeams().getAwayTeam().getNickname()+".png")));

			teamHome[i].setText(league.getGames().get(league.getNbJourney()-1).getGames().get(i).getTeams().getHomeTeam().getNickname()+"    ");
			score[i].setText("-");
			teamAway[i].setText("    "+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getTeams().getAwayTeam().getNickname());
		
	}


	}
	
	public static void scoreEdit(LeagueInterface league) {
		scoreHome[EventStatPanel.getMatch()-1].setText(""+league.getGames().get(league.getNbJourney()-1).getGames().get(EventStatPanel.getMatch()-1).getScore().getHomeTScore());
		scoreAway[EventStatPanel.getMatch()-1].setText(""+league.getGames().get(league.getNbJourney()-1).getGames().get(EventStatPanel.getMatch()-1).getScore().getAwayTScore());

}
}
