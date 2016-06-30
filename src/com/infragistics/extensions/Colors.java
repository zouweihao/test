package com.infragistics.extensions;
  
import android.graphics.Color;

public final class Colors {

	public static int Transparent = Color.parseColor("#00000000");
	public static int Black = Color.parseColor("#000000");
	public static int White = Color.parseColor("#ffffff");

	public static int Red = Color.parseColor("#ff0000");
	public static int RedDark = Color.parseColor("#990000");
	public static int RedLight = Color.parseColor("#ff0000");
	
	public static int Blue = Color.parseColor("#0000ff");
	public static int BlueDark = Color.parseColor("#1564b2");
	public static int BlueLight  = Color.parseColor("#1e90ff");
	public static int BlueTransparent = Color.parseColor("#641e90ff");
	
	public static int Green  = Color.parseColor("#008000");
	public static int GreenDark = Color.parseColor("#00b200");
	public static int GreenLight = Color.parseColor("#00e500");
	
	public static int Gray = Color.parseColor("#808080");
	public static int GrayDark = Color.parseColor("#4c4c4c");
	public static int GrayLight = Color.parseColor("#bfbfbf");
	 
	public static int Gold = Color.parseColor("#ffd700");
	public static int GoldDark = Color.parseColor("#998100");
	public static int GoldLight = Color.parseColor("#ffd700");
	
	public static int GetColor(int color, double opacity){
		
		String colorHex = Integer.toHexString(color);  
		int alpha = (int)(opacity * 255);
		colorHex = Integer.toHexString(alpha) + colorHex.substring(2);
		color = (int)Long.parseLong(colorHex, 16);
		   
		return color;
	}
}
