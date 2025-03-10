package z.practice.collection.ex1;

public class Music {
	private String title;
	private String singer;
	
	public Music() {
		super();
	}

	public Music(String title, String singer) {
		super();
		this.title = title;
		this.singer = singer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	@Override
	public String toString() {
		return singer+"-"+title;
	}
	
	public int hashCode() {
		return 0;
	}
	
	//클래스에서 equals를 오버라이딩 하지 않으면 기본 Object의 equals를 따른다(참조비교)
	//실제 해당 클래스의 객체 비교시 기준을 가지고 오버라이딩 해줘야 컬렉션과 같은 곳에서
	//적절하게 사용된다.
	public boolean equals(Object obj) {
		return true;
	}
	
	public int compareTo(Object o) {
		return 0;
	}
	
	
}
