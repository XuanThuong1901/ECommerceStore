package com.poly.ecommercestore.service.shippingunit;

import com.poly.ecommercestore.entity.ShippingUnits;
import com.poly.ecommercestore.request.system.ShippingUnitRequest;

import java.util.List;

public interface IShippingUnitService {

    List<ShippingUnits> getAllShippingUnit();

    ShippingUnits addShippingUnit(ShippingUnitRequest shippingUnit);

    Boolean updateShippingUnit(ShippingUnitRequest shippingUnit, int iDShippingUnit);

    Boolean deleteShippingUnit(int iDShippingUnit);
}
