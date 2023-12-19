package com.example.backend.api.controllers;

import com.example.backend.api.services.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ImageController {

    private final ImageService imageService;
    private static final String CREATE_IMAGE = "/image";
    private static final String GET_IMAGE_NAME = "/{name}";
    private static final String EDIT_IMAGE_ID = "/edit/image/id"; //URL не працює
    private static final String DELETE_IMAGE_ID = "/delete/image/{id}";

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping(CREATE_IMAGE)
    public ResponseEntity<?> create(@RequestParam MultipartFile image) throws IOException {
        String uploadImage = imageService.uploadImage(image);

        return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
    }

    @GetMapping(GET_IMAGE_NAME)
    public ResponseEntity<?> downloadImage(@PathVariable String name){
        byte[] imageData = imageService.downloadImage(name);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }

    @PutMapping
    public ResponseEntity<?> editImage(@RequestParam MultipartFile image, @PathVariable String name){
        return null; //розробляється
    }

    @DeleteMapping(DELETE_IMAGE_ID)
    public void deleteIdImage(@PathVariable Long id){
        imageService.deleteIdImage(id);
    }
}
