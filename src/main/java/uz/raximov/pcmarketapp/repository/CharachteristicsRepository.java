package uz.raximov.pcmarketapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.raximov.pcmarketapp.entity.Address;
import uz.raximov.pcmarketapp.entity.Charachteristics;

@RepositoryRestResource(path = "characteristics")
public interface CharachteristicsRepository extends JpaRepository<Charachteristics, Integer> {
}
