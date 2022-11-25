package com.example.demo.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Storage.Storage;

@Service
public class StorageService implements Storage
{
  private final Path root = Paths.get("src/main/resources/static/assets/musics");

  @Override
  public void init() {
  }

  @Override
  public void save(MultipartFile file) {
  }

  @Override
  public Resource load(String filename) {
    return null;
  }

  @Override
  public void deleteAll() {
  }
  
  @Override
  public Stream<Path> loadAll() {
    return null;
  }

  public void saveByID(MultipartFile file, String fileName) {

    try {
        Files.copy(file.getInputStream(), this.root.resolve(fileName + ".wav"), StandardCopyOption.REPLACE_EXISTING);
    }
    catch (Exception e) {
        throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
    }
  }

  public void deleteByID(String fileName) {
    try {
      FileSystemUtils.deleteRecursively(this.root.resolve(fileName + ".wav"));
    }
    catch (Exception e) {
      throw new RuntimeException("Could not delete the file. Error: " + e.getMessage());
    }
  }

  public String getStaticWavFilePath(String fileName) {
    return "/assets/musics/" + String.valueOf(fileName) + ".wav";
  }

}