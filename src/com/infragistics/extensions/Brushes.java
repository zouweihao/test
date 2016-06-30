package com.infragistics.extensions;

import com.infragistics.graphics.SolidColorBrush;
import android.graphics.Color;

public class Brushes {

	public static SolidColorBrush Transparent = GetBrush(Colors.Transparent);
	public static SolidColorBrush Black = GetBrush(Colors.Black);
	public static SolidColorBrush White = GetBrush(Colors.White);

	public static SolidColorBrush Red = GetBrush(Colors.Red);
	public static SolidColorBrush RedDark = GetBrush(Colors.RedDark);
	public static SolidColorBrush RedLight = GetBrush(Colors.RedLight);
	
	public static SolidColorBrush Blue = GetBrush(Colors.Blue);
	public static SolidColorBrush BlueDark = GetBrush(Colors.BlueDark);
	public static SolidColorBrush BlueLight = GetBrush(Colors.BlueLight);
	public static SolidColorBrush BlueTransparent = GetBrush(Colors.BlueTransparent);
	
	public static SolidColorBrush Green  = GetBrush(Colors.Green);
	public static SolidColorBrush GreenDark = GetBrush(Colors.GreenDark);
	public static SolidColorBrush GreenLight  = GetBrush(Colors.GreenLight);
		
	public static SolidColorBrush Gray = GetBrush(Colors.Gray);
	public static SolidColorBrush GrayDark = GetBrush(Colors.GrayDark);
	public static SolidColorBrush GrayLight = GetBrush(Colors.GrayLight);
	 
	public static SolidColorBrush Gold = GetBrush(Colors.Gold);
	public static SolidColorBrush GoldDark = GetBrush(Colors.GoldDark);
	public static SolidColorBrush GoldLight = GetBrush(Colors.GoldLight);
	
	public static SolidColorBrush GetBrush(int color){
		SolidColorBrush brush = new SolidColorBrush();
		brush.setColor(color);
		
		return brush;
	}
	public static SolidColorBrush GetBrush(int color, double opacity){
		
		color = Colors.GetColor(color, opacity);
		 
		SolidColorBrush brush = new SolidColorBrush();
		brush.setColor(color);
		
		return brush;
	}
	 
	public static SolidColorBrush GetBrush(String colorHex){
		return GetBrush(Color.parseColor(colorHex));
	}
	
	
	
}
