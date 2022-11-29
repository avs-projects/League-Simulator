package gui.home;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import process.league.LeagueInterface;

public class BudgetMatchPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
		
	protected static JLabel infoBudgetLabel[] = new JLabel[10];
	protected static JLabel info = new JLabel();
	
	public BudgetMatchPanel() {
		
		addLabel(infoBudgetLabel);
		
		initStyle();
		
		initLayout();
	}
	
	protected void initStyle() {
		
		info.setBounds(0,0,350,70);
		info.setBackground(new Color(17,35,63));
		info.setOpaque(true);
		info.setText("FINANCES DU MATCH");
		info.setForeground(new Color(219,225,32));
		info.setFont(new Font("Times",Font.BOLD,15));
		info.setHorizontalAlignment(SwingConstants.CENTER);
		
		int x = 10;
		int y = 70;

		for (int i = 0; i< infoBudgetLabel.length; i++) {
			if(i%2==0) {
				infoBudgetLabel[i].setBounds(x,y,130,40);
				infoBudgetLabel[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
				x = x+130;
			}
			else {
				infoBudgetLabel[i].setBounds(x,y,200,40);
				infoBudgetLabel[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));

				x=10;
				y=y+40;

			}
			
			infoBudgetLabel[i].setForeground(new Color(17,35,63));
		}


	}
	
	protected void initLayout() {
		 
		setBounds(940, 405, 350, 315);
		setBackground(Color.WHITE);
		setLayout(null);
		
		for (int i = 0; i< infoBudgetLabel.length; i++) {
			add(infoBudgetLabel[i]);
		}
		
		add(info);
		
	
	}
	
	protected void addLabel (JLabel[] jlabel){
		
        for (int i = 0; i < jlabel.length; i++){
            jlabel[i] = new JLabel();
        }
        
    }
	
	public static void matchBudgetEdit(LeagueInterface league, int i) {
		
		infoBudgetLabel[0].setText(" Spectateurs  ");
		infoBudgetLabel[2].setText(" Location du stade  ");
		infoBudgetLabel[4].setText(" Voyage (Domicile)  ");
		infoBudgetLabel[6].setText(" Voyage (Exterieur) ");
		infoBudgetLabel[8].setText(" Tickets vendus ");
		
		infoBudgetLabel[1].setText(""+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getBudget().getEarnings().getTicketSelling()+"  ");
		infoBudgetLabel[3].setText("- "+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getBudget().getExpenses().getStadiumRent()+" €  ");
		infoBudgetLabel[5].setText("- "+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getBudget().getExpenses().getTravelHome()+" €  ");
		infoBudgetLabel[7].setText("- "+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getBudget().getExpenses().getTravelAway()+" €  ");
		infoBudgetLabel[9].setText("+ "+league.getGames().get(league.getNbJourney()-1).getGames().get(i).getBudget().getEarnings().getTicketEarnings() + " €  ");
	

	}
}

