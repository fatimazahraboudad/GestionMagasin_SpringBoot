package com.example.gestionMagasin.Services.service_Imp;

import com.example.gestionMagasin.Dtos.ProduitDto;
import com.example.gestionMagasin.Entities.Produit;
import com.example.gestionMagasin.Mappers.ProduitMapper;
import com.example.gestionMagasin.Repository.ProductRepository;
import com.example.gestionMagasin.Services.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProduitServiceImpl implements ProduitService {

    private final ProductRepository productRepository;

    public ProduitServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProduitDto getProduitById(Long id) {
        Produit produit = productRepository.findById(id).orElseThrow(()-> new RuntimeException("product not found with name "+id));
        return ProduitMapper.mapper.produitToProduitDto(produit);
    }

    @Override
    public Produit getProduitByIdHelper(Long id) {
        Produit produit = productRepository.findById(id).orElseThrow(()-> new RuntimeException("product not found with name "+id));
        return produit;
    }

    @Override
    public List<ProduitDto> getAllProduit() {
        List<Produit> produitList = productRepository.findAll();
        return ProduitMapper.mapper.produitsToproduitDtos(produitList);
    }

    @Override
    public ProduitDto addProduit(ProduitDto produitDto) {
        Produit newProduit = ProduitMapper.mapper.produitDtoToProduit(produitDto);
        Produit produitSaved = productRepository.save(newProduit);
        return ProduitMapper.mapper.produitToProduitDto(produitSaved);
    }

    @Override
    public ProduitDto updateProduit(Long id, ProduitDto produitDto) {
        Produit produitToUpdate = productRepository.findById(id).orElseThrow(()-> new RuntimeException("product not found with name "+id));
        produitToUpdate.setNom(produitDto.getNom());
        produitToUpdate.setPrix(produitDto.getPrix());
        produitToUpdate.setCategory(produitDto.getCategory());
        produitToUpdate.setQuantite(produitToUpdate.getQuantite());
        Produit produitUpdated= productRepository.save(produitToUpdate);
        return ProduitMapper.mapper.produitToProduitDto(produitUpdated);
    }

    @Override
    public String deleteProduit(Long id) {
        Produit produitToDelete = productRepository.findById(id).orElseThrow(()-> new RuntimeException("product not found with name "+id));
        productRepository.delete(produitToDelete);
        return "product deleted succeffully";
    }

    @Override
    public ProduitDto updateProduitQuantite(Long id, int quantite) {
        Produit produitToUpdate = productRepository.findById(id).orElseThrow(()-> new RuntimeException("product not found with name "+id));


        produitToUpdate.setQuantite(produitToUpdate.getQuantite()-quantite);
        Produit produitUpdated= productRepository.save(produitToUpdate);
        return ProduitMapper.mapper.produitToProduitDto(produitUpdated);
    }
}
