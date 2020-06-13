package com.beliakaliaksei.library.repository;

import com.beliakaliaksei.library.entity.Photo;
import com.beliakaliaksei.library.entity.Reader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {
    Page<Reader> findAll(Pageable pageable);
    List<Reader> findReadersByPhoto(Photo photo);
    List<Reader> findReaderByBookKeeperNull();
}
