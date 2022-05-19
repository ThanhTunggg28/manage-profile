package net.sparkminds.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.sparkminds.profile.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long>{

}
