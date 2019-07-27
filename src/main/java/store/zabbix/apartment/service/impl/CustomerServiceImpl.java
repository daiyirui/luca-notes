package store.zabbix.apartment.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import store.zabbix.apartment.enums.ExceptionEnums;
import store.zabbix.apartment.enums.SystemExceptionCode;
import store.zabbix.apartment.exception.CheckException;
import store.zabbix.apartment.model.Customer;
import store.zabbix.apartment.repository.CustomerRepository;
import store.zabbix.apartment.service.CustomerService;

import java.util.Objects;

/**
 * description: 宾客接口实现 逻辑处理
 *
 * @author eyck.cui update: 2019-07-25 00:43
 **/
@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Page<Customer> getCustomerList(Integer pageNum, Integer pageSize) {
        log.info("接收到的参数 pageNum:{} pageSize:{}", pageNum, pageSize);

        if(Objects.isNull(pageNum) || Objects.isNull(pageSize)){
            throw new CheckException(ExceptionEnums.PAGE_VAILD);
        }

        //将参数传给这个方法就可以实现物理分页了，非常简单。
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(pageNum, pageSize, sort);

        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer insertCustomer(Customer customer) {

        log.info("insertCustomer params:{}",customer.toString());

        return customerRepository.saveAndFlush(customer);
    }
}
