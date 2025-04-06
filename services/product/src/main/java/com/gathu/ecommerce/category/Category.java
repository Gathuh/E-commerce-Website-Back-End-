package com.gathu.ecommerce.category;


import com.gathu.ecommerce.product.Product;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Primary;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter

@Entity
@Builder
public class Category {

    @Id
    @GeneratedValue
    private  Integer id;
    private String name;
    private String description;
    @OneToMany(mappedBy="category",cascade = CascadeType.REMOVE)
    private List<Product> products;
}
