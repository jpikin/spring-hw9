package homework.buy.controller;

import homework.buy.exceptions.NotEnoughMoneyException;
import homework.buy.service.PersonService;
import homework.buy.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/buy")
public class TransactionController {
    private TransactionService service;
    private PersonService personService;

    @PostMapping("/buy/{id}/")
    public void transaction(@PathVariable Long id, @RequestBody double cost) throws NotEnoughMoneyException {

        service.buyProductTransaction(cost, id);


    }
}
