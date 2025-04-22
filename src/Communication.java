
public abstract class Communication {
	
	private String number1;
	private String number2;
	private int year;
	private int month;
	private int day;
	
	
	public String getNumber1() {
		return number1;
	}


	public String getNumber2() {
		return number2;
	}


	public abstract int getCallDuration(); 
	//Xreiazetai gia th registry pou diaxeirizetai antikeimena communication, parolo pou tha kanei override h sunarthsh tou PhoneCall.
	public abstract String getSmsContent(); 
	//Xreiazontai gia th registry pou diaxeirizetai antikeimena communication, parolo pou tha kanei override h sunarthsh tou SMS.
	
	//SOS! oi getCallLength kai getSmsContent einai abstract methodoi. DEN THA EXOUN TIPOTA MESA STO KURIOS SOMA TOUS. THA KANOUN OVERRIDE OI ANTISTOIXES METHODOI TOU PhoneCall kai tou SMS otan klhthei.
	//PANTOS STH PhoneCall PREPEI NA KANO KAI METHODO getSmsContent POU EPISTREFEI null. GENIKA THA MOU EINAI AXRHSH MESA STO PhoneCall ALLA XORIS AUTH BGAINEI COMPILER ERROR.
	// TO IDIO KAI STHN SMS. PREPEI ena "axrhsto" getCallLength;
	

	public Communication(String number1, String number2, int day, int month, int year) {
		this.number1 = number1;
		this.number2 = number2;
		this.year = year;
		this.month = month;
		this.day = day;
	}



	public void printInfo(){
		System.out.println("Between " + number1 + " --- " + number2 + "\non " + year+"/"+month+"/"+day);	
	}
}
