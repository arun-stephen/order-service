package com.test.orders;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao {
    public List<Order> getOrders() {
        return Stream.of(
                new Order(101, "mobile", 1, 40000),
                new Order(102, "laptop", 2, 115000),
                new Order(103, "motorcycle", 1, 85000),
                new Order(104, "car", 1, 785000)
        ).collect(Collectors.toList());
    }
}
