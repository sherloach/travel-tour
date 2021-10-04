//package com.nqhtour.repository;
//
//import com.nqhtour.entity.ClientEntity;
//import com.nqhtour.entity.ClientTourEntity;
//import com.nqhtour.entity.TourEntity;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import java.util.List;
//
//public interface ClientTourRepository extends JpaRepository<ClientTourEntity, Long>{
//    ClientTourEntity findOneByClientEntityAndTourEntity(ClientEntity client, TourEntity tour);
//    List<ClientTourEntity> findAllByClientEntity(ClientEntity client);
///*    void deleteByClientEntityAndTourEntity(ClientEntity client, TourEntity tour);
//
//    @Query(value = "call travelbooking.sp_cancellation(?1,?2)", nativeQuery = true)
//    void deleteBooking(Long idCLient, Long idTour);*/
//}
