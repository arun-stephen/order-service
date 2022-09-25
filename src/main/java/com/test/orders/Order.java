package com.test.orders;

import lombok.Data;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
    private int id;
    private String name;
    private int quantity;
    private long price;
}
