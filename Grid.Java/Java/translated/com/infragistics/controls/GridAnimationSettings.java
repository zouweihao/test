//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/

package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;

/**
*   Represents the animation settings for a grid.
*/
public class GridAnimationSettings {

	private GridAnimationSettingsImplementation __GridAnimationSettingsImplementation;
	GridAnimationSettingsImplementation getImplementation() { return __GridAnimationSettingsImplementation; }
	public GridAnimationSettings() {
		this(new GridAnimationSettingsImplementation());
	}
	GridAnimationSettings(GridAnimationSettingsImplementation GridAnimationSettingsImpl) {
		__GridAnimationSettingsImplementation = GridAnimationSettingsImpl;
	}

	private GridAnimationPhaseSettings getExternalSettings(final GridAnimationPhaseSettingsImplementation impl) {
		if (impl == null) {
			return null;
		}
		GridAnimationPhaseSettings ext = (GridAnimationPhaseSettings) impl.getExternalObject();
		if (ext == null) {
			ext = new GridAnimationPhaseSettings(impl);
            impl.setExternalObject(ext);
		}

		return ext;
	}

	/**
	* Gets the animation settings used for the main phase of row selection
	*/
	public GridAnimationPhaseSettings getRowSelectionMainPhase() {
		return getExternalSettings(__GridAnimationSettingsImplementation.getRowSelectionMainPhase());
    }

	/**
	* Sets the animation settings used for the main phase of row selection
	*/
    public void setRowSelectionMainPhase(GridAnimationPhaseSettings value) {
        if (value == null) {
            __GridAnimationSettingsImplementation.setRowSelectionMainPhase(null);
            return;
        }
        __GridAnimationSettingsImplementation.setRowSelectionMainPhase(value.getImplementation());
    }

	

}
