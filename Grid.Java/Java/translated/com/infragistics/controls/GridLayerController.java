//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;

class GridLayerController {
RecyclingManager _recyclingManager = new RecyclingManager();


public boolean containsPath(CellPath path, VisualModel model) {
	for (int l = 0; l < model.getGridLayers().getCount(); l++) {
		if (model.getGridLayers().inner[l].containsKey(path)) {
			return true;
		}

	}

	return false;
}


public void ensureModelReady(CellPath path, GridImplementation grid, VisualModel visualModel, GridLayer desiredLayer, ModelTypes modelType) {
	if (!this.containsPath(path, visualModel)) {
		CellModel model = null;
		Object resolvedValue = null;
		boolean isPlaceholder = false;
		if (path.getIsContentCell()) {
			ColumnImplementation col = grid.getContainingColumn(path);
			resolvedValue = grid.getAdapter().resolveValue(path, col.getKey());
			if (resolvedValue == null && grid.getAdapter().isPlaceholderValue(path, col.getKey())) {
				isPlaceholder = true;
			}

		}

		String resolvedStyleKey = grid.getStyleKey(path, grid, resolvedValue);
		model = _recyclingManager.dequeue(resolvedStyleKey);
		if (model == null) {
			model = grid.createModel(path, resolvedStyleKey);

		} else {
			model.reset();
		}

		if (visualModel.getHiddenLayer().containsKey(path)) {
			visualModel.getHiddenLayer().getItem(path).remove(model);
			if (visualModel.getHiddenLayer().getItem(path).getCount() == 0) {
				visualModel.getHiddenLayer().remove(path);
			}

		}

		desiredLayer.add(path, model);
		model.setCurrentLayer(desiredLayer);
		model.setPath(path);
		model.setModelType(modelType);
		grid.onModelRejoined(model, resolvedValue);
		if (isPlaceholder) {
			model.setVirtualizationPercentage(1d);
		}


	} else {
		CellModel existingModel = getModel(path, visualModel);
		moveToLayer(path, visualModel, desiredLayer);
		existingModel.setModelType(modelType);
	}

}


private GridLayer getLayer(CellPath path, VisualModel model) {
	for (int l = 0; l < model.getGridLayers().getCount(); l++) {
		if (model.getGridLayers().inner[l].containsKey(path)) {
			return model.getGridLayers().inner[l];
		}

	}

	return null;
}


private void moveToLayer(CellPath path, VisualModel visualModel, GridLayer desiredLayer) {
	GridLayer currentLayer = getLayer(path, visualModel);
	if (currentLayer == null || currentLayer == desiredLayer) {
		return;
	}

	CellModel model = currentLayer.getItem(path);
	currentLayer.remove(path);
	desiredLayer.add(path, model);
	model.setCurrentLayer(desiredLayer);
}


private void moveToHiddenLayer(CellPath path, VisualModel visualModel) {
	GridLayer currentLayer = getLayer(path, visualModel);
	if (currentLayer == null) {
		return;
	}

	CellModel model = currentLayer.getItem(path);
	currentLayer.remove(path);
	List__1<CellModel> models = null;
	if (visualModel.getHiddenLayer().containsKey(path)) {
		models = visualModel.getHiddenLayer().getItem(path);

	} else {
		models = new List__1<CellModel>(new TypeInfo(CellModel.class));
		visualModel.getHiddenLayer().add(path, models);
	}

	models.add(model);
}


public void removeModel(CellPath path, VisualModel visualModel) {
	GridLayer currLayer = getLayer(path, visualModel);
	if (currLayer == null) {
		return;
	}

	CellModel model = getModel(path, visualModel);
	moveToHiddenLayer(path, visualModel);
	_recyclingManager.enqueue(model);
}


public CellModel getModel(CellPath path, VisualModel model) {
	for (int l = 0; l < model.getGridLayers().getCount(); l++) {
		if (model.getGridLayers().inner[l].containsKey(path)) {
			return model.getGridLayers().inner[l].getItem(path);
		}

	}

	return null;
}


public void positionModel(CellModel model, VisualModel visualModel, double left, double top, double width, double height) {
	model.setX((int)java.lang.Math.round(left + model.getLeftOffset() + (model.getLeftPercentOffset() * model.getWidth())));
	model.setY((int)java.lang.Math.round(top + model.getTopOffset() + (model.getTopPercentOffset() * model.getHeight())));
	model.setWidth((int)width);
	model.setHeight((int)height);
}

}
