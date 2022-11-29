package gui.balancesheet;

import java.awt.Color;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import process.league.LeagueInterface;

public class BalanceSheetPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	private TVRight tvRightPanel = new TVRight();
	
	protected JLabel budgetNBA[] = new JLabel[12];
	
	public BalanceSheetPanel() {
		
		addLabel(budgetNBA);
		
		initStyle();
		
		initLayout();
	}
	
	protected void initStyle() {
		
		int y = 0;
		
		for(int i=0;i<budgetNBA.length;i++) {
			budgetNBA[i].setBounds(1080,y,210,30);
			budgetNBA[i].setBackground(Color.WHITE);
			budgetNBA[i].setOpaque(true);
			budgetNBA[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(221,221,221)));
			y=y+30;
		}
		
		budgetNBA[0].setHorizontalAlignment(SwingConstants.CENTER);
		budgetNBA[0].setBackground(new Color(17,35,63));
		budgetNBA[0].setOpaque(true);
		budgetNBA[0].setForeground(Color.WHITE);
		budgetNBA[0].setText("NBA");
		
		budgetNBA[5].setHorizontalAlignment(SwingConstants.CENTER);
		budgetNBA[5].setBackground(new Color(17,35,63));
		budgetNBA[5].setOpaque(true);
		budgetNBA[5].setForeground(Color.WHITE);
		budgetNBA[5].setText("Tenant du titre");
	}
	protected void initLayout() {
		
		setBounds(110, 80, 1310, 780);
		setBackground(new Color(240,240,240));
		setLayout(null);
				
		for(int i=0;i<budgetNBA.length;i++) {
			add(budgetNBA[i]);
		}
		
		add(tvRightPanel);
		
	}
	
	public void addLabel(JLabel[] jlabel){
        for (int i = 0; i < jlabel.length; i++){
            jlabel[i] = new JLabel();
        }
    }
	
	public void edit(LeagueInterface league) {
		tvRightPanel.edit(league);
		budgetNBA[1].setText("Droit TV : "+numberFormat(league.getCommissioner().getTvRight())+" €");
		budgetNBA[2].setText(" 50% des gains seront reversés");
		budgetNBA[3].setText( " aux équipes en fin de saison");
		budgetNBA[4].setText(" régulière");
		if(league.getStep().equals("endSeason") && !league.getGames().get(league.getNbJourney()).getMonth().equals("Octobre")) {
			budgetNBA[6].setText("Gagnant");
			budgetNBA[7].setText(league.getWinners().get("winner"+league.getGames().get(league.getNbJourney()).getYear()));
			budgetNBA[8].setText("Meilleur marqueur");
			budgetNBA[9].setText(league.getWinners().get("best scorer"+league.getGames().get(league.getNbJourney()).getYear()));
			budgetNBA[10].setText("Meilleur passeur");
			budgetNBA[11].setText(league.getWinners().get("best setter"+league.getGames().get(league.getNbJourney()).getYear()));
		}

	}
	
	public String numberFormat(long number) {
		DecimalFormat format = new DecimalFormat("###,###,###,###" ); 
		DecimalFormatSymbols s = format.getDecimalFormatSymbols();
		s.setGroupingSeparator(' ');
		format.setDecimalFormatSymbols(s);
		return 	format.format(number);

	}
}
