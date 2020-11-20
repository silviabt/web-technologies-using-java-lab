package com.uni.Lab7.domain;

public interface Product {

    /**
     * Returns the name of the product;
     * @return product name
     */
    String getName();

    /**
     * Returns the price of the product;
     * @return product price
     */
    double getPrice();

    /**
     * Returns the description of the product;
     * @return product description
     */
    String getDescription();
}
