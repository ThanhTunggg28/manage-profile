package net.sparkminds.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.sparkminds.profile.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long>{

}
