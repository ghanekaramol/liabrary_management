package com.library.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.model.Book;
import com.library.ResponseClass.BookResponse;
import com.library.dto.BookDTO;
import com.library.exception.BookDeleteException;
import com.library.exception.BookIssueException;
import com.library.exception.BookRemoveIssueException;
import com.library.exception.DataNotFoundException;
import com.library.model.User;
import com.library.repository.BookRepository;
import com.library.repository.CategoryRepository;
import com.library.repository.UserRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	//adding a book
	public void addBook(BookDTO bookRequest)
	{
		String bookRequestName = bookRequest.getBookName();
		Integer requestCategoryId = bookRequest.getCategoryId();
		Book book = new Book();
		book.setBookName(bookRequestName);
		book.setCategory(categoryRepository.findById(requestCategoryId).get());
		bookRepository.save(book);
	}
	
	//fetching a single book
	public BookResponse getBook(Integer bookId)
	{
		Book book = bookRepository.findById(bookId).get();
		
		if(bookRepository.findById(bookId).isEmpty())
		{
			throw new DataNotFoundException();
		}
		
		BookResponse bookRes = new BookResponse();
		bookRes.setBookName(book.getBookName());
		bookRes.setCategoryName(book.getCategory().getCategoryName());
		bookRes.setIssueStatus(book.getIssueStatus());
		
		return bookRes;
	}
	
	//fetching all books
	public List<BookResponse> getAllBook()
	{
		List<Book> bookList = bookRepository.findAll();
		if(bookList.isEmpty())
		{
			throw new DataNotFoundException();
		}	
		
		List<BookResponse> bookResList = new  ArrayList<BookResponse>();
		bookList.forEach(
				
				(n) -> {
					BookResponse bookRes = new BookResponse();
					bookRes.setBookName(n.getBookName());
					bookRes.setCategoryName(n.getCategory().getCategoryName());
					bookRes.setIssueStatus(n.getIssueStatus());
					bookResList.add(bookRes);
					
				});
		return bookResList;	
	}
	
	//delete a book
	public void deleteBook(Integer bookId)
	{
		if(bookRepository.findById(bookId).get().getIssueStatus()!=null) {
			throw new BookDeleteException();
		}
		bookRepository.deleteById(bookId);
	}
	
	//update the book
	public Book updateBook(Book book)
	{
		Book bookObj = bookRepository.findById(book.getBookId()).get();
		
		if(bookRepository.findById(book.getBookId()).isEmpty()) {
			throw new DataNotFoundException();
		}
		bookObj.setBookName(book.getBookName());
		book.setCategory(bookObj.getCategory());
		return bookRepository.save(bookObj);	
	}
	
	//issue a book
	public Book issueBook(BookDTO bookDto) throws Exception
	{
			
		Book book = bookRepository.findById(bookDto.getBookId()).get();
		
		if(book.getIssueStatus()!=null)
			{
				throw new BookIssueException();
			}
		User user = userRepository.findById(bookDto.getUserId()).get();
		book.setIssueStatus("Issued");
		book.setUser(user);
		return bookRepository.save(book);
		}
		
			
	
	public Book removeIssuedBook(Integer bookId)
	{	
		Book book = bookRepository.findById(bookId).get();
		if(book.getIssueStatus() == null)
		{
			throw new BookRemoveIssueException();
		}
			book.setIssueStatus(null);
			book.setUser(null);
			return bookRepository.save(book);		
	}

	//list of issued book
	public List<BookResponse> listOfIssueBook() throws Exception
	{
		
		List<Book> book = bookRepository.findAllIssuedBook();
		if(book.isEmpty()) {
			throw new DataNotFoundException();
		}
		List<BookResponse> bookResList = new ArrayList<>();
		book.forEach(
				
				(n) ->
				{
					BookResponse bookRes = new BookResponse();
					bookRes.setBookName(n.getBookName());
					bookRes.setCategoryName(n.getCategory().getCategoryName());
					bookRes.setIssueStatus(n.getIssueStatus());
					bookResList.add(bookRes);			
				}
				
				);
		
		return bookResList;
		
	}

}