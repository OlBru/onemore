package com.example.onemore.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.onemore.models.holder;
import com.example.onemore.Repositories.HolderRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class HolderService {
    private final HolderRepository holderRepository;

    @Autowired
    public HolderService(HolderRepository holderRepository) {
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
