package gui.map;

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

import data.basketteam.BasketballTeam;
import factory.AbstractDAOFactory;
import gui.main.LeagueGUI;
import gui.main.MyImageButton;
import process.team.TeamBuilder;

public class MapPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	protected MyImageButton teams[] = new MyImageButton[30];
	
	protected JLabel infoTeam[] = new JLabel[8];

	protected JLabel matchs[] = new JLabel[22];
	
	protected JLabel map = new JLabel();
	
	public MapPanel() {
		
		addLabel(infoTeam);
		
		addLabel(matchs);
		
		addImageButton(teams);
		
		initActions();
		
		initStyle();
		
		initLayout();
		
	}
	
	protected void initActions() {
		
		for(int i=0;i<teams.length;i++) {
			teams[i].addActionListener(new showTeam(i));
		}
		
	}
	
	protected void initStyle() {
		
		map.setBounds(20, 10, 900, 600);
		map.setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/usmapstates.png")));
		
		teams[0].setBounds(650,360,60,60);
		teams[1].setBounds(820,160,60,60);	
		teams[2].setBounds(800,250,60,60);		
		teams[3].setBounds(730,360,60,60);		
		teams[4].setBounds(570,220,60,60);		
		teams[5].setBounds(350,200,60,60);		
		teams[6].setBounds(410,390,60,60);		
		teams[7].setBounds(300,270,60,60);		
		teams[8].setBounds(630,140,60,60);		
		teams[9].setBounds(50,250,60,60);		
		teams[10].setBounds(470,440,60,60);
		teams[11].setBounds(630,260,60,60);		
		teams[12].setBounds(110,290,60,60);
		teams[13].setBounds(60,340,60,60);
		teams[14].setBounds(560,330,60,60);
		teams[15].setBounds(750,500,60,60);
		teams[16].setBounds(570,140,60,60);
		teams[17].setBounds(490,130,60,60);
		teams[18].setBounds(550,460,60,60);
		teams[19].setBounds(770,190,60,60);
		teams[20].setBounds(430,320,60,60);
		teams[21].setBounds(710,440,60,60);
		teams[22].setBounds(730,230,60,60);		
		teams[23].setBounds(180,370,60,60);		
		teams[24].setBounds(80,110,60,60);
		teams[25].setBounds(70,180,60,60);
		teams[26].setBounds(400,460,60,60);
		teams[27].setBounds(720,140,60,60);	
		teams[28].setBounds(210,220,60,60);
		teams[29].setBounds(760,300,60,60);
		
		for(int i=0;i<teams.length;i++) {
			teams[i].setContentAreaFilled(false);
		}
		
		int y = 580;
		
		for(int i=0;i<infoTeam.length;i++) {
			if(i==0 || i==1) {

				if(i==0) {
					infoTeam[i].setBounds(150,y,300,25);
				}
				else {
					infoTeam[i].setBounds(450,y,300,25);
					y=y+25;
				}
				infoTeam[i].setBackground(new Color(17,35,63));
				infoTeam[i].setForeground(Color.WHITE);
			}
			else if(i%2==1){
				infoTeam[i].setBounds(450,y,300,25);
				infoTeam[i].setBackground(Color.WHITE);
				y=y+25;
			}
			else {
				infoTeam[i].setBounds(150,y,300,25);
				infoTeam[i].setBackground(Color.WHITE);
			}
			infoTeam[i].setOpaque(true);
			infoTeam[i].setBorder(BorderFactory.createMatteBorder(1,0,0,0, Color.LIGHT_GRAY));
			infoTeam[i].setHorizontalAlignment(SwingConstants.CENTER);
		}
		
		y = 20;
		
		for(int i=0;i<matchs.length;i++) {
			if(i==0 || i==1) {
				matchs[0].setBackground(new Color(17,35,63));
				matchs[0].setOpaque(true);
				matchs[0].setHorizontalAlignment(SwingConstants.CENTER);
				matchs[0].setForeground(Color.WHITE);
				matchs[0].setBounds(950,y,300,60);
				if(i==1) 
					y = y+60;
				

			}
			else if(i%2==1){
				matchs[i].setBackground(Color.WHITE);
				matchs[i].setOpaque(true);
				matchs[i].setBounds(1050,y,200,60);
				y=y+60;
			}
			else {
				matchs[i].setBackground(Color.WHITE);
				matchs[i].setOpaque(true);
				matchs[i].setBounds(950,y,100,60);
				
			}
			matchs[i].setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
			matchs[i].setFont(new Font("Times",Font.BOLD,15));

		}

	}
	
	protected void initLayout() {
		
		setBounds(110, 80, 1310, 700);
		setBackground(new Color(240,240,240));
		setLayout(null);
				
		for(int i=0;i<teams.length;i++) {
			add(teams[i]);
		}
		
		for(int i=0;i<infoTeam.length;i++) {
			add(infoTeam[i]);
		}
		
		for(int i=0;i<matchs.length;i++) {
			add(matchs[i]);
		}
		
		add(map);
		
	}
	
	protected void addImageButton (MyImageButton[] jbutton){
		
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		
		ArrayList<BasketballTeam> league = new ArrayList<>();
		
		league = TeamBuilder.setupTeams(adf);
		
        for (int i = 0; i < jbutton.length; i++){
        	jbutton[i] = new MyImageButton("/images/teams/"+league.get(i).getNickname()+".png","club");
        	jbutton[i].setBackground(new Color(67, 31, 114));
        }
    }
	
	protected void addLabel(JLabel[] jlabel){
        for (int i = 0; i < jlabel.length; i++){
            jlabel[i] = new JLabel();
        }
    }
	
	private class showTeam implements ActionListener {
		int index;
		
		public showTeam(int index) {
			this.index = index;
		}
		
		public void actionPerformed(ActionEvent e) {
			
			for(int i=0;i<matchs.length;i++) {
				matchs[i].setText("");
				matchs[i].setIcon(null);
			}
			infoTeam[0].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/teams/16x16/"+LeagueGUI.getLeague().getTeamList().get(index).getNickname()+".png")));
			infoTeam[0].setText(LeagueGUI.getLeague().getTeamList().get(index).getName());
			infoTeam[1].setText(LeagueGUI.getLeague().getTeamList().get(index).getLocation().getStadium().getName());
			infoTeam[2].setText(" Budget : "+LeagueGUI.getLeague().getTeamList().get(index).getBudget().getBudget()+" €");
			infoTeam[4].setText(" Note : "+LeagueGUI.getLeague().getTeamList().get(index).getStat());
			infoTeam[6].setText(" Bilan : "+LeagueGUI.getLeague().getTeamList().get(index).getRank().getVictory()+" V "+
					LeagueGUI.getLeague().getTeamList().get(index).getRank().getDefeat() + " D");

			infoTeam[3].setText(""+LeagueGUI.getLeague().getTeamList().get(index).getLocation().getStadium().getCapacity()+" Places");
			infoTeam[5].setText(""+LeagueGUI.getLeague().getTeamList().get(index).getLocation().getStadium().getSeatPrice()+" €");
			infoTeam[7].setText(""+LeagueGUI.getLeague().getTeamList().get(index).getLocation().getDivision()+" - "+LeagueGUI.getLeague().getTeamList().get(index).getLocation().getConference());

			
			matchs[0].setText("Derniers matchs");
			
			int i = 2;
			int j = 1;
			
			while(i<22) {
				
				if ((LeagueGUI.getLeague().getCurrentSeason()-j)<0) {
					i=22;
				}
				
				else if(LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-j).getGames().size()!=0 &&
						(LeagueGUI.getLeague().getNbJourney()-j)!=0 && LeagueGUI.getLeague().getCurrentSeason()<174 ) {
					for(int k=0;k<LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-j).getGames().size();k++) {
					
							if(LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-j).getGames().get(k).getTeams().getHomeTeam().equals(LeagueGUI.getLeague().getTeamList().get(index)) ||
								LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-j).getGames().get(k).getTeams().getAwayTeam().equals(LeagueGUI.getLeague().getTeamList().get(index))) {
								if(LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-j).getGames().get(k).getTeams().getHomeTeam().equals(LeagueGUI.getLeague().getTeamList().get(index))) {
									matchs[i].setText("    "+LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-j).getGames().get(k).getScore().getHomeTScore() + " - "+
										LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-j).getGames().get(k).getScore().getAwayTScore());
									matchs[i+1].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/teams/16x16/"+LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-j).getGames().get(k).getTeams().getAwayTeam().getNickname()+".png")));
									matchs[i+1].setText("  "+LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-j).getGames().get(k).getTeams().getAwayTeam().getNickname());
									i=i+2;
								}
								else {
									matchs[i].setText("    "+LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-j).getGames().get(k).getScore().getAwayTScore() + " - "+
										LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-j).getGames().get(k).getScore().getHomeTScore());
									matchs[i+1].setText("  "+LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-j).getGames().get(k).getTeams().getHomeTeam().getNickname());
									matchs[i+1].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/teams/16x16/"+LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-j).getGames().get(k).getTeams().getHomeTeam().getNickname()+".png")));

									i=i+2;
								}	
							}
						}
					j++;
				
				}
				else {
					for(int k=0;k<LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-j).getGames().size();k++) {
						if(LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-j).getGames().get(k).getTeams().getHomeTeam().equals(LeagueGUI.getLeague().getTeamList().get(index)) ||
								LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-j).getGames().get(k).getTeams().getAwayTeam().equals(LeagueGUI.getLeague().getTeamList().get(index))) {
							if(LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-j).getGames().get(k).getTeams().getHomeTeam().equals(LeagueGUI.getLeague().getTeamList().get(index))) {
								matchs[i].setText("    "+LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-j).getGames().get(k).getScore().getHomeTScore() + " - "+
										LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-j).getGames().get(k).getScore().getAwayTScore());
								matchs[i+1].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/teams/16x16/"+LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-j).getGames().get(k).getTeams().getAwayTeam().getNickname()+".png")));
								matchs[i+1].setText("  "+LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-j).getGames().get(k).getTeams().getAwayTeam().getNickname());
									i=i+2;
							}
							else {
								matchs[i].setText("    "+LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-j).getGames().get(k).getScore().getAwayTScore() + " - "+
										LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-j).getGames().get(k).getScore().getHomeTScore());
								matchs[i+1].setText("  "+LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-j).getGames().get(k).getTeams().getHomeTeam().getNickname());
								matchs[i+1].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/teams/16x16/"+LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-j).getGames().get(k).getTeams().getHomeTeam().getNickname()+".png")));

								i=i+2;
							}
							
						}
						
					}
				j++;
				}
			}	
		}
	}
}
