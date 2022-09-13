package by.teachmeskills.eshop.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "categories")
@SuperBuilder
public class Category extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "rating")
    private double rating;

    @OneToMany(mappedBy = "category", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Product> products;
}

