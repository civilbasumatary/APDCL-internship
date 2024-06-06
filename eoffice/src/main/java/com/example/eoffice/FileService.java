package com.example.eoffice;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private OfficeRepository officeRepository;

    public FileEntity uploadFile(MultipartFile file, Long officeId) throws IOException {
        Office office = officeRepository.findById(officeId).orElseThrow(() -> new RuntimeException("Office not found"));
        String filePath = saveFile(file);
        FileEntity fileEntity = new FileEntity();
        fileEntity.setName(file.getOriginalFilename());
        fileEntity.setPath(filePath);
        fileEntity.setOffice(office);
        return fileRepository.save(fileEntity);
    }

    private String saveFile(MultipartFile file) throws IOException {
        String directory = "uploads/";
        String filePath = directory + file.getOriginalFilename();
        Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
        return filePath;
    }

    public List<FileEntity> getFilesForOffice(Long officeId) {
        Office office = officeRepository.findById(officeId).orElseThrow(() -> new RuntimeException("Office not found"));
        return fileRepository.findByOffice(office);
    }

    public FileEntity editFile(Long fileId, String newName) {
        FileEntity file = fileRepository.findById(fileId).orElseThrow(() -> new RuntimeException("File not found"));
        file.setName(newName);
        return fileRepository.save(file);
    }
}

