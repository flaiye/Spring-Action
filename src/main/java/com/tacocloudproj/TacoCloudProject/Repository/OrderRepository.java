package com.tacocloudproj.TacoCloudProject.Repository;

import com.tacocloudproj.TacoCloudProject.model.TacoOrder;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository {
    TacoOrder save(TacoOrder order);
}
