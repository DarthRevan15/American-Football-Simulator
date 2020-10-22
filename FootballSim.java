package classes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.View;
import java.lang.*;

public class FootballSim extends JFrame 
{
	public FootballSim() 
	{
		setSize(300, 250);
		setTitle("Football Sim");
	}
	
	public static void main(String[] args) 
	{
		FootballSim menuGUI = new FootballSim();
		JLabel lblTitle = new JLabel("American Football");
		
		Font titleFont = new Font("Georgia", Font.BOLD, 28);
		lblTitle.setFont(titleFont);
		
		JButton btnNew = new JButton("New");
		btnNew.setSize(100, 30);
		btnNew.addActionListener(new ActionListener() 
		{
					public void actionPerformed(ActionEvent e) 
					{
						menuGUI.hide();
						FootballSim newGUI = new FootballSim();
						newGUI.setSize(450, 250);
						JLabel lblTitle2 = new JLabel("New Game");
						
						Font titleFont = new Font("Georgia", Font.BOLD, 40);
						lblTitle2.setFont(titleFont);
						
						JLabel select = new JLabel("Select Team:");
						// create an empty combo box with items of type String
						JComboBox<String> comboTeams = new JComboBox<String>();
						 
						// add items to the combo box
						comboTeams.addItem("Gators");
						comboTeams.addItem("Crimson Tide");
						comboTeams.addItem("Tigers");
						comboTeams.addItem("Wildcats");
						comboTeams.addItem("Bulldogs");
						comboTeams.addItem("Razorbacks");
						JLabel teamSet = new JLabel();
						comboTeams.addActionListener(new ActionListener() 
						{
							@Override
							public void actionPerformed(ActionEvent e) 
							{
								teamSet.setText(comboTeams.getSelectedItem().toString());
							}
						});
						
						
						JLabel coach = new JLabel("Coach Name");
						JTextField name = new JTextField();
						
						JButton btnCancel = new JButton("Cancel");
						btnCancel.addActionListener(new ActionListener() 
						{
						    public void actionPerformed(ActionEvent e)
						    {
						       newGUI.dispose();
						       menuGUI.show();
						    }
						});
						JButton btnProceed = new JButton("Proceed");
						btnProceed.addActionListener(new ActionListener() 
						{
							public void actionPerformed(ActionEvent e) 
							{
								newGUI.dispose();
								FootballSim seasonMenuGUI = new FootballSim();

								JLabel captionTeam = new JLabel("Team:");
								captionTeam.setHorizontalAlignment(JLabel.CENTER);
								JLabel team = teamSet;
								team.setHorizontalAlignment(JLabel.CENTER);
								
								JLabel caption = new JLabel("Coach:");
								caption.setHorizontalAlignment(JLabel.CENTER);
								JLabel coachName;
								JTextField coach;
								coach = name;
								coachName = new JLabel(coach.getText());
								coachName.setHorizontalAlignment(JLabel.CENTER);
								
								JLabel week = new JLabel("Week:");
								
								// Just a stand-in
								// Will need to figure out how to make weekly opponents random
								// And not the team selected
								JLabel game = new JLabel("vs Gators,");
								
								JLabel winLoss = new JLabel("W-L: 0-0");
								winLoss.setHorizontalAlignment(JLabel.CENTER);
								
								JButton stats, roster, sched;
								stats = new JButton("Stats");
								stats.setSize(50, 30);
								roster = new JButton("Roster");
								roster.setSize(50, 30);
								sched = new JButton("Schedule");
								sched.setSize(50, 30);
								
								JButton btnSave = new JButton("Save");
								btnSave.addActionListener(new ActionListener() 
								{
									public void actionPerformed(ActionEvent e) 
									{
										FootballSim saveGUI = new FootballSim();
										seasonMenuGUI.hide();
										
										JLabel lblSave = new JLabel("Save Game");
										lblSave.setFont(titleFont);
										
										JLabel lblSaveName = new JLabel("Do you want to save your game? Name the save:");
										JTextField saveName = new JTextField();
										
										JButton btnCancel = new JButton("Cancel");
										btnCancel.addActionListener(new ActionListener() 
										{
										    public void actionPerformed(ActionEvent e)
										    {
										       saveGUI.dispose();
										       seasonMenuGUI.show();
										    }
										});
										JButton btnSave = new JButton("Save");
										btnSave.addActionListener(new ActionListener() 
										{
										    public void actionPerformed(ActionEvent e)
										    {
										       saveGUI.dispose();
										       seasonMenuGUI.show();
										    }
										});
										
										JPanel saveTitle = new JPanel(new FlowLayout());
										saveTitle.add(lblSave);
										
										JPanel info = new JPanel(new GridLayout(2, 1));
										info.add(lblSaveName);
										info.add(saveName);
										
										JPanel btns = new JPanel(new GridLayout(1, 2));
										btns.add(btnCancel);
										btns.add(btnSave);
										
										JPanel mainSave = new JPanel(new BorderLayout());
										mainSave.add(saveTitle, BorderLayout.NORTH);
										mainSave.add(info, BorderLayout.CENTER);
										mainSave.add(btns, BorderLayout.SOUTH);
										
										saveGUI.getContentPane().add(mainSave);
										saveGUI.setVisible(true);
										saveGUI.setDefaultCloseOperation(EXIT_ON_CLOSE);
									}
								});
								
								// Need to figure out how to display W/L ratio after each week is simmed
								// or is not yet simmed
								JButton btnMenu = new JButton("Menu");
								btnMenu.addActionListener(new ActionListener() 
								{
									public void actionPerformed(ActionEvent e) 
									{
										seasonMenuGUI.hide();
										FootballSim menuQuest = new FootballSim();
										JLabel lblTitle = new JLabel("American Football");
										
										Font titleFont = new Font("Georgia", Font.BOLD, 28);
										lblTitle.setFont(titleFont);
										
										JLabel title = new JLabel("Are you sure you wish to quit to the menu?");
										
										JButton btnNo, btnYes;
										btnNo = new JButton("No");
										btnNo.addActionListener(new ActionListener()
										{
											public void actionPerformed(ActionEvent e) {
												menuQuest.dispose();
												seasonMenuGUI.show();
											}
										});
										
										btnYes = new JButton("Yes");
										btnYes.addActionListener(new ActionListener()
										{
											public void actionPerformed(ActionEvent e) {
												menuQuest.dispose();
												menuGUI.show();
											}
										});
										
										JPanel windTitle, menuRead, btns, menuMain;
										
										windTitle = new JPanel(new FlowLayout());
										windTitle.add(lblTitle);
										
										menuRead = new JPanel(new FlowLayout());
										menuRead.add(title);
										
										btns = new JPanel(new GridLayout(1, 2));
										btns.add(btnNo);
										btns.add(btnYes);
										
										menuMain = new JPanel(new BorderLayout());
										menuMain.add(windTitle, BorderLayout.NORTH);
										menuMain.add(menuRead, BorderLayout.CENTER);
										menuMain.add(btns, BorderLayout.SOUTH);
										
										menuQuest.getContentPane().add(menuMain);
										menuQuest.setVisible(true);
										menuQuest.setDefaultCloseOperation(EXIT_ON_CLOSE);
									}
								});

								JButton btnSim = new JButton("Simulate");
								
								JPanel teamTitle = new JPanel(new GridLayout(2, 2));
								teamTitle.add(captionTeam);
								teamTitle.add(team);
								teamTitle.add(caption);
								teamTitle.add(coachName);
								
								JPanel season = new JPanel(new FlowLayout());
								season.add(week);
								season.add(game);
								season.add(winLoss);
								
//								JPanel seasBtns = new JPanel(new FlowLayout());
								
								JPanel btns = new JPanel(new GridLayout(2, 3, 5, 5));
								btns.add(stats);
								btns.add(roster);
								btns.add(sched);
								btns.add(btnSave);
								btns.add(btnMenu);
								btns.add(btnSim);
								
								JPanel mainSeas = new JPanel(new BorderLayout());
								mainSeas.add(teamTitle, BorderLayout.NORTH);
								mainSeas.add(season, BorderLayout.CENTER);
								mainSeas.add(btns, BorderLayout.SOUTH);
								
								seasonMenuGUI.getContentPane().add(mainSeas);
								seasonMenuGUI.setVisible(true);
								seasonMenuGUI.setDefaultCloseOperation(EXIT_ON_CLOSE);
							}
						});
						JPanel title = new JPanel(new FlowLayout());
						title.add(lblTitle2);
						
						JPanel info = new JPanel(new GridLayout(2, 2, 5, 5));
						info.add(select);
						info.add(comboTeams);
						info.add(coach);
						info.add(name);
						
						JPanel infoBtns = new JPanel(new GridLayout(1, 2));
						infoBtns.add(btnCancel);
						infoBtns.add(btnProceed);
						
						JPanel main = new JPanel(new BorderLayout());
						main.add(title, BorderLayout.NORTH);
						main.add(info, BorderLayout.CENTER);
						main.add(infoBtns, BorderLayout.SOUTH);
						
						newGUI.getContentPane().add(main);
						newGUI.setVisible(true);
						newGUI.setDefaultCloseOperation(EXIT_ON_CLOSE);
						
					}
				});
		JButton btnLoad = new JButton("Load");
		btnLoad.setSize(100, 30);
		btnLoad.addActionListener(new ActionListener() 
		{
					public void actionPerformed(ActionEvent e) 
					{
						menuGUI.hide();
						FootballSim loadGUI = new FootballSim();
						loadGUI.setSize(450, 250);
						JLabel lblTitle3 = new JLabel("Load Game");
						
						Font titleFont = new Font("Georgia", Font.BOLD, 40);
						lblTitle3.setFont(titleFont);
						
						// needs to have info from another class or section to have a selection of saves
						// to choose from to continue playing
						// for now it is an example for testing purposes
						JLabel selectGame = new JLabel("Select Save:");
						JComboBox<String> comboSaves = new JComboBox<String>(); 
						comboSaves.addItem("Save 1");
						
						JButton btnCancel = new JButton("Cancel");
						btnCancel.addActionListener(new ActionListener() 
						{
						    public void actionPerformed(ActionEvent e)
						    {
						       loadGUI.dispose();
						       menuGUI.show();
						    }
						});
						JButton btnProceed = new JButton("Proceed");
						
						JPanel title = new JPanel(new FlowLayout());
						title.add(lblTitle3);
						
						JPanel info = new JPanel(new GridLayout(1, 2, 5, 5));
						info.add(selectGame);
						info.add(comboSaves);
						
						JPanel infoBtns = new JPanel(new GridLayout(1, 2));
						infoBtns.add(btnCancel);
						infoBtns.add(btnProceed);
						
						JPanel main = new JPanel(new BorderLayout());
						main.add(title, BorderLayout.NORTH);
						main.add(info, BorderLayout.CENTER);
						main.add(infoBtns, BorderLayout.SOUTH);
						
						loadGUI.getContentPane().add(main);
						loadGUI.setVisible(true);
						loadGUI.setDefaultCloseOperation(EXIT_ON_CLOSE);
					}
				});
		
		JButton btnFAQ = new JButton("FAQ");
		btnFAQ.setSize(100, 30);
		btnFAQ.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				menuGUI.hide();
				FootballSim FAQ = new FootballSim();
				FAQ.setSize(650, 300);
				JLabel FAQTitle = new JLabel("FAQ");
				FAQTitle.setFont(titleFont);
				
				JLabel Q1 = new JLabel("Am I able to save the game I started?");
				JLabel A1 = new JLabel("Soon!");
				JLabel Q2 = new JLabel("Will there be more teams soon?");
				JLabel A2 = new JLabel("Yes! I wanted to start with the 6 already in.");
				JLabel Q3 = new JLabel("Will we be able to create our own custom league?");
				JLabel A3 = new JLabel("One day!");
				JLabel Q4 = new JLabel("Will stats be on the main Season screen?");
				JLabel A4 = new JLabel("Yes! Once I figure that issue out!");
				
				JButton btnBack = new JButton("Back");
				btnBack.addActionListener(new ActionListener() 
				{
				    public void actionPerformed(ActionEvent e)
				    {
				       FAQ.dispose();
				       menuGUI.show();
				    }
				});
				
				JPanel titleFAQ = new JPanel(new FlowLayout());
				titleFAQ.add(FAQTitle);
				
				JPanel questions = new JPanel(new GridLayout(4, 2, 5, 5));
				questions.add(Q1);
				questions.add(A1);
				questions.add(Q2);
				questions.add(A2);
				questions.add(Q3);
				questions.add(A3);
				questions.add(Q4);
				questions.add(A4);
				
				JPanel btns = new JPanel(new GridLayout(1, 2));
				btns.add(btnBack);
				
				JPanel mainFAQ = new JPanel(new BorderLayout());
				mainFAQ.add(titleFAQ, BorderLayout.NORTH);
				mainFAQ.add(questions, BorderLayout.CENTER);
				mainFAQ.add(btns, BorderLayout.SOUTH);
				
				FAQ.getContentPane().add(mainFAQ);
				FAQ.setVisible(true);
				FAQ.setDefaultCloseOperation(EXIT_ON_CLOSE);
			}
		});
		
		JPanel titlePan = new JPanel(new FlowLayout());
		titlePan.add(lblTitle);
		
		JPanel panel = new JPanel(new GridLayout(1, 2));
		panel.add(btnNew);
		panel.add(btnLoad);
		
		JPanel panelFAQ = new JPanel(new GridLayout(1, 1));
		panelFAQ.add(btnFAQ);
		
		JPanel mainPan = new JPanel(new BorderLayout());
		mainPan.add(titlePan, BorderLayout.NORTH);
		mainPan.add(panel, BorderLayout.CENTER);
		mainPan.add(panelFAQ, BorderLayout.SOUTH);
		
		menuGUI.getContentPane().add(mainPan);
		menuGUI.setVisible(true);
		menuGUI.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
