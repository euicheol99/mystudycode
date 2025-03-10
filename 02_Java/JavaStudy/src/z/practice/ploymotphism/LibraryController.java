package z.practice.ploymotphism;

public class LibraryController {
	private Member mem=null;
	private Book[] bList=new Book[5];
	
	{
		bList[0] = new CookBook("백종원의 집밥", "백종원", "tvN", true);
		bList[1] = new AniBook("한번 더 해요", "미티", "원모어", 19);
		bList[2] = new AniBook("루피의 원피스", "루피", "japan", 12);
		bList[3] = new CookBook("이혜정의 얼마나 맛있게요", "이혜정", "문학", false);
		bList[4] = new CookBook("최현석 날 따라해봐", "최현석", "소금책", true);
	}	
	public void insertMember(Member mem) {
		this.mem=mem;
	}
	
	public Member myInfo(){
		return mem;
	}
	
	public Book[] selectAll() {
		
		return bList;
	}
	
	//제목에 keyword가 포함된 모든 책 검사
	public Book[] searchBook(String keyword) {
		/*
		 * 문자열에 특정 문자가 포함되어 있는지 검사하는 방법
		 * 문자열.indexOf("찾고자하는 문자열") -> index값 반환 / 못 찾으면 -1 반환
		 * 	int num = "안녕하세요. 최지원입니다. " .indexOf("세요"); -> 3
		 * -> 문자열에서 찾고자하는 문자열이 몇번째 index에 포함되어 있는지 찾고싶을 때 사용
		 * 
		 * 문자열.contains("찾고자하는 문자열") -> 찾고자하는 문자열이 포함되어 있는지
		 * 찾고자하는 뭄ㄴ자열이 포함되어 있다면 true 반환 없다면 false 반환
		 * 
		 * */
		
		Book[] scbook=new Book[bList.length];
		int count=0;
		for(int i=0; i<bList.length; i++) {
			if(bList[i].getTitle().contains(keyword)) {
				scbook[count]=bList[i];
				count++;
			}
		}
		return scbook;
	} 
	
	public int rentBook(int index) {
		int result=0;
		
		if (bList[index] instanceof CookBook &&  ((CookBook) bList[index]).isCoupon()) {
			result=2;
		} 												
		else if (bList[index] instanceof CookBook && !((CookBook) bList[index]).isCoupon()) {
			result=0;
		} 
		else if (bList[index] instanceof AniBook && ((AniBook)bList[index]).getAccessAge()>mem.getAge()) {
			result=1;
		}
		
			return result;
	}
}
