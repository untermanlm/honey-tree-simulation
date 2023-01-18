import java.util.Scanner;

public class RunSim {
    public static void main(String [] args) throws Exception {
    	Scanner s = new Scanner(System.in);
    	HoneyTree ht = new HoneyTree();
		MunchlaxHoneyTree mht = new MunchlaxHoneyTree();
		System.out.println("Type in your trainer ID!");
		int tid = s.nextInt();
		s.nextLine();
    	String[] locations = ht.getLocations();
		String munchTrees = mht.checkMunchlax(tid);
    	System.out.println("Type in your next honey tree location! To stop, type 'N'"
    			+ "\nTo list the available locations, type 'L'");
    	String newLoc = s.nextLine();
    	while (!newLoc.equalsIgnoreCase("N")) {
    		if (newLoc.equalsIgnoreCase("L")){
    			System.out.println("Your available locations are: ");
    			for (String location : locations) {
    				System.out.println(location);
    			}
    		}
			else if (munchTrees.contains(newLoc)){
				System.out.println("Your (munchlaxTree) random encounter is: " + mht.randomEncounter(newLoc));
				System.out.println("Type in your next honey tree location! To stop, type 'N'\nTo list the available locations, type 'L'");
			}
    		else {
    			System.out.println("Your random encounter is: " + ht.randomEncounter(newLoc));
        		System.out.println("Type in your next honey tree location! To stop, type 'N'\nTo list the available locations, type 'L'");
    		}
    		newLoc = s.nextLine();
    	}
		s.close();
    }
}
