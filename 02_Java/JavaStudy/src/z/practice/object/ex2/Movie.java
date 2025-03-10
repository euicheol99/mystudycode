package z.practice.object.ex2;

public class Movie {
	String moviename;
	String actor;
	double Score;
	int year;
	
	
	public Movie(String moviename,String actor) {
		this.moviename=moviename;
		this.actor=actor;
	}
	
	public void scye(double Score,int year) {
		this.Score=Score;
		this.year=year;
	}
	
	public void show() {
		System.out.println("movie name: "+moviename+
							" actor: "+actor+
							" Score: "+Score+
							" year: "+year);
	}
	
	
	
	
}
