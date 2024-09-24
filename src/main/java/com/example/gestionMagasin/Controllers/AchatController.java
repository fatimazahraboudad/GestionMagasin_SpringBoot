package com.example.gestionMagasin.Controllers;

import com.example.gestionMagasin.Dtos.AchatDto;
import com.example.gestionMagasin.Services.AchatService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Achat")
public class AchatController {

    private final AchatService achatService;

    public AchatController(AchatService achatService) {
        this.achatService = achatService;
    }

    @GetMapping("all")
    private List<AchatDto> all(){
        return achatService.getAllAchat();
    }

    @GetMapping("findById/{id}")
    private AchatDto AchatById(@PathVariable Long id) {
        return achatService.getAchatById(id);
    }

    @PostMapping("addAchat")
    private AchatDto addAchat(@RequestBody AchatDto a) {
        return achatService.addAchat(a);
    }

    @DeleteMapping("delete/{id}")
    private String delete(@PathVariable Long id){
        return achatService.deleteAchat(id);
    }

    @PutMapping("update/{id}")
    private AchatDto update(@PathVariable Long id,@RequestBody AchatDto achat) {
        return achatService.updateAchat(id,achat);
    }


}
