package store.zabbix.wheather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import store.zabbix.wheather.common.PageResultBean;
import store.zabbix.wheather.common.ResultBean;
import store.zabbix.wheather.model.Customer;
import store.zabbix.wheather.service.CustomerService;

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
    public PageResultBean<List<Customer>> getCustomerList(@PathVariable(value = "pageNum") Integer pageNum,
                                                          @PathVariable(value = "pageSize") Integer pageSize){
        return new PageResultBean<>(customerService.getCustomerList(pageNum, pageSize));
    }
}
