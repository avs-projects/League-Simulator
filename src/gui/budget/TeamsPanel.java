package gui.budget;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import data.basketteam.BasketballTeam;
import factory.AbstractDAOFactory;
import gui.main.LeagueGUI;
import gui.main.MyButton;
import gui.main.MyImageButton;
import process.league.LeagueInterface;
import process.team.TeamBuilder;

public class TeamsPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	protected static MyButton conferenceOuestButton = new MyButton("Conference OUEST");
	protected static MyButton conferenceEstButton = new MyButton("Conference EST");
	
	protected MyButton[] estButton = new MyButton[3];
	protected MyButton[] ouestButton = new MyButton[3];
	
	protected JLabel luxuryTaxTeams[] = new JLabel[30];
	
	protected JLabel divisionLabel = new JLabel("");
		
	protected MyImageButton[] teams = new MyImageButton[30];
	
	protected JLabel[] teamsNameLabel = new JLabel[5];
	
	public TeamsPanel() {
		
		addButton(estButton);
		
		addButton(ouestButton);
		
		addLabel(luxuryTaxTeams);
		
		addIcon(teams, "Southwest");
		
		addLabel(teamsNameLabel);
		
		initActions();
		
		initStyle();
		
		initLayout();
		
	}
	
	protected void initActions() {
		
			conferenceOuestButton.addActionListener(new changeConference("Ouest"));
			conferenceEstButton.addActionListener(new changeConference("Est"));

			estButton[0].addActionListener(new showTeam("Atlantique"));
			estButton[1].addActionListener(new showTeam("Centre"));
			estButton[2].addActionListener(new showTeam("Sud-Est"));
			ouestButton[0].addActionListener(new showTeam("Nord-Ouest"));
			ouestButton[1].addActionListener(new showTeam("Pacifique"));
			ouestButton[2].addActionListener(new showTeam("Sud-Ouest"));
			
			for (int i=0; i<teams.length ;i++) teams[i].addActionListener(new searchAction(i));
	
	}
	
	protected void initStyle() {
		
		setBounds(40,10,400,700);
		setBackground(new Color(240,240,240));
		setLayout(null);
		
		divisionLabel.setBounds(0,40,400,10);
		divisionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		divisionLabel.setBackground(Color.WHITE);
		divisionLabel.setOpaque(true);
		
		conferenceOuestButton.setBounds(0,0,200,40);
		conferenceOuestButton.setForeground(Color.BLACK);
		conferenceOuestButton.setBackground(Color.WHITE);
		conferenceEstButton.setBounds(200,0,200,40);
		conferenceEstButton.setForeground(Color.BLACK);
		conferenceEstButton.setBackground(Color.LIGHT_GRAY);

		setImageButtonStyle();
		
		setButtonStyle(estButton,0,50,133,40,133);
		setButtonStyle(ouestButton,0,50,133,40,133);
		
		int y = 110;
		
		for (int i = 0; i< teamsNameLabel.length; i++) {
			teamsNameLabel[i].setBounds(80,y,320,100);
			teamsNameLabel[i].setForeground(Color.BLACK);
			teamsNameLabel[i].setBackground(Color.WHITE);
			teamsNameLabel[i].setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
			teamsNameLabel[i].setOpaque(true);
			y=y+100;
		}
		
	}
	
	protected void initLayout() {
		
		setImageButtonLayout(teams, false);
		
		setButtonLayout(estButton,false);
		setButtonLayout(ouestButton,false);
		
		add(divisionLabel);
		
		add(conferenceOuestButton);
		add(conferenceEstButton);
		
		for (int i = 0; i< teamsNameLabel.length; i++) {
			add(teamsNameLabel[i]);
			teamsNameLabel[i].setVisible(false);
		}
		
		ouestButton[0].setBackground(new Color(17,35,63));
		ouestButton[0].setForeground(Color.WHITE);

		for (int i = 0; i< teamsNameLabel.length; i++) teamsNameLabel[i].setVisible(true);	
		
		teams[28].setVisible(true);
		teams[7].setVisible(true);
		teams[24].setVisible(true);
		teams[17].setVisible(true);
		teams[20].setVisible(true);
		teamsNameLabel[0].setText("  "+teams[7].getTeamName());
		teamsNameLabel[1].setText("  "+teams[17].getTeamName());
		teamsNameLabel[2].setText("  "+teams[20].getTeamName());
		teamsNameLabel[3].setText("  "+teams[24].getTeamName());
		teamsNameLabel[4].setText("  "+teams[28].getTeamName());

	}
	
	public void setImageButtonStyle () {
		for (int i = 0; i< teams.length; i++) {
			teams[i].setBackground(Color.WHITE);
			teams[i].setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
		}
		
		teams[0].setBounds(0,110,80,100);
		teams[3].setBounds(0,210,80,100);
		teams[15].setBounds(0,310,80,100);
		teams[21].setBounds(0,410,80,100);
		teams[29].setBounds(0,510,80,100);
		
		teams[1].setBounds(0,110,80,100);
		teams[2].setBounds(0,210,80,100);
		teams[19].setBounds(0,310,80,100);
		teams[22].setBounds(0,410,80,100);
		teams[27].setBounds(0,510,80,100);
		
		teams[4].setBounds(0,110,80,100);
		teams[5].setBounds(0,210,80,100);
		teams[8].setBounds(0,310,80,100);
		teams[11].setBounds(0,410,80,100);
		teams[16].setBounds(0,510,80,100);
		
		teams[7].setBounds(0,110,80,100);
		teams[17].setBounds(0,210,80,100);
		teams[20].setBounds(0,310,80,100);
		teams[24].setBounds(0,410,80,100);
		teams[28].setBounds(0,510,80,100);
		
		teams[9].setBounds(0,110,80,100);
		teams[12].setBounds(0,210,80,100);
		teams[13].setBounds(0,310,80,100);
		teams[23].setBounds(0,410,80,100);
		teams[25].setBounds(0,510,80,100);
		
		teams[6].setBounds(0,110,80,100);
		teams[10].setBounds(0,210,80,100);
		teams[14].setBounds(0,310,80,100);
		teams[18].setBounds(0,410,80,100);
		teams[26].setBounds(0,510,80,100);
	}
	
	public void setImageButtonLayout (MyImageButton[] jbutton, Boolean bool) {
		for (int i = 0; i< jbutton.length; i++) {
			add(jbutton[i]);
			jbutton[i].setVisible(bool);
		}
	}
	
	public void setButtonStyle (MyButton[] jbutton, int x, int y, int width, int height, int sum) {
		for (int i = 0; i< jbutton.length; i++) {
			jbutton[i].setBounds(x, y, width, height);
			jbutton[i].setHorizontalAlignment(SwingConstants.CENTER);
			jbutton[i].setBackground(new Color(241,241,241));
			jbutton[i].setForeground(Color.BLACK);
			x=x+sum;
		}
	}
	
	public void setButtonLayout (MyButton[] jbutton, Boolean bool) {
		for (int i = 0; i< jbutton.length; i++) {
			add(jbutton[i]);
			jbutton[i].setVisible(bool);
		}
	}
	
	public void addIcon(MyImageButton[] jbutton, String conference) {
		
		int i = 0;
		
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		
		ArrayList<BasketballTeam> league = new ArrayList<>();
		
		league = TeamBuilder.setupTeams(adf);
		
		while (i<jbutton.length) {
			
				jbutton[i] = new MyImageButton("/images/teams/"+league.get(i).getNickname() +".png",
						league.get(i).getName());
				i++;
		}
	}

	public void addButton(MyButton[] jbutton){
        for (int i = 0; i < jbutton.length; i++){
        	jbutton[i] = new MyButton("");
        }
    }
	
	public void addLabel(JLabel[] jlabel){
        for (int i = 0; i < jlabel.length; i++){
            jlabel[i] = new JLabel();
        }
    }
	
	private class showTeam implements ActionListener {
		String division;
		
		public showTeam(String division) {
			this.division = division;
		}
		
		public void actionPerformed(ActionEvent e) {
			
			for (int i = 0; i< teams.length; i++) teams[i].setVisible(false);
			
			for (int i = 0; i< estButton.length; i++) {
				estButton[i].setBackground(new Color(241,241,241));
				estButton[i].setForeground(Color.BLACK);
			}
			for (int i = 0; i< ouestButton.length; i++) {
				ouestButton[i].setBackground(new Color(241,241,241));
				ouestButton[i].setForeground(Color.BLACK);

			}
				
			if (division.equals("Sud-Est")) {
				estButton[2].setBackground(new Color(17,35,63));
				estButton[2].setForeground(Color.WHITE);
			
				teams[21].setVisible(true);
				teams[29].setVisible(true);
				teams[0].setVisible(true);
				teams[3].setVisible(true);
				teams[15].setVisible(true);
				teamsNameLabel[0].setText("  "+teams[0].getTeamName());
				teamsNameLabel[1].setText("  "+teams[3].getTeamName());
				teamsNameLabel[2].setText("  "+teams[15].getTeamName());
				teamsNameLabel[3].setText("  "+teams[21].getTeamName());
				teamsNameLabel[4].setText("  "+teams[29].getTeamName());	
			}
			
			if (division.equals("Atlantique")) {
				estButton[0].setBackground(new Color(17,35,63));
				estButton[0].setForeground(Color.WHITE);
				
				teams[1].setVisible(true);
				teams[2].setVisible(true);
				teams[19].setVisible(true);
				teams[22].setVisible(true);
				teams[27].setVisible(true);
				teamsNameLabel[0].setText("  "+teams[1].getTeamName());
				teamsNameLabel[1].setText("  "+teams[2].getTeamName());
				teamsNameLabel[2].setText("  "+teams[19].getTeamName());
				teamsNameLabel[3].setText("  "+teams[22].getTeamName());
				teamsNameLabel[4].setText("  "+teams[27].getTeamName());
			}
				
			if (division.equals("Centre")) {
				estButton[1].setBackground(new Color(17,35,63));
				estButton[1].setForeground(Color.WHITE);

				teams[8].setVisible(true);
				teams[5].setVisible(true);
				teams[11].setVisible(true);
				teams[4].setVisible(true);
				teams[16].setVisible(true);
				teamsNameLabel[0].setText("  "+teams[4].getTeamName());
				teamsNameLabel[1].setText("  "+teams[5].getTeamName());
				teamsNameLabel[2].setText("  "+teams[8].getTeamName());
				teamsNameLabel[3].setText("  "+teams[11].getTeamName());
				teamsNameLabel[4].setText("  "+teams[16].getTeamName());
			}
			
			if (division.equals("Nord-Ouest")) {
				ouestButton[0].setBackground(new Color(17,35,63));
				ouestButton[0].setForeground(Color.WHITE);

				teams[28].setVisible(true);
				teams[7].setVisible(true);
				teams[24].setVisible(true);
				teams[17].setVisible(true);
				teams[20].setVisible(true);
				teamsNameLabel[0].setText("  "+teams[7].getTeamName());
				teamsNameLabel[1].setText("  "+teams[17].getTeamName());
				teamsNameLabel[2].setText("  "+teams[20].getTeamName());
				teamsNameLabel[3].setText("  "+teams[24].getTeamName());
				teamsNameLabel[4].setText("  "+teams[28].getTeamName());		
			}
			if (division.equals("Pacifique")) {
				ouestButton[1].setBackground(new Color(17,35,63));
				ouestButton[1].setForeground(Color.WHITE);

				teams[13].setVisible(true);
				teams[23].setVisible(true);
				teams[9].setVisible(true);
				teams[25].setVisible(true);
				teams[12].setVisible(true);
				teamsNameLabel[0].setText("  "+teams[9].getTeamName());
				teamsNameLabel[1].setText("  "+teams[12].getTeamName());
				teamsNameLabel[2].setText("  "+teams[13].getTeamName());
				teamsNameLabel[3].setText("  "+teams[23].getTeamName());
				teamsNameLabel[4].setText("  "+teams[25].getTeamName());			
			}
			
			if (division.equals("Sud-Ouest")) {
				ouestButton[2].setBackground(new Color(17,35,63));
				ouestButton[2].setForeground(Color.WHITE);

				teams[18].setVisible(true);
				teams[26].setVisible(true);
				teams[10].setVisible(true);
				teams[6].setVisible(true);
				teams[14].setVisible(true);
				teamsNameLabel[0].setText("  "+teams[6].getTeamName());
				teamsNameLabel[1].setText("  "+teams[10].getTeamName());
				teamsNameLabel[2].setText("  "+teams[14].getTeamName());
				teamsNameLabel[3].setText("  "+teams[18].getTeamName());
				teamsNameLabel[4].setText("  "+teams[26].getTeamName());
			}
			
			for (int i = 0; i< teamsNameLabel.length; i++) teamsNameLabel[i].setVisible(true);	
			
		}		
	}
	
	public class changeConference implements ActionListener {
		
		private String conference;
		
		public changeConference(String conference) {
			this.conference=conference;
		}
		
		public void actionPerformed(ActionEvent e) { 
			teamsPanelEdit(LeagueGUI.getLeague(),conference);
		}
	}
	
	public void teamsPanelEdit(LeagueInterface league, String conference) {
		
            if(conference.equals("Est")) {
            	
            	conferenceEstButton.setBackground(Color.WHITE);
    			
    			conferenceOuestButton.setBackground(Color.LIGHT_GRAY);
                	for(int i = 0; i<estButton.length; i++) {
                		ouestButton[i].setVisible(false);
                		estButton[i].setVisible(false);
                		if (i==0) estButton[i].setText("Atlantique");
                		else if (i==1) estButton[i].setText("Centre");
                		else estButton[i].setText("Sud-Est");
                		estButton[i].setVisible(true);
                	}

            }       
            
          
             else {
                    	conferenceEstButton.setBackground(Color.LIGHT_GRAY);
              			
              			conferenceOuestButton.setBackground(Color.WHITE);
                    for(int i = 0; i<ouestButton.length; i++) {
                		estButton[i].setVisible(false);
                		ouestButton[i].setVisible(false);
                		if (i==0) ouestButton[i].setText("Nord-Ouest");
                		else if (i==1) ouestButton[i].setText("Pacifique");
                		else ouestButton[i].setText("Sud-Ouest");
                		ouestButton[i].setVisible(true);
                	}
          
            }
        }
	
	
	private class searchAction implements ActionListener {
		int i;
		
		public searchAction(int i) {
			this.i = i;
		}
		public void actionPerformed(ActionEvent e) {
			TeamBudgetPanel.searchAction(i,"Revenus");
			
		}
	}
	}
    

