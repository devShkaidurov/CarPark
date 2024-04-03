package com.pegasAgro.carPark.dto.dealerDTO;

import com.pegasAgro.carPark.models.Dealer;

import lombok.Data;

@Data
public class DealerDTO {
    private long id;
    private String name;
    private String email;
    private String agentFIO;

    public static DealerDTO fromEntity (Dealer dealer) {
        DealerDTO dto = new DealerDTO();
        dto.setId(dealer.getId());
        dto.setName(dealer.getName());
        dto.setEmail(dealer.getEmail());
        dto.setAgentFIO(dealer.getAgentFIO());
        return dto;
    }

    public static Dealer toEntity (DealerDTO dto) {
        Dealer dealer = new Dealer();
        dealer.setId(dto.getId());
        dealer.setName(dto.getName());
        dealer.setEmail(dto.getEmail());
        dealer.setAgentFIO(dto.getAgentFIO());
        return dealer;
    }


}
