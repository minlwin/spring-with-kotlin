package com.jdc.deno.projection.api

import com.jdc.deno.projection.model.form.MerchantCreateForm
import com.jdc.deno.projection.model.form.MerchantSearchForm
import com.jdc.deno.projection.service.MerchantService
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("merchants")
class MerchantApi(private val service: MerchantService) {
    @GetMapping
    fun search(form:MerchantSearchForm,
               @RequestParam(required = false, defaultValue = "0") current:Int,
               @RequestParam(required = false, defaultValue = "10") max:Int)
        = service.search(form, current, max)

    @PostMapping
    fun create(@RequestBody form:MerchantCreateForm, result:BindingResult) = service.create(form)

    @GetMapping("{id}")
    fun findById(@PathVariable id:Long) = service.findById(id)

    @PostMapping("{id}")
    fun update(@PathVariable id:Long, @RequestBody form:MerchantCreateForm, result: BindingResult)
        = service.update(id, form)
}