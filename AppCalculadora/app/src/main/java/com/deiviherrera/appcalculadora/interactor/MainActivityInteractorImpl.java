package com.deiviherrera.appcalculadora.interactor;

import com.deiviherrera.appcalculadora.presenter.MainActivityPresenter;

public class MainActivityInteractorImpl implements MainActivityInteractor {

    private MainActivityPresenter presenter;

    public MainActivityInteractorImpl(MainActivityPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void sumar(String n1, String n2) {
        Double resultado = Double.valueOf(n1)+Double.valueOf(n2);
        presenter.showResul(String.valueOf(resultado));

    }
}
