package uz.raximov.pcmarketapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.raximov.pcmarketapp.entity.Address;

@RepositoryRestResource(path = "address")
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
