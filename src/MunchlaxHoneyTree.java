import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
//I am just commenting on this program because I want to test out my vertical monitor setup ~Hello future me!
public class MunchlaxHoneyTree extends HoneyTree {
	@SuppressWarnings("serial")
	public static final Map<Integer, ArrayList<String>> groupC = new HashMap<Integer, ArrayList<String>>() {{
		ArrayList<String> one = new ArrayList<>();
			one.add("Munchlax");
			put(1, one);
	}};	
	public String checkMunchlax(int trainerID) {
		String munchTrees = "";
		if (trainerID >= 0 && trainerID <= 65535) {
			int a = (int)(Math.floor(trainerID / 256) % 21);
			int b = (int)(Math.floor(trainerID % 256) % 21);
			if (a == b) {
				b = (b+1) % 21;
			}
			System.out.println("Two of your Munchlax trees should be " + locations[a] + " and " + locations[b] + ".");
			munchTrees = locations[a] + ", " + locations[b];
		}
		else System.out.println("Your trainer ID number is out of range!");
		return munchTrees;
	}
    public String randomEncounter(String treeLocation) throws Exception {
    	Map<Integer, ArrayList<String>> encounterMap = groupSelect(treeLocation);
    	if (encounterMap.isEmpty()) return "Encounter missed";
    	int rand = (int)(100*Math.random()+1);
    	Integer[] keys = encounterMap.keySet().toArray(new Integer[0]);
    	Arrays.sort(keys);
    	String [] values = new String[6];
    	int i = 0;
    	for (ArrayList<String> val : encounterMap.values()) {
    		for (String value : val) {
    			values[i] = value;
    			i++;
    		}
    	}
    	if (encounterMap.equals(groupC)) {
    		return values[0];
    	}
    	if (rand >= 1 && rand <= 10) {
    		ArrayList<String> fiveVal = encounterMap.get(keys[0]);
    		int randFive = (int)(1*Math.random()+1);
    		return fiveVal.get(randFive);
    	}
    	else if(rand > 10 && rand <= 20) {
    		ArrayList<String> tenVal = encounterMap.get(keys[1]);
    		return tenVal.get(0);
    	}
    	else if(rand > 20 && rand <= 60) {
    		ArrayList<String> twentyVal = encounterMap.get(keys[2]);
    		int randTwenty = (int)(1*Math.random()+1);
    		return twentyVal.get(randTwenty);
    	}
    	else {
    		ArrayList<String> fortyVal = encounterMap.get(keys[3]);
    		return fortyVal.get(0);
    	}
    }
    public Map<Integer, ArrayList<String>> groupSelect(String treeLocation) throws Exception {
    	if (lastTreeLocation.isEmpty()) {
        	addTree(treeLocation);
        	return groupHelper();
    	}
    	else{
    		if (treeLocation.equals(lastTreeLocation)) {
    			addTree(treeLocation);
    			int rand = (int)(100*Math.random()+1);
    			if (rand <= 90) {
    				if (lastGroup.equals("groupA")) return groupA;
    				else if (lastGroup.equals("groupB")) return groupB;
    				else if (lastGroup.equals("groupC")) return groupC;
    				else return groupA;
    			}
    			else {
    				return groupHelper();
    			}
    		}
    		else {
            	addTree(treeLocation);
            	return groupHelper();
    		}
    	}
    	

    }
    public Map<Integer, ArrayList<String>> groupHelper() {
    	int rand = (int)(100*Math.random()+1);
    	if (rand <= 70) {
    		setLG("groupB");
    		return groupB;
    	}
    	else if (rand > 70 && rand <= 90) {
    		setLG("groupA");
    		return groupA;
    	}
    	else if (rand == 91) {
    		setLG("groupC");
    		return groupC;
    	}
    	else {
    		setLG("");
    		return Collections.emptyMap();
    	}
    }
	public static void main(String [] args) throws Exception {
		MunchlaxHoneyTree mht = new MunchlaxHoneyTree();
		String pokemon = "";
		int count = 0;
		while (true){
			if (pokemon.equals("Munchlax")){
				break;
			}
			pokemon = mht.randomEncounter(locations[count%2]);
			System.out.println(pokemon + "-" + locations[count%2]);
			count++;
		}
		System.out.println(count);

	}
	
}
