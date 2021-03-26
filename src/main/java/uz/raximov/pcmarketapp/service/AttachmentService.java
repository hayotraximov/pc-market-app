package uz.raximov.pcmarketapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.raximov.pcmarketapp.entity.Attachment;
import uz.raximov.pcmarketapp.entity.AttachmentContent;
import uz.raximov.pcmarketapp.repository.AttachmentContentRepository;
import uz.raximov.pcmarketapp.repository.AttachmentRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.Optional;

@Service
public class AttachmentService {
    @Autowired
    AttachmentRepository attachmentRepository;

    @Autowired
    AttachmentContentRepository attachmentContentRepository;

    //bitta attachmentni qaytarish
    public void getById(Integer id, HttpServletResponse response) throws IOException {
        Optional<Attachment> byId = attachmentRepository.findById(id);
        if (byId.isPresent()){
            Attachment attachment = byId.get();
            Optional<AttachmentContent> byAttachmentId = attachmentContentRepository.findByAttachmentId(attachment.getId());
            if (byAttachmentId.isPresent()){
                AttachmentContent attachment_content = byAttachmentId.get();

                response.setHeader("Content-Disposition", "attachment; filename=\""+attachment.getName()+"\"");
                response.setContentType(attachment.getContentType());
                FileCopyUtils.copy(attachment_content.getBytes(), response.getOutputStream());
            }
        }
    }

    //o'chirish
    public void deleteById(Integer id){
        Optional<Attachment> attachmentOptional = attachmentRepository.findById(id);
        if (attachmentOptional.isPresent()) {
            Attachment attachment = attachmentOptional.get();
            Optional<AttachmentContent> byAttachmentId = attachmentContentRepository.findByAttachmentId(attachment.getId());
            byAttachmentId.ifPresent(attachmentContent -> attachmentContentRepository.delete(attachmentContent));
            attachmentRepository.delete(attachment);
        }
    }

    public Attachment add(MultipartHttpServletRequest request) throws IOException {
        Iterator<String> fileNames = request.getFileNames();
        while (fileNames.hasNext()){
            MultipartFile file = request.getFile(fileNames.next());
            if (file != null){
                Attachment attachment = new Attachment();
                attachment.setName(file.getOriginalFilename());
                attachment.setSize(file.getSize());
                attachment.setContentType(file.getContentType());
                Attachment savedAttachment = attachmentRepository.save(attachment);

                AttachmentContent attachment_content = new AttachmentContent();
                attachment_content.setAttachment(savedAttachment);
                attachment_content.setBytes(file.getBytes());
                attachmentContentRepository.save(attachment_content);
                //return "Fayl saqlandi IDSI: " + savedAttachment.getId();
                return savedAttachment;
            }
        }
        return new Attachment();
    }
}
