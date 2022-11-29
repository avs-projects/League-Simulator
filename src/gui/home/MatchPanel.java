package gui.home;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import data.match.Match;
import gui.main.LeagueGUI;
import gui.main.MyImageButton;
import process.league.LeagueInterface;

public class MatchPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	protected static JLabel teamHome[] = new JLabel[10];
	protected static JLabel teamHomePic[] = new JLabel[10];
	protected static JLabel teamAway[] = new JLabel[10];
	protected static JLabel teamAwayPic[] = new JLabel[10];
	
	protected static JLabel scoreHome[] = new JLabel[10];
	protected static JLabel scoreAway[] = new JLabel[10];
	protected static JLabel score[] = new JLabel[10];
	
	protected static MyImageButton infoMatch[] = new MyImageButton[10];

	protected static JLabel dateLabel = new JLabel ("");
	protected JLabel calendrier[] = new JLabel[2];
	
	public MatchPanel() {
		
		addLabel(teamHome);
		
		addLabel(teamAway);
		
		addLabel(teamHomePic);
		
		addLabel(teamAwayPic);
		
		addLabel(scoreHome);
		
		addLabel(scoreAway);
		
		addLabel(score);
		
		addLabel(calendrier);
		
		addImageButton(infoMatch);
		
		initActions();

		initStyle();
		
		initLayout();
		
	}
	
	protected void initActions() {
	
			for (int j = 0; j<10; j++) {
				infoMatch[j].addActionListener(new lookInfo(j));
			
			}
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
		
		calendrier[0].setText("CALENDRIER");

		dateLabel.setBounds(0,30,380,35);
		dateLabel.setForeground(Color.WHITE);
		dateLabel.setBackground(new Color(17,35,63));
		dateLabel.setOpaque(true);


		int y = 65;
		
		for (int i = 0; i< teamHome.length; i++) {
			teamHome[i].setBounds(0, y, 100, 28);
			teamHome[i].setForeground(new Color(17,35,63));
			teamHome[i].setHorizontalAlignment(SwingConstants.RIGHT);
			teamHome[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(221,221,221)));
			y=y+28;
		}

		y = 65;
		
		for (int i = 0; i< teamHomePic.length; i++) {
			teamHomePic[i].setBounds(100, y, 30, 28);
			teamHomePic[i].setHorizontalAlignment(SwingConstants.LEFT);
			teamHomePic[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(221,221,221)));
			y=y+28;
		}
		
		y = 65;
		
		for (int i = 0; i< scoreHome.length; i++) {
			scoreHome[i].setBounds(130, y, 30, 28);
			scoreHome[i].setForeground(new Color(17,35,63));
			scoreHome[i].setHorizontalAlignment(SwingConstants.CENTER);
			scoreHome[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(221,221,221)));
			y=y+28;
		}
		
		y = 65;
		
		for (int i = 0; i< score.length; i++) {
			score[i].setBounds(160, y, 10, 28);
			score[i].setForeground(new Color(17,35,63));
			score[i].setHorizontalAlignment(SwingConstants.CENTER);
			score[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(221,221,221)));
			y=y+28;
		}
		
		y = 65;
		
		for (int i = 0; i< scoreAway.length; i++) {
			scoreAway[i].setBounds(170, y, 30, 28);
			scoreAway[i].setForeground(new Color(17,35,63));
			scoreAway[i].setHorizontalAlignment(SwingConstants.CENTER);
			scoreAway[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(221,221,221)));
			y=y+28;
		}
		
		y = 65;
		
		for (int i = 0; i< teamAwayPic.length; i++) {
			teamAwayPic[i].setBounds(200, y, 30, 28);
			teamAwayPic[i].setHorizontalAlignment(SwingConstants.RIGHT);
			teamAwayPic[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(221,221,221)));
			y=y+28;
		}
		
		y = 65;
	
		for (int i = 0; i< teamAway.length; i++) {
			teamAway[i].setBounds(230, y, 100, 28);
			teamAway[i].setForeground(new Color(17,35,63));
			teamAway[i].setHorizontalAlignment(SwingConstants.LEFT);
			teamAway[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(221,221,221)));
			y=y+28;
		}
		
		y = 65;
		
		for (int i = 0; i< infoMatch.length; i++) {
			infoMatch[i].setBounds(330, y, 50, 28);
			infoMatch[i].setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, new Color(221,221,221)));
			infoMatch[i].setBackground(Color.WHITE);
			y=y+28;
		}

	
	}
	
	protected void initLayout() {
		
		setBounds(40,40,380,360);
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
		
		for (int i = 0; i< infoMatch.length; i++) {
			add(infoMatch[i]);
			infoMatch[i].setVisible(false);
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
	
	public class lookInfo implements ActionListener {
		
		private int i;
		
		public lookInfo(int i) {
			this.i=i;
		}
		
		public void actionPerformed(ActionEvent e) { 
			InfoPanel.infoEdit(LeagueGUI.getLeague(), i);
			StatPanel.statEdit(LeagueGUI.getLeague(), i);
			PlayersPanel.playersEdit(LeagueGUI.getLeague(), i,LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getGames().get(i).getTeams().getHomeTeam().getName());
			BudgetMatchPanel.matchBudgetEdit(LeagueGUI.getLeague(), i);
		}
	}
	
	public void matchEdit (LeagueInterface league) {
				
		for (int i = 0; i< infoMatch.length; i++) {

			infoMatch[i].setVisible(false);

		}

		for (int i = 0; i< teamHome.length; i++) {
				
			teamAwayPic[i].setVisible(false);
			teamHomePic[i].setVisible(false);
			scoreHome[i].setVisible(false);
			scoreAway[i].setVisible(false);
			score[i].setVisible(false);
			teamAway[i].setVisible(false);
			teamHome[i].setVisible(false);

				
			teamHome[i].setText("");
			teamHome[i].setForeground(new Color(17,35,63));
			teamHome[i].setHorizontalAlignment(SwingConstants.RIGHT);
				
			teamAway[i].setText("");
			teamAway[i].setForeground(new Color(17,35,63));
				
			scoreHome[i].setText("");
			scoreHome[i].setForeground(new Color(17,35,63));
			
			score[i].setText("");
			
			scoreAway[i].setText("");
			scoreAway[i].setForeground(new Color(17,35,63));
				
			teamHomePic[i].setIcon(null);
				
			teamAwayPic[i].setIcon(null);

			}

			ArrayList<Match> match = new ArrayList<>();
			match = league.play();

			for (int i = 0; i<match.size(); i++) {
			
			teamHomePic[i].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/teams/16x16/"+match.get(i).getTeams().getHomeTeam().getNickname()+".png")));
			teamAwayPic[i].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/teams/16x16/"+match.get(i).getTeams().getAwayTeam().getNickname()+".png")));

			teamHome[i].setText(match.get(i).getTeams().getHomeTeam().getNickname()+"    ");
			scoreHome[i].setText(""+match.get(i).getScore().getHomeTScore());	
			score[i].setText("-");
			scoreAway[i].setText(""+match.get(i).getScore().getAwayTScore());
			teamAway[i].setText("    "+match.get(i).getTeams().getAwayTeam().getNickname());
			
			if(match.get(i).getScore().getHomeTScore()<match.get(i).getScore().getAwayTScore()) {
				teamHome[i].setFont(new Font("",Font.BOLD,12));
				teamHome[i].setForeground(new Color(125,125,125));
				scoreHome[i].setForeground(new Color(125,125,125));
			}
			else {
				teamAway[i].setFont(new Font("",Font.BOLD,12));
				teamAway[i].setForeground(new Color(125,125,125));
				scoreAway[i].setForeground(new Color(125,125,125));
			}
			infoMatch[i].setVisible(true);
			teamHome[i].setVisible(true);
			teamAway[i].setVisible(true);
			scoreHome[i].setVisible(true);
			score[i].setVisible(true);
			scoreAway[i].setVisible(true);
			teamHomePic[i].setVisible(true);
			teamAwayPic[i].setVisible(true);

		}
			calendrier[1].setText("JOURNEE "+(LeagueGUI.getLeague().getNbJourney()+2)/3);
		
			dateLabel.setText("  Journée "+(league.getCurrentSeason()+2)/3+" - "+ league.getDate(1));
			
			if(league.getGames().get(league.getNbJourney()-1).getGames().size()!=0) {
				int random = (int) (Math.random()* match.size());
				InfoPanel.infoEdit(LeagueGUI.getLeague(),  random);
				StatPanel.statEdit(LeagueGUI.getLeague(),  random);
				PlayersPanel.playersEdit(LeagueGUI.getLeague(),  random,league.getGames().get(league.getNbJourney()-1).getGames().get(random).getTeams().getHomeTeam().getName());
				BudgetMatchPanel.matchBudgetEdit(LeagueGUI.getLeague(), random);
			}
	}
}
