package by.katya.manomstore.repository;

import by.katya.manomstore.entity.Manometer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManomRepository extends JpaRepository <Manometer, Long> {
}
