package com.archisketch.demo.repository

import com.archisketch.demo.entity.AddressType
import com.archisketch.demo.entity.FloorPlan
import com.archisketch.demo.entity.QFloorPlan.floorPlan
import com.archisketch.demo.entity.QUnitType.unitType
import com.archisketch.demo.entity.QApartmentComplex.apartmentComplex
import com.archisketch.demo.entity.QAddress.address
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class FloorPlanRepositoryImpl(
    private val queryFactory: JPAQueryFactory
) : FloorPlanRepository {

    override fun searchFloorPlans(
        name: String?,
        addressType: String?,
        addressKeyword: String?,
        exclusiveAreaSort: String?,
        isExtended: Int?,
        unitName: String?
    ): List<FloorPlan> {

        val query = queryFactory.selectFrom(floorPlan)
            .join(floorPlan.apartmentComplex, apartmentComplex)
            .join(apartmentComplex.addresses, address)
            .join(floorPlan.unitType, unitType)
            .on(floorPlan.apartmentComplex.id.eq(unitType.apartmentComplex.id))
            .where(
                name?.let { apartmentComplex.name.eq(it.trim()) },
                isExtended?.let { unitType.isExtended.eq(it == 1) },
                unitName?.let { unitType.name.containsIgnoreCase(it.trim()) },
                addressKeyword?.let { address.fullAddress.containsIgnoreCase(it.trim()) },
                addressType?.let { address.type.eq(AddressType.valueOf(it)) }
            )
            .groupBy(unitType.name)
            .apply {
                when (exclusiveAreaSort?.lowercase()) {
                    "asc" -> orderBy(unitType.exclusiveArea.asc())
                    "desc" -> orderBy(unitType.exclusiveArea.desc())
                }
            }

        return query.fetch()
    }
}