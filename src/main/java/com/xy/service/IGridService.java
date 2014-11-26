package com.xy.service;

import java.util.List;

import com.xy.model.AdPrProblemstb;

public interface IGridService {

	public List<AdPrProblemstb>  getProblemsList();

	public String getOperList(String start, String limit);
}
