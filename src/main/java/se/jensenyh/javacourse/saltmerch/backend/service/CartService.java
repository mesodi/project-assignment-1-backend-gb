package se.jensenyh.javacourse.saltmerch.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jensenyh.javacourse.saltmerch.backend.model.CartItem;
import se.jensenyh.javacourse.saltmerch.backend.repository.CartRepository;

import java.util.List;

@Service
    public class CartService
    {
        @Autowired
        CartRepository cartDataBase;

        public List<CartItem> SelectAllItemsIncart() {
            return cartDataBase.selectAllItems();
        }

        public int insertOrIncrementItem (String actionTodo, CartItem cartItem) {

            return switch (actionTodo) {
                case "add" -> cartDataBase.insertOrIncrementItem(cartItem);
                case "remove" -> cartDataBase.deleteOrDecrementItem(cartItem);
                default -> -1;
            };
        }
            public void clearCart (boolean restock)
            {
                cartDataBase.deleteAllItems(restock);
            }


    }


    //cartService.addOrRemoveItem(action, cartItem);