package com.poly.ecommercestore.service.cart;

import com.poly.ecommercestore.entity.Carts;
import com.poly.ecommercestore.entity.Customers;
import com.poly.ecommercestore.entity.Products;
import com.poly.ecommercestore.entity.embeddable.CartId;
import com.poly.ecommercestore.repository.CartRepository;
import com.poly.ecommercestore.repository.CustomerRepository;
import com.poly.ecommercestore.repository.ProductRepository;
import com.poly.ecommercestore.DTO.client.CartDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CartService implements ICartService{

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    private final Boolean SELECT_STATE = false;

    @Override
    public List<Carts> getCartByCustomer(String iDCustomer) {
        return cartRepository.getCartCustomer(iDCustomer);
    }

    @Override
    public Carts addCart(String iDCustomer, int iDProduct, CartDTO cart) {
        Customers customer = customerRepository.getCustomersById(iDCustomer);
        if(customer == null)
            return null;

        Products product = productRepository.getReferenceById(iDProduct);
        if(product == null)
            return null;

        Date updateDate = new Date();
        CartId cartId = new CartId(customer.getIDCustomer(), product.getIDProduct());
        Carts newCart = new Carts(cartId, SELECT_STATE, updateDate, cart.getQuantity(), customer, product);


        cartRepository.save(newCart);

        return newCart;
    }

    @Override
    public Boolean deleteCart(String iDCustomer, int iDProduct) {
        Carts cart = cartRepository.getCart(iDCustomer, iDProduct);
        if(cart == null)
            return false;

        cartRepository.delete(cart);
        return true;
    }

    @Override
    public Boolean updateCart(String iDCustomer, int iDProduct, CartDTO cartRequest) {
        Carts cart = cartRepository.getCart(iDCustomer, iDProduct);
        if(cart == null)
            return false;

        cart.setQuantity(cartRequest.getQuantity());

        if(cartRepository.save(cart) == null)
            return false;

        return true;
    }

    @Override
    public List<Carts> selectCart(String iDCustomer, List<CartDTO> cart) {

//        List<Carts> cartList = cartRepository.getCartCustomer(iDCustomer);
//        if(cartList == null)
//            return null;
//
//        for (CartRequest c : cart){
//            if(c.)
//        }

        return null;
    }


}
