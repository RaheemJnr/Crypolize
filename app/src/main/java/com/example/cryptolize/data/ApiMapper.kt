//package com.example.cryptolize.data
//
///**
// * we use #DomainMapper interface to map our domain model to network DTO
// */
//
//class DTOMapper : DomainMapper<, > {
//    override fun mapToDomainModel(model: GithubDTO)
//            : GithubListData {
//        return GithubListData(
//            id = model.id,
//            name = model.name,
//            owner = model.owner,
//            url = model.url,
//            stargazers_count = model.stargazer_count,
//            language = model.language
//        )
//
//    }
//
//    override fun mapFromDomainModel(domainModel: GithubListData)
//            : GithubDTO {
//        return GithubDTO(
//            id = domainModel.id,
//            name = domainModel.name,
//            owner = domainModel.owner,
//            url = domainModel.url,
//            stargazer_count = domainModel.stargazers_count,
//            language = domainModel.language
//        )
//    }
//
//    fun toDomainList(initial: List<GithubDTO>)
//            : List<GithubListData> {
//        return initial.map { mapToDomainModel(it) }
//    }
//
//    fun fromDomainList(initial: List<GithubListData>)
//            : List<GithubDTO> {
//        return initial.map { mapFromDomainModel(it) }
//    }
//
//}