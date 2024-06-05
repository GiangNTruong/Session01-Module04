package ra.crudemployee.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadFile {
    String uploadToLocal(MultipartFile image);
    String uploadToFirebase(String filePath);
}
