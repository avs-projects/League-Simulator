package gui.main;

import java.awt.Color;

import javax.swing.JPanel;

import gui.budget.TeamBudgetPanel;
import gui.budget.TeamsPanel;
import process.league.LeagueInterface;

public class BudgetPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	protected TeamsPanel teamsPanel = new TeamsPanel();
	protected TeamBudgetPanel teamBudgetPanel = new TeamBudgetPanel();
	
	public BudgetPanel() {
		
		initStyle();
		
		initLayout();
	}
	
	protected void initStyle() {
		
	}
	
	protected void initLayout() {
		
		setBounds(110, 80, 1310, 730);
		setBackground(new Color(240,240,240));
		setLayout(null);
		
		add(teamBudgetPanel);
		add(teamsPanel);
		
	}
	
	public void edit (LeagueInterface league) {
		teamsPanel.teamsPanelEdit(league,"Ouest");
		teamBudgetPanel.teamBudgetEdit((int) (Math.random()*30));
	}

}
