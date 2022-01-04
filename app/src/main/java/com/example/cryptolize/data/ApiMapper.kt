package com.example.cryptolize.data

import com.example.cryptolize.data.model.CryptoListDTO
import com.example.cryptolize.domain.DomainMapper
import com.example.cryptolize.domain.models.CryptoListModel

/**
 * we use #DomainMapper interface to map our domain model to network DTO
 */

class DTOMapper : DomainMapper<CryptoListDTO, CryptoListModel> {
    override fun mapToDomainModel(model: CryptoListDTO)
            : CryptoListModel {
        return CryptoListModel(
            id = model.id,
            symbol = model.symbol,
            image = model.image,
            current_price = model.current_price,
            price_change_percentage_24h = model.price_change_percentage_24h,
            total_volume = model.total_volume
        )

    }

    override fun mapFromDomainModel(domainModel: CryptoListModel)
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
            : List<CryptoListModel> {
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<CryptoListModel>)
            : List<CryptoListDTO> {
        return initial.map { mapFromDomainModel(it) }
    }

}