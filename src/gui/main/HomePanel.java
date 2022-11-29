package gui.main;

import java.awt.Color;

import javax.swing.JPanel;

import gui.home.BudgetMatchPanel;
import gui.home.InfoPanel;
import gui.home.MatchPanel;
import gui.home.PlayersPanel;
import gui.home.SecondMatchPanel;
import gui.home.StatPanel;
import process.league.LeagueInterface;

public class HomePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	protected MatchPanel matchPanel = new MatchPanel();
	protected SecondMatchPanel secondMatchPanel = new SecondMatchPanel();
	protected PlayersPanel playersPanel = new PlayersPanel();
	protected BudgetMatchPanel budgetMatchPanel = new BudgetMatchPanel();
	
	protected StatPanel statPanel = new StatPanel();
	protected InfoPanel infoPanel = new InfoPanel();
	
	public HomePanel() {
		
		initStyle();
		
		initLayout();
		
	}
	
	protected void initStyle() {
		
	}
	
	protected void initLayout() {
		
		setBounds(100, 40, 1310, 730);
		setBackground(new Color(240,240,240));
		setLayout(null);
				
		add(matchPanel);
		add(secondMatchPanel);
		add(playersPanel);
		add(budgetMatchPanel);
		add(statPanel);
		add(infoPanel);
		
	}
	
	public void edit (LeagueInterface league) {
		matchPanel.matchEdit(league);
		secondMatchPanel.matchEdit(league);
	}

}
