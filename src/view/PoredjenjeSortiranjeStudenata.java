//#sortiranje_studenata

package view;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PoredjenjeSortiranjeStudenata implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		
		Pattern pattern = Pattern.compile("[A-Z]{2,2}( )[0-9]{1,3}[/][0-9]{4,4}");
		
		Matcher m1 = pattern.matcher(s1);
		Matcher m2 = pattern.matcher(s2);
		
		if (m1.matches() && m2.matches()) {
			
			StringBuffer smer1 = new StringBuffer();
			StringBuffer broj1 = new StringBuffer();
			StringBuffer godina1 = new StringBuffer();
			
			StringBuffer smer2 = new StringBuffer();
			StringBuffer broj2 = new StringBuffer();
			StringBuffer godina2 = new StringBuffer();
			
			for (int i= 0; i<2; i++) {
				
				smer1.append(s1.charAt(i));	//Formiranje smera
				smer2.append(s2.charAt(i));
				
			}
			
			int crtica = 0;	//Indikator da li se posmatra deo pre ili posle crtice "/"
			for (int i = 3; i < s1.length(); i++) {
				
				if (crtica == 0 && Character.isDigit(s1.charAt(i))) {
					broj1.append(s1.charAt(i));
				} else if (crtica != 0 && Character.isDigit(s1.charAt(i))) {
					godina1.append(s1.charAt(i));
				} else crtica++;
			}
			
			crtica = 0;
			for (int i = 3; i < s2.length(); i++) {
				
				if (crtica == 0 && Character.isDigit(s2.charAt(i))) {
					broj2.append(s2.charAt(i));
				} else if (crtica != 0 && Character.isDigit(s2.charAt(i))) {
					godina2.append(s2.charAt(i));
				} else crtica++;
			}
			
			String sSmer1 = smer1.toString();
			String sBroj1 = broj1.toString();
			String sGod1 = godina1.toString();
			
			String sSmer2 = smer2.toString();
			String sBroj2 = broj2.toString();
			String sGod2 = godina2.toString();
			
			
			//System.out.println(sSmer1+sBroj1+"/"+sGod1+"   "+sSmer2+sBroj2+"/"+sGod2);
			
			if (!sSmer1.equals(sSmer2))				//Prioritet: SMER->GODINA->BROJ
				return sSmer1.compareTo(sSmer2);
			else if (!sGod1.equals(sGod2))
				return sGod1.compareTo(sGod2);
			else return sBroj1.compareTo(sBroj2);
			
		} else 
			return s1.compareTo(s2);
	}

}
