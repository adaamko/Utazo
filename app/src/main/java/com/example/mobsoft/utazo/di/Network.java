package com.example.mobsoft.utazo.di;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Gábor on 4/19/2018
 */

@Qualifier
@Retention(RUNTIME)
public @interface Network {
}
