package com.example.project.service;

import ch.qos.logback.core.joran.sanity.Pair;
import com.example.project.dao.ContractMRepository;
import com.example.project.dao.PersoanaRepository;
import com.example.project.model.Contract_m;
import com.example.project.model.Persoana;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContractMService {
    private  final ContractMRepository contractMRepository;
    private final PersoanaService persoanaService;
    @Autowired
    public ContractMService(ContractMRepository contractMRepository, PersoanaService persoanaService) {
        this.contractMRepository = contractMRepository;
        this.persoanaService = persoanaService;
    }
    public List<Contract_m> findByFunctie(String functie){

        return contractMRepository.findByFunctie(functie);
    }
    public List<Object[]> findPairContracts(){
        List<Object[]> pairs = new ArrayList<>();
        List<Contract_m> contract1 = contractMRepository.findPairContracts();
        List<Contract_m> contract2 = new ArrayList<>();

        for (Contract_m contract_m : contract1) {
            List<Contract_m> contractSameComision = contractMRepository.findContractsWithSameComision(contract_m.getComision());
            for (Contract_m contractM : contractSameComision) {
                if (contractM.getIdAngajat().getId_p() != contract_m.getIdAngajat().getId_p() &&
                        contractM.getId_cm() < contract_m.getId_cm()    ) {
                    contract2.add(contractM);
                    Object[] pair = {contract_m, contractM};
                    pairs.add(pair);
                }
            }
        }
        return pairs;
    }
    public void addContract(LocalDate data, String functie, Long salarBaza, Double comision, Long id){
        Persoana persoana = persoanaService.findById(id);
        Contract_m contract_m = new Contract_m(data, functie, salarBaza, comision, persoana);
        contractMRepository.save(contract_m);
    }
    public List<Contract_m> getAllContracte(){
        return contractMRepository.findAll();
    }
}
