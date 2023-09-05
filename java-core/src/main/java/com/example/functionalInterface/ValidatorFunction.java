package com.example.functionalInterface;

import com.example.myCore.City;

import java.util.function.Function;

/**
 *  Combinator Patttern
 *  练习 interface Function<T, R> 的应用场景
 *
 */
public interface ValidatorFunction extends Function<City, ValidationResult> {

    static ValidatorFunction isAddressValid() {
        return city -> city.getStreet().length() > 5 ?
                ValidationResult.SUCCESS : ValidationResult.ADDRESS_ERROR;
    }

    static ValidatorFunction isPostCodeValid(){
        return city -> city.getPostcode().length() == 6 ?
                ValidationResult.SUCCESS : ValidationResult.POSTCODE_ERROR;

    }

}

 enum ValidationResult{
    SUCCESS,
    ADDRESS_ERROR,
    POSTCODE_ERROR
}


