
import ru.netology.hm12.NotFoundException;
import ru.netology.hm12.Product;
import ru.netology.hm12.ShopRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopTests {

    ShopRepository shopRepository = new ShopRepository();
    Product product1 = new Product(1, "Молоко", 10);
    Product product2 = new Product(2, "Яйца", 20);
    Product product3 = new Product(3, "Хлеб", 30);
    Product product4 = new Product(4, "Гвозди", 40);

    @BeforeEach
    public void setUp() {
        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);
        shopRepository.add(product4);
    }

    @Test
    public void removeExistingProduct() {
        shopRepository.remove(3);
        Assertions.assertArrayEquals(new Product[]{product1, product2, product4}, shopRepository.findAll());
    }

    @Test
    public void removeNonExistingProduct() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            shopRepository.remove(6);
        });
    }

}