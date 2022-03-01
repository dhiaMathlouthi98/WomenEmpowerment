package tn.esprit.spring.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Event;

@Repository
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {

	Page<Event> findAll(Pageable pageable);
	Page<Event> findByTitle(String title, Pageable pageable);
}
