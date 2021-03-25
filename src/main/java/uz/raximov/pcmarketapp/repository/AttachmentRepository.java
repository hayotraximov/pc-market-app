package uz.raximov.pcmarketapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.raximov.pcmarketapp.entity.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {
}
