package labs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.*;


public class HTMLval {
	
	public static void validHTML(String s) throws IOException {
		BufferedReader sc= new BufferedReader(new FileReader(s));
		HTMLstack<Character> HTMLval = new HTMLstack<>();
		String st;
		Pattern pattern = Pattern.compile("head");
		int okay =0;
		int linenumber=0;
		
		while((st=sc.readLine()) != null) {
			linenumber++;
			//System.out.println(st);
			Matcher matcher = pattern.matcher(st);
            if (matcher.find()) {   
            	int n = matcher.start();
            	int m =matcher.end();
            	if(okay>0) {
            		if((st.charAt(n-2))=='<' && st.charAt(n-1)=='/') {
                		if(st.charAt(m)=='>') {
                			//opening head tag is okay
                			okay++;
                		}
                		else {
                			//opening head tag is not okay
                			System.out.println("The closing tag is not closed properly in line numnber: "+linenumber);
                		}
                	}else {
                		System.out.println("The closing tag is not closed properly!!"+ linenumber);
            		}
            	}

            	if((st.charAt(n-1))=='<') {
            		if(st.charAt(m)=='>') {
            			//opening head tag is okay
            			okay++;
            		}
            		else {
            			//opening head tag is not okay
            			System.out.println("Head opening tag is not closed properly");
            		}
            	} 
            }     
	  
            else {
				for(int i=0; i<st.length(); i++) {
					char c = st.charAt(i);
					if(c=='<') {
						//if(Pattern.matches(s, ss))
						HTMLval.push(c);
					}
					else if(c=='<') {
						if(!HTMLval.isEmpty() && HTMLval.peek()=='<' ) {
						HTMLval.pop();
						}
						else {
							System.out.println("The invalid order");
						}
					}
				}
			}
		}
	}
			
			
	public static void main (String args []) throws IOException {
		validHTML("C:\\Code\\html.txt");
	}

}
