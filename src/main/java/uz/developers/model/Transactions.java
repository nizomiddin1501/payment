package uz.developers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transactions {
    private int id;
    private Double amount;
    private Date date;
    private String senderCardNumber;
    private String receiverCardNumber;
}
