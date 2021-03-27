package uz.raximov.pcmarketapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

    @RestResource(path="searchByCharacteristics", rel="searchByCharacteristics")
    @Query(value = "select * from product p where p.id in (select product_id from charachteristics c where c.type =:type  and c.size =:size )",nativeQuery = true)
    List<Product> searchByCharacteristics(@Param("type") String type, @Param("size") Integer size);

    @RestResource(path="searchByGraphicCard", rel="searchByGraphicCard")
    @Query(value = "select * from product p where p.id in (select product_id from charachteristics c where c.type =:type  and c.name =:name )",nativeQuery = true)
    List<Product> searchByGraphicCard(@Param("type") String type, @Param("name") String name);

    @RestResource(path="searchByModel", rel="searchByModel")
    @Query(value = "select * from product p where p.model=:name",nativeQuery = true)
    List<Product> searchByModel(@Param("name") String name);

    @RestResource(path="searchByPrice", rel="searchByPrice")
    @Query(value = "select * from product p where p.price >:min and p.price<:max",nativeQuery = true)
    List<Product> searchByPrice(@Param("min") Integer min, @Param("max") Integer max);

}
