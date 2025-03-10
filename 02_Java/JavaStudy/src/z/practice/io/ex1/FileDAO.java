package z.practice.io.ex1;

import java.io.File;

public class FileDAO {
	public boolean checkName(String file) {
		
		return new File(file).exists() ;
	}
	
	public void fileSave(String file,String s) {
		int count=0;
		File f1 = new File("file");
	}
	
	public StringBuilder fileOpen(String file) {
		return null;
	}
	
	public void fileEdit(String file,String s) {
		
	}
}
