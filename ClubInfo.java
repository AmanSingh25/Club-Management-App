import java.util.Arrays;

public class ClubInfo{
	public static void main(String[] args){
		In file = new In("clubs.csv");
		int n = Integer.parseInt(file.readline());
		Club[] fav = new Club[n];

		for (int i=0; i<n; i++){
			String[] items = line.split(",");
			System.out.println(items[1]);
			int clubId = Integer.parseInt(items[0].trim());
			fav[i] = new Club(clubId, items[1], items[2]);
		}

		System.out.print("ID, Name, Country");
		Arrays.sort(fav);

		for (Club c: fav){
			System.out.println(c);
		}

		In file2 = new In("clubs2.csv");
		int n2 = Integer.parseInt(file.readline());
		ClubWins[] fav2 = new ClubWins[n2];

		for (int i=0; i<n2; i++){
			String[] items = line.split(",");
			System.out.println(items[1]);
			int clubId = Integer.parseInt(items[0].trim());
			int wins = Integer.parseInt(items[3].trim());
			fav2[i] = new ClubWins(clubId, items[1], items[2], wins);
		}

		System.out.print("Id, Name, Country, Wins");
		Arrays.sort(fav2);

		for (ClubWins c: fav2){
			System.out.println(c);
		}

		In file3 = new In("clubs3.csv");
		int n3 = Integer.parseInt(file.readline());
		FirstWin[] fav3 = new FirstWin[n3];

		for (int i=0; i<n3; i++){
			String[] items = line.split(",");
			System.out.println(items[1]);
			int clubId = Integer.parseInt(items[0].trim());
			int year = Integer.parseInt(items[3].trim());
			fav3[i] = new FirstWin(ClubId, items[1], items[2], year);
		}

		System.out.print("ID, Name, Country, FirstWin");
		Arrays.sort(fav3);

		for (FirstWin c: fav3){
			System.out.println(c);
		}

		In file4 = new In("clubs4.csv");
		int n4 = Integer.parseInt(file.readline());
		TotalBudget[] fav4 = new TotalBudget[n4];

		for (int i=0; i<n4; i++){   //Since club array has a length of 4.
			String[] items = line.split(",");
			System.out.println(items[1]);
			int clubId = Integer.parseInt(items[0].trim());
			int wins = Integer.parseInt(items[3].trim());
			int year = Integer.parseInt(items[4].trim());
			fav4[i] = new TotalBudget(clubId, items[1], items[2], wins, budget);
		}

		System.out.print("ClubID, Club Name, Country, Wins , Budget");
		Arrays.sort(fav4);

		for (TotalBudget b: fav4){
			System.out.println(b);
		}
	}
}