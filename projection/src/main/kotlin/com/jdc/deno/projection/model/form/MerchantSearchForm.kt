package com.jdc.deno.projection.model.form

import com.jdc.deno.projection.model.entity.Merchant
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.Predicate
import jakarta.persistence.criteria.Root
import org.springframework.util.StringUtils

data class MerchantSearchForm(
        val name:String?,
        val phone:String?,
        val email:String?
) {
    fun where(cb:CriteriaBuilder, root: Root<Merchant>): Predicate {

        var predicate = cb.isFalse(root.get("deleted"))

        if(null != name && StringUtils.hasLength(name)) {
            predicate = cb.and(predicate, cb.equal(root.get<String>("name"), name))
        }

        if(null != phone && StringUtils.hasLength(phone)) {
            predicate = cb.and(predicate, cb.equal(root.get<String>("phone"), phone))
        }

        if(null != email && StringUtils.hasLength(email)) {
            predicate = cb.and(predicate, cb.equal(root.get<String>("email"), email))
        }

        return predicate
    }
}