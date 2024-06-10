package homework.reserve.service;

import homework.reserve.exceptions.NotEnoughQuantityException;
import homework.reserve.model.Product;
import homework.reserve.repository.ProductRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReserveService {

    private ProductRepo productRepo;
    private double cost;

    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }
    public void addProduct(Product product){
        productRepo.save(product);
    }

    @Transactional
    public void addToReserveStore(Long id ,int quantity) throws NotEnoughQuantityException {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if(optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.delFromMainStore(quantity);
            product.addToReserveStore(quantity);
            productRepo.save(product);
            cost = product.getPrice()*product.getReserveStore();
        }
    }


}
