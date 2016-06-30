package com.infragistics.samplesbrowser;

public class SampleInfo {
	public String name;
	public Class<?> seriesClass;
	public SampleType majorType;
	public boolean isSampleGroup;
	
	public SampleInfo(String name, Class<?> seriesClass, SampleType majorType) {
		this.name = name;
		this.seriesClass = seriesClass;
		this.majorType = majorType;
		this.isSampleGroup = false; 
			}
	public SampleInfo(String name) {
		this.name = name;
		this.isSampleGroup = true; 
	}
}

