package com.example.onemore.Services;

import com.example.onemore.Repositories.IssuerRepository;
import com.example.onemore.models.issuer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IssuerService {

    private final IssuerRepository issuerRepository;

    @Autowired
    public IssuerService(IssuerRepository issuerRepository) {
        this.issuerRepository = issuerRepository;
    }

    public List<issuer> getAllIssuers() {
        List<issuer> issuers = new ArrayList<>();
        issuerRepository.findAll().forEach(issuers::add);
        return issuers;
    }

    public issuer getIssuer(Integer id) {
        return issuerRepository.findById(id).orElse(null);
    }

    public void addIssuer(issuer issuer) {
        issuerRepository.save(issuer);
    }

    public void updateIssuer(issuer issuer) {
        issuerRepository.save(issuer);
    }

    public void deleteIssuer(Integer id) {
        issuerRepository.deleteById(id);
    }
}
