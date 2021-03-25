package uz.raximov.pcmarketapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.raximov.pcmarketapp.entity.Address;
import uz.raximov.pcmarketapp.entity.Order;

@RepositoryRestResource(path = "order")
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
