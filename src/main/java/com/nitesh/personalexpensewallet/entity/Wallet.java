package com.nitesh.personalexpensewallet.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name can not be blank")
    @Size(min = 2, max = 20)
    private String name;
    @Size(min = 9, max = 18)
    private String accountNumber;
    @Size(max = 80)
    private String description;
    @Min(1)
    @Max(3)
    private Integer priority;//set priority for high low medium
    private Double currentBalance;

    @PrePersist
    public void setBalance() {
        this.currentBalance = new Double(0);
    }
}
