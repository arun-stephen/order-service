package com.test.orders;

import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderDao orderDao;

    @GetMapping
    public List<Order> fetchOrder() {
        return orderDao.getOrders();
    }

    @GetMapping("/sorted")
    public List<Order> fetchOrderSorted() {
        return orderDao.getOrders().stream().sorted(Comparator.comparing(Order::getPrice))
                .collect(Collectors.toList());
    }
}
