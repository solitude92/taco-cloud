package com.example.tacocloud.repository;

import com.example.tacocloud.domain.TacoOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {

    List<TacoOrder> findAllByDeliveryZip(String deliveryZip);

    List<TacoOrder> findAllByDeliveryCityOrderByDeliveryState(String city);
}
