package com.raheemjnr.cryptolize.domain.mappers

import com.raheemjnr.cryptolize.data.model.CryptoListDTO
import com.raheemjnr.cryptolize.data.repository.local.entity.CryptoEntity
import com.raheemjnr.cryptolize.domain.models.Crypto


/**
 * we use #DomainMapper interface to map our domain model to network DTO and to DB entities
 */

class MapDTOtoDbEntity : DomainMapper<CryptoListDTO, CryptoEntity> {
    override fun mapToDomainModel(model: CryptoListDTO)
            : CryptoEntity {
        return CryptoEntity(
            id = model.id,
            symbol = model.symbol,
            image = model.image,
            current_price = model.current_price,
            price_change_percentage_24h = model.price_change_percentage_24h,
            total_volume = model.total_volume
        )

    }

    override fun mapFromDomainModel(domainModel: CryptoEntity)
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
            : List<CryptoEntity> {
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<CryptoEntity>)
            : List<CryptoListDTO> {
        return initial.map { mapFromDomainModel(it) }
    }

}

class MapDbEntityToUiModel : DomainMapper<CryptoEntity, Crypto> {
    override fun mapToDomainModel(model: CryptoEntity)
            : Crypto {
        return Crypto(
            id = model.id,
            symbol = model.symbol,
            image = model.image,
            current_price = model.current_price,
            price_change_percentage_24h = model.price_change_percentage_24h,
            total_volume = model.total_volume
        )

    }

    override fun mapFromDomainModel(domainModel: Crypto)
            : CryptoEntity {
        return CryptoEntity(
            id = domainModel.id,
            total_volume = domainModel.total_volume,
            current_price = domainModel.current_price,
            price_change_percentage_24h = domainModel.price_change_percentage_24h,
            image = domainModel.image,
            symbol = domainModel.symbol
        )
    }

    fun toDomainList(initial: List<CryptoEntity>)
            : List<Crypto> {
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<Crypto>)
            : List<CryptoEntity> {
        return initial.map { mapFromDomainModel(it) }
    }

}