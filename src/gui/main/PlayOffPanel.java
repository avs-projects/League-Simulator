package gui.main;

import java.awt.Color;
import java.awt.Font;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import data.match.Match;
import process.league.LeagueInterface;

public class PlayOffPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	protected JLabel firstRound[] = new JLabel[16];
	protected JLabel firstRoundScore[] = new JLabel[16];
	
	protected JLabel playOff = new JLabel(new ImageIcon(LeagueGUI.class.getResource("/images/nba.jpg")));
	
	protected JLabel conferenceOuest = new JLabel("Conference OUEST");
	protected JLabel conferenceEst = new JLabel("Conference EST");
	
	protected JLabel semiFinal[] = new JLabel[8];
	protected JLabel semiFinalScore[] = new JLabel[8];

	protected JLabel finalConference[] = new JLabel[4];
	protected JLabel finalConferenceScore[] = new JLabel[4];

	protected JLabel finalNBA[] = new JLabel[2];
	protected JLabel finalNBAScore[] = new JLabel[2];

	public PlayOffPanel() {
		
		addLabel(firstRound);
		
		addLabel2(firstRoundScore);
		
		addLabel(semiFinal);
		
		addLabel2(semiFinalScore);
		
		addLabel(finalConference);
		
		addLabel2(finalConferenceScore);
		
		addLabel(finalNBA);
		
		addLabel2(finalNBAScore);
		
		initStyle();
		
		initLayout();
		
	}
	
	protected void initStyle() {
		
		conferenceOuest.setBounds(830,20,400,50);
		conferenceOuest.setForeground(Color.BLACK);
		conferenceOuest.setHorizontalAlignment(SwingConstants.CENTER);
		conferenceOuest.setFont(new Font("Arial",Font.BOLD,35));

		conferenceEst.setBounds(40,20,400,50);
		conferenceEst.setForeground(Color.BLACK);
		conferenceEst.setHorizontalAlignment(SwingConstants.CENTER);
		conferenceEst.setFont(new Font("Arial",Font.BOLD,35));
		
		playOff.setBounds(490,20,300,132);
		playOff.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		
		firstRound[0].setBounds(20,80,150,70);
		firstRound[1].setBounds(20,150,150,70);
		firstRound[2].setBounds(20,230,150,70);
		firstRound[3].setBounds(20,300,150,70);
		firstRound[4].setBounds(20,410,150,70);
		firstRound[5].setBounds(20,480,150,70);
		firstRound[6].setBounds(20,560,150,70);
		firstRound[7].setBounds(20,630,150,70);
		
		firstRound[8].setBounds(1110,80,150,70);
		firstRound[9].setBounds(1110,150,150,70);
		firstRound[10].setBounds(1110,230,150,70);
		firstRound[11].setBounds(1110,300,150,70);
		firstRound[12].setBounds(1110,410,150,70);
		firstRound[13].setBounds(1110,480,150,70);
		firstRound[14].setBounds(1110,560,150,70);
		firstRound[15].setBounds(1110,630,150,70);
		
		firstRoundScore[0].setBounds(170,80,30,70);
		firstRoundScore[1].setBounds(170,150,30,70);
		firstRoundScore[2].setBounds(170,230,30,70);
		firstRoundScore[3].setBounds(170,300,30,70);
		firstRoundScore[4].setBounds(170,410,30,70);
		firstRoundScore[5].setBounds(170,480,30,70);
		firstRoundScore[6].setBounds(170,560,30,70);
		firstRoundScore[7].setBounds(170,630,30,70);
		
		firstRoundScore[8].setBounds(1080,80,30,70);
		firstRoundScore[9].setBounds(1080,150,30,70);
		firstRoundScore[10].setBounds(1080,230,30,70);
		firstRoundScore[11].setBounds(1080,300,30,70);
		firstRoundScore[12].setBounds(1080,410,30,70);
		firstRoundScore[13].setBounds(1080,480,30,70);
		firstRoundScore[14].setBounds(1080,560,30,70);
		firstRoundScore[15].setBounds(1080,630,30,70);
		
		semiFinal[0].setBounds(210,155,150,70);
		semiFinal[1].setBounds(210,225,150,70);
		semiFinal[2].setBounds(210,485,150,70);
		semiFinal[3].setBounds(210,555,150,70);
		semiFinal[4].setBounds(920,155,150,70);
		semiFinal[5].setBounds(920,225,150,70);
		semiFinal[6].setBounds(920,485,150,70);
		semiFinal[7].setBounds(920,555,150,70);
		
		semiFinalScore[0].setBounds(360,155,30,70);
		semiFinalScore[1].setBounds(360,225,30,70);
		semiFinalScore[2].setBounds(360,485,30,70);
		semiFinalScore[3].setBounds(360,555,30,70);
		semiFinalScore[4].setBounds(890,155,30,70);
		semiFinalScore[5].setBounds(890,225,30,70);
		semiFinalScore[6].setBounds(890,485,30,70);
		semiFinalScore[7].setBounds(890,555,30,70);
		
		finalConference[0].setBounds(330,320,150,70);
		finalConference[1].setBounds(330,390,150,70);
		finalConference[2].setBounds(800,320,150,70);
		finalConference[3].setBounds(800,390,150,70);
		
		finalConferenceScore[0].setBounds(480,320,30,70);
		finalConferenceScore[1].setBounds(480,390,30,70);
		finalConferenceScore[2].setBounds(770,320,30,70);
		finalConferenceScore[3].setBounds(770,390,30,70);
		
		finalNBA[0].setBounds(540,270,210,100);
		finalNBA[1].setBounds(540,370,210,100);
		
		finalNBAScore[0].setBounds(540,170,210,100);
		finalNBAScore[1].setBounds(540,470,210,100);

		for(int i=0;i<firstRound.length;i++) {
			firstRound[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
			firstRound[i].setBackground(Color.WHITE);
			firstRound[i].setOpaque(true);
			firstRound[i].setFont(new Font("Arial",Font.BOLD,12));
			firstRoundScore[i].setHorizontalAlignment(SwingConstants.CENTER);
			firstRoundScore[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
			firstRoundScore[i].setBackground(Color.WHITE);
			firstRoundScore[i].setFont(new Font("Arial",Font.BOLD,15));
			firstRoundScore[i].setOpaque(true);

		}
		
		for(int i=0;i<semiFinal.length;i++) {
			semiFinal[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
			semiFinal[i].setBackground(Color.WHITE);
			semiFinal[i].setOpaque(true);
			semiFinal[i].setFont(new Font("Arial",Font.BOLD,12));
			semiFinalScore[i].setHorizontalAlignment(SwingConstants.CENTER);
			semiFinalScore[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));	
			semiFinalScore[i].setBackground(Color.WHITE);
			semiFinalScore[i].setFont(new Font("Arial",Font.BOLD,15));
			semiFinalScore[i].setOpaque(true);
		}
		
		for(int i=0;i<finalConference.length;i++) {
			finalConference[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
			finalConference[i].setBackground(Color.WHITE);
			finalConference[i].setOpaque(true);
			finalConference[i].setFont(new Font("Arial",Font.BOLD,12));
			finalConferenceScore[i].setHorizontalAlignment(SwingConstants.CENTER);
			finalConferenceScore[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
			finalConferenceScore[i].setBackground(Color.WHITE);
			finalConferenceScore[i].setFont(new Font("Arial",Font.BOLD,15));
			finalConferenceScore[i].setOpaque(true);
		}
		
		for(int i=0;i<finalNBA.length;i++) {
			finalNBA[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
			finalNBA[i].setBackground(Color.WHITE);
			finalNBA[i].setOpaque(true);
			finalNBA[i].setFont(new Font("Arial",Font.BOLD,12));
			finalNBAScore[i].setHorizontalAlignment(SwingConstants.CENTER);
			finalNBAScore[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
			finalNBAScore[i].setBackground(Color.WHITE);
			finalNBAScore[i].setFont(new Font("Arial",Font.BOLD,45));
			finalNBAScore[i].setOpaque(true);
		}
		
		
	}
	
	protected void initLayout() {
		setBounds(110, 60, 1310, 730);
		setBackground(new Color(240,240,240));
		setLayout(null);
		
		for(int i=0;i<firstRound.length;i++) {
			add(firstRound[i]);
			add(firstRoundScore[i]);
		}
		
		for(int i=0;i<semiFinal.length;i++) {
			add(semiFinal[i]);
			add(semiFinalScore[i]);
		}
		
		for(int i=0;i<finalConference.length;i++) {
			add(finalConference[i]);
			add(finalConferenceScore[i]);
		}
		
		for(int i=0;i<finalNBA.length;i++) {
			add(finalNBA[i]);
			add(finalNBAScore[i]);
		}
			
		add(conferenceOuest);
		add(conferenceEst);
		add(playOff);
			
	}
	
	public void addLabel(JLabel[] jlabel){
        for (int i = 0; i < jlabel.length; i++){
            jlabel[i] = new JLabel("");
        }
    }
	
	public void addLabel2(JLabel[] jlabel){
        for (int i = 0; i < jlabel.length; i++){
            jlabel[i] = new JLabel("");
        }
    }
	
	public void edit (LeagueInterface league) {
		if(LeagueGUI.getLeague().getCurrentSeason()==1) {
			for(int i=0;i<firstRound.length;i++) {
				firstRound[i].setText("");
				firstRound[i].setIcon(null);
				firstRoundScore[i].setText("");
				firstRoundScore[i].setIcon(null);
			}
			for(int i=0;i<semiFinal.length;i++) {
				semiFinal[i].setText("");
				semiFinal[i].setIcon(null);
				semiFinalScore[i].setText("");
				semiFinalScore[i].setIcon(null);
			}
			for(int i=0;i<finalConference.length;i++) {
				finalConference[i].setText("");
				finalConference[i].setIcon(null);
				finalConferenceScore[i].setText("");
				finalConferenceScore[i].setIcon(null);
			}
			for(int i=0;i<finalNBA.length;i++) {
				finalNBA[i].setText("");
				finalNBA[i].setIcon(null);
				finalNBAScore[i].setText("");
				finalNBAScore[i].setIcon(null);
			}
		}
		if(LeagueGUI.getLeague().getStep().equals("FirstRound")) {
			int i = 0;
			for (Map.Entry<String, Match> k : LeagueGUI.getLeague().getPlayOff().getPlayOffCounter().entrySet()) {
				firstRound[i].setText(k.getValue().getTeams().getHomeTeam().getNickname().toUpperCase());
				firstRound[i].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/teams/"+k.getValue().getTeams().getHomeTeam().getNickname()+".png")));
				firstRound[i+1].setText(k.getValue().getTeams().getAwayTeam().getNickname().toUpperCase());
				firstRound[i+1].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/teams/"+k.getValue().getTeams().getAwayTeam().getNickname()+".png")));
				firstRoundScore[i].setText(""+k.getValue().getScore().getHomeTScore());
				firstRoundScore[i+1].setText(""+k.getValue().getScore().getAwayTScore());

				i=i+2;
			}
		}
		else if(LeagueGUI.getLeague().getStep().equals("Semi")) {
			int i = 0;
			for (Map.Entry<String, Match> k : LeagueGUI.getLeague().getPlayOff().getPlayOffCounter().entrySet()) {
				semiFinal[i].setText(k.getValue().getTeams().getHomeTeam().getNickname().toUpperCase());
				semiFinal[i].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/teams/"+k.getValue().getTeams().getHomeTeam().getNickname()+".png")));
				semiFinal[i+1].setText(k.getValue().getTeams().getAwayTeam().getNickname().toUpperCase());
				semiFinal[i+1].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/teams/"+k.getValue().getTeams().getAwayTeam().getNickname()+".png")));
				semiFinalScore[i].setText(""+k.getValue().getScore().getHomeTScore());
				semiFinalScore[i+1].setText(""+k.getValue().getScore().getAwayTScore());
				i=i+2;
			}
		}
		else if (LeagueGUI.getLeague().getStep().equals("FinaleConference")) {
			int i = 0;
			for (Map.Entry<String, Match> k : LeagueGUI.getLeague().getPlayOff().getPlayOffCounter().entrySet()) {
				finalConference[i].setText(k.getValue().getTeams().getHomeTeam().getNickname().toUpperCase());
				finalConference[i].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/teams/"+k.getValue().getTeams().getHomeTeam().getNickname()+".png")));
				finalConference[i+1].setText(k.getValue().getTeams().getAwayTeam().getNickname().toUpperCase());
				finalConference[i+1].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/teams/"+k.getValue().getTeams().getAwayTeam().getNickname()+".png")));
				finalConferenceScore[i].setText(""+k.getValue().getScore().getHomeTScore());
				finalConferenceScore[i+1].setText(""+k.getValue().getScore().getAwayTScore());
				i=i+2;
			}
		}
		else if (LeagueGUI.getLeague().getStep().equals("FinaleNBA")){
			int i = 0;
			for (Map.Entry<String, Match> k : LeagueGUI.getLeague().getPlayOff().getPlayOffCounter().entrySet()) {
				finalNBA[i].setText(k.getValue().getTeams().getHomeTeam().getNickname().toUpperCase());
				finalNBA[i].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/teams/"+k.getValue().getTeams().getHomeTeam().getNickname()+".png")));
				finalNBA[i+1].setText(k.getValue().getTeams().getAwayTeam().getNickname().toUpperCase());
				finalNBA[i+1].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/teams/"+k.getValue().getTeams().getAwayTeam().getNickname()+".png")));
				finalNBAScore[i].setText(""+k.getValue().getScore().getHomeTScore());
				finalNBAScore[i+1].setText(""+k.getValue().getScore().getAwayTScore());
				i=i+2;
			}
		}
	}

}
