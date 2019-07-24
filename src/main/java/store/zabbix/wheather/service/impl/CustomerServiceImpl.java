package store.zabbix.wheather.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import store.zabbix.wheather.model.Customer;
import store.zabbix.wheather.repository.CustomerRepository;
import store.zabbix.wheather.service.CustomerService;

import java.util.Iterator;
import java.util.List;

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

        //将参数传给这个方法就可以实现物理分页了，非常简单。
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(pageNum, pageSize, sort);

        return customerRepository.findAll(pageable);
    }
}
