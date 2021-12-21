package com.ecommerce.challenge.model;

import javax.persistence.*;

@Entity
@Table(name = "brand_group")
public class BrandGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description")
    private String description;

    public BrandGroup() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static BrandGroup.BrandGroupBuilder newBuilder() {
        return new BrandGroup.BrandGroupBuilder();
    }

    public static final class BrandGroupBuilder {
        private Long id;
        private String name;
        private String description;

        private BrandGroupBuilder() {
        }

        public BrandGroupBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public BrandGroupBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public BrandGroupBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public BrandGroup build() {
            BrandGroup brandGroup = new BrandGroup();
            brandGroup.id = this.id;
            brandGroup.description = this.description;
            brandGroup.name = this.name;
            return brandGroup;
        }
    }
}
