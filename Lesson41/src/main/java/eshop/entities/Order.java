package eshop.entities;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Data
@SuperBuilder
public class Order extends BaseEntity {

    private int userId;
    private int orderPrice;
    private LocalDate orderData;
    private List<Product> products;

}
