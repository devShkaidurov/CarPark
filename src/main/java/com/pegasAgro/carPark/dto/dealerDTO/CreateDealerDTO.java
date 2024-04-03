package com.pegasAgro.carPark.dto.dealerDTO;

import com.pegasAgro.carPark.models.Dealer;

import lombok.Data;

@Data
public class CreateDealerDTO {
    private String name;
    private String email;
    private String agentFIO;

    public static CreateDealerDTO fromEntity (Dealer dealer) {
        CreateDealerDTO dto = new CreateDealerDTO();
        dto.setName(dealer.getName());
        dto.setEmail(dealer.getEmail());
        dto.setAgentFIO(dealer.getAgentFIO());
        return dto;
    }

    public static Dealer toEntity (CreateDealerDTO dto) {
        Dealer dealer = new Dealer();
        dealer.setName(dto.getName());
        dealer.setEmail(dto.getEmail());
        dealer.setAgentFIO(dto.getAgentFIO());
        return dealer;
    }
    
}
