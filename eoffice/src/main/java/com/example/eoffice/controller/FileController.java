package com.example.controller;

@Controller
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @GetMapping
    public String listFiles(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByUsername(userDetails.getUsername());
        List<FileEntity> files = fileService.getFilesForOffice(user.getOffice().getId());
        model.addAttribute("files", files);
        return "files";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, @AuthenticationPrincipal UserDetails userDetails) throws IOException {
        User user = userRepository.findByUsername(userDetails.getUsername());
        fileService.uploadFile(file, user.getOffice().getId());
        return "redirect:/files";
    }

    @PostMapping("/edit")
    public String editFile(@RequestParam("fileId") Long fileId, @RequestParam("newName") String newName) {
        fileService.editFile(fileId, newName);
        return "redirect:/files";
    }
}

