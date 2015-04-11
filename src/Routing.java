

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Routing {
	public static int ch, router, i, j, k, w, min, a, lines;
	int count = 1;
	private static int s = 0;
	public String str4="";
	public String arr1="";
	public String arr2="";

	boolean t = true;
	int v = 0;
	int[][] cost_matrix = new int[100][100];
	public static int[][] dist = new int[100][100];
	int[][] cm = new int[100][100];
	int[][] visited = new int[100][100];
	int[][] lastVisited = new int[100][100];
	Scanner in = new Scanner(System.in);
	Scanner inFile;
	public Routing(){

	}
	public boolean input_matrix(){


		File inputFile = new File("topology.txt"); // declare file to read


		lines = 1;
		System.out
		.println("\nPlease input original routing table data file : ");
		try {
			inFile = new Scanner(inputFile);

			String line = ""; // initialize variable to store line read
			// from file

			int numLines = 0; // initialize variable to count # of lines
			// read

			String data = ""; // initialize variable for piece of
			// space-delimited data to extract

			inFile = new Scanner(inputFile); // open the file for
			// reading

			String[] tokens1 = line.split(" ");

			System.out.println("\n\nReview original Topology matrix: ");

			while (inFile.hasNext())

			{

				line = inFile.nextLine();

				numLines++;

				System.out.println(line);

			}

			inFile.close();

			inFile = new Scanner(inputFile); // open the file for
			// reading

			tokens1 = line.split(" ");
			System.out.println();

			System.out.println("Number of routers : " + numLines);
			count = numLines;

			int[][] network = new int[numLines][numLines];

			int u = 0;

			while (inFile.hasNext())

			{

				data = inFile.nextLine();

				for (int p = 0; p < numLines; p++) {

					tokens1 = data.split(" ");

					cm[u][p] = Integer.parseInt(tokens1[p]);

				}

				u++;

			}

			inFile.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		for (i = 0; i < count; i++) {
			for (j = 0; j < count; j++) {
				dist[i][j] = cost_matrix[i][j] = cm[i][j];
				if (dist[i][j] < 0)
					dist[i][j] = cost_matrix[i][j] = 1000;
			}
		}

		// the visited value of router that is being executed is set to
		// 1
		// lastVisited[] holds the state of last visited router
		for (a = 0; a < count; a++) {
			for (v = 0; v < count; v++) {
				visited[a][v] = 0;

				lastVisited[a][v] = a;
			}
		}

		// flooding the router and finding the smallest path using
		// Djikstra's Algorithm
		for (a = 0; a < count; a++) {
			visited[a][a] = 1;
			for (i = 0; i < count; i++) {
				min = 1000;
				for (w = 0; w < count; w++) {
					if (visited[a][w] == 0) {
						if (dist[a][w] < min) {
							v = w;
							min = dist[a][w];
						}
					}
				}
				visited[a][v] = 1;
				for (w = 0; w < count; w++) {
					if (visited[a][w] == 0) {
						if ((min + cost_matrix[v][w]) < dist[a][w]) {
							dist[a][w] = min + cost_matrix[v][w];
							lastVisited[a][w] = v;
						}
					}
				}
			}

		}return true;
	}


	public String print(){
		String str1="";
		// build the routing table for all routers

		// printing routing table for all routers in table

		System.out.print("\n\n The routing table of all routers : \n");

		System.out.print("    " + " |" + "\t");

		//	String str[] = new String[count];

		for (i = 0; i < count; i++) {

			System.out.print("\n");

			if (i >= 10)
				System.out.print("R" + (i + 1) + "  |" + " \t");

			else
				System.out.print("R" + (i + 1) + "   |" + " \t");

			for (j = 0; j < count; j++) {
				if (dist[i][j] == 1000)
					System.out.print("-\t");
				else
					System.out.print(dist[i][j] + "\t");

			}	
		}
		for(i=0;i<count;i++)
		{
			for(j=0;j<count;j++)
			{
				str1+=Integer.toString(dist[i][j])+" ";	
			}str1+="\n";

		}
		//	System.out.println(str1);
		return str1;
	}

	public String connection(int c){

		String str[] = new String[count];
		String str3="";
		while (true) {
			//	System.out.print("\n\n\nPlease select a Source router : ");
			//	router = in.nextInt() - 1;
			router=c-1;
			if (router <= count) {
				System.out
				.print("\n\nThe connection table for router R"
						+ (router + 1) + " : ");
				System.out.println();

				for (int m = 1; m <= count; m++) {
					int src = router;
					int dest = m - 1;

					int arr[] = new int[count];

					int x = 0;

					if (src <= count && dest <= count) {
						if (dist[src][dest] != 1000) {

							arr[x++] = (dest + 1);
							w = dest;
							while (w != src) {

								arr[x] = (lastVisited[src][w] + 1);
								w = lastVisited[src][w];
								x++;

							}

							int counter = 0;
							for (x = 0; x < count; x++) {
								if (arr[x] != 0) {
									counter++;
								}

							}

							if (counter == 1) {
								str[s] = "-";

								s++;
							} else if (counter > 2) {
								str[s] = "R" + arr[1];

								s++;
							} else {
								str[s] = "R" + arr[0];

								s++;
							}
						}

					}

				}

				System.out.println("Destination \t Interface");
				System.out
				.println("====================================");
				for (int ctr = 0; ctr < count; ctr++) {
					str3=str3+"   R" + (ctr + 1) + "\t\t "
							+ str[ctr]+"\n";

					System.out.println("   R" + (ctr + 1) + "\t\t"
							+ str[ctr]);
				}


				break;
			}// end if 


			//	else {
			//	System.out.print("\n\n Enter a valid router no. !!");
			//}


		}
		//System.out.println(str3);
		return str3;

	}

	
	public void optimalpath(int source,int desti){
	while (true) {
		System.out
				.print("\nPlease input the source  router number : ");
		int src = source - 1;
		System.out
				.print("\nPlease input the  destination router number : ");
		int dest = desti - 1;

		if (src <= count && dest <= count) {
			// shortest distance is picked from the matrix and
			// displayed
			// route taken from source to destination with cost
			// matrix is displayed
			if (dist[src][dest] != 1000) {
				System.out.println("\nThe shortest path between R"
						+ (src + 1) + " and R" + (dest + 1)
						+ "  is :  ");

				System.out.print("\n\n R" + (dest + 1));
				arr2+=Integer.toString((dest + 1));
				w = dest;

				while (w != src) {

					System.out.print(" <-- R"
							+ (lastVisited[src][w] + 1));
					arr1+=Integer.toString(lastVisited[src][w] + 1);

					w = lastVisited[src][w];
					
				}
				System.out.println("\n Total cost is  : "
						+ dist[src][dest]);
				str4+=Integer.toString(dist[src][dest]);
			}

			else
				System.out
						.println("There is no path between the source and destination..!!");

			break;
		}

		else {

			if (src > count && dest > count) {
				System.out
						.println("\n Enter valid source and destination router numbers. ");

			}

			else {
				if (src > count)
					System.out.println("\n Enter a valid source ");

				else
					System.out
							.println("\n Enter a valid destination");

			}

		}
	}
}
}




