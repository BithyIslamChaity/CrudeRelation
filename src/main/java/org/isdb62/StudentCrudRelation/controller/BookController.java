package org.isdb62.StudentCrudRelation.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.isdb62.StudentCrudRelation.model.Book;
import org.isdb62.StudentCrudRelation.service.BookService;
import org.isdb62.dto.BookDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/book")
public class BookController {
    public final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @PostMapping
    public ResponseEntity<?> saveBook(@RequestBody BookDTO bookDTO) {
        Book saved = bookService.saveBook(bookDTO);
        return new ResponseEntity<>(bookDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBook() {
        List<Book> books = bookService.getAllBook();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
@PutMapping("/{id}")
public ResponseEntity<?> updateBook(@PathVariable Integer id, @RequestBody Book book) {
    Book updated = bookService.updateBook(id, book);
    return new ResponseEntity<>(updated, HttpStatus.OK);
}
@GetMapping("/{id}")
public ResponseEntity<?> getBook(@PathVariable Integer id) {
    Book book = bookService.getBook(id);
    return new ResponseEntity<>(book, HttpStatus.OK);
}
}

