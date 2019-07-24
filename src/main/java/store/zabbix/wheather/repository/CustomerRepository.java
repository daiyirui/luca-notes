package store.zabbix.wheather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import store.zabbix.wheather.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}