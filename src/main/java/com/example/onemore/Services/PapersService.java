package com.example.onemore.Services;

import com.example.onemore.Repositories.PapersRepository;
import com.example.onemore.models.papers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PapersService {
    private final PapersRepository papersRepository;

    @Autowired
    public PapersService(PapersRepository paperRepository) {
        this.papersRepository = paperRepository;
    }

    public List<papers> getAllPapers() {
        List<papers> papers = new ArrayList<>();
        papersRepository.findAll().forEach(papers::add);
        return papers;
    }

    public papers getPaper(Integer id) {
        return papersRepository.findById(id).orElse(null);
    }

    public void addPaper(papers paper) {
        papersRepository.save(paper);
    }

    public void updatePaper(papers paper) {
        papersRepository.save(paper);
    }

    public void deletePaper(Integer id) {
        papersRepository.deleteById(id);
    }
}
