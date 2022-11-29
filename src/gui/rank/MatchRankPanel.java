package gui.rank;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import data.basketteam.BasketballTeam;
import gui.main.LeagueGUI;
import gui.main.MyButton;
import process.league.LeagueInterface;

public class MatchRankPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	protected static JLabel rankLabel[] = new JLabel[15];
	protected static JLabel	teamLabel[] = new JLabel[15];
	protected static JLabel formLabel[] = new JLabel[15];
	protected static JLabel	perLabel[] = new JLabel[15];
	protected static JLabel	victoryLabel[] = new JLabel[15];
	protected static JLabel	defeatLabel[] = new JLabel[15];
	
	protected static MyButton conferenceOuestButton = new MyButton("Conference OUEST");
	protected static MyButton conferenceEstButton = new MyButton("Conference EST");
	
	protected static JLabel info[] = new JLabel[6];
	
	protected static JLabel form[] = new JLabel[75];
	
	protected static JLabel classementLabel = new JLabel("CLASSEMENT - EQUIPES");


	public MatchRankPanel() {
		
		addLabel(rankLabel);
		
		addLabel(teamLabel);
		
		addLabel(perLabel);

		addLabel(victoryLabel);

		addLabel(defeatLabel);

		addLabel(formLabel);
		
		addLabel(info);
		
		addLabel(form);
		
		initActions();
		
		initStyle();
		
		initLayout();
		
	}
	
	protected void initActions() {
		conferenceOuestButton.addActionListener(new changeConference("Ouest"));
		conferenceEstButton.addActionListener(new changeConference("Est"));
	}
	
	protected void initStyle() {
		
		classementLabel.setBounds(0,0,500,40);
		classementLabel.setForeground(Color.WHITE);
		classementLabel.setBackground(new Color(17,35,63));
		classementLabel.setOpaque(true);
		classementLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		classementLabel.setHorizontalAlignment(SwingConstants.CENTER);
		classementLabel.setFont(new Font("Times",Font.CENTER_BASELINE,16));
		
		conferenceEstButton.setBounds(0,40,250,40);
		conferenceEstButton.setHorizontalAlignment(SwingConstants.CENTER);
		conferenceEstButton.setBackground(Color.WHITE);
		conferenceEstButton.setForeground(new Color(17,35,63));
		
		conferenceOuestButton.setBounds(250,40,250,40);
		conferenceOuestButton.setHorizontalAlignment(SwingConstants.CENTER);
		conferenceOuestButton.setBackground(Color.LIGHT_GRAY);
		conferenceOuestButton.setForeground(new Color(17,35,63));
		
		int x = 0;
		
		for (int i = 0; i< info.length; i++) {
			if(i==0) {
			info[i].setBounds(x, 80, 80, 30);
			info[i].setText("Position");
			x=x+80;
			}
			else if(i==1) {
				info[i].setBounds(x, 80, 180, 30);
				info[i].setText("Equipe");
				x=x+180;
				}
			else if(i==2) {
				info[i].setBounds(x, 80, 40, 30);
				info[i].setText("G");
				x=x+40;
				}
			else if(i==3) {
				info[i].setBounds(x, 80, 40, 30);
				info[i].setText("P");
				x=x+40;
				}
			else if(i==4){
				info[i].setBounds(x, 80, 60, 30);
				info[i].setText("%");
				x=x+60;
				}
			else {
				info[i].setBounds(x, 80, 100, 30);
				info[i].setText("Forme");
				}
			info[i].setHorizontalAlignment(SwingConstants.CENTER);
			info[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
			info[i].setBackground(new Color(17,35,63));
		}
		
		int y = 110;
		
		for (int i = 0; i< formLabel.length; i++) {
			formLabel[i].setBounds(0, y, 30, 35);
			formLabel[i].setForeground(new Color(17,35,63));
			formLabel[i].setHorizontalAlignment(SwingConstants.CENTER);
			formLabel[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
			if(i==0) {
				formLabel[i].setBackground(Color.GRAY);
				formLabel[i].setOpaque(true);
			}
			else if(i<8){
				formLabel[i].setBackground(Color.LIGHT_GRAY);
				formLabel[i].setOpaque(true);
				formLabel[i].setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.WHITE));
			}
			y=y+35;
		}
		
		y = 110;
		
		for (int i = 0; i< rankLabel.length; i++) {
			rankLabel[i].setBounds(30, y, 50, 35);
			rankLabel[i].setForeground(new Color(17,35,63));
			rankLabel[i].setHorizontalAlignment(SwingConstants.LEFT);
			rankLabel[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
			if(i==0) {
				rankLabel[i].setBackground(Color.GRAY);
				rankLabel[i].setOpaque(true);
			}
			else if(i<8){
				rankLabel[i].setBackground(Color.LIGHT_GRAY);
				rankLabel[i].setOpaque(true);
				rankLabel[i].setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.WHITE));
			}
			y=y+35;
		}
		
		y = 110;
		
		for (int i = 0; i< teamLabel.length; i++) {
			teamLabel[i].setBounds(80, y, 180, 35);
			teamLabel[i].setForeground(new Color(17,35,63));
			teamLabel[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
			if(i==0) {
				teamLabel[i].setBackground(Color.GRAY);
				teamLabel[i].setOpaque(true);
			}
			else if(i<8){
				teamLabel[i].setBackground(Color.LIGHT_GRAY);
				teamLabel[i].setOpaque(true);
				teamLabel[i].setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.WHITE));
			}
			y=y+35;
		}
		
		y = 110;
		
		for (int i = 0; i< victoryLabel.length; i++) {
			victoryLabel[i].setBounds(260, y, 40, 35);
			victoryLabel[i].setForeground(new Color(17,35,63));
			victoryLabel[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
			victoryLabel[i].setHorizontalAlignment(SwingConstants.CENTER);
			if(i==0) {
				victoryLabel[i].setBackground(Color.GRAY);
				victoryLabel[i].setOpaque(true);
			}
			else if(i<8){
				victoryLabel[i].setBackground(Color.LIGHT_GRAY);
				victoryLabel[i].setOpaque(true);
				victoryLabel[i].setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.WHITE));
			}
			y=y+35;
		}
		
		y = 110;
		
		for (int i = 0; i< defeatLabel.length; i++) {
			defeatLabel[i].setBounds(300, y, 40, 35);
			defeatLabel[i].setForeground(new Color(17,35,63));
			defeatLabel[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
			defeatLabel[i].setHorizontalAlignment(SwingConstants.CENTER);
			if(i==0) {
				defeatLabel[i].setBackground(Color.GRAY);
				defeatLabel[i].setOpaque(true);
			}
			else if(i<8){
				defeatLabel[i].setBackground(Color.LIGHT_GRAY);
				defeatLabel[i].setOpaque(true);
				defeatLabel[i].setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.WHITE));

			}
			y=y+35;
		}
		
		y = 110;
		
		for (int i = 0; i< perLabel.length; i++) {
			perLabel[i].setBounds(340, y,60, 35);
			perLabel[i].setForeground(new Color(17,35,63));
			perLabel[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
			perLabel[i].setHorizontalAlignment(SwingConstants.CENTER);
			if(i==0) {
				perLabel[i].setBackground(Color.GRAY);
				perLabel[i].setOpaque(true);
			}
			else if(i<8){
				perLabel[i].setBackground(Color.LIGHT_GRAY);
				perLabel[i].setOpaque(true);
				perLabel[i].setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.WHITE));
			}
			y=y+35;
		}
		
		x = 400;
		y = 110;
		
		for (int i = 0; i< form.length; i++) {
			form[i].setBounds(x, y, 20, 35);
			form[i].setForeground(new Color(17,35,63));
			form[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
			form[i].setHorizontalAlignment(SwingConstants.CENTER);
			if(i%5==4) {
				x=400;
				y=y+35;
			}
			else x=x+20;
			if(i<5) {
				form[i].setBackground(Color.GRAY);
				form[i].setOpaque(true);
			}
			else if(i<40){
				form[i].setBackground(Color.LIGHT_GRAY);
				form[i].setOpaque(true);
				form[i].setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.WHITE));
			}
		}
		
	}
	
	protected void initLayout() {
		
		setBounds(40, 10, 500, 650);
		setBackground(Color.WHITE);
		setLayout(null);
				
		for(int i=0; i<rankLabel.length; i++)
			add(rankLabel[i]);
		
		for(int i=0; i<teamLabel.length; i++)
			add(teamLabel[i]);
		
		for(int i=0; i<victoryLabel.length; i++)
			add(victoryLabel[i]);
		
		for(int i=0; i<defeatLabel.length; i++)
			add(defeatLabel[i]);
		
		for(int i=0; i<perLabel.length; i++)
			add(perLabel[i]);
		
		for(int i=0; i<formLabel.length; i++)
			add(formLabel[i]);
		
		for(int i=0; i<info.length; i++)
			add(info[i]);
		
		for(int i=0; i<form.length; i++)
			add(form[i]);
		
		add(classementLabel);
		add(conferenceOuestButton);
		add(conferenceEstButton);
	}
	
	public void addLabel(JLabel[] jlabel){
        for (int i = 0; i < jlabel.length; i++){
            jlabel[i] = new JLabel();
        }
    }
	
	public class changeConference implements ActionListener {
		
		private String conference;
		
		public changeConference(String conference) {
			this.conference=conference;
		}
		
		public void actionPerformed(ActionEvent e) { 
			matchRankEdit(LeagueGUI.getLeague(),conference);
		}
	}
	
	public void matchRankEdit (LeagueInterface league, String conference) {
		
			for(int i=0;i<form.length;i++) {
				form[i].setIcon(null);
			}
		
		if(conference.equals("Est")) {
			
			conferenceEstButton.setBackground(Color.WHITE);
			
			conferenceOuestButton.setBackground(Color.LIGHT_GRAY);
		
			BasketballTeam[] tmpEst = league.getTeamsRanking().getEasternConference();
		
			int j = 0;
			int t = 0;
			for (int i = 0; i < 15; i++) {
			
				rankLabel[i].setText("    "+tmpEst[i].getRank().getRank());
				teamLabel[i].setText(""+tmpEst[i].getName());
				teamLabel[i].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/teams/16x16/"+tmpEst[i].getNickname()+".png")));
			
				perLabel[i].setText(""+tmpEst[i].getRank().WriteDouble(tmpEst[i].getRank().getPercentage()));
				
				victoryLabel[i].setText(""+tmpEst[i].getRank().getVictory());
				defeatLabel[i].setText(""+tmpEst[i].getRank().getDefeat());
				if(tmpEst[i].getRank().getRank()<tmpEst[i].getRank().getPreviousRank()) {
					formLabel[i].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/up-arrow.png")));
				}
				else if (tmpEst[i].getRank().getRank()>tmpEst[i].getRank().getPreviousRank()){
					formLabel[i].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/down-arrow.png")));
				}
				else {
					formLabel[i].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/circle.png")));
				}
				
				int tmp = 0;
				for(int k = j ; k< 5+t ; k++) {
					if(tmpEst[i].getRank().getForm().get(tmp).equals("V")) {
						form[k].setIcon((new ImageIcon(LeagueGUI.class.getResource("/images/green-circle.png"))));
					}
					else if(tmpEst[i].getRank().getForm().get(tmp).equals("D")) {
						form[k].setIcon((new ImageIcon(LeagueGUI.class.getResource("/images/red-circle.png"))));
					}
					tmp++;
					j++;
				}
				t = t+5;
			}
		}
		else {
			
			conferenceEstButton.setBackground(Color.LIGHT_GRAY);
			
			conferenceOuestButton.setBackground(Color.WHITE);
			
			BasketballTeam[] tmpOuest = league.getTeamsRanking().getWesternConference();
			
			int j = 0;
			int t = 0;
			
			for (int i = 0; i < 15; i++) {
			
				rankLabel[i].setText("    "+tmpOuest[i].getRank().getRank());
				teamLabel[i].setText(tmpOuest[i].getName());
				teamLabel[i].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/teams/16x16/"+tmpOuest[i].getNickname()+".png")));
				perLabel[i].setText(""+tmpOuest[i].getRank().WriteDouble(tmpOuest[i].getRank().getPercentage()));
				victoryLabel[i].setText(""+tmpOuest[i].getRank().getVictory());
				defeatLabel[i].setText(""+tmpOuest[i].getRank().getDefeat());
			
				if(tmpOuest[i].getRank().getRank()<tmpOuest[i].getRank().getPreviousRank()) {
					formLabel[i].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/up-arrow.png")));
				}
				else if (tmpOuest[i].getRank().getRank()>tmpOuest[i].getRank().getPreviousRank()){
					formLabel[i].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/down-arrow.png")));
				}
				else {
					formLabel[i].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/circle.png")));
				}
				
				int tmp = 0;
				for(int k = j ; k< 5+t ; k++) {
					if(tmpOuest[i].getRank().getForm().get(tmp).equals("V")) {
						form[k].setIcon((new ImageIcon(LeagueGUI.class.getResource("/images/green-circle.png"))));
					}
					else if(tmpOuest[i].getRank().getForm().get(tmp).equals("D")) {
						form[k].setIcon((new ImageIcon(LeagueGUI.class.getResource("/images/red-circle.png"))));
					}
					tmp++;
					j++;
				}
				t = t+5;
			}
			
		}
		
		for(int i=0; i<rankLabel.length; i++) {
			rankLabel[i].setVisible(true);
			teamLabel[i].setVisible(true);
			victoryLabel[i].setVisible(true);
			defeatLabel[i].setVisible(true);
			perLabel[i].setVisible(true);
			formLabel[i].setVisible(true);
		}
		for(int i=0; i<form.length; i++)
		form[i].setVisible(true);

		
	}

}
