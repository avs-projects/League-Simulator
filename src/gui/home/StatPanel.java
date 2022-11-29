package gui.home;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import process.league.LeagueInterface;

public class StatPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	protected static JPanel statPanel = new JPanel();
	protected static JLabel quarterLabel[] = new JLabel[18];
	protected static JLabel statLabel[] = new JLabel[12];
	
	protected static JLabel capacityLabel = new JLabel("REMPLISSAGE DU STADE");
	
	protected static JProgressBar progressBar = new JProgressBar(0,100);
	protected static JProgressBar progressBar2 = new JProgressBar(0,100);
	protected static JProgressBar progressBar3 = new JProgressBar(0,100);

	protected static JProgressBar progressBar4 = new JProgressBar(0,100);

	
	public StatPanel() {
		
		addLabel(quarterLabel);
		
		addLabel(statLabel);
		
		initStyle();
		
		initLayout();
	}
	
	protected void initStyle() {
		
		int x = 0;
		int y = 0;
		
		statPanel.setBounds(10,135,430,350);
		statPanel.setBackground(Color.WHITE);
		statPanel.setLayout(null);

		
		for (int i = 0; i< quarterLabel.length; i++) {
			if (i==0 || i==6 || i==12) {
				quarterLabel[i].setBounds(x,y,200,40);
				x=x+200;
			}
			else if (i==5 || i==11) {
				quarterLabel[i].setBounds(x,y,50,40);
				x=0;
				y=y+40;
			}
			else {
				quarterLabel[i].setBounds(x,y,50,40);
				x=x+50;
			}
				
			if(i<6) {
				quarterLabel[i].setBackground(new Color(17,35,63));
				quarterLabel[i].setForeground(Color.WHITE);
			}
			else {
				quarterLabel[i].setForeground(new Color(17,35,63));
				quarterLabel[i].setBackground(Color.WHITE);
			}
			quarterLabel[i].setOpaque(true);
			quarterLabel[i].setFont(new Font("Times",Font.BOLD,12));
			quarterLabel[i].setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.black));

		}
		
		x = 0;
		
		for (int i = 0; i< statLabel.length; i++) {
			if(i==3 || i==6 || i==9) x = 0;
			if(i==0 || i==1 || i==2) {
				statLabel[i].setBackground(new Color(17,35,63));
				statLabel[i].setOpaque(true);
			}
			
			if(i>=3 && i<6) statLabel[i].setBounds(x,70,143,40);
			else if (i>=6 && i<9) statLabel[i].setBounds(x,120,143,40);
			else if (i>=9) statLabel[i].setBounds(x,170,143,40);
			else statLabel[i].setBounds(x,0,143,70); 
			statLabel[i].setForeground(new Color(17,35,63));
			statLabel[i].setFont(new Font("Times",Font.BOLD,15));
			statLabel[i].setHorizontalAlignment(SwingConstants.CENTER);
			x=x+143;
		}
		progressBar.setBounds(10,110,410,10);
		progressBar.setBorderPainted(false);
		progressBar.setForeground(new Color(17,35,63));
		progressBar.setString("");
		progressBar.setBackground(Color.GRAY);
		
		progressBar2.setBounds(10,160,410,10);
		progressBar2.setForeground(new Color(17,35,63));
		progressBar2.setString("");
		progressBar2.setBackground(Color.GRAY);
		progressBar2.setBorderPainted(false);
		
		progressBar3.setBounds(10,210,410,10);
		progressBar3.setForeground(new Color(17,35,63));
		progressBar3.setString("");
		progressBar3.setBackground(Color.GRAY);
		progressBar3.setBorderPainted(false);
		
		progressBar4.setBounds(10,310,410,10);
		progressBar4.setForeground(new Color(17,35,63));
		progressBar4.setString("");
		progressBar4.setBackground(Color.GRAY);
		progressBar4.setBorderPainted(false);
		
		capacityLabel.setBounds(10,260,410,30);
		capacityLabel.setForeground(new Color(219,225,32));
		capacityLabel.setBackground(new Color(17,35,63));
		capacityLabel.setOpaque(true);
		capacityLabel.setHorizontalAlignment(SwingConstants.CENTER);
		capacityLabel.setFont(new Font("Times",Font.BOLD,12));

	}
	
	protected void initLayout() {
		 
		setBounds(455, 250, 450, 470);
		setBackground(new Color(240,240,240));
		setLayout(null);
		
		for (int i = 0; i< quarterLabel.length; i++) {
			add(quarterLabel[i]);
		}
		
		for (int i = 0; i< statLabel.length; i++) {
			statPanel.add(statLabel[i]);
		}
		
		statPanel.add(progressBar);
		statPanel.add(progressBar2);
		statPanel.add(progressBar3);
		statPanel.add(progressBar4);
		statPanel.add(capacityLabel);


		add(statPanel);
	
	}
	
	protected void addLabel (JLabel[] jlabel){
		
        for (int i = 0; i < jlabel.length; i++){
            jlabel[i] = new JLabel();
        }
        
    }
	
	public static void statEdit(LeagueInterface league, int i) {
		
				
		statLabel[0].setText("  "+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getTeams().getHomeTeam().getNickname().toUpperCase());
		statLabel[0].setForeground(new Color(219,225,32));
		statLabel[1].setText(" JOURNEE "+(league.getNbJourney()+2)/3);
		statLabel[1].setForeground(Color.WHITE);
		statLabel[2].setForeground(new Color(219,225,32));
		statLabel[2].setText("  "+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getTeams().getAwayTeam().getNickname().toUpperCase());
		statLabel[3].setText(""+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getHomeStats().getFreeThrow()+"         ("
		+(100*league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getHomeStats().getFreeThrow()/(
				league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getHomeStats().getFreeThrow()+
				league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getAwayStats().getFreeThrow()))+ " %)");
		statLabel[4].setText("Lancers francs");
		statLabel[5].setText("("+(100-(100*league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getHomeStats().getFreeThrow()/(
				league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getHomeStats().getFreeThrow()+
				league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getAwayStats().getFreeThrow()))+ " %)         "+
				league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getAwayStats().getFreeThrow()));
		statLabel[6].setText(""+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getHomeStats().getTwoPoint()+"         ("
			+(100*league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getHomeStats().getTwoPoint()/(
					league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getHomeStats().getTwoPoint()+
					league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getAwayStats().getTwoPoint()))+ " %)");
		statLabel[7].setText("Tirs (hors lancers f.)");
		statLabel[8].setText("("+(100-(100*league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getHomeStats().getTwoPoint()/(
				league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getHomeStats().getTwoPoint()+
				league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getAwayStats().getTwoPoint()))+ " %)         "+
				league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getAwayStats().getTwoPoint()));
		statLabel[9].setText(""+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getHomeStats().getThreePoint()+"         ("
				+(100*league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getHomeStats().getThreePoint()/(
						league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getHomeStats().getThreePoint()+
						league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getAwayStats().getThreePoint()))+ " %)");
		statLabel[10].setText("3 points");
		statLabel[11].setText("("+(100-(100*league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getHomeStats().getThreePoint()/(
				league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getHomeStats().getThreePoint()+
				league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getAwayStats().getThreePoint()))+ " %)         "+
				league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getAwayStats().getThreePoint()));
		
		progressBar.setValue(100*league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getHomeStats().getFreeThrow()/(
				league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getHomeStats().getFreeThrow()+
				league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getAwayStats().getFreeThrow()));
		progressBar.setStringPainted(true);
		progressBar2.setValue(100*league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getHomeStats().getTwoPoint()/(
				league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getHomeStats().getTwoPoint()+
				league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getAwayStats().getTwoPoint()));
		progressBar2.setStringPainted(true);
		progressBar3.setValue(100*league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getHomeStats().getThreePoint()/(
				league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getHomeStats().getThreePoint()+
				league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getAwayStats().getThreePoint()));
		progressBar3.setStringPainted(true);
		progressBar4.setValue(100*league.getGames().get(league.getNbJourney()-1).getGames().get(i).getBudget().getEarnings().getTicketSelling()/(
				league.getGames().get(league.getNbJourney()-1).getGames().get(i).getTeams().getHomeTeam().getLocation().getStadium().getCapacity()));
		progressBar4.setStringPainted(true);
		
		capacityLabel.setText("REMPLISSAGE DU STADE"+" ("+100*league.getGames().get(league.getNbJourney()-1).getGames().get(i).getBudget().getEarnings().getTicketSelling()/(
				league.getGames().get(league.getNbJourney()-1).getGames().get(i).getTeams().getHomeTeam().getLocation().getStadium().getCapacity())
				+"%)");
		
		quarterLabel[0].setText("   Equipe");
		quarterLabel[1].setText("1");
		quarterLabel[2].setText("2");
		quarterLabel[3].setText("3");
		quarterLabel[4].setText("4");
		quarterLabel[5].setText("T");
		quarterLabel[6].setText("   "+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getTeams().getHomeTeam().getName());
		quarterLabel[7].setText(""+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getQuarterTimeHome().getFirstQT());		
		quarterLabel[8].setText(""+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getQuarterTimeHome().getSecondQT());		
		quarterLabel[9].setText(""+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getQuarterTimeHome().getThirdQT());		
		quarterLabel[10].setText(""+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getQuarterTimeHome().getFourthQT());
		quarterLabel[11].setText(""+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getHomeTScore());
		quarterLabel[12].setText("   "+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getTeams().getAwayTeam().getName());
		quarterLabel[13].setText(""+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getQuarterTimeAway().getFirstQT());		
		quarterLabel[14].setText(""+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getQuarterTimeAway().getSecondQT());		
		quarterLabel[15].setText(""+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getQuarterTimeAway().getThirdQT());		
		quarterLabel[16].setText(""+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getQuarterTimeAway().getFourthQT());
		quarterLabel[17].setText(""+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getScore().getAwayTScore());
		
	}
}
