package homework.buy.service;

import homework.buy.exceptions.NotEnoughMoneyException;
import homework.buy.model.Person;
import homework.buy.model.Shop;
import homework.buy.repository.PersonRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private PersonRepo personRepo;
    private Shop shop;


    private void delMoneyFromPersonAccount(double cost, Long personId) throws NotEnoughMoneyException {
        Person person = personRepo.getReferenceById(personId);
        if (cost <= person.getAccount()) {
            person.setAccount(person.getAccount() - cost);
            personRepo.save(person);
        } else {
            throw new NotEnoughMoneyException();
        }
    }

    private void addMoneyToShopAccount(double cost) {
        shop.setAccount(shop.getAccount() + cost);
    }

    @Transactional
    public void buyProductTransaction(double cost, Long personId) throws NotEnoughMoneyException {
        delMoneyFromPersonAccount(cost, personId);
        addMoneyToShopAccount(cost);
    }
}
