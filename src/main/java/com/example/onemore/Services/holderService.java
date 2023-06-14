package com.example.onemore.Services;

import com.example.onemore.models.account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.onemore.models.holder;
import com.example.onemore.Repositories.holderRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class holderService {
    private final holderRepository holderRepository;

    @Autowired
    public holderService(holderRepository holderRepository) {
        this.holderRepository = holderRepository;
    }

    public List<holder> getAllHolders() {
        List<holder> holders = new ArrayList<>();
        holderRepository.findAll().forEach(holders::add);
        return holders;
    }

    public holder getHolder(Integer id) {
        return holderRepository.findById(id).orElse(null);
    }

    public void addHolder(holder holder) {
        holderRepository.save(holder);
    }

    public void updateHolder(holder holder) {
        holderRepository.save(holder);
    }

    public void deleteHolder(Integer id) {
        holderRepository.deleteById(id);
    }
}
