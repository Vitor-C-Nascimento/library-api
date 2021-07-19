package com.vitornascimento.libraryapi.model.repository;

import com.vitornascimento.libraryapi.model.entity.Book;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DataJpaTest
public class BookRepositoryTest {
    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    BookRepository repository;

    @Test
    @DisplayName("Deve retornar verdadeiro se for buscado um ISBN que existe na base")
    public void shouldReturnTrueIfIsbnExists(){
        //cenario
            String isbn = "123";
            Book book = Book.builder().isbn(isbn).title("As aventuras")
                    .author("Arthur")
                    .build();
            testEntityManager.persist(book);
        //execucao
        boolean exists = repository.existsByIsbn(isbn);

        //verificacao

        assertThat(exists).isTrue();

    }

    @Test
    @DisplayName("Deve retornar falso se for buscado um ISBN que não existe na base")
    public void shouldReturnFalseIfIsbnNotExists(){
        //cenario
        String isbn = "123";
        Book book = Book.builder().isbn("345").title("As aventuras")
                .author("Arthur")
                .build();
        testEntityManager.persist(book);
        //execucao
        boolean exists = repository.existsByIsbn(isbn);

        //verificacao

        assertThat(exists).isFalse();

    }
}
