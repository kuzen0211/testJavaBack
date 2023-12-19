package com.example.backend.api.factory;

import com.example.backend.api.DTO.ImageFileDTO;
import com.example.backend.store.models.ImageFile;
import org.springframework.stereotype.Component;

@Component
public class ImageFileFactory {

    public ImageFileDTO makeImageFile (ImageFile imageFile){
        ImageFileDTO imageFileDTO = new ImageFileDTO();

        imageFileDTO.setId(imageFile.getId());
        imageFileDTO.setName(imageFile.getName());
        imageFileDTO.setType(imageFile.getType());
        imageFileDTO.setImage(imageFile.getImage());

        return imageFileDTO;
    }
}
