package com.raheemjnr.cryptolize.domain.mappers


/**
 * a generic interface that accept and map two data objects
 */
interface DomainMapper<T, DomainModel> {

    fun mapToDomainModel(model: T): DomainModel

    fun mapFromDomainModel(domainModel: DomainModel): T
}