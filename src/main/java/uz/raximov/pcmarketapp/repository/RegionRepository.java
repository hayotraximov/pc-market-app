package uz.raximov.pcmarketapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.raximov.pcmarketapp.entity.Region;

@RepositoryRestResource(path = "region")
public interface RegionRepository extends JpaRepository<Region, Integer> {
}
