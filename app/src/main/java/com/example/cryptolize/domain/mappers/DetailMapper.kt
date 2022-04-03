package com.example.cryptolize.domain.mappers

import com.example.cryptolize.data.model.detailsDto.DetailsDTO
import com.example.cryptolize.domain.models.detailModel.CoinDetail

class DetailDTOMapper : DomainMapper<DetailsDTO, CoinDetail> {

    override fun mapToDomainModel(dtoModel: DetailsDTO) =
        CoinDetail(
            id = dtoModel.id,
            symbol = dtoModel.symbol,
            name = dtoModel.name,
            description = dtoModel.description,
            links = dtoModel.links,
            image = dtoModel.image,
            market_cap_rank = dtoModel.market_cap_rank,
            market_data = dtoModel.market_data
        )


    override fun mapFromDomainModel(domainModel: CoinDetail) = DetailsDTO(
        id = domainModel.id,
        symbol = domainModel.symbol,
        name = domainModel.name,
        description = domainModel.description,
        links = domainModel.links,
        image = domainModel.image,
        market_cap_rank = domainModel.market_cap_rank,
        market_data = domainModel.market_data
    )

    fun toDomainList(initial: List<DetailsDTO>): List<CoinDetail> {
        return initial.map { mapToDomainModel(it) }

    }

//
//    fun fromDomainList(intial: List<CoinDetail>): List<DetailsDTO> {
//        return intial.map { mapFromDomainModel(it) }
//    }
}