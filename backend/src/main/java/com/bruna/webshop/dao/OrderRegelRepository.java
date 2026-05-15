package com.bruna.webshop.dao;

import com.bruna.webshop.modules.OrderRegel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRegelRepository extends JpaRepository<OrderRegel, Long> {
}
