package com.myafternoonbank1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myafternoonbank1.entity.Employee;

@Repository
public interface MyBankingDAOInterface extends JpaRepository<Employee, String>{

}
