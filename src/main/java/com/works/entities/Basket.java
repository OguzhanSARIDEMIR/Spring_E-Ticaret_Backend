package com.works.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Data
public class Basket extends Base{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotNull
    @Range(message ="En az 1 adet eklemelisiniz" ,min = 1)
    private Integer quantity;
    boolean status=false;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}