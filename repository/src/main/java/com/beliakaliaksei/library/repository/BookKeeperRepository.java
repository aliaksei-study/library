package com.beliakaliaksei.library.repository;

import com.beliakaliaksei.library.entity.BookKeeper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookKeeperRepository extends JpaRepository<BookKeeper, Long> {
}
