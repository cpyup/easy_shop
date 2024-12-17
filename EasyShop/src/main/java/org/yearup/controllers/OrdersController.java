package org.yearup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.yearup.data.*;
import org.yearup.models.*;

import java.math.BigDecimal;
import java.security.Principal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/orders")
@PreAuthorize("isAuthenticated()")
public class OrdersController {
    private final OrderLineItemDao orderLineItemDao;
    private final ShoppingCartDao shoppingCartDao;
    private final UserDao userDao;
    private final ProfileDao profileDao;
    private final OrderDao orderDao;

    @Autowired
    public OrdersController(OrderLineItemDao orderLineItemDao, ShoppingCartDao shoppingCartDao, UserDao userDao, ProfileDao profileDao, OrderDao orderDao) {
        this.orderLineItemDao = orderLineItemDao;
        this.shoppingCartDao = shoppingCartDao;
        this.userDao = userDao;
        this.profileDao = profileDao;
        this.orderDao = orderDao;
    }

    @PostMapping
    public Order createOrder(Principal principal){
        try {
            String userName = principal.getName();
            User user = userDao.getByUserName(userName);
            if (user == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.");
            }

            Profile currentProfile = profileDao.getByUserId(user.getId());
            LocalDate currentDate = LocalDate.now();

            Order order = new Order()
            {{
                setUserId(user.getId());
                setDate(Date.valueOf(currentDate));
                setAddress(currentProfile.getAddress());
                setCity(currentProfile.getCity());
                setState(currentProfile.getState());
                setZip(currentProfile.getZip());
                setShippingAmount(BigDecimal.ZERO);
            }};

            order = orderDao.create(order);
            ShoppingCart cart = shoppingCartDao.getByUserId(user.getId());

            List<ShoppingCartItem> cartItems = new ArrayList<>(cart.getItems().values());

            for (ShoppingCartItem cartItem : cartItems) {
                OrderLineItem orderItem = convertToLineItem(cartItem, order);
                orderItem = orderLineItemDao.create(orderItem);
                order.add(orderItem);
            }

            shoppingCartDao.emptyCart(user.getId());
            return order;

        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops... our bad.", e);
        }
    }


    private OrderLineItem convertToLineItem(ShoppingCartItem cartItem, Order order){
        return new OrderLineItem(order.getOrderId(), cartItem.getProductId(), cartItem.getProduct().getPrice(),cartItem.getQuantity(),BigDecimal.ZERO);
    }
}
