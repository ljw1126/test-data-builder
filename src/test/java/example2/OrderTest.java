package example2;

import example2.builder.AddressBuilder;
import example2.builder.CustomerBuilder;
import example2.builder.OrderBuilder;
import example2.builder.OrderItemBuilder;
import example2.objectmother.Addresses;
import example2.objectmother.Customers;
import example2.objectmother.OrderItems;
import example2.objectmother.Orders;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static example2.builder.AddressBuilder.*;
import static example2.builder.CustomerBuilder.*;
import static example2.builder.OrderBuilder.*;
import static example2.builder.OrderItemBuilder.*;

// 출처. https://www.arhohuttunen.com/test-data-builders/
public class OrderTest {

    @DisplayName("불필요한 정보를 너무 많이 알고 있고, 생성자 파라미터 추가시 테스트 코드에도 변경이 전파된다")
    @Test
    void constructorOrder() {
        Address address = new Address("1216  Clinton Street", "Philadelphia", "19108", "United States");
        Customer customer = new Customer(1L, "Terry Tew", address);
        Order order = new Order(1L,customer, 0.0, null);
        order.addOrderItem(new OrderItem("Coffee mug", 1));
        
        // do something
    }

    @DisplayName("object mother pattern 사용하여 가독성/재사용성 향상 및 생성자를 숨겼지만 케이스별 팩터리 메서드 추가시 SRP 위반하게 된다")
    @Test
    void constructOrderWithObjectMotherPattern() {
        Address address = Addresses.createAddressWithCountry("United States");
        Customer customer = Customers.createCustomerWithAddress(address);
        Order order = Orders.createOrderWithCustomer(customer);
        order.addOrderItem(OrderItems.createOrderItem("Coffee mug"));

        // do something
    }

    @DisplayName("Test Data Builder 패턴으로 리팩터링하여 Order 생성할 수 있다")
    @Test
    void constructOrderWithTestDataBuilderPattern() {
    Order order = aOrder().withId(1L)
                        .withCustomer(
                            aCustomer()
                                .withId(1L)
                                .withName("Terry Tew")
                                .withAddress(
                                    address()
                                        .withStreet("1216  Clinton Street")
                                        .withCity("Philadelphia")
                                        .withPostalCode("19108")
                                        .withCountry("United States")
                                        .build())
                                .build())
                        .withOrderItems(aOrderItem()
                                .withName("Coffee mug")
                                .withQuantity(1)
                                .build())
                        .build();

        // do something
    }
}
