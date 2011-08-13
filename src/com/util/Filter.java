package com.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * HTML·ûºÅ¹ýÂËÀà
 * @author Administrator
 *
 */
public final class Filter {

	public Filter(){
		
	}
	public static String escapeHTMLTags( String input ) {

		if( input == null || input.length() == 0 ) {
			return input;
		}
		StringBuffer buf = new StringBuffer();
		char ch = ' ';
		for( int i=0; i<input.length(); i++ ) {
			ch = input.charAt(i);
			if( ch == '<' ) {
				buf.append( "&lt;" );
			}
			else if( ch == '>' ) {
				buf.append( "&gt;" );
			}
			else if(ch=='&'){
				buf.append("&amp;");
			}
			else {
				buf.append( ch );
			}
		}
			return buf.toString();
	}
	
	public static boolean IsYoutubeLinkValidate(String html) {
		html = html.trim();
		  
		if(html.indexOf("iframe")==1){
			return true;
		} else {
			return false;
		}
	}
	
}
