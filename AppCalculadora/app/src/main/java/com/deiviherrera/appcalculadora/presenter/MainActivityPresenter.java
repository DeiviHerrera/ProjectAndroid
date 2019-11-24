package com.deiviherrera.appcalculadora.presenter;

public interface MainActivityPresenter {
    void sumar(String n1, String n2);//interactor
    void showError(String error);//vista
    void showResul(String resul);// vista
}
