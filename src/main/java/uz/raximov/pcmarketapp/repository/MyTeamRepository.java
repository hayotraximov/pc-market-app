package uz.raximov.pcmarketapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import uz.raximov.pcmarketapp.entity.Address;
import uz.raximov.pcmarketapp.entity.MyTeam;

@RepositoryRestResource(path = "myteam")
public interface MyTeamRepository extends JpaRepository<MyTeam, Integer> {
//    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN','MODERATOR')")
//    @Override
//    <S extends MyTeam> S save(S s);
//
//    @PreAuthorize(value = "hasRole('SUPER_ADMIN')")
//    @Override
//    void deleteById(Integer integer);
}
