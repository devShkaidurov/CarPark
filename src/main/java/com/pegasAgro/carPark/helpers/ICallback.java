package com.pegasAgro.carPark.helpers;

public interface ICallback {
    double onSuccess(double result);
    double onFailure(Exception e);
}
