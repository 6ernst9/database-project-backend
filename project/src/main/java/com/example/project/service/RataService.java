package com.example.project.service;

import com.example.project.dao.RataRepository;
import com.example.project.model.Contract_j;
import com.example.project.model.Persoana;
import com.example.project.model.Rata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RataService {
    private final RataRepository rataRepository;
    private final ContractJService contractJService;
    @Autowired
    public RataService(RataRepository rataRepository, ContractJService contractJService) {
        this.rataRepository = rataRepository;
        this.contractJService = contractJService;
    }
    public void addRata(Long idCj, LocalDate data, Long suma){
        Contract_j contract_j = contractJService.findById(idCj);
        Long idR = getLastById(idCj);
        idR++;
        rataRepository.save(new Rata(contract_j, idR, data, suma));
    }
    public Long getLastById(Long id){
        Optional<Long> last = rataRepository.getLastById(id);
        return last.orElse(0l);
    }
    public List<Rata> getAllRate(){
        return rataRepository.findAll();
    }
}
