package com.example.demo.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Favorite;
import com.example.demo.model.FavoriteModel;
import com.example.demo.services.FavoriteService;

@Service("favoriteService")
public class FavoriteServiceImpl implements FavoriteService {
	
	@Override
	public Favorite transform(FavoriteModel favorite) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(favorite, Favorite.class);
	}

	@Override
	public FavoriteModel transform(Favorite favorite) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(favorite, FavoriteModel.class);
	}

}
