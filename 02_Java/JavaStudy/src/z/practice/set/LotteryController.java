package z.practice.set;

import java.util.HashSet;
import java.util.TreeSet;

public class LotteryController {
	private HashSet lottery = new HashSet();
	private HashSet win = new HashSet();
	
	public boolean insertObject(Lottery l) {
		return true;
	}
	
	public boolean deleteObject(Lottery l) {
		return true;
	}
	
	public HashSet winObject() {
		return null;
	}
	
	public TreeSet sortedWinObject() {
		return null;
	}
	
	public boolean searchWinner(Lottery l) {
		return true;
	}
}
