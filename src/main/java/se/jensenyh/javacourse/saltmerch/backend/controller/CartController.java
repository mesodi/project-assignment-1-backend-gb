package se.jensenyh.javacourse.saltmerch.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.jensenyh.javacourse.saltmerch.backend.model.CartItem;
import se.jensenyh.javacourse.saltmerch.backend.service.CartService;

import java.util.List;
    @CrossOrigin
    @RequestMapping("/api/v1")
    @RestController

public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping("/carts/{id}")
    public List<CartItem> getCart(@PathVariable int id ){

        return cartService.SelectAllItemsIncart();
    }
    @PatchMapping("/carts/{id}")

    public ResponseEntity<Object> insertOrIncrementItem(@PathVariable int id, @RequestBody CartItem item, @RequestParam String action) {

        if (id == 1) {
            int result;
            result = cartService.insertOrIncrementItem(action, item);
            return switch (result) {
                case 1 -> new ResponseEntity(HttpStatus.CREATED);
                case -1 -> new ResponseEntity("Your cart has been emptyed!", HttpStatus.FORBIDDEN);
                case -2 -> new ResponseEntity("incorrect input, pleas try again!", HttpStatus.BAD_REQUEST);
                default -> throw new IllegalStateException("Unexpected value: " + result);
            };
        }
        return new ResponseEntity("Your Id is incorrect! ", HttpStatus.UNAUTHORIZED);

    }
    @DeleteMapping("/carts/{id}")
    public ResponseEntity<Object>deleteOrDecrementItem(@PathVariable int id, @RequestParam  (required = false)boolean buyout)
    {
        switch (id) {
            case 1:
                if (buyout) {
                    cartService.clearCart(false);
                    return new ResponseEntity("You purchased successfully ", HttpStatus.ACCEPTED);
                } else {
                    cartService.clearCart(true);
                    return new ResponseEntity("Your cart has been emptied  ", HttpStatus.OK);
                }
        }
        return new ResponseEntity("Your Id is incorrect!", HttpStatus.UNAUTHORIZED);
}
}

