package be.ucll.da.hospitalmonolith.domain.appointment;

import jakarta.persistence.*;

@Embeddable
public class Account {

    private double totalCost;

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
