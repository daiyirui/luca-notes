package store.zabbix.apartment.service;

import org.springframework.data.domain.Page;
import store.zabbix.apartment.model.Customer;

/**
 * description: 宾客接口
 *
 * @author eyck.cui update: 2019-07-25 00:38
 **/
public interface CustomerService {
    Page<Customer> getCustomerList(Integer pageNum, Integer pageSize);

    Customer insertCustomer(Customer customer);
}
