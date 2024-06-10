package homework.buy.controller;

import homework.buy.exceptions.NotEnoughMoneyException;
import homework.buy.service.PersonService;
import homework.buy.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequiredArgsConstructor
public class TransactionController {
    private TransactionService service;
    private PersonService personService;

    @PostMapping("/transaction/{id}/")
    public void transaction(@PathVariable Long id, @RequestBody double cost) throws NotEnoughMoneyException {

        service.buyProductTransaction(cost, id);


    }
}
