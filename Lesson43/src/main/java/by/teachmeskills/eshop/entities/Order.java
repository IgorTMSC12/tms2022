package by.teachmeskills.eshop.entities;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Data
@SuperBuilder
public class Order extends BaseEntity {

    private int userId;
    private int price;
    private LocalDate date;
    private List<Product> products;

}