package com.example.onemore.Services;

import com.example.onemore.Repositories.MediatorRepository;
import com.example.onemore.models.account;
import com.example.onemore.models.issuer;
import com.example.onemore.models.mediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Service
public class MediatorService {
    private final MediatorRepository mediatorRepository;

    @Autowired
    public MediatorService(MediatorRepository mediatorRepository) {
        this.mediatorRepository = mediatorRepository;
    }

    public List<mediator> getAllMediators() {
        List<mediator> mediators = new ArrayList<>();
        mediatorRepository.findAll().forEach(mediators::add);
        return mediators;
    }


    public mediator getMediator(Integer id) {
        return mediatorRepository.findById(id).orElse(null);
    }

    public void addMediator(mediator mediator) {
        mediatorRepository.save(mediator);
    }

    public void updateMediator(mediator mediator) {
        mediatorRepository.save(mediator);
    }

    public void deleteMediator(Integer id) {
        mediatorRepository.deleteById(id);
    }

}
