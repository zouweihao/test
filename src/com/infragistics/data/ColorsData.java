package com.infragistics.data;

import java.util.ArrayList;

public class ColorsData 
	extends ArrayList<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -193550029189041378L;

	public ColorsData() {
		
		
		String[] myColor = new String[] { "BLACK", "BLUE", "CYAN", "GRAY", "GREEN", 
				 "MAGENTA", "RED", "TRANSPARENT", "WHITE", "YELLOW" };
         for (int i = 0; i < 10; i++) {
	              add(myColor[i]);
            }
	}

}

