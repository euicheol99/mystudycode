package z.practice.exception1;

import java.util.Scanner;

public class CharacterController {

	public CharacterController() {
		super();
	}
	
	public int countAlpha(String s) throws CharCheckException{
		int count=0;
		for(char c : s.toCharArray()) {
			 if(c==' ') {
				 System.out.println("체크할 문자열 안에 공백이 포함되어 있습니다.");
			 }
		else if((c>='a' && c<='z')||(c>='A' && c<='Z')) {
				 count++;
			 }	
		}	return count;
	}
}
