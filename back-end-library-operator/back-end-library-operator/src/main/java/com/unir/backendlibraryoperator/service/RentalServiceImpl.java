package com.unir.backendlibraryoperator.service;

import com.unir.backendlibraryoperator.data.RentalRepository;
import com.unir.backendlibraryoperator.data.utils.BooksFacade;
import com.unir.backendlibraryoperator.model.pojo.*;
import com.unir.backendlibraryoperator.model.request.CreateRentalRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RentalServiceImpl implements RentalService {

    @Autowired
    private RentalRepository repository;

    @Autowired
    private BooksFacade booksFacade;

    @Override
    public RentalDto createRental(CreateRentalRequest request) {
        List<Book> books = request.getRentalDetailRequestLists().stream().map(x->booksFacade.getBook(x.getBookId())).filter(Objects::nonNull).toList();

        if (books.size() == request.getRentalDetailRequestLists().size())
        {

            Rental rental = Rental.builder().rentDate(request.getRentalDate()).build();
            List<RentalDetail> rentalDetails = request.getRentalDetailRequestLists().stream().map(detailRequest -> {
                RentalDetail detailEntity = RentalDetail.builder()
                        .amount(detailRequest.getAmount())
                        .rentalDay(detailRequest.getRentDate())
                        .returnDay(detailRequest.getReturnDate())
                        .numberDay(detailRequest.getNumberDay())
                        .book_Id(detailRequest.getBookId())
                        .rental(rental)
                        .build();

                return detailEntity;
            }).collect(Collectors.toList());
            rental.setRentalDetail(rentalDetails);
            repository.save(rental);
            return getRentalDto(rental);

        }else {
            return null;
        }
    }
    @Override
    public List<RentalDto> getRentals()
    {
        List<Rental> rentals = repository.getRentals();
        if(!rentals.isEmpty())
        {
            return rentals.stream().map(this::getRentalDto).collect(Collectors.toList());
        }else{
            return null;
        }
        //return rentals.isEmpty() ? null : rentals;
    }

    @Override
    public RentalDto getRental(String id) {
        Rental rental =repository.getRentalById(Long.valueOf(id));
        if (rental != null)
            return getRentalDto(rental);
        return  null;
    }

    private RentalDto getRentalDto(Rental x)
    {
        return RentalDto.builder()
                .id(x.getId())
                .rentDate(x.getRentDate().toString())
                .rentalDetails(x.getRentalDetail().stream().map(y->{
                    return RentalDetailDto.builder()
                            .rentDate(y.getRentalDay().toString())
                            .numberDay(y.getNumberDay())
                            .returnDate(y.getReturnDay().toString())
                            .amount(y.getAmount())
                            .bookId(y.getBook_Id()).build();
                }).collect(Collectors.toList())).build();
    }
}
