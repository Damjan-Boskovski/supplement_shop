package mk.ukim.finki.wp.supplement_shop.service;

import mk.ukim.finki.wp.supplement_shop.model.Category;
import mk.ukim.finki.wp.supplement_shop.model.Product;
import mk.ukim.finki.wp.supplement_shop.model.ShoppingCart;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartService {

    List<Product> listAllProductsInShoppingCart(Long cartId);

    ShoppingCart getActiveShoppingCart(String username);

    ShoppingCart addProductToShoppingCart(String username, Long productId);

}
