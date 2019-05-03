	package appentrypoint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import alginterface.AlgApp;
import datasetinterface.LoadDataset;
import labinterface.MultipleAnalysisApp;
import labinterface.SingleAnalysisApp;

@SuppressWarnings("serial")
public class Menu extends JPanel {

	/**
	 * Create the panel.
	 */
	public Menu() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));

		
		
		
		
		
		JButton launchButton = new JButton();
		launchButton.setToolTipText("Launch an experiment");
		launchButton.setPreferredSize(new Dimension(150, 150));
		launchButton.setForeground(new Color(0, 153, 0));
		launchButton.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		
		
		
		
		int tam1 = 70;		
		URL url_img1 = ClassLoader.getSystemResource("tricluster_pattern.png");		
		ImageIcon source1 = new ImageIcon(url_img1);
		Image img1 = source1.getImage() ;  
		Image newimg1 = img1.getScaledInstance( tam1, tam1,  java.awt.Image.SCALE_SMOOTH ) ;  
		source1 = new ImageIcon(newimg1);
		
		launchButton.setIcon(source1);
		
		
		
		
		
		
		
		add(launchButton);

		launchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				launchAlgoritm();
			}
		});

		JButton singleAnalisysButton = new JButton("<html>Single<br>results analysis</html>");
		singleAnalisysButton.setPreferredSize(new Dimension(150, 100));
		singleAnalisysButton.setForeground(new Color(0, 153, 255));
		singleAnalisysButton.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		add(singleAnalisysButton);
		
		singleAnalisysButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				launchSingleAnalysis();				
			}
		});
		

		JButton severalAnalysisButton = new JButton(
				"<html>Multiple<br>results analysis</html>");
		severalAnalysisButton.setPreferredSize(new Dimension(150, 100));
		severalAnalysisButton.setForeground(new Color(255, 153, 51));
		severalAnalysisButton.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		add(severalAnalysisButton);
		
		severalAnalysisButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				launchMultipleAnalysis();				
			}
		});

		JButton loadDatasetButton = new JButton("<html>Load a<br>dataset</html>");
		loadDatasetButton.setPreferredSize(new Dimension(150, 100));
		loadDatasetButton.setForeground(new Color(153, 204, 153));
		loadDatasetButton.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		add(loadDatasetButton);

		loadDatasetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				launchLoadDataset();				
			}
		});
		
		
	}
	
	private void launchMultipleAnalysis() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MultipleAnalysisApp window = new MultipleAnalysisApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	private void launchSingleAnalysis() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SingleAnalysisApp window = new SingleAnalysisApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	private void launchAlgoritm() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlgApp window = new AlgApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	
	private void launchLoadDataset(){
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoadDataset window = new LoadDataset();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
	}
	
}
