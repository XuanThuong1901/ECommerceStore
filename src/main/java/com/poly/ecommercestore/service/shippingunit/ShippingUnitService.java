package com.poly.ecommercestore.service.shippingunit;

import com.poly.ecommercestore.entity.ShippingUnits;
import com.poly.ecommercestore.repository.ShippingUnitRepository;
import com.poly.ecommercestore.DTO.system.ShippingUnitDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingUnitService implements IShippingUnitService{

    @Autowired
    private ShippingUnitRepository shippingUnitRepository;

    @Override
    public List<ShippingUnits> getAllShippingUnit() {
        return shippingUnitRepository.findAll();
    }

    @Override
    public ShippingUnits addShippingUnit(ShippingUnitDTO shippingUnit) {

        System.out.println(shippingUnitRepository.getShippingUnits(shippingUnit.getShippingUnitName(), shippingUnit.getEmail(), shippingUnit.getTelephone()));

        if(shippingUnitRepository.getShippingUnits(shippingUnit.getShippingUnitName(), shippingUnit.getEmail(), shippingUnit.getTelephone()).size() != 0)
            return null;

        ShippingUnits newShippingUnit = new ShippingUnits(shippingUnit.getShippingUnitName(), shippingUnit.getEmail(), shippingUnit.getTelephone(), shippingUnit.getAddress());
        shippingUnitRepository.save(newShippingUnit);

        return newShippingUnit;
    }

    @Override
    public Boolean updateShippingUnit(ShippingUnitDTO shippingUnit, int iDShippingUnit) {

        ShippingUnits updateShippingUnit = shippingUnitRepository.getReferenceById(iDShippingUnit);

        if(updateShippingUnit == null)
            return false;

        updateShippingUnit.setShippingUnitName(shippingUnit.getShippingUnitName());
        updateShippingUnit.setEmail(shippingUnit.getEmail());
        updateShippingUnit.setTelephone(shippingUnit.getTelephone());
        updateShippingUnit.setAddress(shippingUnit.getAddress());

        if (shippingUnitRepository.save(updateShippingUnit) == null)
            return false;

        return true;
    }

    @Override
    public Boolean deleteShippingUnit(int iDShippingUnit) {

        ShippingUnits shippingUnit = shippingUnitRepository.getReferenceById(iDShippingUnit);

        if(shippingUnit == null)
            return false;

        shippingUnitRepository.delete(shippingUnit);
        return true;
    }
}
