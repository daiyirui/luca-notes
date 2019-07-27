package store.zabbix.apartment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import store.zabbix.apartment.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}