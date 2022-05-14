package mk.ukim.finki.wp.supplement_shop.repository;

import mk.ukim.finki.wp.supplement_shop.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
}
