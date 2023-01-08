package com.example.project.api;

import ch.qos.logback.core.joran.sanity.Pair;
import com.example.project.request.ContractMRequest;
import com.example.project.model.Contract_m;
import com.example.project.service.ContractMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("contracte_munca")
public class ContractMController {
    private final ContractMService contractMService;
    @Autowired
    public ContractMController(ContractMService contractMService) {
        this.contractMService = contractMService;
    }
    @PostMapping
    public void addContract(@RequestBody ContractMRequest contractMRequest){
        contractMService.addContract(contractMRequest.getData(),
                                    contractMRequest.getFunctie(),
                                    contractMRequest.getSalarBaza(),
                                    contractMRequest.getComision(),
                                    contractMRequest.getIdAngajat());
    }
    @GetMapping
    public List<Contract_m> getAllContracte(){
        return contractMService.getAllContracte();
    }
    @GetMapping("/functie")
    public List<Contract_m> findByFunctie(@RequestParam(name = "functie", defaultValue = "") String functie) {
        return contractMService.findByFunctie(functie);
    }
    @GetMapping("/pairs")
    public List<Object[]> findPairContracts(){
        return contractMService.findPairContracts();
    }
}
