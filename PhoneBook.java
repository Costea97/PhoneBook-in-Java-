
	import java.util.*;
	import java.util.Arrays;

	
	public class PhoneBook {
	    Map<String, List<String>> map = new HashMap<String, List<String>>();
	    private Map<String, List<String>> phoneRecord;

	    public PhoneBook() {
	        phoneRecord = new TreeMap<String, List<String>>();
	    }

	   
	    public Boolean addNameAndNumber(String name, String number) {
	        if (phoneRecord.containsKey(name)) {
	            phoneRecord.get(name).add(number);
	            return true;
	        }
	        List<String> newNumber = new ArrayList<String>();
	        newNumber.add(number);
	        phoneRecord.put(name, newNumber);
	        return true;
	    }

	   
	    public boolean deleteNameAndNumber(String name) {
	        return phoneRecord.remove(name) != null;
	    }


	   
	    public String retrieveNumbersByName(String name) {
	        return join(phoneRecord.get(name));
	    }

	 
	    public String retrieveNameByNumber(String number) {
	        for (String nameKey : phoneRecord.keySet()) {
	            List<String> numForName = phoneRecord.get(nameKey);
	            if(numForName.contains(number)){
	                return nameKey;
	            }
	        }
	        return "";
	    }

	   
	    public String listAllNames() {
	        StringBuilder list = new StringBuilder();
	        Formatter prettyListNames = new Formatter(list);
	        for (String nameKey : phoneRecord.keySet()) {
	            prettyListNames.format("Name: %s%n", nameKey);
	        }
	        return list.toString();
	    }

	 
	    public String listAllNamesAndNumbers() {
	        StringBuilder list = new StringBuilder();
	        Formatter prettyList = new Formatter(list);
	        for (String nameKey : phoneRecord.keySet()) {
	            prettyList.format("Name: %s PhoneNumber: %-10s%n", nameKey, join(phoneRecord.get(nameKey)));
	        }
	        return list.toString();
	    }

	    public static String join(List<String> listNum){

	        if(listNum.size() == 1){
	            return listNum.get(0);
	        }
	        StringBuilder sb = new StringBuilder();
	        for ( int i = 0; i < listNum.size(); i++)
	        {
	            sb.append(listNum.get(i));
	            if (i < listNum.size()-1){
	                sb.append(", ");
	            }
	        }
	        return sb.toString();
	    }

	    public static void main(String[] args) {

	        PhoneBook lancasterPeople = new PhoneBook();
	        lancasterPeople.addNameAndNumber("Mihai", "0765237511");
	        lancasterPeople.addNameAndNumber("George","0723842955");
	        lancasterPeople.addNameAndNumber("Alex",  "0773419675");
	        lancasterPeople.addNameAndNumber("Claudiu","0721555131");
	        lancasterPeople.addNameAndNumber("Cristi","0733890678");
	        lancasterPeople.addNameAndNumber("Marius","0722345229");
	        lancasterPeople.addNameAndNumber("Ana",   "0745896659");


	        String x = lancasterPeople.listAllNamesAndNumbers();
	        System.out.println(x);

	        String y = lancasterPeople.listAllNames();
	        System.out.println(y);


	    }

	}

