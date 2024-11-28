package org.example.unit_test.chap05;

public class CustomerController {

    private final CustomerRepository customerRepository; // 내부 시스템
    private final ProductRepository productRepository; // 내부 시스템
    private final EmailGateway emailGateway;

    public CustomerController(final EmailGateway emailGateway) {
        this.customerRepository = new CustomerRepository();
        this.productRepository = new ProductRepository();
        this.emailGateway = emailGateway;
    }

    // 구매: 시스템 내부 통신, 외부 통신이 모두 존재하는 비즈니스 유스케이스
    // CustomerController.purchase(id, id, quantity) 를 외부 시스템에서 호출 -> 외부 시스템 통신
    public boolean purchase(final Long customerId, final Long productId, final int quantity) {
        Customer customer = customerRepository.findById(customerId);
        Product product = productRepository.findById(productId);

        boolean isSuccess = customer.purchase(new Store(), product, quantity);
        if (isSuccess) {
            // email 전송: 외부 시스템 통신
            emailGateway.sendReceipt("eamil@eamil.com", product, quantity);
        }
        return isSuccess;
    }

}
