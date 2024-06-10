package homework.reserve.controller;

import homework.reserve.exceptions.NotEnoughQuantityException;
import homework.reserve.model.Product;
import homework.reserve.service.ReserveService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReserveController {

    private ReserveService service;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }
    @PostMapping("/add")
    public void addProduct(@RequestBody Product product){
        service.addProduct(product);
    }

    @PutMapping("/reserve/{id}")
    public List<Product> productReserve(@PathVariable Long id, @RequestParam int quantity) throws NotEnoughQuantityException {
        service.addToReserveStore(id, quantity);
        return service.getAllProducts();
    }
}
