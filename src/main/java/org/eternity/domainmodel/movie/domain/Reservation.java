package org.eternity.domainmodel.movie.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.eternity.domainmodel.generic.Money;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor
public class Reservation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "SCREENING_ID")
    private Screening screening;
    private int audienceCount;
    private Money fee;

    public Reservation(Customer customer, Screening screening, int audienceCount, Money fee) {
        this.customer = customer;
        this.screening = screening;
        this.audienceCount = audienceCount;
        this.fee = fee;
    }
}
