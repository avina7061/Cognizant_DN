package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.service.BookService;

public class LibraryManagementApplication {

    public static void main(String[] args) {

        // Load Spring IoC Container
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get Bean
        BookService bookService =
                context.getBean("bookService", BookService.class);

        // Test Dependency Injection
        bookService.addBook();

        // Close context
        ((ClassPathXmlApplicationContext) context).close();
    }
}