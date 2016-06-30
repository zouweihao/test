package com.infragistics.samplesbrowser;

import android.app.Activity;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class SampleLayout extends FrameLayout
{
	public FrameLayout.LayoutParams sampleLayoutParams;
	
	protected FrameLayout sampleContainer;
	protected LinearLayout sampleOptions;
	protected LinearLayout sampleRoot;
	protected int sampleTransitionInDuration = 1000;
	
	protected static int IdCounter = 0;
	
	protected final Activity context;
		
	public int Id = 0;
	
	public SampleLayout(Activity activity) {
		super(activity);
		
		context = activity;

		sampleLayoutParams = new FrameLayout.LayoutParams(
				FrameLayout.LayoutParams.MATCH_PARENT,
				FrameLayout.LayoutParams.MATCH_PARENT);

		sampleContainer = new FrameLayout(context);
        sampleContainer.setLayoutParams(sampleLayoutParams);
		sampleRoot = new LinearLayout(context);
		sampleOptions = new LinearLayout(context);
		
		sampleRoot.setOrientation(LinearLayout.VERTICAL);
		sampleOptions.setOrientation(LinearLayout.VERTICAL);
		
		sampleRoot.addView(sampleOptions);
		sampleRoot.addView(sampleContainer);
		
		this.addView(sampleRoot);
		
		Id = ++IdCounter;
	 
	}

    protected String getDescription() {
        return "";
    }

	
	public void cleanup() {	
		System.out.println("sample cleanup: " + this.getClass().getName() + "...");
	}
	 
}
