package com.example.project.api;

import com.example.project.model.Contract_j;
import com.example.project.request.ContractJRequest;
import com.example.project.service.ContractJService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("contracte_judiciare")
public class ContractJController {
    private final ContractJService contractJService;
    @Autowired
    public ContractJController(ContractJService contractJService) {
        this.contractJService = contractJService;
    }
    @PostMapping
    public void addContract(@RequestBody ContractJRequest contractJRequest){
        contractJService.addContract(contractJRequest.getData(),
                                    contractJRequest.getObiect(),
                                    contractJRequest.getOnorar(),
                                    contractJRequest.getNrPagini(),
                                    contractJRequest.getIdClient(),
                                    contractJRequest.getIdAvocat());
    }
    @GetMapping
    public List<Contract_j> getAllContracte(){
        return contractJService.getAllContracte();
    }
    @GetMapping("filter/date")
    public List<Contract_j> findContractsBetweenDateAmount( @RequestParam(name = "firstAmount", defaultValue = "0") int firstAmount,
                                                            @RequestParam(name = "secondAmount", defaultValue = "10000") int secondAmount,
                                                            @RequestParam(name = "month", defaultValue = "1") int month,
                                                            @RequestParam(name = "year", defaultValue = "2022") int year){
        return contractJService.findContractsBetweenDateAmount(firstAmount, secondAmount, month, year);
    }
    @GetMapping("filter/pairs")
    public List<Object[]> findPairByAvocat(){
        return contractJService.findPairByAvocat();
    }
    @GetMapping("filter/not_paid")
    public Optional<List<Contract_j>> findNotPaid(){
        return contractJService.findNotPaid();
    }
}
