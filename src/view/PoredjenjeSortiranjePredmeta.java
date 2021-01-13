//#sortiranje_predmeta
//Reference:
//https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html
//https://www.geeksforgeeks.org/pattern-compilestring-method-in-java-with-examples/

package view;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PoredjenjeSortiranjePredmeta implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {

		Pattern pattern = Pattern.compile("[A-Za-z0-9]+"); //formiranje patterna
		
		Matcher m1 = pattern.matcher(s1);
		Matcher m2 = pattern.matcher(s2);
		
		
		if(m1.matches() && m2.matches()) {

			
			StringBuffer karakt1 = new StringBuffer();  
			StringBuffer cifra1 = new StringBuffer();
			StringBuffer ostalo1 = new StringBuffer(); 
			
			
			StringBuffer karakt2 = new StringBuffer();  
			StringBuffer cifra2 = new StringBuffer();
			StringBuffer ostalo2 = new StringBuffer(); 
			          
			        for (int i=0; i<s1.length(); i++) 
			        { 
			            if (Character.isDigit(s1.charAt(i))) 
			                cifra1.append(s1.charAt(i)); 
			            else if(Character.isAlphabetic(s1.charAt(i))) 
			                karakt1.append(s1.charAt(i)); 
			            else
			                ostalo1.append(s1.charAt(i)); 
			        } 
			
			
			        for (int i=0; i<s2.length(); i++) 
			        { 
			            if (Character.isDigit(s2.charAt(i))) 
			                cifra2.append(s2.charAt(i)); 
			            else if(Character.isAlphabetic(s2.charAt(i))) 
			                karakt2.append(s2.charAt(i)); 
			            else
			                ostalo2.append(s2.charAt(i)); 
			        } 
			
			        
			String slova1 = karakt1.toString();
			String slova2 = karakt2.toString();
			
			String brojevi1 = cifra1.toString();
			String brojevi2 = cifra1.toString();
			
		
			if(!slova1.equals(slova2)) {
				return slova1.compareTo(slova2);
			}
				return brojevi1.compareTo(brojevi2);
	


		}else{
			return s1.compareTo(s2);
		}

	}

}
