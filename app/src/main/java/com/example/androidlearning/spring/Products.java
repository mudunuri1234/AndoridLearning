package com.example.androidlearning.spring;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fcwl on 6/10/2015.
 */
@Root
public class Products implements Serializable {

    @Element(name = "firstName")
    private String firstName;

    @Element(name = "lastName")
    private String lastName;

    @ElementList(inline=true)
    private List<Product> productList;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String NEW_LINE = System.getProperty("line.separator");

        result.append(this.getClass().getName() + " Object {" + NEW_LINE);
        result.append(" firstName: " + firstName + NEW_LINE);
        result.append(" lastName : " + lastName + NEW_LINE);
        result.append("}");

        return result.toString();
    }

}
