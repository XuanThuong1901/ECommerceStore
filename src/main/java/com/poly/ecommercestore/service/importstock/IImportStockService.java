package com.poly.ecommercestore.service.importstock;

import com.poly.ecommercestore.entity.ImportStocks;
import com.poly.ecommercestore.DTO.system.ImportStockDTO;

import java.util.List;

public interface IImportStockService {

    ImportStocks addImportStock(ImportStockDTO importStock);

    List<ImportStocks> getAllImportStock();

    ImportStocks updateImportStock(ImportStockDTO importStock);

    ImportStocks getOneImportStock(int iDImportStock);
}
