import java.util.Comparator;
public class Club implements Comparable<Club>{
	//instance variables
	private int clubId;
	private String name;
	private String country;

	public static final Comparator<Club> NAME = new NameComparator();
	public static final Comparator<Club> COUNTRY = new CountryComparator();


	public Club(int clubId, String name, String country){
		this.clubId = clubId;
		this.name = name;
		this.country = country;
		
	}

	public String toString(){
		return clubId + " Club: " + name + "representing " + country ;
	}

	public int compareTo(Club other){
		return this.clubId - other.clubId;
	}



	static class NameComparator implements Comparator<Club>{
		public int compare(Club firstClub, Club secondClub){
			return (firstClub.name).compareTo(secondClub.name);
	   }
    }

   static class CountryComparator implements Comparator<Club>{
	    public int compare(Club firstClub, Club secondClub){
			return (firstClub.country).compareTo(secondClub.country);
		}
	}



class ClubWins extends Club{
	private int wins;

	public ClubWins(int clubId, String name, String country, int wins){
		super(clubId, name, country);
		this.wins = wins;
	}	

	public String toString(){
		return "Total wins for this club is " + wins;
	}

	public int compareTo(ClubWins other){
		return this.wins - other.wins;
	}

	public String getClubWins(){
	 return wins + "";
}

class FirstWin extends Club {
	private int year;

	public FirstWin(int clubId, String name, String country, int wins, int year){
		super(clubId, name, country);
		this.year = year;
	}

	public String toString(){
		return "First win for this Club was in" + year;
	}

	public int compareTo(FirstWin other){
		return this.year - other.year;
	}

	public String getFirstWin(){
	 return year + "";
	}
}

	class TotalBudget extends FirstWin {
	private int budget;

    public TotalBudget(int clubId, String name, String country, int wins, int year, int budget){
      super(clubId, name, country, wins, year);
      this.budget = budget;
    }

    public String toString(){
      return "This club has a budget of" + budget;
    }

    public int compareTo(TotalBudget other){
      return this.budget - other.budget;
    }

    public String TotalBudget(){
	  return budget + "";
	}

  }	


	}

  public int getclubId(){
	 return clubId;
	}

    public String getname(){
	 return name;
	}

	public String getcountry(){
		return country;
	}


    public String getPhoto(){
	   return name + ".jpg";
	}

}