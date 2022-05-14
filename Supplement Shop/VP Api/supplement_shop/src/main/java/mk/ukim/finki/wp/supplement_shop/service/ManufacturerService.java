package mk.ukim.finki.wp.supplement_shop.service;

import mk.ukim.finki.wp.supplement_shop.model.Category;
import mk.ukim.finki.wp.supplement_shop.model.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {

    List<Manufacturer> findAll();

    Optional<Manufacturer> findById(long id);

    Optional<Manufacturer> save(Manufacturer manufacturer);

    Optional<Manufacturer> edit(long id, Manufacturer manufacturerDetails);

    void deleteById(long id);

}
