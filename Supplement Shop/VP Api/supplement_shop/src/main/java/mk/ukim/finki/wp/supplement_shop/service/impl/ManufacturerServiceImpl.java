package mk.ukim.finki.wp.supplement_shop.service.impl;

import mk.ukim.finki.wp.supplement_shop.exception.ManufacturerNotFoundException;
import mk.ukim.finki.wp.supplement_shop.model.Manufacturer;
import mk.ukim.finki.wp.supplement_shop.repository.ManufacturerRepository;
import mk.ukim.finki.wp.supplement_shop.service.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Manufacturer> findAll() {
        return manufacturerRepository.findAll();
    }

    @Override
    public Optional<Manufacturer> findById(long id) {
        return manufacturerRepository.findById(id);
    }

    @Override
    public Optional<Manufacturer> save(Manufacturer manufacturer) {
        return Optional.of(manufacturerRepository.save(manufacturer));
    }

    @Override
    public Optional<Manufacturer> edit(long id, Manufacturer manufacturerDetails) {
        Manufacturer manufacturerToEdit = manufacturerRepository.findById(id)
                .orElseThrow(() -> new ManufacturerNotFoundException(id));

        manufacturerToEdit.setName(manufacturerDetails.getName());
        manufacturerToEdit.setCountry(manufacturerDetails.getCountry());
        return Optional.of(manufacturerRepository.save(manufacturerToEdit));
    }

    @Override
    public void deleteById(long id) {
        manufacturerRepository.deleteById(id);
    }
}
