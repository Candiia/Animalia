package com.candi.animalia.files.service;

import com.candi.animalia.files.model.FileMetadata;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {


    void init();

    //almacenar ficheross
    FileMetadata store(MultipartFile file);

    //cargar ese fichero con su idenfiticador y devuelve como un recurso
    Resource loadAsResource(String filename);

    //borrar un fichero si no quiero tenerlo mas
    void deleteFile(String filename);


}
