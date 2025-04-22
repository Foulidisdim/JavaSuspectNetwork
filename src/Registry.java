import java.util.ArrayList;

public class Registry {
	
	ArrayList<Suspect> Suspects = new ArrayList<>();
	ArrayList<Communication> Communications = new ArrayList<>();
	
	public void addSuspect(Suspect aSuspect) {
		Suspects.add(aSuspect);
	}
	
	public void addCommunication(Communication aCommunication) {
		Communications.add(aCommunication);
		
		String num1 = aCommunication.getNumber1(); 
		String num2 = aCommunication.getNumber2();
		
		Suspect sus1 = null;
		Suspect sus2 = null;
		
		for(Suspect suspect : Suspects) {
			for(String numbers : suspect.getPhoneNumbers()) {
				if(num1.equals(numbers)) //milame gia ton suspect tou protou apo ta 2 noumera.
 					sus1 = suspect; //krata ton upopto 1 (ta stoixeia toy mas niazoun gia na ton epeksergasto kato.)
				if(num2.equals(numbers)) //milame gia ton suspect tou deuterou apo ta 2 noumera.
					sus2 = suspect; //krata ton upopto 2 (ta stoixeia toy mas niazoun gia na ton epeksergasto kato.)
			}
		}
		
		sus1.addPartner(sus2);
		sus2.addPartner(sus1);
	}
	
	public Suspect getSuspectWithMostPartners() {
		
		int max = -1;
		Suspect maxSuspect = null;
		
		for(Suspect suspect : Suspects) { //OS TUPO BAZO SKETO SUSPECT. O X I ArrayList<Suspect>. SOS!!
			if(suspect.getPartners().size() >= max) {
				max = suspect.getPartners().size();
				maxSuspect = suspect;
			}	
		}
		
		return maxSuspect;
	}
	
	public PhoneCall getLongestPhoneCallBetween(String number1, String number2){
		
		int max = -1;
		PhoneCall maxPhoneCall = null; //kano giati an den kano exo compiler error.
		
		for(Communication communication : Communications) {
			
			if(communication.getClass() == PhoneCall.class) { //SOSSS! sto phonecall pou den einai antikeimeno apla bazo.class
			//SOSS! h getClass() epistrefei th klash tou antikeimenou KAI MPORO NA KANO KAI LOGIKH SUGKRISH gia na do an h klsdh tou antikeimenou einai isi me th klash pou thelo.
			//ousiastika checkaro an h epikoinonia einai phonecall.
			
				if(number1.equals(communication.getNumber1()) && number2.equals(communication.getNumber2())) { //h sugkekrimenh klhsh pou theloume
					if(communication.getCallDuration() > max) {
						max = communication.getCallDuration();
						maxPhoneCall = (PhoneCall)communication; //TYPECASTING se PhoneCall. einai to idio me to message sth getMessagesBetween
					}
				}
			}
			
		}
		
		return maxPhoneCall;
	}
	
	public ArrayList<String> getMessagesBetween(String number1, String number2) {
		
		String[] keywords = {"Bomb", "Attack", "Explosives", "Gun"};
		
		ArrayList<String> listOfMessages = new ArrayList<String>();
		for(Communication communication : Communications) {
			
			if(communication.getClass() == SMS.class) { //idia logikh me th pano methodo gia to pos tha paro MONO SMS epikoinonies.
				if(number1.equals(communication.getNumber1()) && number2.equals(communication.getNumber2())) {
					for(String keyword : keywords) {
						if(communication.getSmsContent().contains(keyword)) 
							listOfMessages.add(communication.getSmsContent());	
					}	
				}
			}	
		}
		
		return listOfMessages;
	}
	
	
	public ArrayList<String> getSuspectsFromCountry(String country) {
		
		ArrayList<String> returnList = new ArrayList<>();
		returnList.add("Suspects coming from " + country);
		for(Suspect suspect : Suspects) {
			if(suspect.getOriginCountry().equals(country))
				returnList.add(suspect.getName());
		}
		
		return returnList;
	}
}
