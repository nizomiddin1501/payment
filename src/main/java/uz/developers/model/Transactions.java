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
    private String sender_card_number;
    private String receiver_card_number;
}
