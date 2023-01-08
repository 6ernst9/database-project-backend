package com.example.project.service;

import com.example.project.dao.ContractJRepository;
import com.example.project.model.Contract_j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;
import java.util.Optional;

@Service
public class ContractJService {
    private final ContractJRepository contractJRepository;
    private final PersoanaService persoanaService;
    @Autowired
    public ContractJService(ContractJRepository contractJRepository, PersoanaService persoanaService) {
        this.contractJRepository = contractJRepository;
        this.persoanaService = persoanaService;
    }
    public Contract_j findById(Long id){
        Optional<Contract_j> contract_j = contractJRepository.findById(id);
        if(contract_j.isPresent()){
            return contract_j.get();
        }
        else{
            throw new IllegalStateException("contract not found");
        }
    }
    public List<Contract_j> findContractsBetweenDateAmount(int firstAmount, int secondAmount, int month, int year){
        LocalDate startDate = Year.of(year).atMonth(month).atDay(1);
        LocalDate endDate = Year.of(year).atMonth(month).atEndOfMonth();
        return contractJRepository.findByDateRangeAndOnorarRange(startDate, endDate, firstAmount, secondAmount);
    }
    public Optional<List<Contract_j>> findNotPaid(){
        Optional<List<Contract_j>> notPaidContracts = contractJRepository.findByNotPaid();
        return notPaidContracts;
    }
    public List<Object[]> findPairByAvocat(){
        return contractJRepository.findPairContractsByAvocatId();
    }
    public void addContract(LocalDate data, String obiect, Long onorar, int nrPagini, Long idClient, Long idAvocat){
        Contract_j contract_j = new Contract_j(data, obiect, onorar, nrPagini,   persoanaService.findById(idClient), persoanaService.findById(idAvocat));
        contractJRepository.save(contract_j);
    }
    public List<Contract_j> getAllContracte(){
        return contractJRepository.findAll();
    }
}
