package com.example.onemore.Services;

import com.example.onemore.Repositories.BuysellRepository;
import com.example.onemore.models.buysell;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuysellService {
    private final BuysellRepository buysellRepository;

    @Autowired
    public BuysellService(BuysellRepository buysellRepository) {
        this.buysellRepository = buysellRepository;
    }

    public List<buysell> getAllBuysell() {
        List<buysell> buysellList = new ArrayList<>();
        buysellRepository.findAll().forEach(buysellList::add);
        return buysellList;
    }

    public buysell getBuysell(Integer id) {
        return buysellRepository.findById(id).orElse(null);
    }

    public void addBuysell(buysell buysell) {
        buysellRepository.save(buysell);
    }

    public void updateBuysell(buysell buysell) {
        buysellRepository.save(buysell);
    }

    public void deleteBuysell(Integer id) {
        buysellRepository.deleteById(id);
    }
}
