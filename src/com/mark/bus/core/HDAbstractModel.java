package com.mark.bus.core;

import com.android.volley.RequestQueue;
import com.mark.bus.core.util.RequestManager;


public abstract class HDAbstractModel implements Model {
	private int modelId;
	protected Object processResult;
	protected ModelViewController controller;

	protected boolean loading;
	protected RequestQueue requestQueue;

	public HDAbstractModel(int modelId, ModelViewController controller) {
		this.modelId = modelId;
		this.controller = controller;
		this.requestQueue = RequestManager.getRequestQueue();

		initStatus();
	}

	private void initStatus() {
		loading = false;
	}

	@Override
	public void load(LoadType loadType, Object param) {
		if (isLoading()) {
			cancelLoad(true);
		}

		onLoadingStart();
	}

	@Override
	public int getModelId() {
		return modelId;
	}

	@Override
	public Object getProcessData() {
		return processResult;
	}

	@Override
	public boolean isLoading() {
		return loading;
	}

	@Override
	public void cancelLoad(Object tag) {
		requestQueue.cancelAll(tag);
	}

	@Override
	public void onLoadingStart() {
		loading = true;
	}

	@Override
	public void onLoadingEnd() {
		loading = false;
	}

}
