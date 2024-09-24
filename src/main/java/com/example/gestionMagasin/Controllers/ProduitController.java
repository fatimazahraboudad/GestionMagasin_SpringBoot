package com.example.gestionMagasin.Controllers;


import com.example.gestionMagasin.Dtos.ProduitDto;
import com.example.gestionMagasin.Services.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("Produit")
public class ProduitController {

    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping("all")
    public List<ProduitDto> all(){
        return produitService.getAllProduit();
    }

    @PostMapping("addProduit")
    public ProduitDto addProduit(@RequestBody ProduitDto produitDto){
        return produitService.addProduit(produitDto);
    }

    @GetMapping("findById/{id}")
    public ProduitDto ProduitById(@PathVariable Long id) {
        return produitService.getProduitById(id);
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Long id){
        return produitService.deleteProduit(id);
    }

    @PutMapping("update/{id}")
    public ProduitDto update(@PathVariable Long id,@RequestBody ProduitDto client) {
        return produitService.updateProduit(id,client);
    }

}