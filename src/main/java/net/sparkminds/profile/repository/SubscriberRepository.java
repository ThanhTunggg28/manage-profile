package net.sparkminds.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.sparkminds.profile.entity.Subscriber;

public interface SubscriberRepository extends JpaRepository<Subscriber, Long>{

}
