package store.zabbix.apartment.controller;

import org.springframework.web.bind.annotation.*;
import store.zabbix.apartment.common.PageResultBean;
import store.zabbix.apartment.common.ResultBean;
import store.zabbix.apartment.model.Customer;
import store.zabbix.apartment.service.CustomerService;

import java.util.List;

/**
 * description: 宾客前端交互层
 *
 * @author eyck.cui update: 2019-07-25 00:40
 **/
@RestController
@RequestMapping(value = "customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/get/{pageNum}/{pageSize}",method = RequestMethod.GET)
    public PageResultBean<Customer> getCustomerList(@PathVariable(value = "pageNum") Integer pageNum,
                                                @PathVariable(value = "pageSize") Integer pageSize){
        return new PageResultBean<>(customerService.getCustomerList(pageNum, pageSize));
    }


    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResultBean<Customer> addCustomer(@RequestBody Customer customer){
        return new ResultBean<>(customer);
    }

}

