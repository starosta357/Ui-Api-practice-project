package api;

import api.model.Customer;
import api.util.CustomerCreator;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class CheckCustomerBaseOperations extends BaseTestCaseApi {

    private static final int CUSTOMER_NUMBER = 1;
    private static final Customer CUSTOMER =
            CustomerCreator.withCredentialsFromProperty();

    @Test
    public void getCustomer() {
        keywordManager
                .customer().getCustomer(CUSTOMER_NUMBER)
                .then()
                .assertThat().body("data.id", equalTo(CUSTOMER_NUMBER));
        //and so on, in future it is better to implement model witch will be
        //representing a response and generate model as an expected result
        //so with this approach we will be able to check hole response rather than
        //one particular field.
    }

    @Test
    public void postCustomer() {
        keywordManager
                .customer().postCustomer(CUSTOMER)
                .then()
                .assertThat()
                .body("name", equalTo(CUSTOMER.getName()))
                .body("job", equalTo(CUSTOMER.getJob()));
    }

    @Test
    public void patchCustomer() {
        keywordManager
                .customer().patchCustomer(CUSTOMER, CUSTOMER_NUMBER)
                .then()
                .assertThat()
                .body("name", equalTo(CUSTOMER.getName()))
                .body("job", equalTo(CUSTOMER.getJob()));
    }

    @Test
    public void deleteCustomer() {
        keywordManager
                .customer().deleteCustomer(CUSTOMER_NUMBER);
    }

}
