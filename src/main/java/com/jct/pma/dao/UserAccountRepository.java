package com.jct.pma.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jct.pma.entities.UserAccount;

public interface UserAccountRepository extends PagingAndSortingRepository<UserAccount, Long>{

}
