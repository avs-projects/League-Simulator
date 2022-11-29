package gui.balancesheet;

import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import data.basketteam.BasketballTeam;
import gui.main.LeagueGUI;
import process.league.LeagueInterface;

public class TVRight extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	protected JLabel BasketballTeams[] = new JLabel[30];
	
	protected JLabel info[] = new JLabel[5];
	
	protected JLabel infoPayment[] = new JLabel[5];
	
	protected JLabel tvRightES[] = new JLabel[30];
	
	protected JLabel tvRightFF[] = new JLabel[30];
	
	protected JLabel tvRightMP[] = new JLabel[30];
	
	protected JLabel totalPayment[] = new JLabel[30];
	
	protected JLabel unavailable = new JLabel("Disponible au début des playOff");
	
	public TVRight() {
		
		addLabel(BasketballTeams);
		
		addLabel(tvRightES);

		addLabel(tvRightFF);

		addLabel(tvRightMP);
		
		addLabel(info);
		
		addLabel(totalPayment);
		
		addLabel(infoPayment);
		
		initStyle();
		
		initLayout();
		
	}
	
	public void initStyle() {
		
		unavailable.setBounds(10,40,1040,580);
		unavailable.setFont(new Font("Times",Font.BOLD,45));
		unavailable.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));

		unavailable.setHorizontalAlignment(SwingConstants.CENTER);
		unavailable.setOpaque(true);
		
		info[0].setBounds(10,0,200,40);
		info[0].setText("Nom du club");
		info[1].setBounds(220,0,200,40);
		info[1].setText("Partage équitable");
		info[2].setBounds(430,0,200,40);
		info[2].setText("Paiement selon spectateurs");
		info[3].setBounds(640,0,200,40);
		info[3].setText("Paiement selon classement");
		info[4].setBounds(850,0,200,40);
		info[4].setText("Paiement total");
		
		infoPayment[0].setBounds(10,630,200,18);
		infoPayment[0].setText("Total");
		infoPayment[1].setBounds(220,630,200,18);
		infoPayment[2].setBounds(430,630,200,18);
		infoPayment[3].setBounds(640,630,200,18);
		infoPayment[4].setBounds(850,630,200,18);
		
		for(int i=0;i<infoPayment.length;i++) {
			if(i==0) infoPayment[i].setBackground(new Color(17,35,63));
			else infoPayment[i].setBackground(Color.red);
			infoPayment[i].setHorizontalAlignment(SwingConstants.CENTER);
			infoPayment[i].setForeground(Color.WHITE);
			infoPayment[i].setOpaque(true);
		}
		
		for(int i=0;i<info.length;i++)  {
			info[i].setBackground(new Color(17,35,63));
			info[i].setForeground(Color.WHITE);
			info[i].setHorizontalAlignment(SwingConstants.CENTER);
			info[i].setOpaque(true);
		}
		
		int y = 50;
		
		for(int i=0;i<BasketballTeams.length;i++) {
			if(i%2==0) {
				BasketballTeams[i].setBackground(new Color(225,225,225));
				BasketballTeams[i].setOpaque(true);
			}
			BasketballTeams[i].setBounds(10,y,200,19);
			y=y+19;

		}
		
		y=50 ;
		
		for(int i=0;i<tvRightES.length;i++) {
			if(i%2==0) {
				tvRightES[i].setBackground(new Color(225,225,225));
				tvRightES[i].setOpaque(true);
			}
			tvRightES[i].setBounds(220,y,200,19);
			tvRightES[i].setHorizontalAlignment(SwingConstants.CENTER);
			y=y+19;

		}
		
		y=50 ;
		
		for(int i=0;i<tvRightFF.length;i++) {
			if(i%2==0) {
				tvRightFF[i].setBackground(new Color(225,225,225));
				tvRightFF[i].setOpaque(true);
			}
			tvRightFF[i].setBounds(430,y,200,19);
			tvRightFF[i].setHorizontalAlignment(SwingConstants.CENTER);
			y=y+19;

		}
		
		y=50 ;
		
		for(int i=0;i<tvRightMP.length;i++) {
			if(i%2==0) {
				tvRightMP[i].setBackground(new Color(225,225,225));
				tvRightMP[i].setOpaque(true);
			}
			tvRightMP[i].setBounds(640,y,200,19);
			tvRightMP[i].setHorizontalAlignment(SwingConstants.CENTER);
			y=y+19;

		}
		
		y=50 ;
		
		for(int i=0;i<totalPayment.length;i++) {
			if(i%2==0) {
				totalPayment[i].setBackground(new Color(225,225,225));
				totalPayment[i].setOpaque(true);
			}
			totalPayment[i].setBounds(850,y,200,19);
			totalPayment[i].setHorizontalAlignment(SwingConstants.CENTER);
			y=y+19;

		}
		
	
		
	
	}
	
	public void initLayout() {
		
		setBounds(0, 0, 1060, 650);
		setBackground(new Color(240,240,240));
		setLayout(null);
				
		add(unavailable);
		unavailable.setVisible(true);
		
		for(int i=0;i<BasketballTeams.length;i++) {
			add(BasketballTeams[i]);
			add(tvRightMP[i]);
			add(tvRightFF[i]);
			add(tvRightES[i]);
			add(totalPayment[i]);
		}
		
		for(int i=0; i<info.length;i++) {
			add(info[i]);
			}
		
		for(int i=0; i<infoPayment.length;i++) {
			add(infoPayment[i]);
		}
		
		
	}
	
	public void addLabel(JLabel[] jlabel){
        for (int i = 0; i < jlabel.length; i++){
            jlabel[i] = new JLabel();
        }
    }
	
	public void edit(LeagueInterface league) {
		
		if(LeagueGUI.getLeague().getCurrentSeason()==178) {
		unavailable.setVisible(false);
		
		BasketballTeam[] tvPayment = new BasketballTeam[30];
		for(int i=0;i<tvPayment.length;i++) tvPayment[i] = league.getTeamList().get(i);
		
		tri(tvPayment);
		
		int a = 0;
		int b = 0;
		int c = 0;
		
		for(int i=0;i<BasketballTeams.length;i++) {
		
			BasketballTeams[i].setText(tvPayment[i].getName());
			BasketballTeams[i].setIcon(new ImageIcon(LeagueGUI.class.getResource
					("/images/Teams/16x16/"+tvPayment[i].getNickname()+".png")));

			tvRightES[i].setText(""+numberFormat((int)tvPayment[i].getBudget().getEarnings()
					.getTvRight().getEqualShare()));
			
			a = a+(int)tvPayment[i].getBudget().getEarnings().getTvRight().getEqualShare();
			
			tvRightFF[i].setText(""+numberFormat((int)tvPayment[i].getBudget().getEarnings()
					.getTvRight().getFacilityFees())+"     ("+numberFormat((int)tvPayment[i].getBudget().getEarnings()
							.getTvRight().getViewers())+")");
			b = b+(int)tvPayment[i].getBudget().getEarnings().getTvRight().getFacilityFees();
			
			tvRightMP[i].setText(""+numberFormat((int)tvPayment[i].getBudget().getEarnings()
					.getTvRight().getMeritPayment())+"     ("+numberFormat((int)tvPayment[i].getRank().getRank())+")");
			
			c = c + (int)tvPayment[i].getBudget().getEarnings().getTvRight().getMeritPayment();
			totalPayment[i].setText(""+numberFormat((long)tvPayment[i].getBudget().getEarnings()
					.getTvRight().getMeritPayment()+(long)tvPayment[i].getBudget().getEarnings()
					.getTvRight().getFacilityFees()+(long)tvPayment[i].getBudget().getEarnings()
					.getTvRight().getEqualShare()));
			
		}
		
		infoPayment[1].setText(""+numberFormat(a));
		infoPayment[2].setText(""+numberFormat(b));
		infoPayment[3].setText(""+numberFormat(c));
		}
		else if(LeagueGUI.getLeague().getGames().get(LeagueGUI.getLeague().getNbJourney()-1).getMonth().equals("Octobre"))
			unavailable.setVisible(true);
	}
	
	public String numberFormat(long number) {
		DecimalFormat format = new DecimalFormat("###,###,###,###" ); 
		DecimalFormatSymbols s = format.getDecimalFormatSymbols();
		s.setGroupingSeparator(' ');
		format.setDecimalFormatSymbols(s);
		return 	format.format(number);

	}
	
	public static void tri(BasketballTeam tableau[]) {
		int longueur = tableau.length;
		BasketballTeam tampon = null;
		boolean permut;
 
		do {
			permut = false;
			for (int i = 0; i < longueur - 1; i++) {
				double div= tableau[i].getBudget().getEarnings().getTvRight().getEqualShare()+
						tableau[i].getBudget().getEarnings().getTvRight().getFacilityFees()+
						tableau[i].getBudget().getEarnings().getTvRight().getMeritPayment();
				double div2= tableau[i+1].getBudget().getEarnings().getTvRight().getEqualShare()+
						tableau[i+1].getBudget().getEarnings().getTvRight().getFacilityFees()+
						tableau[i+1].getBudget().getEarnings().getTvRight().getMeritPayment();	
				
				if (div<div2) {
					tampon = tableau[i];
					tableau[i] = tableau[i + 1];
					tableau[i + 1] = tampon;
					permut = true;
				}
			}
		} while (permut);
	}
	
}
