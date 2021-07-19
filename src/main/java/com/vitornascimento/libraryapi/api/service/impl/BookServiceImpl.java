package com.vitornascimento.libraryapi.api.service.impl;

import com.vitornascimento.libraryapi.api.service.BookService;
import com.vitornascimento.libraryapi.exception.BusinessException;
import com.vitornascimento.libraryapi.model.entity.Book;
import com.vitornascimento.libraryapi.model.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository repository;

    public BookServiceImpl(BookRepository repository) {

        this.repository = repository;
    }

    @Override
    public Book save(Book book) {
        if(repository.existsByIsbn(book.getIsbn())){
            throw new BusinessException("Isbn já cadastrado");
        }
        return repository.save(book);
    }
}
