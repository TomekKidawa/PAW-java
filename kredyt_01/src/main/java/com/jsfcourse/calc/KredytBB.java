package com.jsfcourse.calc;

import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named
@RequestScoped
//@SessionScoped
public class KredytBB {
	private long kwota = 0;
	private int lata = 0;
	private double opr = 0;
	private Double result;

	@Inject
	FacesContext ctx;



	public long getKwota() {
		return kwota;
	}

	public void setKwota(long kwota) {
		this.kwota = kwota;
	}

	public int getLata() {
		return lata;
	}

	public void setLata(int lata) {
		this.lata = lata;
	}

	public double getOpr() {
		return opr;
	}

	public void setOpr(double opr) {
		this.opr = opr;
	}


	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}
// aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
	public boolean doTheMath() {
		try {
//			double kwota = Double.parseDouble(this.kwota);
//			double lata = Double.parseDouble(this.lata);
//			double opr = Double.parseDouble(this.opr);

			result = (kwota* (opr * 0.01)+ (kwota/(lata*12)));

			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
			return true;
		} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Blad podczas przetwarzania danych", null));
			return false;
		}
	}

	// Go to "showresult" if ok ok ok ok ok ok 
	public String calc() {
		if (doTheMath()) {
			return "showresult";
		}
		return null;
	}

	// Put result in messages on AJAX call
	public String calc_AJAX() {
		if (doTheMath()) {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Wynik: " + result, null));
		}
		return null;
	}

	public String info() {
		return "info";
	}
}