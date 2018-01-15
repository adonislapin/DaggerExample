package com.globant.mvpweatherapp.di.anotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by adoniram.dominguez on 15/01/2018.
 */


@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityContext {
}
