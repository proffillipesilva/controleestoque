package com.fiec.estoqueia.controllers;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;

@RestController
@RequestMapping("/images")
public class ImageController {

    private static final String UPLOAD_DIR = "uploads"; // Directory to store uploaded images
    private static final String THUMBNAIL_DIR = "thumbnails";
    private static final int THUMBNAIL_SIZE = 150; // Thumbnail size (150x150 pixels)

    public ImageController() {
        // Create the upload and thumbnail directories if they don't exist
        createDirectoryIfNotExists(UPLOAD_DIR);
        createDirectoryIfNotExists(THUMBNAIL_DIR);
    }

    private void createDirectoryIfNotExists(String directoryName) {
        File directory = new File(directoryName);
        if (!directory.exists()) {
            if (!directory.mkdirs()) {
                // Handle the error appropriately, e.g., log it and throw an exception
                System.err.println("Failed to create directory: " + directoryName);
                // In a real application, you might want to throw an exception here
                // to prevent the application from starting or to handle the error more gracefully.
                // For example:
                // throw new RuntimeException("Failed to create directory: " + directoryName);
            }
        }
    }



    @GetMapping("/{filename}")
    public ResponseEntity<Resource> getImage(@PathVariable String filename,
                                             @RequestParam(value = "thumbnail", defaultValue = "false") boolean thumbnail) {
        try {
            // Determine the directory based on the 'thumbnail' parameter
            String directory = thumbnail ? THUMBNAIL_DIR : UPLOAD_DIR;
            Path filePath = Paths.get(directory, thumbnail ? "thumb_" + filename : filename);
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists()) {
                // Determine the content type based on the file extension.
                String contentType = Files.probeContentType(filePath);
                if (contentType == null) {
                    contentType = "application/octet-stream"; // Default content type
                }
                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType(contentType))
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}

