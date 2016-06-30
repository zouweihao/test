//Copyright (c) 2013-2015 Infragistics Inc.
 //http://www.infragistics.com/
package com.infragistics.controls;
import com.infragistics.*;
import com.infragistics.controls.*;
class RecyclingManager {
private Dictionary__2<String, Stack__1<CellModel>> _pools;

public RecyclingManager() {



		_pools = new Dictionary__2<String, Stack__1<CellModel>>(new TypeInfo(String.class), new TypeInfo(Stack__1.class, new TypeInfo[] {}));
}


public CellModel dequeue(String id) {
	if (!_pools.containsKey(id)) {
		_pools.add(id, new Stack__1<CellModel>(new TypeInfo(CellModel.class)));
		return null;
	}

	Stack__1<CellModel> pool = _pools.getItem(id);
	if (pool.getCount() > 0) {
		CellModel model = pool.pop();
		if (model.getState() == ModelStates.INVIEW) {
			model.setState(ModelStates.RECYCLED);
		}

		return model;
	}

	return null;
}


public void enqueue(CellModel model) {
	model.setState(ModelStates.RECYCLED);
	if (!_pools.containsKey(model.getStyleKey())) {
		_pools.add(model.getStyleKey(), new Stack__1<CellModel>(new TypeInfo(CellModel.class)));
	}

	_pools.getItem(model.getStyleKey()).push(model);
}

}
