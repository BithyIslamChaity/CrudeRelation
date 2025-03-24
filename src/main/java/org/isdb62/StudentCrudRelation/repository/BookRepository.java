package org.isdb62.StudentCrudRelation.repository;

import org.isdb62.StudentCrudRelation.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository <Book, Integer> {
    
}
