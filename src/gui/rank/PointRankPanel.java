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

import data.player.Player;
import gui.main.LeagueGUI;
import gui.main.MyButton;
import gui.main.MyImageButton;
import process.league.LeagueInterface;

public class PointRankPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	protected static JLabel info[] = new JLabel[6];
	protected static JLabel rankLabel[] = new JLabel[15];
	protected static JLabel playersLabel[] = new JLabel[15];
	protected static JLabel	teamLabel[] = new JLabel[15];
	protected static JLabel pointsLabel[] = new JLabel[15];
	protected static JLabel perLabel[] = new JLabel[15];
	protected static JLabel gamesLabel[] = new JLabel[15];
	
	protected static MyButton points = new MyButton("Meilleurs marqueurs");
	protected static MyButton passes = new MyButton("Meilleurs passeurs");
	protected static MyImageButton downPoints = new MyImageButton("/images/down.png","scroll");
	protected static MyImageButton downPasses = new MyImageButton("/images/down.png","scroll");
	
	protected static MyImageButton upPoints = new MyImageButton("/images/up.png","scroll");
	protected static MyImageButton upPasses = new MyImageButton("/images/up.png","scroll");
	
	protected JLabel classementPlaLabel = new JLabel("CLASSEMENT - JOUEURS");
	
	protected int scroll = 0;
	
	protected String tmp;

	public PointRankPanel() {
		
		addLabel(info);
		
		addLabel(rankLabel);
		
		addLabel(playersLabel);
		
		addLabel(teamLabel);
		
		addLabel(pointsLabel);
		
		addLabel(perLabel);
		
		addLabel(gamesLabel);
			
		initStyle();
		
		initActions();
		
		initLayout();

	}
	
	protected void initActions() {
		points.addActionListener(new changeCategory("Points"));
		passes.addActionListener(new changeCategory("Passes"));
		downPoints.addActionListener(new scrollDown("Points"));
		downPasses.addActionListener(new scrollDown("Passes"));
		upPoints.addActionListener(new scrollUp("Points"));
		upPasses.addActionListener(new scrollUp("Passes"));
	}
	
	protected void initStyle() {
		
		downPoints.setBounds(0,660,550,20);
		downPoints.setBackground(new Color(17,35,63));
		downPoints.setOpaque(true);
		
		upPasses.setBounds(0,110,550,20);
		upPasses.setBackground(new Color(17,35,63));
		upPasses.setOpaque(true);
		
		upPoints.setBounds(0,110,550,20);
		upPoints.setBackground(new Color(17,35,63));
		upPoints.setOpaque(true);
		
		downPasses.setBounds(0,660,550,20);
		downPasses.setBackground(new Color(17,35,63));
		downPasses.setOpaque(true);
	
		classementPlaLabel.setBounds(0,0,550,40);
		classementPlaLabel.setForeground(Color.WHITE);
		classementPlaLabel.setBackground(new Color(17,35,63));
		classementPlaLabel.setOpaque(true);
		classementPlaLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		classementPlaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		classementPlaLabel.setFont(new Font("Times",Font.CENTER_BASELINE,16));
		
		points.setBounds(0,40,275,40);
		points.setHorizontalAlignment(SwingConstants.CENTER);
		points.setBackground(Color.WHITE);
		points.setForeground(new Color(17,35,63));
		
		passes.setBounds(275,40,275,40);
		passes.setHorizontalAlignment(SwingConstants.CENTER);
		passes.setBackground(Color.LIGHT_GRAY);
		passes.setForeground(new Color(17,35,63));
		
		int x = 0;
		
		for (int i = 0; i< info.length; i++) {
			if(i==0) {
			info[i].setBounds(x, 80, 50, 30);
			info[i].setText("P");
			x=x+50;
			}
			else if(i==1) {
				info[i].setBounds(x, 80, 160, 30);
				info[i].setText("Nom");
				x=x+140;
				}
			else if(i==2) {
				info[i].setBounds(x, 80, 180, 30);
				info[i].setText("Equipe");
				x=x+180;
				}
			else if(i==3) {
				info[i].setBounds(x, 80, 70, 30);
				info[i].setText("Points");
				x=x+70;
				}
			else if(i==4){
				info[i].setBounds(x, 80, 60, 30);
				info[i].setText("Moy");
				x=x+60;
			}
			else {
				info[i].setBounds(x, 80, 50, 30);
				info[i].setText("MJ");
			}

			info[i].setHorizontalAlignment(SwingConstants.CENTER);
			info[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
			info[i].setBackground(new Color(17,35,63));
		}
		
		int y = 130;
		
		for (int i = 0; i< rankLabel.length; i++) {
			rankLabel[i].setBounds(0, y, 50, 35);
			rankLabel[i].setForeground(new Color(17,35,63));
			rankLabel[i].setHorizontalAlignment(SwingConstants.CENTER);
			rankLabel[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
			y=y+35;
		}
		
		y = 130;
		
		for (int i = 0; i< playersLabel.length; i++) {
			playersLabel[i].setBounds(50, y, 160, 35);
			playersLabel[i].setForeground(new Color(17,35,63));
			playersLabel[i].setHorizontalAlignment(SwingConstants.LEFT);
			playersLabel[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
			y=y+35;
		}
		
		y = 130;
		
		for (int i = 0; i< teamLabel.length; i++) {
			teamLabel[i].setBounds(210, y, 180, 35);
			teamLabel[i].setForeground(new Color(17,35,63));
			teamLabel[i].setHorizontalAlignment(SwingConstants.LEFT);
			teamLabel[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
			y=y+35;
		}
		
		y = 130;
		
		for (int i = 0; i< pointsLabel.length; i++) {
			pointsLabel[i].setBounds(390, y, 70, 35);
			pointsLabel[i].setForeground(new Color(17,35,63));
			pointsLabel[i].setHorizontalAlignment(SwingConstants.CENTER);
			pointsLabel[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
			y=y+35;
		}
		
		y = 130;
		
		for (int i = 0; i< perLabel.length; i++) {
			perLabel[i].setBounds(460, y, 40, 35);
			perLabel[i].setForeground(new Color(17,35,63));
			perLabel[i].setHorizontalAlignment(SwingConstants.CENTER);
			perLabel[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
			y=y+35;
		}
		
		y = 130;
		
		for (int i = 0; i< gamesLabel.length; i++) {
			gamesLabel[i].setBounds(500, y, 50, 35);
			gamesLabel[i].setForeground(new Color(17,35,63));
			gamesLabel[i].setHorizontalAlignment(SwingConstants.CENTER);
			gamesLabel[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
			y=y+35;
		}
		

	}

	protected void initLayout() {
		setBounds(650, 10, 550, 680);
		setBackground(Color.WHITE);
		setLayout(null);
		
		for(int i=0; i<info.length; i++)
			add(info[i]);
		
		for(int i=0; i<rankLabel.length; i++)
			add(rankLabel[i]);
		
		for(int i=0; i<playersLabel.length; i++)
			add(playersLabel[i]);
		
		for(int i=0; i<teamLabel.length; i++)
			add(teamLabel[i]);
		
		for(int i=0; i<pointsLabel.length; i++)
			add(pointsLabel[i]);
		
		for(int i=0; i<perLabel.length; i++)
			add(perLabel[i]);
		
		for(int i=0; i<gamesLabel.length; i++)
			add(gamesLabel[i]);
		
		add(classementPlaLabel);
		add(points);
		add(passes);
		add(downPoints);
		add(downPasses);
		add(upPoints);
		add(upPasses);
		
		downPasses.setVisible(false);
		upPasses.setVisible(false);
	}
	
	public void addLabel(JLabel[] jlabel){
        for (int i = 0; i < jlabel.length; i++){
            jlabel[i] = new JLabel();
        }
    }
	
	public class changeCategory implements ActionListener {
		
		private String category;
		
		public changeCategory(String category) {
			this.category=category;
		}
		
		public void actionPerformed(ActionEvent e) { 
			scroll=0;
			pointRankEdit(LeagueGUI.getLeague(),category);
		}
	}
	
	public class scrollDown implements ActionListener {
		
		private String category;
		
		public scrollDown(String category) {
			this.category=category;
		}
		
		public void actionPerformed(ActionEvent e) { 
			scroll = scroll+15;
			if(scroll==300) scroll=0;
			pointRankEdit(LeagueGUI.getLeague(), category);
		}
	}
	
	public class scrollUp implements ActionListener {
		
		private String category;
		
		public scrollUp(String category) {
			this.category=category;
		}
		
		public void actionPerformed(ActionEvent e) { 
			if(scroll==0) scroll=300;
			scroll = scroll-15;
			pointRankEdit(LeagueGUI.getLeague(), category);
		}
	}
	
	public void pointRankEdit(LeagueInterface league, String category) {
		
		if(category.equals("Points")) {
			
			passes.setBackground(Color.LIGHT_GRAY);
			info[3].setText("Points");

			points.setBackground(Color.WHITE);
			Player players[] = new Player[300];
			players = league.getPlayersRank().getPlayersPoints();
			
			for(int i=0; i<15; i++) {
				rankLabel[i].setText(""+(i+scroll+1));
				playersLabel[i].setText(players[i+scroll].getName());
				pointsLabel[i].setText(""+players[i+scroll].getPlayerStatistics().getBasketScored());
				perLabel[i].setText(""+(players[i+scroll].WriteDouble((float) players[i+scroll].getPlayerStatistics().getBasketScored()/(players[i+scroll].getGamesPlayed()))));
				gamesLabel[i].setText(""+(players[i+scroll].getGamesPlayed()));
				for( int j=0; j<30;j++) {
					if(league.getTeamList().get(j).getSquad().contains(players[i+scroll])) {
						teamLabel[i].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/teams/16x16/"+
						league.getTeamList().get(j).getNickname()+".png")));
						teamLabel[i].setText(league.getTeamList().get(j).getName());
					}
				}
			}
			
			downPasses.setVisible(false);
			downPoints.setVisible(true);
			upPasses.setVisible(false);
			upPoints.setVisible(true);
			
		}
		else if(category.equals("Passes")){
			
			
			points.setBackground(Color.LIGHT_GRAY);
			info[3].setText("Passes");

			passes.setBackground(Color.WHITE);
			
			Player players[] = new Player[300];
			players = league.getPlayersRank().getPlayersAssists();
			
			for(int i=0; i<15; i++) {
				rankLabel[i].setText(""+(i+scroll+1));
				playersLabel[i].setText(players[i+scroll].getName());
				pointsLabel[i].setText(""+players[i+scroll].getPlayerStatistics().getAssists());
				perLabel[i].setText(""+(players[i+scroll].WriteDouble(
						(float) players[i+scroll].getPlayerStatistics().getAssists()/(players[i+scroll].getGamesPlayed()))));
				gamesLabel[i].setText(""+(players[i+scroll].getGamesPlayed()));
				for( int j=0; j<30;j++) {
					if(league.getTeamList().get(j).getSquad().contains(players[i+scroll])) {
					teamLabel[i].setIcon(new ImageIcon(LeagueGUI.class.getResource("/images/teams/16x16/"+
							league.getTeamList().get(j).getNickname()+".png")));
					teamLabel[i].setText(league.getTeamList().get(j).getName());
					}
				}
				
			}
			downPasses.setVisible(true);
			downPoints.setVisible(false);
			upPasses.setVisible(true);
			upPoints.setVisible(false);
			
		}
		

		
	}
}
