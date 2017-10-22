package pl.bigboook.spring1.bookmarks;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> add(@RequestBody Account input){
        accountRepository.save(new Account(input.getPassword(), input.getUsername()));

        return ResponseEntity.accepted().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    Collection<Account> List(){
        List<Account> result = accountRepository.findAll();

        return result;
    }


}

