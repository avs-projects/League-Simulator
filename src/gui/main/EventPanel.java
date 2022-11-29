package gui.main;

import java.awt.Color;

import javax.swing.JPanel;

import gui.event.EventMatchPanel;
import gui.event.EventStatPanel;
import process.league.LeagueInterface;

public class EventPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	protected EventMatchPanel eventMatchPanel = new EventMatchPanel();
	
	protected EventStatPanel eventStatPanel = new EventStatPanel();

	public EventPanel() {
		
		initStyle();
		
		initLayout();
	}
	
	protected void initStyle() {
		
	}
	
	protected void initLayout() {
		
		setBounds(110, 60, 1310, 730);
		setBackground(new Color(240,240,240));
		setLayout(null);
		
		add(eventMatchPanel);
		add(eventStatPanel);
		

	}
	
	public void edit(LeagueInterface league) {
		eventStatPanel.setMatch(0);
		eventStatPanel.setIndex(0);
		eventStatPanel.eventStatEdit();
		eventMatchPanel.eventMatchEdit(league);
	}
}
