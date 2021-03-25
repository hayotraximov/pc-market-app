package uz.raximov.pcmarketapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.raximov.pcmarketapp.entity.AttachmentContent;

import java.util.Optional;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, Integer> {
    Optional<AttachmentContent> findByAttachmentId(Integer id);
}
