package com.deiviherrera.appcalculadora.presenter;

import com.deiviherrera.appcalculadora.interactor.MainActivityInteractor;
import com.deiviherrera.appcalculadora.interactor.MainActivityInteractorImpl;
import com.deiviherrera.appcalculadora.view.MainActivityView;

public class MaintActivityPresenterImpl implements MainActivityPresenter {
    private MainActivityView activityView;
    private MainActivityInteractor interactor;

    public MaintActivityPresenterImpl(MainActivityView activityView) {
        this.activityView = activityView;
        interactor = new MainActivityInteractorImpl(this);
    }

    @Override
    public void sumar(String n1, String n2) {
        interactor.sumar(n1, n2);
    }

    @Override
    public void showError(String error) {
        activityView.showError(error);
    }

    @Override
    public void showResul(String resul) {
        activityView.showResult(resul);
    }
}
