package z.practice.io.ex1;

public class FileController {
	private FileDAO fd = new FileDAO();
	
	public boolean checkName(String file) {
		
		return fd.checkName(file);
	}
	
	public void fileSave(String file,StringBuilder sb) {
		String s=sb.toString();
		fd.fileSave(file, s);
	}
	
	public StringBuilder fileOPen(String file) {
		
		return fd.fileOpen(file);
	}
	
	public void fileEdit(String file,StringBuilder sb) {
		
	}
}
