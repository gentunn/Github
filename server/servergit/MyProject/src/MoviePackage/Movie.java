package MoviePackage;

public class Movie {
    private String name;
    private String rating;
    private int year;
    private int runtime;
    public Movie() {
		this.name = "";
		this.rating = "";
		this.year = 0;
		this.runtime = 0;
		}
	public Movie(String name, String rating, int year, int runtime) {
		this.name = name;
		this.rating = rating;
		this.year = year;
		this.runtime = runtime;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}
	public String getName() {
		return name;
	}
	public String getRating() {
		return rating;
	}
	public int getYear() {
		return year;
	}
	public int getRuntime() {
		return runtime;
	}

	public String toString() {
		return "Movie [name= " + name + ", rating= " + rating + ", year= " + year + ", runtime= " + runtime + "]";
	}
    
}
