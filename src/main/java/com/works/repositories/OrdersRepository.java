package com.works.repositories;

import com.works.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
    List<Orders> findByIdIs(Long id);

    List<Orders> findByUser_Id(Long id);

}