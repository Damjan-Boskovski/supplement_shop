package mk.ukim.finki.wp.supplement_shop.controller;

import mk.ukim.finki.wp.supplement_shop.model.Manufacturer;
import mk.ukim.finki.wp.supplement_shop.service.ManufacturerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/manufacturers")
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @GetMapping
    public List<Manufacturer> getAll() {
        return manufacturerService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Manufacturer> getById(@PathVariable Long id){
        return manufacturerService.findById(id)
                .map(manufacturer -> ResponseEntity.ok().body(manufacturer))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/create")
    public ResponseEntity<Manufacturer> create(@RequestBody Manufacturer manufacturerToCreate){
        return manufacturerService.save(manufacturerToCreate)
                .map(manufacturer -> ResponseEntity.ok().body(manufacturer))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Manufacturer> update(@PathVariable Long id, @RequestBody Manufacturer manufacturerToUpdate) {
        return manufacturerService.edit(id, manufacturerToUpdate)
                .map(manufacturer -> ResponseEntity.ok().body(manufacturer))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        manufacturerService.deleteById(id);
        if (manufacturerService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

}
