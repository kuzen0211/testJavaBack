package com.example.backend.api.services;

import com.example.backend.api.factory.ImageFileFactory;
import com.example.backend.api.services.impl.ImageFileServiceImpl;
import com.example.backend.api.utils.ImageUtl;
import com.example.backend.store.models.ImageFile;
import com.example.backend.store.repository.ImageFileRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageService implements ImageFileServiceImpl {

    private final ImageFileRepository imageFileRepository;
    private final ImageFileFactory imageFileFactory;

    public ImageService(ImageFileRepository imageFileRepository,
                        ImageFileFactory imageFileFactory) {
        this.imageFileRepository = imageFileRepository;
        this.imageFileFactory = imageFileFactory;
    }

    @Override
    public String uploadImage(MultipartFile image) throws IOException {
        ImageFile file = new ImageFile();

        file.setName(image.getOriginalFilename());
        file.setType(image.getContentType());
        file.setImage(ImageUtl.compressImage(image.getBytes()));

        imageFileFactory.makeImageFile(imageFileRepository.save(file));

        return "Фотограція успішно, добавлена!  : " + image.getOriginalFilename();

    }

    @Override
    @Transactional
    public byte[] downloadImage(String name) {
        Optional<ImageFile> dbImageData = imageFileRepository.findByName(name);
        return ImageUtl.decompressImage(dbImageData.get().getImage());
    }

    @Override
    public byte[] editLoadImage(MultipartFile image, String name) {

        return new byte[0];
    }

    @Override
    public void deleteIdImage(Long id) {
        imageFileRepository.deleteById(id);
    }
}