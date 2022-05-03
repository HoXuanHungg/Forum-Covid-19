package com.dg3.forum.forum.serviceimpl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dg3.forum.forum.entity.Users;
import com.dg3.forum.forum.repository.UserstRepository;
import com.dg3.forum.forum.util.CSVHelper;

@Service
public class CSVServiceImpl {
  @Autowired
  UserstRepository repository;

  public void save(MultipartFile file) {
    try {
      List<Users> listUsers = CSVHelper.csvToTutorials(file.getInputStream());
      repository.saveAll(listUsers);
    } catch (IOException e) {
      throw new RuntimeException("fail to store csv data: " + e.getMessage());
    }
  }

  public ByteArrayInputStream load() {
    List<Users> listUsers = repository.findAll();
    ByteArrayInputStream in = CSVHelper.tutorialsToCSV(listUsers);
    return in;
  }

  public List<Users> getAllUsers() {
    return repository.findAll();
  }
}

