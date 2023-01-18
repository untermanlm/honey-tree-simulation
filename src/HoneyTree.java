import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Arrays;
public class HoneyTree{
	//variables and getters/setters
	@SuppressWarnings("serial")
	public static final Map<Integer, ArrayList<String>> groupA = new HashMap<Integer, ArrayList<String>>() {{
		ArrayList<String> forty = new ArrayList<>();
			forty.add("Combee");
		ArrayList<String> twenty = new ArrayList<>();
			twenty.add("Wurmple");
			twenty.add("Burmy");
		ArrayList<String> ten = new ArrayList<>();
			ten.add("Cherubi");
		ArrayList<String> five = new ArrayList<>();
			five.add("Aipom");
			five.add("Aipom");
		put(40, forty);
		put(20, twenty);
		put(10, ten);
		put(5, five);
	}};
	@SuppressWarnings("serial")
	public static final Map<Integer, ArrayList<String>> groupB = new HashMap<Integer, ArrayList<String>>() {{
		ArrayList<String> forty = new ArrayList<>();
			forty.add("Burmy");
		ArrayList<String> twenty = new ArrayList<>();
			twenty.add("Cherubi");
			twenty.add("Combee");
		ArrayList<String> ten = new ArrayList<>();
			ten.add("Aipom");
		ArrayList<String> five = new ArrayList<>();
			five.add("Aipom");
			five.add("Heracross");
		put(40, forty);
		put(20, twenty);
		put(10, ten);
		put(5, five);
	}};		  
    public static final String[] locations = {
    		"Route 205, Floroama Town side",
    		"Route 205, Eterna City side",
    		"Route 206", 
    		"Route 207",
    		"Route 208",
    		"Route 209",
    		"Route 210, Solaceon Town Side",
    		"Route 210, Celestic Town side",
    		"Route 211",
    		"Route 212, Hearthome City side",
    		"Route 212, Pastoria City side",
    		"Route 213",
    		"Route 214",
    		"Route 215",
    		"Route 218",
    		"Route 221",
    		"Route 222",
    		"Valley Windworks",
    		"Eterna Forest",
    		"Fuego Ironworks",
    		"Floaroma Meadow"
    };
    public String lastTreeLocation;
    public ArrayList<String> treeLog;
    public String lastGroup;
    public HoneyTree() {
    	lastTreeLocation = "";
    	treeLog = new ArrayList<>();
    	lastGroup = "";
    }
    public HoneyTree(String lastTreeLocation) throws Exception {
    	addTree(lastTreeLocation);
    }
    public String getLST() {return lastTreeLocation;}
    public void setLST(String lst) {lastTreeLocation = lst;}
    public String getLG() {return lastGroup;}
    public void setLG(String lg) {lastGroup = lg;}
    public String[] getLocations() {return locations;}
    
    //encounter mechanics
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
    		setLG("groupA");
    		return groupA;
    	}
    	else if (rand > 70 && rand <= 90) {
    		setLG("groupB");
    		return groupB;
    	}
    	else {
    		setLG("");
    		return Collections.emptyMap();
    	}
    }
    public ArrayList<String> addTree(String lastTreeLocation) throws Exception{
    	
    	for (String location : locations) {
    		if (lastTreeLocation.equals(location)) {
    			treeLog.add(lastTreeLocation);
    			setLST(lastTreeLocation);
    			return treeLog;
    		}
    	}
    	throw new Exception("You entered an invalid tree location.");
    }
}