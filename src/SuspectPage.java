import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class SuspectPage extends JFrame{
	
	//ftiaxno ta koumpia kai ta text field. auta tha mpoune se ksexorista pane opos fainetai sto paradeigma
	//meta ola ta pane tha mpoun sto idio parathiro.
	
	//bhma 1 DHMIOURGIA UPODOXEA
	private JPanel infoPanel = new JPanel();
	private JPanel SMSFinderPanel = new JPanel();
	private JPanel partnersPanel = new JPanel();
	private JPanel suggestedPartnersPanel = new JPanel();
	private JPanel originCountryPanel = new JPanel();
	private JPanel returnPanel = new JPanel();
	
	private JPanel totalPanel = new JPanel();
	
	
	//bhma 2 DHMIOURGIA GRAFIKON SUSTATIKON
	
	//infopanel
	private JTextField name = new JTextField();
	private JTextField codeName = new JTextField();
	private JTextArea phoneNumbers = new JTextArea();
	
	
	//smsfinder
	private JTextField number = new JTextField("Phone number");
	private JTextArea SMScontents = new JTextArea(10,20);
	private JButton findSMSButton = new JButton("Find SMS");
	
	
	//partners
	private JTextArea partners = new JTextArea(10,20);
	private JLabel partnersLabel = new JLabel("Partners");
	
	//suggested partners
	private JTextArea suggestedPartners = new JTextArea(5,20);
	private JLabel suggestedPartnersLabel = new JLabel("Suggested Partners ----->");
	
	//origin country
	private JTextArea originCountry = new JTextArea(5, 30);
	
	//Return to Search Screen button
	private JButton returnButton = new JButton("Return to Search Screen");
	
			
			
	public Registry mainRegistry;
	public Suspect foundSuspect;
	
	public SuspectPage(Registry aRegistry, Suspect aSuspect){
		mainRegistry = aRegistry;
		foundSuspect = aSuspect;
		
		//BAZO TA BORDERS!!!
		Border lowerEtchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		Border JTextBorder = new JTextField().getBorder();
	
		SMScontents.setBorder(JTextBorder);
		partners.setBorder(JTextBorder);
		suggestedPartners.setBorder(JTextBorder);
		originCountry.setBorder(JTextBorder);
		
		infoPanel.setBorder(lowerEtchedBorder);
		SMSFinderPanel.setBorder(lowerEtchedBorder);
		partnersPanel.setBorder(lowerEtchedBorder);
		suggestedPartnersPanel.setBorder(lowerEtchedBorder);
		originCountryPanel.setBorder(lowerEtchedBorder);
				
				
		//infopanel
		name.setText(aSuspect.getName());
		codeName.setText(aSuspect.getCodeName());
		for(String phonenumbers : aSuspect.getPhoneNumbers()) {
			phoneNumbers.append(phonenumbers + "\n");
		}
		
		//partners
		for(Suspect suspectpartners : aSuspect.getPartners()) {
			partners.append(suspectpartners.getName() + ", " + suspectpartners.getCodeName() + "\n");
		}
		
		//suggested partners
		for(Suspect suggestedpartners : aSuspect.suggestedPartners()){
			suggestedPartners.append(suggestedpartners.getName() + "\n");
		}
		
		//origin country
		for(String suspects : aRegistry.getSuspectsFromCountry(aSuspect.getOriginCountry())) {
			originCountry.append(suspects + "\n");
		}
		
		//bhma 3 PROSTHIKI GRAFIKON SUSTATIKON STA EPIMEROUS PANEL
		infoPanel.add(name);
		infoPanel.add(codeName);
		infoPanel.add(phoneNumbers);
		
		SMSFinderPanel.add(number);
		SMSFinderPanel.add(SMScontents);
		SMSFinderPanel.add(findSMSButton);
		
		partnersPanel.add(partnersLabel);
		partnersPanel.add(partners);
		
		suggestedPartnersPanel.add(suggestedPartnersLabel);
		suggestedPartnersPanel.add(suggestedPartners);
		
		originCountryPanel.add(originCountry);
		
		returnPanel.add(returnButton);
		
		
		
		//PROSTHIKI TON EPIMEROUS PANEL SE ENA TELIKO PANEL
		totalPanel.add(infoPanel);
		totalPanel.add(SMSFinderPanel);
		totalPanel.add(partnersPanel);
		totalPanel.add(suggestedPartnersPanel);
		totalPanel.add(originCountryPanel);
		totalPanel.add(returnPanel);
			
		
		//bhma 4 PROSTHIKI TOU TELIKOU PANEL STO PARATHIRO POU THA EMFANISTEI.
		totalPanel.setLayout(new FlowLayout()); //Diataksh ton panel pano sto parathiro. koutakia, to ena kato apo to allo prepei.
		this.setContentPane(totalPanel);

		
		//bhma 3 xeirismou akroath sumbanton: KATASKEUH AKROATON
		ButtonListener smsListener = new ButtonListener();
		ButtonListener2 returnToSearchListener = new ButtonListener2();
		//bhma 4 xeirismou akroath sumbanton: SUNDESH AKROATON ME PHGH SYMBANTON.
		findSMSButton.addActionListener(smsListener);
		returnButton.addActionListener(returnToSearchListener);
		//oi klaseis buttonlistener kato kathorizoun ti kanoun ta koumpia.
		
		
		setVisible(true); //kathista to parathiro orato.
		setSize(500, 750);
		setTitle("Suspect Page"); //titlos parathirou.
		setLocationRelativeTo(null); // GIA NA EMFANIZETAI STO KENTRO TO PARATHIRO
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	//bhma 1 xeirismou sumbanton: DHMIOURGIA KLASEON AKROATON ("AUTIOU")
	class ButtonListener implements ActionListener{
	
		@Override
		public void actionPerformed(ActionEvent e) {
			
			//bhma 2 xeirismou sumbanton: SUGGRAFH EKTELOUMENOU KODIKA. BHMATA 3 KAI 4 PANO STO CONSTRUCTOR SuspectPage.
			if(e.getSource() == findSMSButton) {
				for(String suspectnumbers : foundSuspect.getPhoneNumbers()) {
					for(String messages : mainRegistry.getMessagesBetween(suspectnumbers, number.getText())) {
						SMScontents.append(messages + "\n"); //bazei ola ta zhtoumena sms metaksi ton arithmon tou suspect kai tou arithmou pou tou edosa mesa sto textarea.
					}	
				}
			}	
		}	
	}
	
	class ButtonListener2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//bhma 2 xeirismou sumbanton: SUGGRAFH EKTELOUMENOU KODIKA. BHMATA 3 KAI 4 PANO STO CONSTRUCTOR SuspectPage.
			if(e.getSource() == returnButton) { //SOSS! AN TO KOUMPI POU PATHTHIKE EINAI TO Return to Search Screen!!!!
				dispose(); //kleinei to parathiro!
				new FindSuspect(mainRegistry);
			}	
		}
	}
	
	
	
	
	
	
}