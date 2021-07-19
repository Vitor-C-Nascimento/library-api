package com.vitornascimento.libraryapi.api.service;

import com.vitornascimento.libraryapi.api.DTO.BookDTO;
import com.vitornascimento.libraryapi.model.entity.Book;

public interface BookService {
    Book save(Book book);
}
