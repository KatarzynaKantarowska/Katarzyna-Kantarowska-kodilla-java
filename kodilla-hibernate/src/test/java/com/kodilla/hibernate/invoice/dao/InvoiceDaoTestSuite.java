package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
@Transactional
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ItemDao itemDao;

    @Test
    void testInvoiceDaoSave(){
        //Given
        Product product = new Product("Laptop");
        Product product2 = new Product("Smartphone");
        Product product3 = new Product("Tablet");
        Product product4 = new Product("Myszka");
        Product product5 = new Product("Klawiatura");

        Item item = new Item(product,new BigDecimal(7000),1,new BigDecimal(7000));
        Item item2 = new Item(product2,new BigDecimal(3000),3,new BigDecimal(9000));
        Item item3 = new Item(product3,new BigDecimal(1000),2,new BigDecimal(2000));
        Item item4 = new Item(product4,new BigDecimal(70),8,new BigDecimal(560));
        Item item5 = new Item(product5,new BigDecimal(130),2,new BigDecimal(260));

        Invoice invoice = new Invoice("4585", List.of(item,item2,item3,item4,item5));

        //When
        invoiceDao.save(invoice);
        Integer invoiceId = invoice.getId();

        //Then
        Invoice retrievedInvoice = invoiceDao.findById(invoiceId).orElse(null);
        Assertions.assertNotNull(invoiceId);
        Assertions.assertEquals(5,retrievedInvoice.getItems().size());

        //CleanUp
        invoiceDao.deleteById(invoiceId);
        productDao.delete(product);
        productDao.delete(product2);
        productDao.delete(product3);
        productDao.delete(product4);
        productDao.delete(product5);
    }
}