package uz.raximov.pcmarketapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.raximov.pcmarketapp.entity.District;

@RepositoryRestResource(path = "district")
public interface DistrictRepository extends JpaRepository<District, Integer> {
}
