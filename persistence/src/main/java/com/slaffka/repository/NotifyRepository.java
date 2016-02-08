package com.slaffka.repository;

import com.slaffka.domain.Notify;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NotifyRepository extends PagingAndSortingRepository<Notify, Long> {
}
