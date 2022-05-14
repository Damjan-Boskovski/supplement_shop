package mk.ukim.finki.wp.supplement_shop.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }
}
