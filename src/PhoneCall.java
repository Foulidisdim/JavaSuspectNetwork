
public class PhoneCall extends Communication {

	private int callDuration;

	
	public PhoneCall(String number1, String number2, int day, int month, int year, int callLength) {
		super(number1, number2, day, month, year);
		this.callDuration = callLength;
	}

	public int getCallDuration(){ //OVERRIDE to getCallLength tou Communication. AUTO EDO THA TREKSEI, OXI TOU COMMUNICATION!
		return callDuration;
	}
	
	public void printInfo() {
		System.out.println("This phone call has the following info");
		super.printInfo();
		System.out.println("Duration: " + callDuration);
	}

	@Override
	public String getSmsContent() {
		return null;
	}
}