package gui.main;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import gui.rank.MatchRankPanel;
import gui.rank.PointRankPanel;
import process.league.LeagueInterface;

public class RankPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private MatchRankPanel matchRankPanel = new MatchRankPanel();
	private PointRankPanel pointRankPanel = new PointRankPanel();

	public RankPanel() {
		
		initStyle();

		initLayout();
		
	}
	
	protected void initStyle() {
		
	}
	
	protected void initLayout() {
		setBounds(110, 60, 1310, 730);
		setBackground(new Color(240,240,240));
		setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(221,221,221)));
		setLayout(null);
				
		add(matchRankPanel);
		add(pointRankPanel);
	}
	
	public void edit (LeagueInterface league) {
		matchRankPanel.matchRankEdit(league,"Est");
		pointRankPanel.pointRankEdit(league,"Points");
	}

}
