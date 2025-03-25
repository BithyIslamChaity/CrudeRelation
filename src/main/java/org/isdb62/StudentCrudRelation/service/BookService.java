package org.isdb62.StudentCrudRelation.service;

import java.lang.foreign.Linker.Option;
import java.util.List;
import java.util.Optional;

import org.isdb62.StudentCrudRelation.model.Book;
import org.isdb62.StudentCrudRelation.model.StudentClass;
import org.isdb62.StudentCrudRelation.repository.BookRepository;
import org.isdb62.dto.BookDTO;
import org.springframework.stereotype.Service;


@Service
public class BookService {

	private final BookRepository bookRepository;
	private final StudentClassService studentClassService;

	public BookService(BookRepository bookRepository, StudentClassService studentClassService) {
		this.bookRepository = bookRepository;
		this.studentClassService = studentClassService;
	}

	public Book saveBook(BookDTO bookDTO) {
		Integer clazzId = bookDTO.getClazzId();
		StudentClass clazz = studentClassService.getStudentClass(clazzId);

		Book book = new Book();
		book.setName(bookDTO.getName());
		book.setAuthor(bookDTO.getAuthor());
		book.setPublisher(bookDTO.getPublisher());

		if (clazz != null) {
			book.setClazz(clazz);
		}
		return bookRepository.save(book);
	}

    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    public Book updateBook(Integer id, Book book) {

		Optional<Book> bookById = bookRepository.findById(id);

		if (bookById.isPresent()) {
			Book aBook = new Book();

			if (book.getName() != null) {
				aBook.setName(book.getName());
			}

			if (book.getAuthor() != null) {
				aBook.setAuthor(book.getAuthor());
			}

			if (book.getPublisher() != null) {
				aBook.setPublisher(book.getPublisher());
			}

			if (book.getClazz() != null) {
				Integer classId = book.getClazz().getId();
				StudentClass clazz = studentClassService.getStudentClass(classId);
				if (clazz == null) {
					throw new IllegalArgumentException("Class not found");
				}
				aBook.setClazz(clazz);

			}
			return bookRepository.save(aBook);

		} else {
			throw new IllegalArgumentException("Book not found");
		}

	}

    public Book getBook(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBook'");
    
    
}

    public void deleteBook(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteBook'");
    }
}
