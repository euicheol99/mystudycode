package z.practice.interface1;

public class V40 extends SmartPhone implements NotePen {

	
	public V40() {
		super();
		super.setMaker("LG");
	}

	@Override
	public String makeCall() {
		// TODO Auto-generated method stub
		return "번호를 누르고 통화버튼을 누름";
	}

	@Override
	public String takeCall() {
		// TODO Auto-generated method stub
		return "수신 버튼을 누름";
	}

	@Override
	public String picture() {
		// TODO Auto-generated method stub
		return "1200,1600만 트리플 카메라";
	}

	@Override
	public String touch() {
		// TODO Auto-generated method stub
		return "정전식";
	}

	@Override
	public boolean bluetoothPen() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String charge() {
		// TODO Auto-generated method stub
		return "고속 충전, 고속 무선 충전";
	}

	public String printInformation() {
		return null;
	}

	

}
