package com.example.gestionMagasin.Controllers;


import com.example.gestionMagasin.Dtos.PaiementDto;
import com.example.gestionMagasin.Services.PaiementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Paiement")
public class PaiementController {
    private final PaiementService paiementService;

    public PaiementController(PaiementService paiementService) {
        this.paiementService = paiementService;
    }

    @GetMapping("all")
    public List<PaiementDto> all() {
        return paiementService.getAllPaiement();
    }

    @GetMapping("PaiementById/{id}")
    public PaiementDto paiementById(@PathVariable Long id) {
        return paiementService.getPaiementById(id);
    }

    @PostMapping("addPaiement")
    public PaiementDto addPaiement(@RequestBody PaiementDto p) {
        return paiementService.addPaiement(p);
    }

    @PutMapping("update/{id}")
    public PaiementDto updatePaiement(@PathVariable Long id,@RequestBody PaiementDto p) {
        return paiementService.updatePaiement(id,p);
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        return paiementService.deletePaiement(id);
    }
}