package com.example.demo.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.FavoriteList;
import com.example.demo.repository.FavoriteListRepository;

@Service
public class FavoriteListService {
    @Autowired
    private FavoriteListRepository favoriteListRepository;

    public List<FavoriteList> getAllFavoriteItems() {
        return favoriteListRepository.findAll();
    }

    public FavoriteList addFavoriteItem(FavoriteList favoriteList) {
        return favoriteListRepository.save(favoriteList);
    }

    public FavoriteList updateFavoriteItem(Long id, FavoriteList favoriteList) {
        if (favoriteListRepository.existsById(id)) {
            favoriteList.setId(id);
            return favoriteListRepository.save(favoriteList);
        }
        return null; // Handle not found case
    }

    public void deleteFavoriteItem(Long id) {
        favoriteListRepository.deleteById(id);
    }
}

