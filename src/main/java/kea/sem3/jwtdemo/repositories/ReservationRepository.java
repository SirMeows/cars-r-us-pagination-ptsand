package kea.sem3.jwtdemo.repositories;

import kea.sem3.jwtdemo.entity.Car;
import kea.sem3.jwtdemo.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
    Reservation findReservationByReservedCar_IdAndRentalDate(int id, LocalDate date);

    @Query("select c from Car c where c.reservations.size=0")
    List<Car> getNotReservedCars();
}