
package com.proyectoG2.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FirebaseStorageService {

    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    final String BucketName = "jurasicokids.appspot.com";

    final String rutaSuperiorStorage = "jurasicokids";

    final String rutaJsonFile = "firebase";
    
    final String archivoJsonFile = "jurasicokids-firebase-adminsdk-h8vv5-ab05ab3e7c.json";
}
