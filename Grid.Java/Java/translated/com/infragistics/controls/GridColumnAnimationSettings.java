//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/

package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;

/**
*   Represents the Column Animation settings for the grid.
*/
public class GridColumnAnimationSettings {

	private GridColumnAnimationSettingsImplementation __GridColumnAnimationSettingsImplementation;
	GridColumnAnimationSettingsImplementation getImplementation() { return __GridColumnAnimationSettingsImplementation; }
	public GridColumnAnimationSettings() {
		this(new GridColumnAnimationSettingsImplementation());
	}
	GridColumnAnimationSettings(GridColumnAnimationSettingsImplementation GridColumnAnimationSettingsImpl) {
		__GridColumnAnimationSettingsImplementation = GridColumnAnimationSettingsImpl;
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
	* Gets the animation settings used for the main phase of column adding
	*/
	public GridAnimationPhaseSettings getColumnAddingMainPhase() {
		return getExternalSettings(__GridColumnAnimationSettingsImplementation.getColumnAddingMainPhase());
    }

	/**
	* Sets the animation settings used for the main phase of column adding
	*/
    public void setColumnAddingMainPhase(GridAnimationPhaseSettings value) {
        if (value == null) {
            __GridColumnAnimationSettingsImplementation.setColumnAddingMainPhase(null);
            return;
        }
        __GridColumnAnimationSettingsImplementation.setColumnAddingMainPhase(value.getImplementation());
    }

	/**
	* Gets the animation settings used for the pre phase of column adding
	*/
    public GridAnimationPhaseSettings getColumnAddingPrePhase() {
        return getExternalSettings(__GridColumnAnimationSettingsImplementation.getColumnAddingPrePhase());
    }

	/**
	* Sets the animation settings used for the pre phase of column adding
	*/
    public void setColumnAddingPrePhase(GridAnimationPhaseSettings value) {
        if (value == null) {
            __GridColumnAnimationSettingsImplementation.setColumnAddingPrePhase(null);
            return;
        }
        __GridColumnAnimationSettingsImplementation.setColumnAddingPrePhase(value.getImplementation());
    }

	/**
	* Gets the animation settings used for the main phase of column showing
	*/
    public GridAnimationPhaseSettings getColumnShowingMainPhase() {
        return getExternalSettings(__GridColumnAnimationSettingsImplementation.getColumnShowingMainPhase());
    }

	/**
	* Sets the animation settings used for the main phase of column showing
	*/
    public void setColumnShowingMainPhase(GridAnimationPhaseSettings value) {
        if (value == null) {
            __GridColumnAnimationSettingsImplementation.setColumnShowingMainPhase(null);
            return;
        }
        __GridColumnAnimationSettingsImplementation.setColumnShowingMainPhase(value.getImplementation());
    }

	/**
	* Gets the animation settings used for the pre phase of column showing
	*/
    public GridAnimationPhaseSettings getColumnShowingPrePhase() {
        return getExternalSettings(__GridColumnAnimationSettingsImplementation.getColumnShowingPrePhase());
    }

	/**
	* Sets the animation settings used for the pre phase of column showing
	*/
    public void setColumnShowingPrePhase(GridAnimationPhaseSettings value) {
        if (value == null) {
            __GridColumnAnimationSettingsImplementation.setColumnShowingPrePhase(null);
            return;
        }
        __GridColumnAnimationSettingsImplementation.setColumnShowingPrePhase(value.getImplementation());
    }

	/**
	* Gets the animation settings used for the main phase of column hiding
	*/
    public GridAnimationPhaseSettings getColumnHidingMainPhase() {
        return getExternalSettings(__GridColumnAnimationSettingsImplementation.getColumnHidingMainPhase());
    }
    
	/**
	* Sets the animation settings used for the main phase of column hiding
	*/
	public void setColumnHidingMainPhase(GridAnimationPhaseSettings value) {
        if (value == null) {
            __GridColumnAnimationSettingsImplementation.setColumnHidingMainPhase(null);
            return;
        }
        __GridColumnAnimationSettingsImplementation.setColumnHidingMainPhase(value.getImplementation());
    }

	/**
	* Gets the animation settings used for the post phase of column hiding
	*/
    public GridAnimationPhaseSettings getColumnHidingPostPhase() {
        return getExternalSettings(__GridColumnAnimationSettingsImplementation.getColumnHidingPostPhase());
    }

	/**
	* Sets the animation settings used for the post phase of column hiding
	*/
    public void setColumnHidingPostPhase(GridAnimationPhaseSettings value) {
        if (value == null) {
            __GridColumnAnimationSettingsImplementation.setColumnHidingPostPhase(null);
            return;
        }
        __GridColumnAnimationSettingsImplementation.setColumnHidingPostPhase(value.getImplementation());
    }

	/**
	* Gets the animation settings used for the pre phase of column moving
	*/
	public GridAnimationPhaseSettings getColumnMovingPrePhase() {
        return getExternalSettings(__GridColumnAnimationSettingsImplementation.getColumnMovingPrePhase());
    }

	/**
	* Gets the animation settings used for the main phase of column moving
	*/
    public GridAnimationPhaseSettings getColumnMovingMainPhase() {
        return getExternalSettings(__GridColumnAnimationSettingsImplementation.getColumnMovingMainPhase());
    }
    
	/**
	* Sets the animation settings used for the pre phase of column moving
	*/
    public void setColumnMovingPrePhase(GridAnimationPhaseSettings value) {
        if (value == null) {
            __GridColumnAnimationSettingsImplementation.setColumnMovingPrePhase(null);
            return;
        }
        __GridColumnAnimationSettingsImplementation.setColumnMovingPrePhase(value.getImplementation());
    }
    
	/**
	* Sets the animation settings used for the main phase of column moving
	*/
    public void setColumnMovingMainPhase(GridAnimationPhaseSettings value) {
        if (value == null) {
            __GridColumnAnimationSettingsImplementation.setColumnMovingMainPhase(null);
            return;
        }
        __GridColumnAnimationSettingsImplementation.setColumnMovingMainPhase(value.getImplementation());
    }
	
	/**
	* Gets the animation settings used for the main phase of column exchanging
	*/
    public GridAnimationPhaseSettings getColumnExchangingMainPhase() {
        return getExternalSettings(__GridColumnAnimationSettingsImplementation.getColumnExchangingMainPhase());
    }

	/**
	* Gets the animation settings used for the clean up phase of column exchanging
	*/
    public GridAnimationPhaseSettings getColumnExchangingCleanupPhase() {
        return getExternalSettings(__GridColumnAnimationSettingsImplementation.getColumnExchangingCleanupPhase());
    }

	/**
	* Sets the animation settings used for the main phase of column exchanging
	*/
    public void setColumnExchangingMainPhase(GridAnimationPhaseSettings value) {
        if (value == null) {
            __GridColumnAnimationSettingsImplementation.setColumnExchangingMainPhase(null);
            return;
        }
        __GridColumnAnimationSettingsImplementation.setColumnExchangingMainPhase(value.getImplementation());
    }

	/**
	* Sets the animation settings used for the clean up phase of column exchanging
	*/
    public void setColumnExchangingCleanupPhase(GridAnimationPhaseSettings value) {
        if (value == null) {
            __GridColumnAnimationSettingsImplementation.setColumnExchangingCleanupPhase(null);
            return;
        }
        __GridColumnAnimationSettingsImplementation.setColumnExchangingCleanupPhase(value.getImplementation());
    }

	/**
	* Gets the animation settings used for the main phase of column property updating
	*/
    public GridAnimationPhaseSettings getColumnPropertyUpdatingMainPhase() {
        return getExternalSettings(__GridColumnAnimationSettingsImplementation.getColumnPropertyUpdatingMainPhase());
    }

	/**
	* Sets the animation settings used for the main phase of column property updating
	*/
    public void setColumnPropertyUpdatingMainPhase(GridAnimationPhaseSettings value) {
        if (value == null) {
            __GridColumnAnimationSettingsImplementation.setColumnPropertyUpdatingMainPhase(null);
            return;
        }
        __GridColumnAnimationSettingsImplementation.setColumnPropertyUpdatingMainPhase(value.getImplementation());
    }



}
