package com.poly.ecommercestore.service.shippingunit;

import com.poly.ecommercestore.entity.ShippingUnits;
import com.poly.ecommercestore.DTO.system.ShippingUnitDTO;

import java.util.List;

public interface IShippingUnitService {

    List<ShippingUnits> getAllShippingUnit();

    ShippingUnits addShippingUnit(ShippingUnitDTO shippingUnit);

    Boolean updateShippingUnit(ShippingUnitDTO shippingUnit, int iDShippingUnit);

    Boolean deleteShippingUnit(int iDShippingUnit);
}
