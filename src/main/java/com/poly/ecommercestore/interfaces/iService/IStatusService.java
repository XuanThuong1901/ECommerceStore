package com.poly.ecommercestore.interfaces.iService;

import com.poly.ecommercestore.entity.Status;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IStatusService {

    public List<Status>getAllStatus();

}
