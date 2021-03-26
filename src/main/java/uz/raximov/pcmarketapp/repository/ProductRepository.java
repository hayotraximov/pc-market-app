package uz.raximov.pcmarketapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import uz.raximov.pcmarketapp.entity.Address;
import uz.raximov.pcmarketapp.entity.Product;

import java.util.List;

@RepositoryRestResource(path = "product")
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN','MODERATOR')")
    @Override
    <S extends Product> S save(S s);

    @PreAuthorize(value = "hasRole('SUPER_ADMIN')")
    @Override
    void deleteById(Integer integer);

    @RestResource(path="searchByName", rel="searchByName")
    List<Product> findAllByNameContainsIgnoreCase(@Param("searchByName") String searchByName);

//    @RestResource(path="searchByRam", rel="searchByRam")
//    List<Product> findAllByNameContainsIgnoreCase(@Param("searchByRam") String searchByRam);
}
