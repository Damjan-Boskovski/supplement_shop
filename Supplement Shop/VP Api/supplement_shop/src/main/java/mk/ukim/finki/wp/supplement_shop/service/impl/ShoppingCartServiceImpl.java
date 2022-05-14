package mk.ukim.finki.wp.supplement_shop.service.impl;

import mk.ukim.finki.wp.supplement_shop.exception.ProductAlreadyInShoppingCartException;
import mk.ukim.finki.wp.supplement_shop.exception.ProductNotFoundException;
import mk.ukim.finki.wp.supplement_shop.exception.ShoppingCartNotFoundException;
import mk.ukim.finki.wp.supplement_shop.exception.UserNotFoundException;
import mk.ukim.finki.wp.supplement_shop.model.Product;
import mk.ukim.finki.wp.supplement_shop.model.ShoppingCart;
import mk.ukim.finki.wp.supplement_shop.model.User;
import mk.ukim.finki.wp.supplement_shop.model.enumerations.ShoppingCartStatus;
import mk.ukim.finki.wp.supplement_shop.repository.ShoppingCartRepository;
import mk.ukim.finki.wp.supplement_shop.repository.UserRepository;
import mk.ukim.finki.wp.supplement_shop.service.ProductService;
import mk.ukim.finki.wp.supplement_shop.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final UserRepository userRepository;
    private final ProductService productService;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository,
                                   UserRepository userRepository,
                                   ProductService productService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.userRepository = userRepository;
        this.productService = productService;
    }

    @Override
    public List<Product> listAllProductsInShoppingCart(Long cartId) {
        if(this.shoppingCartRepository.findById(cartId).isEmpty())
            throw new ShoppingCartNotFoundException();
        return this.shoppingCartRepository.findById(cartId).get().getProducts();
    }

    @Override
    public ShoppingCart getActiveShoppingCart(String username) {
        User user = this.userRepository.findByEmail(username)
                .orElseThrow(UserNotFoundException::new);

        return this.shoppingCartRepository
                .findByUserAndStatus(user, ShoppingCartStatus.CREATED)
                .orElseGet(() -> {
                    ShoppingCart cart = new ShoppingCart(user);
                    return this.shoppingCartRepository.save(cart);
                });
    }

    @Override
    public ShoppingCart addProductToShoppingCart(String username, Long productId) {
        ShoppingCart shoppingCart = this.getActiveShoppingCart(username);
        Product product = this.productService.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));
        if(shoppingCart.getProducts()
                .stream().filter(i -> i.getId() == productId)
                .collect(Collectors.toList()).size() > 0)
            throw new ProductAlreadyInShoppingCartException();
        shoppingCart.getProducts().add(product);
        return this.shoppingCartRepository.save(shoppingCart);
    }

}
