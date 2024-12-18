package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CompanyDaoTestSuite {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testSaveManyToMany(){
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        softwareMachine.getEmployees().add(stephanieClarckson);
        softwareMachine.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(greyMatter);
        johnSmith.getCompanies().add(softwareMachine);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);
        lindaKovalsky.getCompanies().add(softwareMachine);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();

        //Then
        Assertions.assertNotEquals(0,softwareMachineId);
        Assertions.assertNotEquals(0,greyMatterId);
        Assertions.assertNotEquals(0,dataMaestersId);

        //CleanUp
        employeeDao.deleteAll();
        companyDao.deleteAll();

    }
    @Test
    void testFindEmployeeByLastName() {
        //Given
        Employee employee = new Employee("John", "Smith");
        employeeDao.save(employee);

        //When
        List<Employee> result = employeeDao.findByLastName("Smith");

        //Then
        Assertions.assertEquals(1,result.size());
        Assertions.assertEquals("Smith", result.get(0).getLastname());

        //CleanUp
        employeeDao.deleteAll();

    }
    @Test
    void testFindCompanyByPrefix() {
        //Given
        Company company = new Company("Polomarket");
        companyDao.save(company);
        Company company2 = new Company("Lidl");
        companyDao.save(company2);
        Company company3 = new Company("Biedronka");
        companyDao.save(company3);

        //When
        List<Company> companies = companyDao.findByNamePrefix("Pol");

        //Then
        Assertions.assertEquals(1,companies.size());
        Assertions.assertEquals("Polomarket",companies.get(0).getName());
        //CleanUp
        companyDao.deleteAll();
    }
}
