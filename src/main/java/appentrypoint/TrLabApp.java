package appentrypoint;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.net.URL;
import java.util.Locale;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import utils.SystemUtilities;

public class TrLabApp {

	private static final Logger LOG = LoggerFactory.getLogger(TrLabApp.class);
	
	
	private JFrame frame;
	
	private JTextPane title;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					SystemUtilities.changeLocale();
					LOG.debug("Locale Language = "+(Locale.getDefault()).getLanguage());
					
//					UIManager.setLookAndFeel(SystemUtilities.getSystemProperty("swing.defaultlaf"));
					
					TrLabApp window = new TrLabApp();
					window.frame.setVisible(true);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TrLabApp() {
		initialize();
	}
	
	
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Arial", Font.PLAIN, 12));
		frame.setBounds(100, 100, 800, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new BoxLayout(titlePanel,BoxLayout.X_AXIS));
		
		int tam1 = 50;
		
		URL url_img1 = ClassLoader.getSystemResource("logo_lsi.gif");		
		ImageIcon sourceLsi = new ImageIcon(url_img1);
		Image img = sourceLsi.getImage() ;  
		Image newimg = img.getScaledInstance( tam1, tam1,  java.awt.Image.SCALE_SMOOTH ) ;  
		sourceLsi = new ImageIcon( newimg );
		
		JLabel lsiLogoIcon = new JLabel(sourceLsi);
		titlePanel.add(lsiLogoIcon);		
		
		title = new JTextPane();
		title.setPreferredSize(new Dimension (200,100));
		title.setBorder(null);		
		title.setText("TrLab");
		title.setEditable(false);
		title.setBackground(SystemColor.window);
		SimpleAttributeSet attribs = new SimpleAttributeSet();
		StyleConstants.setBackground(attribs, SystemColor.window);
		StyleConstants.setForeground(attribs, SystemColor.controlHighlight);
		StyleConstants.setAlignment(attribs, StyleConstants.ALIGN_CENTER);
		StyleConstants.setFontFamily(attribs, "Arial");
		StyleConstants.setFontSize(attribs, 70);
		StyleConstants.setBold(attribs, true);
		StyleConstants.setItalic(attribs, true);
		title.setParagraphAttributes(attribs, true);
		
		titlePanel.add(title);
		
		int tam2 = 70;		
		URL url_img2 = ClassLoader.getSystemResource("logo_us.png");		
		ImageIcon sourceUs = new ImageIcon(url_img2);
		Image img2 = sourceUs.getImage() ;  
		Image newimg2 = img2.getScaledInstance( tam2, tam2,  java.awt.Image.SCALE_SMOOTH ) ;  
		sourceUs = new ImageIcon( newimg2 );
		JLabel usLogoIcon = new JLabel(sourceUs);
		titlePanel.add(usLogoIcon);
		
		
		frame.getContentPane().add(titlePanel);
				
		Menu menu = new Menu();
		frame.getContentPane().add(menu);
	
	}

	
	
}
