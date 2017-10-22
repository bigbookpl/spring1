package pl.bigboook.spring1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.bigboook.spring1.bookmarks.Account;
import pl.bigboook.spring1.bookmarks.AccountRepository;
import pl.bigboook.spring1.bookmarks.Bookmark;
import pl.bigboook.spring1.bookmarks.BookmarkRepository;

import java.util.Arrays;

@SpringBootApplication
public class Spring1Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring1Application.class, args);
	}

	@Bean
	CommandLineRunner init(AccountRepository accountRepository, BookmarkRepository bookmarkRepository){
		return (evt) -> Arrays
				.asList("jhoeller,dsyer,pwebb,ogierke,rwinch,mfisher,mpollack,jlong".split(","))
				.forEach(name -> {
					Account account = accountRepository.save(new Account(name, "somepass"));
					bookmarkRepository.save(new Bookmark(account, String.format("smaple://uri/1/%s", name), String.format("Descrption 1: %s", name)));
					bookmarkRepository.save(new Bookmark(account, String.format("smaple://uri/2/%s", name), String.format("Descrption 2: %s", name)));

				});
	}
}
