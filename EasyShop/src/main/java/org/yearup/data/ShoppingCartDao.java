package org.yearup.data;

import org.yearup.models.ShoppingCart;

public interface ShoppingCartDao
{
    ShoppingCart getByUserId(int userId);
    ShoppingCart addProductToCart(int userId, int productId, int quantity);
    void updateCartProduct(int userId, int productId, int quantity); // Will either
    void emptyCart(int userId);
    // add additional method signatures here
}
