
public class SMS extends Communication{

	private String smsContent;
	

	public SMS(String number1, String number2, int day, int month, int year, String smsContent) {
		super(number1, number2, day, month, year);
		this.smsContent = smsContent;
	}

	
	public String getSmsContent() {
		return smsContent;
	}


	public void printInfo() {
		System.out.println("This SMS has the following info");
		super.printInfo();
		System.out.println("Text: " + smsContent);
	}


	@Override
	public int getCallDuration() {
		return 0;
	}
}
