package com.example.demo.services;

import com.example.demo.entity.Favorite;
import com.example.demo.model.FavoriteModel;

public interface FavoriteService {

	public abstract Favorite transform(FavoriteModel favoriteModel);
	public abstract FavoriteModel transform(Favorite favorite);
	
}
