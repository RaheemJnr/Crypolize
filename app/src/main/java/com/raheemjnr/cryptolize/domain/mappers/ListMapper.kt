package com.raheemjnr.cryptolize.domain.mappers

import com.raheemjnr.cryptolize.data.model.CryptoListDTO
import com.raheemjnr.cryptolize.domain.models.Crypto


/**
 * we use #DomainMapper interface to map our domain model to network DTO
 */

class ListDTOMapper : DomainMapper<CryptoListDTO, Crypto> {
    override fun mapToDomainModel(dtoModel: CryptoListDTO)
            : Crypto {
        return Crypto(
            id = dtoModel.id,
            symbol = dtoModel.symbol,
            image = dtoModel.image,
            current_price = dtoModel.current_price,
            price_change_percentage_24h = dtoModel.price_change_percentage_24h,
            total_volume = dtoModel.total_volume
        )

    }

    override fun mapFromDomainModel(domainModel: Crypto)
            : CryptoListDTO {
        return CryptoListDTO(
            id = domainModel.id,
            total_volume = domainModel.total_volume,
            current_price = domainModel.current_price,
            image = domainModel.image,
            symbol = domainModel.symbol
        )
    }

    fun toDomainList(initial: List<CryptoListDTO>)
            : List<Crypto> {
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<Crypto>)
            : List<CryptoListDTO> {
        return initial.map { mapFromDomainModel(it) }
    }

}