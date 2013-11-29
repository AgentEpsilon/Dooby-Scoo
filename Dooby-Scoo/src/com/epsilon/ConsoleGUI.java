package com.epsilon;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class ConsoleGUI extends JFrame {

	private JPanel contentPane;
	private JTextField commandLine;
	private JTextArea console;
	private JScrollPane scrollPane;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnGame;
	private JMenuItem mntmInventory;
	private JMenuItem mntmMap;
	private JMenuItem mntmSave;
	private JMenuItem mntmLoad;
	private JMenuItem mntmExit;
	private JSeparator separator;
	private JMenu mnEdit;
	private JMenuItem mntmClearConsole;

	/**
	 * Create the frame.
	 */
	public ConsoleGUI() {
		setTitle("Game");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 400, 300);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnFile = new JMenu("File");
		menuBar.add(mnFile);

		mntmSave = new JMenuItem("Export Console Log");
		mntmSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				exportLog();
			}
		});
		mnFile.add(mntmSave);

		mntmLoad = new JMenuItem("Import Console Log");
		mntmLoad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				importLog();
			}
		});
		mnFile.add(mntmLoad);

		separator = new JSeparator();
		mnFile.add(separator);

		mntmExit = new JMenuItem("Exit");
		mntmExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(arg0.getButton() == MouseEvent.BUTTON1)
				{
					int choice = JOptionPane.showConfirmDialog(contentPane, "Are you sure you want to quit?", "Quit", JOptionPane.YES_NO_OPTION);
					if(choice == 0)
					{
						System.exit(0);
					}
				}
			}
		});
		mnFile.add(mntmExit);

		mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);

		mntmClearConsole = new JMenuItem("Clear Console");
		mntmClearConsole.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if (arg0.getButton() == MouseEvent.BUTTON1)
					console.setText("");
			}
		});
		mnEdit.add(mntmClearConsole);

		mnGame = new JMenu("Game");
		menuBar.add(mnGame);

		mntmInventory = new JMenuItem("Inventory");
		mntmInventory.setEnabled(false);
		mnGame.add(mntmInventory);

		mntmMap = new JMenuItem("Map");
		mntmMap.setEnabled(false);
		mnGame.add(mntmMap);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		commandLine = new JTextField();
		commandLine.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					handleInput(e);
					commandLine.setText("");
				}
			}
		});
		contentPane.add(commandLine, BorderLayout.SOUTH);
		commandLine.setColumns(10);

		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		console = new JTextArea();
		scrollPane.setViewportView(console);
		console.setEditable(false);
	}

	public void handleInput(KeyEvent e) {
		post(commandLine.getText());
	}

	public void post(String input) {
		console.append(input+"\n");
	}
	
	public void exportLog()
	{
		Writer writer = null;
		JFileChooser fc = new JFileChooser();
		
		int choice = fc.showSaveDialog(contentPane);

		if(choice==JFileChooser.APPROVE_OPTION)
		{
		try {
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream(fc.getSelectedFile()), "utf-8"));
		    writer.write(console.getText());
		} catch (IOException ex) {
		  // report
		} finally {
		   try {writer.close();} catch (Exception ex) {}
		}
		}
	}
	
	public void importLog()
	{
		JFileChooser fc = new JFileChooser();
		int choice = fc.showOpenDialog(contentPane);
		
		if(choice==JFileChooser.APPROVE_OPTION)
		{
			console.setText("");
			Path file = fc.getSelectedFile().toPath();
			try (InputStream in = Files.newInputStream(file);
			    BufferedReader reader =
			      new BufferedReader(new InputStreamReader(in))) {
			    String line = null;
			    while ((line = reader.readLine()) != null) {
			        post(line);
			    }
			} catch (IOException x) {
			    System.err.println(x);
			}
		}
	}
}
