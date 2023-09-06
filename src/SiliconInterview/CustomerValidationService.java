package SiliconInterview;

import java.util.ArrayList;
import java.util.List;

class Customer{
    private final String id;
    private String userName;
    private String email;
    private String address;
    private String phoneNumber;

    // Constructors, setters and getters

    public Customer(String id, String userName, String email, String address, String phoneNumber) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

class CustomerResponse{
    private final String id;
    private String userName;
    private String email;
    private String address;
    private String phoneNumber;
    public boolean isFound;
    // Constructors, setters and getters

    public CustomerResponse(String id, String userName, String email, String address, String phoneNumber, boolean isFound) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.isFound = isFound;
    }
}

public class CustomerValidationService{

    public  List<CustomerResponse> validateCustomer(List<Customer> customers){

        List<CustomerResponse> customerResponses = new ArrayList<>();

        for(Customer customer : customers){

            boolean isFoundLocal = validateCustomerLocal(customer);
            boolean isFoundMaster = false;
            if(!isFoundLocal){
                isFoundMaster = validateCustomerMaster(customer);
            }
            CustomerResponse currentCustomerResponse = new CustomerResponse(customer.getId(), customer.getUserName(), customer.getEmail(), customer.getAddress(), customer.getPhoneNumber(),isFoundLocal || isFoundMaster);
            customerResponses.add(currentCustomerResponse);
        }
        return customerResponses;
    }

    private boolean validateCustomerMaster(Customer customer) {
        return false;
    }

    private boolean validateCustomerLocal(Customer customer) {
        return false;
    }

    public static void main(String[] args) {
        CustomerValidationService customerValidationService = new CustomerValidationService();
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("1","Andy","AndyEmail","address", "123"));
        customers.add(new Customer("2","Bandy","AndyEmail","address", "123"));
        List<CustomerResponse> customerResponses = customerValidationService.validateCustomer(customers);
        System.out.print(customerResponses);
    }

}
