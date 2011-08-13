package com.models;

import java.util.*;

import com.entities.*;

public interface ListBaseModel<T> {
	
	public List<T> findAll();
}