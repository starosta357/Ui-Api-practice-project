package api.util;

import api.model.Customer;
import service.TestDataReader;

public class CustomerCreator {
    public static final String CUSTOMER_NAME = "api.customer.name";
    public static final String CUSTOMER_JOB = "api.customer.job";

    public static Customer withCredentialsFromProperty() {
        return new Customer(TestDataReader.getTestData(CUSTOMER_NAME),
                TestDataReader.getTestData(CUSTOMER_JOB));
    }

    public static Customer withEmptyCustomerName() {
        return new Customer("", TestDataReader.getTestData(CUSTOMER_JOB));
    }

    public static Customer withEmptyCustomerJob() {
        return new Customer(TestDataReader.getTestData(CUSTOMER_NAME), "");
    }
}
