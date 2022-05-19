package net.sparkminds.profile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.sparkminds.profile.entity.Subscriber;
import net.sparkminds.profile.enumeration.Gender;

public interface SubscriberRepository extends JpaRepository<Subscriber, Long>{

	List<Subscriber> findByBrandId(Long brandId);

	List<Subscriber> findByGender(Gender sex);
	

}
