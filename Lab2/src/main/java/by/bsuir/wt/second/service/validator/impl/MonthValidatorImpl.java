package by.bsuir.wt.second.service.validator.impl;

import by.bsuir.wt.second.service.validator.AbstractValidator;

public class MonthValidatorImpl extends AbstractValidator {
    private static final String MONTH_REGEX = "^([1-9]|1[012])$";

    @Override
    protected String getRegex() {
        return MONTH_REGEX;
    }
}