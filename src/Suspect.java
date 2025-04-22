import java.util.ArrayList;
import java.util.HashSet;

public class Suspect {

	private String name;
	private String codeName;
	private String originCountry;
	private String crimeCity; //pou drasthriopoieitai
	private ArrayList<String> phoneNumbers = new ArrayList<>(); 
	//TIP: an edina os int ta noumera sth main, DE GRAFO int mesa sta <>. Integer PREPEI!! px kai gia boolean prepei Boolean (to legomeno Wrapper Class)
	private ArrayList<Suspect> Partners = new ArrayList<>(); //lista me sunergates (sunergaths = me opoion suspect exei epikoinonhsei esto 1 fora)

	//constructor
	public Suspect(String name, String codeName, String originCountry, String crimeCity) {
		this.name = name;
		this.codeName = codeName;
		this.originCountry = originCountry;
		this.crimeCity = crimeCity;
	}
	
	
	//getters
	public String getName() {
		return name;
	}

	public String getCodeName() {
		return codeName;
	}

	public String getOriginCountry() {
		return originCountry;
	}
	
	public ArrayList<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public ArrayList<Suspect> getPartners() {
		return Partners;
	}
	
	

	//methodoi
	public void addNumber(String number) {
		phoneNumbers.add(number);
	}

	public boolean isConnectedTo(Suspect aSuspect) {
		
		for(Suspect partner : Partners) {
			if(partner.equals(aSuspect)) {
				return true;
			}
		}
		
		return false; //to else einai
		
	}
	
	public void addPartner(Suspect someSuspect) {
		
		if(!isConnectedTo(someSuspect))  //den einai sthn lista. ton bazo
			Partners.add(someSuspect);			
	}
	
	public ArrayList<Suspect> getCommonPartners(Suspect aSuspect){
		
		ArrayList<Suspect> commonPartners = new ArrayList<>();
		
		for(Suspect partners1 : Partners) {
			for(Suspect partners2 : aSuspect.getPartners()) {
				if(partners1.equals(partners2))
					commonPartners.add(partners1);
			}
		}
		
		return commonPartners;
	}
	
	public void printPartners(ArrayList<Suspect> Partners) {
		for(Suspect partner : Partners) {
			String name = partner.getName();
			String codeName = partner.getCodeName();
			String originCountry = partner.getOriginCountry();
			
			System.out.print(name + " " + codeName);
			if(originCountry == this.originCountry) 
				System.out.println(" *");	
		}
	}
	
	public ArrayList<Suspect> suggestedPartners(){
		HashSet<Suspect> suggestedList = new HashSet<>(); 
		for(Suspect partners : Partners) { //gia kathe sunergath
			for(Suspect suggested : partners.getPartners()) { //psakse sth lista sunergaton tou
				if(!Partners.contains(suggested) && !suggested.equals(this)) { 
				//1h sunthiki: an o sunergaths tou sunergath DEN einai sth lista ton sunergaton tou suspect pou eksetazoume
				//2h sunthiki: agnooume ton suspect pou eksetazoume profanos
				suggestedList.add(suggested); //TO BAZO SE HASHSET GIA NA MHN EXO DIPLOTYPA!!
				}
			}
		}
		ArrayList<Suspect> returnList = new ArrayList<>(suggestedList); 
		//GIA NA KANO COPY ENA HASHSET SE ARRAYLIST TO STELNO KATA TH DIMIOURGIA TOU ARRAYLIST OS ORISMA.
		return returnList;
	}
	
	
	
}