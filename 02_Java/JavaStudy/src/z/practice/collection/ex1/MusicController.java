package z.practice.collection.ex1;

import java.util.ArrayList;
import java.util.List;

public class MusicController {
	private List list = new ArrayList();
	
	public int addList(Music music) {
		list.add(music);
		return 1;
	}
	
	public int addAtZero(Music music) {
		list.add(0,music);
		return 1;
	}
	
	public List printAll() {
		return list;
	}
	
	public Music searchMusic(String title) {
		for(Object obj : list) {
			if(((Music)obj).getTitle().equals(title)) {
				return (Music)obj;
			}
		}
		return null;
	}
	
	public Music removeMusic(String title) {
		for(Object obj : list) {
			if(((Music)obj).getTitle().equals(title)) {
				
				return (Music)obj;
			}
		}
//		list.remove(this.searchMusic(title));
		return null;
	}
	
	public Music setMusic(String title,Music music) {
		return null;
	}
	
	public int ascTitle() {
		return 0;
	}
	
	public int descSinger() {
		return 0;
	}
		
	
}
