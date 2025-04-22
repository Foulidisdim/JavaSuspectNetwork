import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FindSuspect extends JFrame {
	
	//thimisou. 4 bhmata gia th kataskeuh tou parathirou:
	//bhma 1 DHMIOURGIA UPODOXEA
	private JPanel panel = new JPanel();
		
	//bhma 2 DHMIOURGIA GRAFIKON SUSTATIKON
	private JTextField searchName = new JTextField("Please enter suspect's name"); //plaisio keimenou
	private JButton findButton = new JButton("Find"); //koumpi find
	private JButton networkButton = new JButton("Visualize Network"); //koumpi visualize network
	
	private Registry mainRegistry = new Registry();
	public FindSuspect(Registry aRegistry) {//PAIRNEI TO REGISTRY APO TH MAIN.
		mainRegistry = aRegistry; //ANATHESI TOU REGISTRY THS MAIN STO REGISTRY AYTHS THS KLASHS GIA NA MPORO NA AKSIOPOIHSO TA STOIXEIA STON AKROATH.
		
		
		//bhma 3 PROSTHIKI GRAFIKON SUSTATIKON STO PANEL
		panel.add(searchName);
		panel.add(findButton);
		panel.add(networkButton);
		
		//bhma 4 PROSTHIKI PANEL STO PARATHIRO POU THA EMFANISTEI.
		this.setContentPane(panel);
		
		
		
		//bhma 3 xeirismou akroath sumbanton: KATASKEUH AKROATH
			ButtonListener listener = new ButtonListener();
			ButtonListener2 listener2 = new ButtonListener2();
		//bhma 4 xeirismou akroath sumbanton: SUNDESH AKROATH ME PHGH SYMBANTON.
			findButton.addActionListener(listener);
			networkButton.addActionListener(listener2);
		//tora THA KANO KATO APO AYTH TH METHODO NEA KLASH ButtonListener POU EKEI THA KATHORISO TI THA GINEI AFOU PATHTHEI TO FIND.
			
		
				
		setVisible(true); //kathista to parathiro orato.
		setSize(300, 150);
		setTitle("Find Suspect"); //titlos parathirou.
		setLocationRelativeTo(null); // GIA NA EMFANIZETAI STO KENTRO TO PARATHIRO
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	//bhma 1 xeirismou sumbanton: DHMIOURGIA KLASHS AKROATH ("AUTIOU")
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//bhma 2 xeirismou sumbanton: SUGGRAFH EKTELOUMENOU KODIKA. BHMATA 3 KAI 4 PANO STO CONSTRUCTOR FindSuspect.
			
			ArrayList<Suspect> Suspects = mainRegistry.Suspects;
			boolean found = false;
			Suspect foundSuspect = null;
			
			for(Suspect suspect : Suspects) { //anazhthsh upoptou.
				if(searchName.getText().equals(suspect.getName())) {
					found = true;
					foundSuspect = suspect;
				}
					
			}
			
			if(found == false) { //DEN BRETHIKE O UPOPTOS STO REGISTRY. PETA ENHMEROTIKO MHNYMA.
			JOptionPane.showMessageDialog(null, "Suspect " + searchName.getText() + " Not Found");
			}
			else {
				if(e.getSource() == findButton) { //SOSS! AN TO KOUMPI POU PATHTHIKE EINAI TO findButton!!!!
					dispose(); //kleinei to parathiro!
					SuspectPage suspectpage = new SuspectPage(mainRegistry, foundSuspect);
				}
			}
		}
	}
	
	class ButtonListener2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == networkButton) {
				dispose();
				new Suspectsnetwork(mainRegistry);
			}
		}	
	}
}
