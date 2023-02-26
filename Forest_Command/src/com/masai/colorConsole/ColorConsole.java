package com.masai.colorConsole;

public class ColorConsole {
	
	static final String GREEN ="\u001B[32m";	
	public static final String bold = "\u001b[1m";
	public static final String reset = "\u001B[0m";
    public static final String italic = "\u001b[3m";
    public static final String black = "\u001b[30m";
    public static final String bgBrightWhite = "\u001b[47;1m";
    public static final String blue = "\u001b[34m";	
    public static final String underline = "\u001b[4m";
    public static final String yellow = "\u001b[33m";
	
    
    public static void style() {
    	System.out.println(underline+bgBrightWhite+bold+black+"");
	}
    
    public static void reset() {
    	System.out.println(reset+GREEN+bold+"");
    }
    
	public static void welcome() {
		System.out.println(yellow+"");
	}
	
	public static void exitColor() {
		System.out.println(reset+italic+blue);
	}
	
	public static void listPreview() {
		System.out.println(bgBrightWhite+bold+black);
	}
	

}
