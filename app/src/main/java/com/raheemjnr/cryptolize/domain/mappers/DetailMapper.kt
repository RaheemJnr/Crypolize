package com.raheemjnr.cryptolize.domain.mappers

import com.raheemjnr.cryptolize.data.model.detailsDto.DetailsDTO
import com.raheemjnr.cryptolize.domain.models.detailModel.CoinDetail


class DetailDTOMapper : DomainMapper<DetailsDTO, CoinDetail> {

    override fun mapToDomainModel(model: DetailsDTO) =
        CoinDetail(
            id = model.id,
            symbol = model.symbol,
            name = model.name,
            description = model.description,
            links = model.links,
            image = model.image,
            market_cap_rank = model.market_cap_rank,
            market_data = model.market_data
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