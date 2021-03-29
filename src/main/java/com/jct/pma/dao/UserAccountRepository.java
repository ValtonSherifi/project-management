package com.jct.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.jct.pma.entities.UserAccount;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long>{

}
