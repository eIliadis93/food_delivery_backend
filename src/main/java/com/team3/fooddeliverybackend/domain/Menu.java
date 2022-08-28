package com.team3.fooddeliverybackend.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MENUS")
@SequenceGenerator(name = "idGenerator", sequenceName = "MENUS_SEQ", initialValue = 1, allocationSize = 1)
public class Menu extends BaseModel{

    @ManyToMany
    private List<Product> productList;
}
