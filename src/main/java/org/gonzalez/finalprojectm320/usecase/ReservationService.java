package org.gonzalez.finalprojectm320.usecase;

import java.util.List;
import org.gonzalez.finalprojectm320.model.Bookable;
import org.gonzalez.finalprojectm320.model.Reservation;
import org.gonzalez.finalprojectm320.repository.interfaces.ReservationRepository;
import org.gonzalez.finalprojectm320.repository.interfaces.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private final ReservationRepository reservationRepository;

    @Autowired
    private final RoomRepository roomRepository;


    public ReservationService(ReservationRepository reservationRepository, RoomRepository roomRepository) {
        this.reservationRepository = reservationRepository;
        this.roomRepository = roomRepository;

    }

    public boolean createReservation(org.gonzalez.finalprojectm320.model.Reservation r) {
        return reservationRepository.createReservation(r);
    }

    public List<Reservation> getReservations() {
        return reservationRepository.getReservations();
    }

    public org.gonzalez.finalprojectm320.model.Reservation getReservation(int id) {
        return reservationRepository.getReservation(id);
    }

    public boolean updateReservation(int id, org.gonzalez.finalprojectm320.model.Reservation newReservation) {
        return reservationRepository.updateReservation(id, newReservation);
    }

    public boolean deleteReservation(int id) {
        return reservationRepository.deleteReservation(id);
    }

    public double calculateTotalPrice(int id) {
        Reservation reservation = reservationRepository.getReservation(id);
        Bookable reservedBookable = roomRepository.getRoom(reservation.getBookableId());

        return reservation.getNumberOfPeople()* reservedBookable.getPriceForPerson() * reservation.reservedDays();
    }
}
